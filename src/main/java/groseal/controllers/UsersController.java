package groseal.controllers;

import groseal.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;

@Controller
@RequestMapping("/user")
public class UsersController {
    private UserService userService;

    @Autowired
    public UsersController(UserService userService) {
        this.userService = userService;
    }

    //Показывает о вошедшем юзере
    @GetMapping()
    public String show(Model model, Principal principal) {
        model.addAttribute("user", userService.loadUserByUsername(principal.getName()));
//        return "showUser";
        return "/infoUser";
    }

    //Показывает юзера по id
    @GetMapping("/{id}")
    public String show(@PathVariable("id") Long id, Model model) {
        model.addAttribute("user", userService.readUser(id));
        return "/infoUser";
    }

}
