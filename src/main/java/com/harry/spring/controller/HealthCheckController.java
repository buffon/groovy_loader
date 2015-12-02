package com.harry.spring.controller;

import com.harry.spring.base.BaseGroovy;
import com.harry.spring.base.GroovyLoadManager;
import com.harry.spring.base.IGroovyLoadManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HealthCheckController {

    @Autowired
    private IGroovyLoadManager groovyLoadManager;

    @RequestMapping(value = "health_check", method = RequestMethod.GET)
    @ResponseBody
    public String check() {
        BaseGroovy groovy = groovyLoadManager.get(GroovyLoadManager.BEAN_NAME);
        groovy.say();
        return "SUCCESS";
    }
}