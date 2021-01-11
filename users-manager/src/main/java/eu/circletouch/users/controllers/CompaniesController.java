package eu.circletouch.users.controllers;

import eu.circletouch.commons.beans.BrowseRequest;
import eu.circletouch.commons.beans.BrowseResponse;
import eu.circletouch.users.beans.Company;
import eu.circletouch.users.beans.User;
import eu.circletouch.users.services.CompaniesService;
import eu.circletouch.users.services.UsersService;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/companies")
public class CompaniesController {

    private final CompaniesService companiesService;
    private final UsersService usersService;

    public CompaniesController(CompaniesService companiesService, UsersService usersService) {
        this.companiesService = companiesService;
        this.usersService = usersService;
    }

    @GetMapping(value = "/{id}")
    public Company get(@PathVariable("id") Integer id, Authentication authentication) {
        org.springframework.security.core.userdetails.User principal = (org.springframework.security.core.userdetails.User) authentication.getPrincipal();
        User req = usersService.getByUsername(principal.getUsername());
        return companiesService.get(id, req);
    }

    @PostMapping(value = "/browse")
    public BrowseResponse<Company> browse(@RequestBody BrowseRequest browseRequest, Authentication authentication) {
        org.springframework.security.core.userdetails.User principal = (org.springframework.security.core.userdetails.User) authentication.getPrincipal();
        User req = usersService.getByUsername(principal.getUsername());
        return companiesService.browse(browseRequest, req);
    }

    @PostMapping("/")
    public Company create(@RequestBody Company company, Authentication authentication) {
        org.springframework.security.core.userdetails.User principal = (org.springframework.security.core.userdetails.User) authentication.getPrincipal();
        User req = usersService.getByUsername(principal.getUsername());
        return companiesService.create(company, req);
    }

    @PostMapping(value = "/{id}")
    public Company update(@PathVariable("id") Integer id, @RequestBody Company company, Authentication authentication) {
        org.springframework.security.core.userdetails.User principal = (org.springframework.security.core.userdetails.User) authentication.getPrincipal();
        User req = usersService.getByUsername(principal.getUsername());
        return companiesService.update(id, company, req);
    }

    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable("id") Integer id, Authentication authentication) {
        org.springframework.security.core.userdetails.User principal = (org.springframework.security.core.userdetails.User) authentication.getPrincipal();
        User req = usersService.getByUsername(principal.getUsername());
        companiesService.delete(id, req);
    }
}
