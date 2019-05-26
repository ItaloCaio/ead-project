package br.com.eadsimple.controller;

import br.com.eadsimple.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class UserCtrl {

    @Autowired
    private UserRepository userRepository;

    @RequestMapping(value = "/cadastro", method = RequestMethod.GET)
    public String form() {
        return "views/register";
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String home(@AuthenticationPrincipal UserDetails userDetails) {
        if (userDetails == null)
            return "views/home";
        else
            return "views/register";
    }


}
