package nevg.steelstorage.Controller;

import jakarta.validation.Valid;
import nevg.steelstorage.Models.DTO.Earnings.AddEarningsDTO;
import nevg.steelstorage.Models.DTO.Machines.GetMachineModelDTO;
import nevg.steelstorage.Models.DTO.Steel.GetDiametersDTO;
import nevg.steelstorage.Service.EarningsService;
import nevg.steelstorage.Service.MachineService;
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
public class EarningsController {

    private final SteelService steelService;
    private final MachineService machineService;
    private final EarningsService earningsService;

    public EarningsController(SteelService steelService, MachineService machineService,
                              EarningsService earningsService) {
        this.steelService = steelService;
        this.machineService = machineService;
        this.earningsService = earningsService;
    }

    @GetMapping("/earnings")
    public ModelAndView earnings() {
        List<GetDiametersDTO> getDiametersDTOS = steelService.getDiameterForAllSteel();
        List<GetMachineModelDTO> getMachineBrandAndModel = machineService.getMachineBrandsAndModel();
        ModelAndView modelAndView = new ModelAndView("earnings");
        modelAndView.addObject("diameters", getDiametersDTOS);
        modelAndView.addObject("machines", getMachineBrandAndModel);
        return modelAndView;
    }

    @PostMapping("/earnings")
    public ModelAndView earnings(@Valid AddEarningsDTO addEarningsDTO, BindingResult bindingResult,
                                 @AuthenticationPrincipal UserDetails userDetails) {
        ModelAndView modelAndView = new ModelAndView("earnings");
        if (!bindingResult.hasErrors()) {
            boolean checkCountOfSteel = steelService.checkAvailability(addEarningsDTO.getNumberOfSteel(),
                    addEarningsDTO.getDiameter());
            if (checkCountOfSteel) {
                boolean isAdd = earningsService.addEarning(addEarningsDTO, userDetails);
                return new ModelAndView("redirect:/dashboard");
            } else {
                boolean noSteel = true;
                modelAndView.addObject("steelErr", noSteel);
            }
        }
        return modelAndView;
    }

    @ModelAttribute
    AddEarningsDTO addEarningsDTO() {
        return new AddEarningsDTO();
    }
}
