package cz.bee_kingdom.client.ui;

import cz.bee_kingdom.client.data.TreatmentClient;
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

    public TreatmentWebController(TreatmentClient treatmentClient) {
        this.treatmentClient = treatmentClient;
    }

    @GetMapping
    public String list(Model model, @PathVariable Long id) {
        Collection<TreatmentWebModel> tmp = treatmentClient.readAll(id);
        model.addAttribute("treatments", tmp);
        return "treatments";
    }

    @GetMapping("/{id_treatment}")
    public String current(Model model, @PathVariable Long id, @PathVariable Long id_treatment) {
        TreatmentWebModel tmp = treatmentClient.readById(id_treatment);
        System.out.println(tmp);
        model.addAttribute("treatment", new ColonyDTO()).addAttribute("current", tmp);
        return "coloniesChange";
    }

    @PostMapping("/{id_treatment}/update_treatment")
    public String update(Model model, @ModelAttribute TreatmentDTO treatmentDTO, @PathVariable Long id, @PathVariable Long id_treatment) {
        treatmentDTO.setIdColony(id);
        System.out.println("test put: " + treatmentDTO);
        treatmentClient.update(treatmentDTO, id_treatment);
        TreatmentWebModel tmp = treatmentClient.readById(id_treatment);
        System.out.println("result put: " + tmp);
        model.addAttribute("treatment", new ColonyDTO()).addAttribute("current", tmp);
        return "coloniesChange";
    }

    @GetMapping("/add")
    public String addScreen(Model model, @ModelAttribute TreatmentDTO treatmentDTO) {
        model.addAttribute("treatment", new TreatmentDTO());
        return "coloniesAdd";
    }

    @PostMapping("/add/create")
    public String create(Model model, @ModelAttribute TreatmentDTO treatmentDTO) {
        System.out.println(treatmentDTO);
        treatmentClient.create(treatmentDTO);
        model.addAttribute("treatment", new TreatmentDTO());
        return "coloniesAdd";
    }
}
