package de.csausl.nftag22_externalapis.model;
import java.util.List;

public record PersonData(
        int id,
        String name,
        String status,
        String species,
        String speciesType,
        String gender
        //PersonOrigin origin,
        //PersonLocation location,
        //String image,
        //List<String> episode,
        //String characterUrl,
        //String created

) {
}
