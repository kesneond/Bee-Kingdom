package cz.bee_kingdom.client.ui;

import cz.bee_kingdom.client.data.BeeColonyClient;
import cz.bee_kingdom.client.model.ColonyDTO;
import cz.bee_kingdom.client.model.ColonyWebModel;
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
        beeColonyClient.update(colonyDTO);
        ColonyWebModel tmp = beeColonyClient.readById(colonyDTO.getName());
        System.out.println("result put: " + tmp);
        model.addAttribute("current", tmp);
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
        beeColonyClient.create(colonyDTO);
        model.addAttribute("colony", new ColonyDTO());
        return "coloniesAdd";
    }

    @GetMapping("/{id}/delete")
    public String delete(Model model, @ModelAttribute ColonyDTO colonyDTO, @PathVariable Long id) {
        beeColonyClient.delete(id);
        return this.list(model);
    }
}
