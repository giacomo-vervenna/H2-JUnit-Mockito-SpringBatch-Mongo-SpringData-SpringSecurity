package com.example.passwordManager.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.bson.codecs.pojo.annotations.BsonProperty;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Document
public class User {

    @BsonProperty("_id")
    private ObjectId id;
    private String username;
    private String pwd;
    private List<Password> passwords;
}
