package com.boot.i_am_crud.controller;

import com.boot.i_am_crud.model.User;
import com.boot.i_am_crud.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class Controllers {

    @Autowired
    private UserService userService;

    @GetMapping(value = "admin")
    public String adminRoom(Model model) {
        User user = userService.getUserByName(SecurityContextHolder.getContext()
                .getAuthentication().getName());
        model.addAttribute("user", user);
        return "admin";
    }

    @GetMapping(value = "allusers")
    public String userList(Model model) {
        List<User> userList = userService.listUsers();
        model.addAttribute("userList", userList);
        return "users";
    }

    @GetMapping(value = "user")
    public String singleUser(Model model) {
        User user = userService.loadUserByUsername(SecurityContextHolder.getContext().getAuthentication().getName());
        model.addAttribute("user", user);
        return "user";
    }

    @PostMapping(value = "/save")
    public String saveUser(@ModelAttribute("user") User user) {
        userService.saveUser(user);
        return "redirect:/allusers";
    }

    @GetMapping(value = "addUser")
    public String addUser(Model model) {
        User user = new User();
        model.addAttribute("user", user);
        return "userinfo";
    }

    @GetMapping("/delete/{id}")
    public String deleteUser(@PathVariable("id") Long id) {
        userService.deleteUser(id);
        return "redirect:/allusers";
    }

    @GetMapping("/")
    public String greetings(ModelMap model) {
        model.addAttribute("greeting", ", glad to see you!");
        return "greeting";
    }

    @GetMapping("userinfo/{id}")
    public String userInfo(@PathVariable("id") Long id, Model model) {
        model.addAttribute("user", this.userService.getUserByID(id));
        return "userinfo";
    }

    @GetMapping(value = "/denied")
    public String dangerUser() {
        return "denied";
    }
}
