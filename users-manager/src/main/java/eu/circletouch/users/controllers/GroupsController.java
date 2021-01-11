package eu.circletouch.users.controllers;

import eu.circletouch.commons.beans.BrowseRequest;
import eu.circletouch.commons.beans.BrowseResponse;
import eu.circletouch.users.beans.User;
import eu.circletouch.users.beans.UsersGroup;
import eu.circletouch.users.services.GroupsService;
import eu.circletouch.users.services.UsersService;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/groups")
public class GroupsController {

    private final GroupsService groupsService;
    private final UsersService usersService;

    public GroupsController(GroupsService groupsService, UsersService usersService) {
        this.groupsService = groupsService;
        this.usersService = usersService;
    }

    @GetMapping(value = "/{id}")
    public UsersGroup get(@PathVariable("id") Integer id, Authentication authentication) {
        org.springframework.security.core.userdetails.User principal = (org.springframework.security.core.userdetails.User) authentication.getPrincipal();
        User req = usersService.getByUsername(principal.getUsername());
        return groupsService.get(id, req);
    }

    @PostMapping(value = "/browse")
    public BrowseResponse<UsersGroup> browse(@RequestBody BrowseRequest browseRequest, Authentication authentication) {
        org.springframework.security.core.userdetails.User principal = (org.springframework.security.core.userdetails.User) authentication.getPrincipal();
        User req = usersService.getByUsername(principal.getUsername());
        return groupsService.browse(browseRequest, req);
    }

    @PostMapping("/")
    public UsersGroup create(@RequestBody UsersGroup usersGroup, Authentication authentication) {
        org.springframework.security.core.userdetails.User principal = (org.springframework.security.core.userdetails.User) authentication.getPrincipal();
        User req = usersService.getByUsername(principal.getUsername());
        return groupsService.create(usersGroup, req);
    }

    @PostMapping(value = "/{id}")
    public UsersGroup update(@PathVariable("id") Integer id, @RequestBody UsersGroup usersGroup, Authentication authentication) {
        org.springframework.security.core.userdetails.User principal = (org.springframework.security.core.userdetails.User) authentication.getPrincipal();
        User req = usersService.getByUsername(principal.getUsername());
        return groupsService.update(id, usersGroup, req);
    }

    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable("id") Integer id, Authentication authentication) {
        org.springframework.security.core.userdetails.User principal = (org.springframework.security.core.userdetails.User) authentication.getPrincipal();
        User req = usersService.getByUsername(principal.getUsername());
        groupsService.delete(id, req);
    }
}
