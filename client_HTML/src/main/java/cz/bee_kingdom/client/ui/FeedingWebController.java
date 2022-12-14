package cz.bee_kingdom.client.ui;

import cz.bee_kingdom.client.data.FeedingClient;
import cz.bee_kingdom.client.data.FeedingTypeClient;
import cz.bee_kingdom.client.data.TreatmentClient;
import cz.bee_kingdom.client.data.TreatmentTypeClient;
import cz.bee_kingdom.client.model.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@Controller
@RequestMapping("/colonies/{id}/feeding")
public class FeedingWebController {
    private final FeedingClient feedingClient;
    private final FeedingTypeClient feedingTypeClient;

    public FeedingWebController(FeedingClient feedingClient, FeedingTypeClient feedingTypeClient) {
        this.feedingClient = feedingClient;
        this.feedingTypeClient = feedingTypeClient;
    }

    @GetMapping
    public String list(Model model, @PathVariable Long id) {
        Collection<FeedingWebModel> tmp = feedingClient.readAll(id);
        model.addAttribute("feedings", tmp).addAttribute("colonyId", id);
        return "feedings";
    }

    @GetMapping("/{id_feeding}")
    public String current(Model model, @PathVariable Long id, @PathVariable Long id_feeding) {
        FeedingWebModel tmp = feedingClient.readById(id_feeding, id);
        System.out.println(tmp);
        model.addAttribute("current", tmp).addAttribute("types", feedingTypeClient.readAll());
        return "feedingsChange";
    }

    @PostMapping("/{id_feeding}/update_feeding")
    public String update(Model model, @ModelAttribute FeedingDTO feedingDTO, @PathVariable Long id, @PathVariable Long id_feeding) {
        feedingDTO.setIdColony(id);
        System.out.println("test put: " + feedingDTO);
        feedingClient.update(feedingDTO, id_feeding, id);
        FeedingWebModel tmp = feedingClient.readById(id_feeding, id);
        System.out.println("result put: " + tmp);
        model.addAttribute("current", tmp).addAttribute("types", feedingTypeClient.readAll());
        return "feedingsChange";
    }

    @GetMapping("/add")
    public String addScreen(Model model, @ModelAttribute FeedingDTO feedingDTO, @PathVariable Long id) {
        model.addAttribute("feeding", new FeedingDTO()).addAttribute("colonyId", id).addAttribute("types", feedingTypeClient.readAll());
        return "feedingsAdd";
    }

    @PostMapping("/add/create")
    public String create(Model model, @ModelAttribute FeedingDTO feedingDTO, @PathVariable Long id) {
        feedingDTO.setIdColony(id);
        System.out.println(feedingDTO);
        feedingClient.create(feedingDTO);
        model.addAttribute("feeding", new FeedingDTO()).addAttribute("colonyId", id).addAttribute("types", feedingTypeClient.readAll());
        return "feedingsAdd";
    }

    @GetMapping("/{id_feeding}/delete")
    public String delete(Model model, @ModelAttribute FeedingDTO feedingDTO, @PathVariable Long id, @PathVariable Long id_feeding) {
        feedingClient.delete(id_feeding, id);
        return this.list(model, id);
    }
}
