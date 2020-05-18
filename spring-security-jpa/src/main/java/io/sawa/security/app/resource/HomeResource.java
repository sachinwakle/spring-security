package io.sawa.security.app.resource;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeResource {

    @GetMapping("/")
    public String welcomeHome() {
	return "<h1>Hello Guest</h1>";
    }

    @GetMapping("/user")
    public String welcomeUser() {
	return "<h1>Hello User</h1>";
    }

    @GetMapping("/admin")
    public String welcomeAdmin() {
	return "<h1>Hello Admin</h1>";
    }

}
