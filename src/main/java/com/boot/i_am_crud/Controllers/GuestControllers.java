package com.boot.i_am_crud.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class GuestControllers {

    @GetMapping("/")
    public String greetings(ModelMap model) {
        model.addAttribute("greeting", ", glad to see you!");
        return "greeting";
    }

}
