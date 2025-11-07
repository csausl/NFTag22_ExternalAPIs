package de.csausl.nftag22_externalapis.service;

import de.csausl.nftag22_externalapis.model.PersonData;
import de.csausl.nftag22_externalapis.model.PersonResults;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import java.util.List;

@Service
public class RMService {

    // wir importieren uns einen REST-Client
    // unter spring boot 3 -> manuell WebFlux hinzufügen (Vorgänger des Rest clients)
    private final RestClient restClient;

    public RMService(RestClient.Builder restClientBuilder) {
        this.restClient = restClientBuilder
                .baseUrl("https://rickandmortyapi.com/api")
                .build();
    }

    public List<PersonData> getPersons() {
        List<PersonData> persons =
                restClient.get()
                        .uri("/character")
                        .retrieve()
                        .body(PersonResults.class)
                        .results();
        return persons;}

    public PersonData getPersonById(String id) {
        PersonData person=
                restClient.get()
                        .uri("/character/"+id)
                        .retrieve()
                        .body(PersonData.class);
        return person;

    }

    public PersonData createPerson() {return null;}
}
