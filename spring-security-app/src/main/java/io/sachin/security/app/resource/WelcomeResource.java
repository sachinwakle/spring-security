package io.sachin.security.app.resource;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WelcomeResource {

    @GetMapping("/")
    public String greeter() {
	return ("<h1>Welcome</h1>");
    }

    @GetMapping("/user")
    public String userGreeter() {
	return ("<h1>Welcome User</h1>");
    }

    @GetMapping("/admin")
    public String adminGreeter() {
	return ("<h1>Welcome Admin</h1>");
    }

}
