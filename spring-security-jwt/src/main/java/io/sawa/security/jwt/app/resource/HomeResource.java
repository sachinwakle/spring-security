package io.sawa.security.jwt.app.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import io.sawa.security.jwt.app.model.AuthenticationRequest;
import io.sawa.security.jwt.app.model.AuthenticationResponse;
import io.sawa.security.jwt.app.util.JwtUtil;

@Controller
public class HomeResource {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private UserDetailsService userDetailsService;

    @GetMapping("/home")
    public String requestHome() {
	return "Hello World!!";
    }

    @PostMapping("/authenticate")
    public ResponseEntity<?> createAuthenticationToken(@RequestBody AuthenticationRequest authenticationRequest)
	    throws Exception {
	try {
	    authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
		    authenticationRequest.getUsername(), authenticationRequest.getPassword()));
	} catch (BadCredentialsException e) {
	    throw new Exception("Incorrect username or password", e);
	}

	final UserDetails userDetails = userDetailsService.loadUserByUsername(authenticationRequest.getUsername());

	final String jwt = jwtUtil.generateToken(userDetails);
	return ResponseEntity.ok(new AuthenticationResponse(jwt));
    }

}
