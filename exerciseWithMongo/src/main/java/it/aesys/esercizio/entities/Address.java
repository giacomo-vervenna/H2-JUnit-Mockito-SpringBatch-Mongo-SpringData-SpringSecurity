package it.aesys.esercizio.entities;

import lombok.*;
import org.bson.codecs.pojo.annotations.BsonProperty;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Document
public class Address {


    @BsonProperty("_id")
    private ObjectId id;

    @NonNull
    String street;
    @NonNull
    String civic;
    @NonNull
    Integer postalCode;
}
