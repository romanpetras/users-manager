package eu.circletouch.users.controllers;

import eu.circletouch.commons.beans.BrowseRequest;
import eu.circletouch.commons.beans.BrowseResponse;
import eu.circletouch.users.beans.CompanyRole;
import eu.circletouch.users.beans.User;
import eu.circletouch.users.services.RolesService;
import eu.circletouch.users.services.UsersService;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/roles")
public class RolesController {

    private final RolesService rolesService;
    private final UsersService usersService;

    public RolesController(RolesService rolesService, UsersService usersService) {
        this.rolesService = rolesService;
        this.usersService = usersService;
    }

    @GetMapping(value = "/{id}")
    public CompanyRole get(@PathVariable("id") Integer id, Authentication authentication) {
        org.springframework.security.core.userdetails.User principal = (org.springframework.security.core.userdetails.User) authentication.getPrincipal();
        User req = usersService.getByUsername(principal.getUsername());
        return rolesService.get(id, req);
    }

    @PostMapping(value = "/browse")
    public BrowseResponse<CompanyRole> browse(@RequestBody BrowseRequest browseRequest, Authentication authentication) {
        org.springframework.security.core.userdetails.User principal = (org.springframework.security.core.userdetails.User) authentication.getPrincipal();
        User req = usersService.getByUsername(principal.getUsername());
        return rolesService.browse(browseRequest, req);
    }

    @PostMapping("/")
    public CompanyRole create(@RequestBody CompanyRole companyRole, Authentication authentication) {
        org.springframework.security.core.userdetails.User principal = (org.springframework.security.core.userdetails.User) authentication.getPrincipal();
        User req = usersService.getByUsername(principal.getUsername());
        return rolesService.create(companyRole, req);
    }

    @PostMapping(value = "/{id}")
    public CompanyRole update(@PathVariable("id") Integer id, @RequestBody CompanyRole companyRole, Authentication authentication) {
        org.springframework.security.core.userdetails.User principal = (org.springframework.security.core.userdetails.User) authentication.getPrincipal();
        User req = usersService.getByUsername(principal.getUsername());
        return rolesService.update(id, companyRole, req);
    }

    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable("id") Integer id, Authentication authentication) {
        org.springframework.security.core.userdetails.User principal = (org.springframework.security.core.userdetails.User) authentication.getPrincipal();
        User req = usersService.getByUsername(principal.getUsername());
        rolesService.delete(id, req);
    }
}
