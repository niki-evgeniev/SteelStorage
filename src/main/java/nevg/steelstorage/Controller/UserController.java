package nevg.steelstorage.Controller;

import jakarta.validation.Valid;
import nevg.steelstorage.Models.DTO.RegisterNewUser;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
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

    @PostMapping("/sign_up")
    public ModelAndView sign_up(@Valid RegisterNewUser registerNewUser,
                                BindingResult bindingResult) {
        System.out.println();
        if (bindingResult.hasErrors() || !registerNewUser.getPassword()
                .equals(registerNewUser.getConfirmPassword())) {
            return new ModelAndView("sign-up");
        }
        return new ModelAndView();
    }

    @RequestMapping("/login-error")
    public ModelAndView errorLogin() {
        ModelAndView modelAndView = new ModelAndView("sign-in");
        modelAndView.addObject("bad_credentials", true);
        System.out.println("ERROR LOGIN");
        return modelAndView;
    }
}
