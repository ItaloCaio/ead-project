package br.com.eadsimple.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class ClassCtrl {

    @RequestMapping(value = "/salas", method = RequestMethod.GET)
    public String classes() {
        return "views/classes";
    }

    @RequestMapping(value = "/sala/{codigo}", method = RequestMethod.GET)
    public String aClass(@PathVariable("codigo") long codigo) {
        return "views/class";
    }
}
