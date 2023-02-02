package it.aesys.esercizio.entities;

import lombok.*;
import org.bson.codecs.pojo.annotations.BsonProperty;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
@Getter
@Setter
@NoArgsConstructor
@Document
public class User {

    @BsonProperty("_id")
    private ObjectId id;
    @NonNull
    String fiscalCode;
    @NonNull
    String name;
    @NonNull
    String surname;
    @NonNull
    Address address;
    @NonNull
    String birthDate;
}
