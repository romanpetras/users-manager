package eu.circletouch.users.controllers;

import eu.circletouch.commons.beans.BrowseRequest;
import eu.circletouch.commons.beans.BrowseResponse;
import eu.circletouch.users.beans.User;
import eu.circletouch.users.services.UsersService;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/users")
public class UsersController {

    private final UsersService usersService;

    public UsersController(UsersService usersService) {
        this.usersService = usersService;
    }

    @GetMapping(value = "/{id}")
    public User get(@PathVariable("id") Integer id, Authentication authentication) {
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

    @PostMapping(value = "/browse")
    public BrowseResponse<User> browse(@RequestBody BrowseRequest browseRequest, Authentication authentication) {
        org.springframework.security.core.userdetails.User principal = (org.springframework.security.core.userdetails.User) authentication.getPrincipal();
        User req = usersService.getByUsername(principal.getUsername());
        return usersService.browse(browseRequest, req);
    }

    @PostMapping("/")
    public User create(@RequestBody User user, Authentication authentication) {
        org.springframework.security.core.userdetails.User principal = (org.springframework.security.core.userdetails.User) authentication.getPrincipal();
        User req = usersService.getByUsername(principal.getUsername());
        return usersService.create(user, req);
    }

    @PostMapping(value = "/{id}")
    public User update(@PathVariable("id") Integer id, @RequestBody User user, Authentication authentication) {
        org.springframework.security.core.userdetails.User principal = (org.springframework.security.core.userdetails.User) authentication.getPrincipal();
        User req = usersService.getByUsername(principal.getUsername());
        return usersService.update(id, user, req);
    }

    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable("id") Integer id, Authentication authentication) {
        org.springframework.security.core.userdetails.User principal = (org.springframework.security.core.userdetails.User) authentication.getPrincipal();
        User req = usersService.getByUsername(principal.getUsername());
        usersService.delete(id, req);
    }
}
