package cz.bee_kingdom.client.ui;

import cz.bee_kingdom.client.data.FeedingClient;
import cz.bee_kingdom.client.data.FeedingTypeClient;
import cz.bee_kingdom.client.data.NoteClient;
import cz.bee_kingdom.client.data.NoteTypeClient;
import cz.bee_kingdom.client.model.*;
import jakarta.ws.rs.QueryParam;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.concurrent.ArrayBlockingQueue;

@Controller
@RequestMapping("/colonies/{id}/note")
public class NoteWebController {
    private final NoteClient noteClient;
    private final NoteTypeClient noteTypeClient;

    public NoteWebController(NoteClient noteClient, NoteTypeClient noteTypeClient) {
        this.noteClient = noteClient;
        this.noteTypeClient = noteTypeClient;
    }

    @GetMapping
    public String list(Model model, @PathVariable Long id, @RequestParam(value="type", required = false)String typeRes) {
        Collection<NoteWebModel> tmp;

        if(typeRes == null || typeRes.equals("all")){
            tmp = noteClient.readAll(id);
        } else {
            tmp = noteClient.filteredReadAll(id, typeRes);
        }
        Collection<NoteTypeWebModel> types = noteTypeClient.readAll();
        NoteTypeDTO typeFill = new NoteTypeDTO();
        model.addAttribute("notes", tmp)
                .addAttribute("colonyId", id)
                .addAttribute("types", types)
                .addAttribute("typeFill", typeFill);
        return "notes";
    }

    @GetMapping("/{id_note}")
    public String current(Model model, @PathVariable Long id, @PathVariable Long id_note) {
        NoteWebModel tmp = noteClient.readById(id_note, id);
        System.out.println(tmp);
        model.addAttribute("current", tmp).addAttribute("types", noteTypeClient.readAll());
        return "notesChange";
    }

    @PostMapping("/{id_feeding}/update_note")
    public String update(Model model, @ModelAttribute NoteDTO noteDTO, @PathVariable Long id, @PathVariable Long id_feeding) {
        noteDTO.setIdColony(id);
        System.out.println("test put: " + noteDTO);
        noteClient.update(noteDTO, id_feeding, id);
        NoteWebModel tmp = noteClient.readById(id_feeding, id);
        System.out.println("result put: " + tmp);
        model.addAttribute("current", tmp).addAttribute("types", noteTypeClient.readAll()).addAttribute("success", "Note was changed!");
        return "notesChange";
    }

    @GetMapping("/add")
    public String addScreen(Model model, @ModelAttribute NoteDTO noteDTO, @PathVariable Long id) {
        model.addAttribute("note", new NoteDTO()).addAttribute("colonyId", id).addAttribute("types", noteTypeClient.readAll());
        return "notesAdd";
    }

    @PostMapping("/add/create")
    public String create(Model model, @ModelAttribute NoteDTO noteDTO, @PathVariable Long id) {
        noteDTO.setIdColony(id);
        System.out.println(noteDTO);
        try {
            noteClient.create(noteDTO);
        } catch (Exception e) {
            model.addAttribute("error", "Note can't be created, check if you filled whole form!");
            return "errorHandle";
        }
        model.addAttribute("note", new NoteDTO())
                .addAttribute("colonyId", id)
                .addAttribute("types", noteTypeClient.readAll())
                .addAttribute("success", "Note was added!");
        return "notesAdd";
    }

    @GetMapping("/{id_note}/delete")
    public String delete(Model model, @ModelAttribute NoteDTO noteDTO, @PathVariable Long id, @PathVariable Long id_note) {
        noteClient.delete(id_note, id);
        return this.list(model, id, "");
    }
}
