package nevg.steelstorage.Controller;

import jakarta.validation.Valid;
import nevg.steelstorage.Models.DTO.RegisterNewUser;
import nevg.steelstorage.Service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/sign_in")
    public ModelAndView signIn() {
        return new ModelAndView("signIn");
    }


    @PostMapping("/sign_up")
    public ModelAndView sign_up(@Valid RegisterNewUser registerNewUser,
                                BindingResult bindingResult) {
        ModelAndView modelAndView = new ModelAndView("sign-up");
        if (bindingResult.hasErrors() || !registerNewUser.getPassword()
                .equals(registerNewUser.getConfirmPassword())) {
            return modelAndView;
        }
        // check email existing
        boolean isEmailFree = userService.checkEmailIsFree(registerNewUser.getEmail());

        if (!isEmailFree) {
            boolean successfulRegisterNewUser = userService.registerNewUser(registerNewUser);
            return new ModelAndView("redirect:/");
        }
        modelAndView.addObject("emailExist", isEmailFree);
        return modelAndView;
    }

    @RequestMapping("/login-error")
    public ModelAndView errorLogin() {
        ModelAndView modelAndView = new ModelAndView("signIn");
        modelAndView.addObject("bad_credentials", true);
        System.out.println("ERROR LOGIN");
        return modelAndView;
    }

    @ModelAttribute
    RegisterNewUser registerNewUser() {
        return new RegisterNewUser();
    }
}
