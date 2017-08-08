package com.xzkingdee.config.com.xzkingdee.cloud.web;

import org.junit.Test;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.junit.Assert.*;

/**
 * Created by Administrator on 2017/8/8.
 */
public class HomeControllerTest {
    @Test
    public void home() throws Exception {
        HomeController controller = new HomeController();

        MockMvc mockMvc = standaloneSetup(controller).build();
        mockMvc.perform(get("/"))
               .andExpect(view().name("home"));
    }

}