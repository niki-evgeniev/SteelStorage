package nevg.steelstorage.Controller;


import jakarta.validation.Valid;
import nevg.steelstorage.Models.DTO.Steel.AddSteelDTO;
import nevg.steelstorage.Models.DTO.Steel.GetDiametersDTO;
import nevg.steelstorage.Service.SteelService;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class SteelController {

    private final SteelService steelService;

    public SteelController(SteelService steelService) {
        this.steelService = steelService;
    }


    @GetMapping("/add_steel")
    public ModelAndView addSteel() {
        List<GetDiametersDTO> getDiametersDTOS = steelService.getDiameterForAllSteel();
        ModelAndView modelAndView = new ModelAndView("addSteel");
        modelAndView.addObject("diameters", getDiametersDTOS);
        return modelAndView;
    }

    @PostMapping("/add_steel")
    public ModelAndView addSteel(@Valid AddSteelDTO addSteelDTO, BindingResult bindingResult,
                                 @AuthenticationPrincipal UserDetails userDetails) {

        if (bindingResult.hasErrors()){
            List<GetDiametersDTO> getDiametersDTOS = steelService.getDiameterForAllSteel();
            return new ModelAndView("addSteel")
                    .addObject("diameters", getDiametersDTOS);
        }
        steelService.addCutSteel(addSteelDTO, userDetails);
        return new ModelAndView("redirect:/dashboard");
    }

    @ModelAttribute
    AddSteelDTO addSteelDTO() {
        return new AddSteelDTO();
    }
}