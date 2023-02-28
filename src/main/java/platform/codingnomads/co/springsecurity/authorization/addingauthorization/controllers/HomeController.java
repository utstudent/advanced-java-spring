package platform.codingnomads.co.springsecurity.authorization.addingauthorization.controllers;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.annotation.security.RolesAllowed;

@Controller
public class HomeController {

    @GetMapping("/")
    public String homePage() {

        return "authorization/home";
    }

    @GetMapping("/admin")
    public String adminPage() {
        return "authorization/admin";
    }

    @GetMapping("/superu")
    public String superUPage() {
        return "authorization/superu";
    }

    @GetMapping("/mas")
    @PreAuthorize("#id != 1")
    public String testMas(int id){
        return "authorization/home";
    }

    @GetMapping("/updater")
    @RolesAllowed("SUPERU")
    public String updatePage() {
        return "practice";
    }

    @GetMapping("/car")
    @RolesAllowed("ADMIN")
    public String carPage() {
        return "cars";
    }
    @GetMapping("/subjects")

    public String subjectsPage() {
        return "subjects";
    }

    /*
        Method Security Annotations

        @RolesAllowed("USER")
        @PreAuthorize("#id != 1")
        @PostAuthorize("returnObject.ownerUsername == authentication.principal.username")
        @PreFilter(value = "filterObject != shutdown", filterTarget = "commands")
        @PostFilter("filterObject.id <= 20")
     */
}