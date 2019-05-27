package br.com.eadsimple.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class VideoCtrl {

    @RequestMapping(value = "/sala/{codigo}/newVideo", method = RequestMethod.GET)
    public String savaVideo(@PathVariable("codigo") long codigo) {
        return "views/newVideo";
    }
}
