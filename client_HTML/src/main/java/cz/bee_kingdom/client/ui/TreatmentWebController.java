package cz.bee_kingdom.client.ui;

import cz.bee_kingdom.client.data.TreatmentClient;
import cz.bee_kingdom.client.data.TreatmentTypeClient;
import cz.bee_kingdom.client.model.ColonyDTO;
import cz.bee_kingdom.client.model.ColonyWebModel;
import cz.bee_kingdom.client.model.TreatmentDTO;
import cz.bee_kingdom.client.model.TreatmentWebModel;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@Controller
@RequestMapping("/colonies/{id}/treatment")
public class TreatmentWebController {
    private final TreatmentClient treatmentClient;
    private final TreatmentTypeClient treatmentTypeClient;

    public TreatmentWebController(TreatmentClient treatmentClient, TreatmentTypeClient treatmentTypeClient) {
        this.treatmentClient = treatmentClient;
        this.treatmentTypeClient = treatmentTypeClient;
    }

    @GetMapping
    public String list(Model model, @PathVariable Long id) {
        Collection<TreatmentWebModel> tmp = treatmentClient.readAll(id);
        model.addAttribute("treatments", tmp).addAttribute("colonyId", id);
        return "treatments";
    }

    @GetMapping("/{id_treatment}")
    public String current(Model model, @PathVariable Long id, @PathVariable Long id_treatment) {
        TreatmentWebModel tmp = treatmentClient.readById(id_treatment, id);
        System.out.println(tmp);
        model.addAttribute("treatment", new TreatmentDTO()).addAttribute("current", tmp).addAttribute("types", treatmentTypeClient.readAll());
        return "treatmentsChange";
    }

    @PostMapping("/{id_treatment}/update_treatment")
    public String update(Model model, @ModelAttribute TreatmentDTO treatmentDTO, @PathVariable Long id, @PathVariable Long id_treatment) {
        treatmentDTO.setIdColony(id);
        System.out.println("test put: " + treatmentDTO);
        treatmentClient.update(treatmentDTO, id_treatment, id);
        TreatmentWebModel tmp = treatmentClient.readById(id_treatment, id);
        System.out.println("result put: " + tmp);
        model.addAttribute("treatment", new TreatmentDTO()).addAttribute("current", tmp).addAttribute("types", treatmentTypeClient.readAll());
        return "treatmentsChange";
    }

    @GetMapping("/add")
    public String addScreen(Model model, @ModelAttribute TreatmentDTO treatmentDTO, @PathVariable Long id) {
        model.addAttribute("treatment", new TreatmentDTO()).addAttribute("colonyId", id).addAttribute("types", treatmentTypeClient.readAll());
        return "treatmentsAdd";
    }

    @PostMapping("/add/create")
    public String create(Model model, @ModelAttribute TreatmentDTO treatmentDTO, @PathVariable Long id) {
        treatmentDTO.setIdColony(id);
        System.out.println(treatmentDTO);
        treatmentClient.create(treatmentDTO);
        model.addAttribute("treatment", new TreatmentDTO()).addAttribute("colonyId", id).addAttribute("types", treatmentTypeClient.readAll());
        return "treatmentsAdd";
    }
}
