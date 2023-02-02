package it.aesys.esercizio.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
//import org.bson.codecs.pojo.annotations.BsonProperty;
//import org.bson.types.ObjectId;
//import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@Entity(name = "admins")
//@Document
public class Admin{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;
    @NonNull
    String fiscalCode;
    @NonNull
    String name;
    @NonNull
    String surname;
    @NonNull
    @JsonIgnore
    String password;
    @NonNull
    Date birthDate;
}
