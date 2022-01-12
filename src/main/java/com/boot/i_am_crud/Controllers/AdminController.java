package com.boot.i_am_crud.Controllers;

import com.boot.i_am_crud.model.Role;
import com.boot.i_am_crud.model.User;
import com.boot.i_am_crud.service.RoleService;
import com.boot.i_am_crud.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private UserServiceImpl userService;

    @Autowired
    private PasswordEncoder encoder;

    @Autowired
    private RoleService roleService;
//
//    @Autowired
//    public void setUserService(UserService userService) {
//        this.userService = userService;
//    }


    @GetMapping(value = "/allusers")
    public String userList(Model model) {
        List<User> userList = userService.listUsers();

        model.addAttribute("userList", userList);

        return "users";
    }

    @PostMapping(value = "/save")
    public String saveOrUpdateUser(@ModelAttribute("user") User user) {

        user.setPassword(encoder.encode(user.getPassword()));

        userService.saveOrUpdateUser(user);
        return "redirect:/admin/allusers";
    }

    @GetMapping(value = "addUser")
    public String addUser(Model model) {
        User user = new User();
        List<Role> roles = roleService.allRoles();
        model.addAttribute("user", user);
        model.addAttribute("roles", roles);
        return "userinfo";
    }

    @GetMapping("userinfo/{id}")
    public String userInfo(@PathVariable("id") Long id, Model model) {
        List<Role> roles = roleService.allRoles();
        model.addAttribute("user", this.userService.getUserByID(id));
        model.addAttribute("roles", roles);
        return "userinfo";
    }

    @GetMapping("/delete/{id}")
    public String deleteUser(@PathVariable("id") Long id) {
        userService.deleteUser(id);
        return "redirect:/admin/allusers";
    }
}
