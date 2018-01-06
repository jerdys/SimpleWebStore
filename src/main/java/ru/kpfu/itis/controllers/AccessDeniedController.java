package ru.kpfu.itis.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AccessDeniedController {
    @GetMapping
    public String getAccessDeniedPage() {
        return "/403";
    }
}
