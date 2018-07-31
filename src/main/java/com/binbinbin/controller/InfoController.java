package com.binbinbin.controller;

import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * Created by bin on 2018/5/15.
 */
@RestController
public class InfoController {
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(InfoController.class);
    /**
     *
     * @return
     */
    @RequestMapping("info")
    public String info(){
        return "hello consumer";
    }

}
