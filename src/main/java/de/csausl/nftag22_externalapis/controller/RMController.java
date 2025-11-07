package de.csausl.nftag22_externalapis.controller;

import de.csausl.nftag22_externalapis.model.PersonData;
import de.csausl.nftag22_externalapis.service.RMService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/characters")
public class RMController {

    private final RMService rmService;

    public RMController(RMService rmService) {
        this.rmService = rmService;
    }

    @GetMapping
    public List<PersonData> getPersons() {
        return rmService.getPersons();
    }

    @GetMapping("/{id}")
    public PersonData getPersonByID(@PathVariable String id) {
        return rmService.getPersonById(id);
    }

    @PostMapping
    public PersonData createPerson(@RequestBody PersonData person) {
        return rmService.createPerson();
    }

}
