package ru.kata.spring.boot_security.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.kata.spring.boot_security.demo.model.Role;
import ru.kata.spring.boot_security.demo.model.User;
import ru.kata.spring.boot_security.demo.service.RoleService;
import ru.kata.spring.boot_security.demo.service.UserService;

import java.security.Principal;
import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminController {

    private final UserService userService;
    private final RoleService roleService;

    public AdminController(UserService userService, RoleService roleService) {
        this.userService = userService;
        this.roleService = roleService;
    }

    @GetMapping
    public String showAllUsers(Model model, Principal principal) {
        model.addAttribute("users", userService.findAll());
        User principalUser = userService.findByName(principal.getName());
        model.addAttribute("principalUser", principalUser);
        model.addAttribute("newUser", new User ());
        model.addAttribute("allRoles", roleService.getRoles());
        model.addAttribute("titleTable1", "Список всех пользователей:");
        return "admin";
    }

    @GetMapping("/{id}")
    public String showUser(@PathVariable("id") Long id, Model model) {
        model.addAttribute("user", userService.findOne(id));
        model.addAttribute("titleTable", "Страница пользователя:");
        return "user";
    }

    @GetMapping("/addUser")
    public String addNewUser(Model model, @ModelAttribute("user") User user) {
        List<Role> roles = roleService.getRoles();
        model.addAttribute("rolesAdd", roles);
        return "creation";
    }
    @PostMapping ("/user-creation")
    public String addCreateNewUser(User user) {
        userService.save(user);
        return "redirect:/admin";
    }

    @PatchMapping("/user-update")
    public String updateUser(User user) {
        userService.update(user);
        return "redirect:/admin";
    }

    @GetMapping("/user-update/{id}")
    public String updateUserForm(@PathVariable("id") Long id, Model model) {
        model.addAttribute("user", userService.getUser(id));
        return "admin";
    }

    @GetMapping("/delete/{id}")
    public String deleteUserForm(@PathVariable("id") Long id, Model model) {
        model.addAttribute("user", userService.getUser(id));
        return "admin";
    }

    @DeleteMapping("/user-delete")
    public String deleteUser(Long id) {
        userService.delete(id);
        return "redirect:/admin";
    }
}

