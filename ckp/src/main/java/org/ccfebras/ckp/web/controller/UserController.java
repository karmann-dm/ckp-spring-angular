package org.ccfebras.ckp.web.controller;

import org.ccfebras.ckp.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/user")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/{id}/username")
    public String getUsernameById(@PathVariable("id") Long id) {
        return userService.findUserById(id).getEmail();
    }
}
