package de.csausl.nftag22_externalapis.controller;

import de.csausl.nftag22_externalapis.model.RequestNewUser;
import de.csausl.nftag22_externalapis.model.ResponseNewUser;
import de.csausl.nftag22_externalapis.model.UserData;
import de.csausl.nftag22_externalapis.service.ReqresService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/reqres")
public class ReqresController {
    private final ReqresService reqresService;
    public ReqresController(ReqresService reqresService) {
        this.reqresService = reqresService;
    }

    @GetMapping("/users")
    public List<UserData> getUsers() {
        return reqresService.getUsers();
    }

    @PostMapping("/users")
    public ResponseNewUser createUser(@RequestBody RequestNewUser data){
        return reqresService.createUser(data);
    }
}
