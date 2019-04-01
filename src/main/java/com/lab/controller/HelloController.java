package com.lab.controller;

/**
 * Created by debashisghosh on 11/5/16.
 */

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import com.lab.model.Location;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import com.lab.model.Location;

import org.springframework.web.bind.annotation.RequestMapping;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

@RestController
public class HelloController {
    @Autowired
    private Location location;
    @RequestMapping("/")
    public String index() {
        Logger logger = LoggerFactory.getLogger(this.getClass());
	logger.debug("inside index of hellocontroller");
        return "Hi Kops Kubernetes and AWS, Azure Kubernets(AKS) -  from "+location.getCountry();
    }
    @RequestMapping("/eat-cpu")
    public String eatCPU() {
        Logger logger = LoggerFactory.getLogger(this.getClass());
	logger.debug("inside index of eatCPU");
	int count = Runtime.getRuntime().availableProcessors();  
        for (int i = 0; i < count; i++) {
            new Thread(new Runnable() {
                public void run() {
                    while (true);
                }
            }).start();
        }
        return "Munching CPU";
    }
}
