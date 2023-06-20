package com.works.controllers;

import com.works.entities.Admin;
import com.works.services.LoginService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
@RequiredArgsConstructor
public class LoginController {

    final LoginService loginService;

    @GetMapping("/")
    public String login() {
        return "login";
    }

    @PostMapping("/login")
    public String userLogin(@Valid Admin admin, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors() ) {
            return "error";
        }
        model.addAttribute("email", admin.getEmail());
        boolean status = loginService.loginStatus(admin);
        System.out.println( status );
        return "login";
    }

}
