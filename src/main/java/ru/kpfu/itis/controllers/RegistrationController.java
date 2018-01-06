package ru.kpfu.itis.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import ru.kpfu.itis.models.User;
import ru.kpfu.itis.services.UsersService;

import javax.validation.Valid;

@Controller
public class RegistrationController {
    @Autowired
    private UsersService usersService;

    @GetMapping("/register")
    public ModelAndView getRegistrationPage(Authentication authentication) {
        ModelAndView modelAndView = new ModelAndView();
        User user = new User();

        modelAndView.addObject("user", user);

        if (authentication != null) {
            modelAndView.setViewName("home");

            return modelAndView;
        }

        modelAndView.setViewName("registration");

        return modelAndView;
    }

    @PostMapping("/register")
    public ModelAndView createNewUser(@Valid User user, BindingResult bindingResult) {
        ModelAndView modelAndView = new ModelAndView();

        if (usersService.findByEmail(user.getEmail()) != null) {
            bindingResult.rejectValue("email", "error.user",
                    "User with this email has already been registered");
        }

        if (bindingResult.hasErrors()) modelAndView.setViewName("registration");
        else {
            usersService.saveUser(user);

            modelAndView.addObject("successMessage", "User has been registered successfully");
            modelAndView.addObject("user", user);
            modelAndView.setViewName("registration");
        }

        return modelAndView;
    }

}
