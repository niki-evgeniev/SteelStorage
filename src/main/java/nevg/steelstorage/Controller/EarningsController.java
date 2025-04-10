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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.UUID;

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
        if (!bindingResult.hasErrors()) {
            boolean isAdd = earningsService.addEarning(addEarningsDTO, userDetails);
            return new ModelAndView("redirect:/dashboard");
        }
        return null;
    }

    @ModelAttribute
    AddEarningsDTO addEarningsDTO() {
        return new AddEarningsDTO();
    }
}
