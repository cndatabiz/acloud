/**
 * 功能描述:
 *
 * @author tommy create on 2017-08-08-13:49
 */

package com.xzkingdee.config.com.xzkingdee.cloud.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class HomeController {
    private final Logger logger = LoggerFactory.getLogger(HomeController.class);

    @GetMapping(value = {"/", "/home"})
    public String home(){
        logger.info("come into Home Controller.");
        return "home";
    }
}
