package io.sawa.security.app.resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeResource {

    @GetMapping("/")
    public String home() {
	return "index";
    }

    @GetMapping("/login")
    public String login() {
	return "login";
    }

}
