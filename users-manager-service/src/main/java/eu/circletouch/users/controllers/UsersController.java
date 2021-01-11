package eu.circletouch.users.controllers;

import eu.circletouch.users.beans.User;
import eu.circletouch.users.services.UsersService;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/users")
public class UsersController {

    private UsersService usersService;

    public UsersController(UsersService usersService) {
        this.usersService = usersService;
    }

    @GetMapping(value = "/{id}")
    public User get(@PathVariable("id") Long id, Authentication authentication) {
        org.springframework.security.core.userdetails.User principal = (org.springframework.security.core.userdetails.User) authentication.getPrincipal();
        User req = usersService.getByUsername(principal.getUsername());
        return usersService.getUser(id);
    }

    @GetMapping(value = "/byusername/{username}")
    public User getByUsername(@PathVariable("username") String username, Authentication authentication) {
        org.springframework.security.core.userdetails.User principal = (org.springframework.security.core.userdetails.User) authentication.getPrincipal();
        User req = usersService.getByUsername(principal.getUsername());
        return usersService.getByUsername(username);
    }
}
