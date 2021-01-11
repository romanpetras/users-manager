package eu.circletouch.users.controllers;

import eu.circletouch.users.beans.Credentials;
import eu.circletouch.users.beans.LoginResponse;
import eu.circletouch.users.services.AuthService;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/auth")
public class AuthController {

    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/")
    public LoginResponse createAuthenticationToken(@RequestBody Credentials credentials) throws Exception {
        return authService.createAuthenticationToken(credentials);
    }
}