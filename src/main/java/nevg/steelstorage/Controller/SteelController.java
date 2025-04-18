package nevg.steelstorage.Controller;


import nevg.steelstorage.Models.DTO.Steel.GetDiametersDTO;
import nevg.steelstorage.Service.SteelService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class SteelController {

    private final SteelService steelService;

    public SteelController(SteelService steelService) {
        this.steelService = steelService;
    }

//    @GetMapping("/earnings")
//    public ModelAndView earnings() {
//        return new ModelAndView("earnings");
//    }

    @GetMapping("/add_steel")
    public ModelAndView addSteel() {
        List<GetDiametersDTO> getDiametersDTOS = steelService.getDiameterForAllSteel();
        ModelAndView modelAndView = new ModelAndView("addSteel");
        modelAndView.addObject("diameters", getDiametersDTOS);
        return modelAndView;
    }
}