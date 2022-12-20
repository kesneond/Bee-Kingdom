package cz.bee_kingdom.client.ui;

import cz.bee_kingdom.client.data.BeeColonyClient;
import cz.bee_kingdom.client.model.ColonyDTO;
import cz.bee_kingdom.client.model.ColonyWebModel;
import io.netty.handler.codec.http.HttpResponseStatus;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@Controller
@RequestMapping("/colonies")
public class ColonyWebController {

    private final BeeColonyClient beeColonyClient;

    public ColonyWebController(BeeColonyClient beeColonyClient) {
        this.beeColonyClient = beeColonyClient;
    }

    @GetMapping
    public String list(Model model) {
        Collection<ColonyWebModel> tmp = beeColonyClient.readAll();
        model.addAttribute("colonies", tmp);
        return "colonies";
    }

    @GetMapping("/{id}")
    public String current(Model model, @PathVariable Long id) {
        ColonyWebModel tmp = beeColonyClient.readById(id);
        System.out.println(tmp);
        model.addAttribute("current", tmp);
        return "coloniesChange";
    }

    @PostMapping("/{id}/update_colony")
    public String update(Model model, @ModelAttribute ColonyDTO colonyDTO, @PathVariable Long id) {
        colonyDTO.setName(id);
        System.out.println("test put: " + colonyDTO);
        try {
            beeColonyClient.update(colonyDTO);
        } catch (Exception e) {
            model.addAttribute("error", "Colony can't be updated, check if you filled whole form");
            return "errorHandle";
        }
        ColonyWebModel tmp = beeColonyClient.readById(colonyDTO.getName());
        System.out.println("result put: " + tmp);
        model.addAttribute("current", tmp).addAttribute("success", "Colony was changed!");
        return "coloniesChange";
    }

    @GetMapping("/add")
    public String addScreen(Model model, @ModelAttribute ColonyDTO colonyDTO) {
        model.addAttribute("colony", new ColonyDTO());
        return "coloniesAdd";
    }

    @PostMapping("/add/create")
    public String create(Model model, @ModelAttribute ColonyDTO colonyDTO) {
        System.out.println(colonyDTO);
        try {
            beeColonyClient.create(colonyDTO);
        } catch (Exception e) {
            model.addAttribute("error", "Colony can't be created, check if you filled whole form!");
            return "errorHandle";
        }
        model.addAttribute("colony", new ColonyDTO()).addAttribute("success", "Colony was added!");
        return "coloniesAdd";
    }

    @GetMapping("/{id}/delete")
    public String delete(Model model, @ModelAttribute ColonyDTO colonyDTO, @PathVariable Long id) {
        beeColonyClient.delete(id);
        return this.list(model);
    }
}
