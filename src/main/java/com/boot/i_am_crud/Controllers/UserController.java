package com.boot.i_am_crud.Controllers;

import com.boot.i_am_crud.model.User;
import com.boot.i_am_crud.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class UserController {

    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }



    @GetMapping(value = "user")
    public String singleUser(Model model) {
        User user = (User) userService.loadUserByUsername(SecurityContextHolder.getContext().getAuthentication().getName());
        model.addAttribute("user", user);
        return "user";
    }

    @GetMapping(value = "/denied")
    public String dangerUser() {
        return "denied";
    }
}