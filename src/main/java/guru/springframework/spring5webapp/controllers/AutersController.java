package guru.springframework.spring5webapp.controllers;

import guru.springframework.spring5webapp.repositories.AutherRepository;
import guru.springframework.spring5webapp.repositories.BookRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AutersController {

    private final AutherRepository autherRepository;

    public AutersController(AutherRepository autherRepository) {
        this.autherRepository = autherRepository;
    }

    @RequestMapping("/authers")
    public String getAuthers(Model model) {
        model.addAttribute("authers", autherRepository.findAll());
        return "authers/authers";
    }
}
