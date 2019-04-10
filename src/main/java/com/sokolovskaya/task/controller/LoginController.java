package com.sokolovskaya.task.controller;

import com.sokolovskaya.task.database.enumeration.UserRole;
import com.sokolovskaya.task.service.dto.User;
import com.sokolovskaya.task.service.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class LoginController {

    private final UserService userService;

    @GetMapping("/login")
    public String getLoginPage(@ModelAttribute("user") User user) {
        return "login";
    }

    @PostMapping("/login")
    public String getUserPage(User user) {
        user = userService.getByName(user.getName());
        String page;
        if (user.getRole() == UserRole.ADMIN) {
            page = "redirect:/admin?id=" + user.getId();
        } else if (user.getRole() == UserRole.CLIENT) {
            page = "redirect:/client?id=" + user.getId();
        } else {
            page = "login";
        }
        return page;
    }
}
