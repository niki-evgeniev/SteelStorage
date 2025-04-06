package nevg.steelstorage.Controller;

import jakarta.validation.Valid;
import nevg.steelstorage.Models.DTO.machine.AddMachineDTO;
import nevg.steelstorage.Service.MachineService;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MachineController {

    private final MachineService machineService;

    public MachineController(MachineService machineService) {
        this.machineService = machineService;
    }

    @GetMapping("/add_machine")
    public ModelAndView addMachine() {
        System.out.println();
        return new ModelAndView("addMachine");
    }

    @PostMapping("/add_machine")
    public ModelAndView addMachine(@Valid AddMachineDTO addMachineDTO, BindingResult bindingResult,
                                   @AuthenticationPrincipal UserDetails userDetails) {
        if (bindingResult.hasErrors()){
            return new ModelAndView("addMachine");
        }
        boolean isAdded = machineService.addNewMachine(addMachineDTO, userDetails);

        if (!isAdded){
            ModelAndView modelAndView = new ModelAndView("addMachine");
            String machineErr= "This serial number or machine exist";
            modelAndView.addObject("machineErr", machineErr);
            return modelAndView;
        }

        return new ModelAndView("redirect:/dashboard");
    }

    @ModelAttribute
    AddMachineDTO addMachineDTO() {
        return new AddMachineDTO();
    }
}
