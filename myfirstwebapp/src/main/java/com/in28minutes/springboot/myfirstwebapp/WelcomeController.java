package com.in28minutes.springboot.myfirstwebapp;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("name")
public class WelcomeController {
    //private  AuthenticationService authenticationService;

    /*public Logincontroller(AuthenticationService authenticationService) {
        this.authenticationService = authenticationService;
    }*/

    @RequestMapping(value="/", method = RequestMethod.GET)
    public String goToWelcomePage(ModelMap model){
        model.put("name", getLoggedinUsername());
        return "welcome";
    }

    private String getLoggedinUsername() {
        Authentication authentication =
                SecurityContextHolder.getContext().getAuthentication();
        return authentication.getName();
    }

    /*@RequestMapping(value="login", method = RequestMethod.POST)
    public String goToWelcomePage(@RequestParam String name, @RequestParam String password, ModelMap model){
       if (authenticationService.authenticate(name,password)) {
           model.put("name", name);
           model.put("password", password);
           return "welcome";
       }
       model.put("errorMessage", "Invalid credentials try again.");
        return "login";
    }*/
}
