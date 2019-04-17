package net.controllers;

import net.Services.UsersService;
import net.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/users")
public class UserController {

    @Autowired
    UsersService usersService;

    @GetMapping("/listUsers")
    public String listUsers(Model model) {
        List<User> listUsers = usersService.listUsers();
        model.addAttribute("emptyUserForAdded", new User());
        model.addAttribute("listUsers", listUsers);
        return "mainPage";
    }

    @PostMapping("/addUser")
    public String addUser(@RequestParam String name,
                          @RequestParam String password,
                          @RequestParam String email,
                          Model model) {

        usersService.addUser(new User(name, password, email));

        return "redirect:listUsers";
    }

    @GetMapping("/user/{id}")
    public String getUserById(@PathVariable long id, Model model) {
        User user = usersService.findUserById(id);
        model.addAttribute("foundUserById", user);
        return "mainPage";
    }

    @GetMapping("/user/delete/{id}")
    public String deleteUser(@PathVariable long id, Model model) {
        usersService.deleteUserById(id);
        return "mainPage";
    }
}
