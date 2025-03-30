package nevg.steelstorage.Controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class EarningsController {

    @GetMapping("/earnings")
    public ModelAndView earnings(){
        return new ModelAndView("earnings");
    }
}