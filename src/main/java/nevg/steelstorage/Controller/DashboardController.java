package nevg.steelstorage.Controller;

import nevg.steelstorage.Models.DTO.Steel.SteelStorageDTO;
import nevg.steelstorage.Models.DTO.Steel.SteelStorageListDTO;
import nevg.steelstorage.Service.SteelService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class DashboardController {

    private final SteelService steelService;

    public DashboardController(SteelService steelService) {
        this.steelService = steelService;
    }

    @GetMapping("/dashboard")
    public ModelAndView dashboard() {

        List<SteelStorageDTO> steelStorageListDTO = steelService.getAllSteelMaterial();

      ModelAndView modelAndView =  new ModelAndView("index");
      modelAndView.addObject("material", steelStorageListDTO);

        System.out.println();

        return modelAndView;
    }
}
