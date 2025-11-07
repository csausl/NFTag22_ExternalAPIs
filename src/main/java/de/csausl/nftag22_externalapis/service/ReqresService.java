package de.csausl.nftag22_externalapis.service;

import de.csausl.nftag22_externalapis.model.*;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import java.util.List;

@Service
public class ReqresService {
    private final RestClient restClient;

    public ReqresService(RestClient.Builder restClientBuilder) {
        this.restClient = restClientBuilder
                .baseUrl("https://reqres.in/api")
                .defaultHeader("x-api-key", "reqres-free-v1")
                .build();
    }

    public List<UserData> getUsers(){
        List<UserData> users=
                restClient.get()
                        .uri("/users")
                        .retrieve()
                        .body(MultiUser.class)
                        .data();
        return users;
    }


    public ResponseNewUser createUser(RequestNewUser newUser){
        return restClient.post()
                .uri("/users")
                .contentType(MediaType.APPLICATION_JSON)
                //.header("x-api-key", "reqres-free-v1")
                .body(newUser)
                .retrieve()
                .body(ResponseNewUser.class);
    }
}
