package nevg.steelstorage.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UserController {

    @GetMapping("/sign_in")
    public ModelAndView signIn() {
        return new ModelAndView("sign-in");
    }

    @GetMapping("/sign_up")
    public ModelAndView signUp() {
        return new ModelAndView("sign-up");
    }
}
