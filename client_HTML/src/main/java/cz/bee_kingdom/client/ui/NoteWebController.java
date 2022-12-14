package cz.bee_kingdom.client.ui;

import cz.bee_kingdom.client.data.FeedingClient;
import cz.bee_kingdom.client.data.FeedingTypeClient;
import cz.bee_kingdom.client.data.NoteClient;
import cz.bee_kingdom.client.data.NoteTypeClient;
import cz.bee_kingdom.client.model.FeedingDTO;
import cz.bee_kingdom.client.model.FeedingWebModel;
import cz.bee_kingdom.client.model.NoteDTO;
import cz.bee_kingdom.client.model.NoteWebModel;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

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
    public String list(Model model, @PathVariable Long id) {
        Collection<NoteWebModel> tmp = noteClient.readAll(id);
        model.addAttribute("notes", tmp).addAttribute("colonyId", id);
        return "notes";
    }

    @GetMapping("/{id_note}")
    public String current(Model model, @PathVariable Long id, @PathVariable Long id_note) {
        NoteWebModel tmp = noteClient.readById(id_note, id);
        System.out.println(tmp);
        model.addAttribute("note", new NoteDTO()).addAttribute("current", tmp).addAttribute("types", noteTypeClient.readAll());
        return "notesChange";
    }

    @PostMapping("/{id_feeding}/update_note")
    public String update(Model model, @ModelAttribute NoteDTO noteDTO, @PathVariable Long id, @PathVariable Long id_feeding) {
        noteDTO.setIdColony(id);
        System.out.println("test put: " + noteDTO);
        noteClient.update(noteDTO, id_feeding, id);
        NoteWebModel tmp = noteClient.readById(id_feeding, id);
        System.out.println("result put: " + tmp);
        model.addAttribute("note", new NoteDTO()).addAttribute("current", tmp).addAttribute("types", noteTypeClient.readAll());
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
        noteClient.create(noteDTO);
        model.addAttribute("note", new NoteDTO()).addAttribute("colonyId", id).addAttribute("types", noteTypeClient.readAll());
        return "notesAdd";
    }

    @GetMapping("/{id_note}/delete")
    public String delete(Model model, @ModelAttribute NoteDTO noteDTO, @PathVariable Long id, @PathVariable Long id_note) {
        noteClient.delete(id_note, id);
        return this.list(model, id);
    }
}
