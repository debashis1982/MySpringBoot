package com.lab.controller;

/**
 * Created by debashisghosh on 11/5/16.
 */

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import com.lab.model.Location;
@RestController
public class HelloController {

    @RequestMapping("/")
    public String index() {

        return "Heroku rocks again and again and again!!";
    }

}
