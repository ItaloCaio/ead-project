package br.com.eadsimple.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ActivityCtrl {

    @RequestMapping(value = "/sala/{codigo}/novaAtividade", method = RequestMethod.GET)
    public String saveActivityAssigned(@PathVariable("codigo") long codigo) {
        return "views/newActivityAssigned";
    }

    @RequestMapping(value = "/sala/{codigo}/atividade/{codigo}", method = RequestMethod.GET)
    public String saveActivityReceived(@PathVariable("codigo") long codigo) {

        return "views/newActivityReceived";
    }

    @RequestMapping(value = "/sala/{codigo}/atividades/{codigo}", method = RequestMethod.GET)
    public String getAtividades(@PathVariable("codigo") long codigo) {

        return "views/listActivityReceived";
    }
}
