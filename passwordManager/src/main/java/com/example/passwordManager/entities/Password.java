package com.example.passwordManager.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.bson.codecs.pojo.annotations.BsonProperty;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@NoArgsConstructor
@Document
public class Password {

    @BsonProperty("pwd_id")
    private ObjectId id;
    private String site;
    private String siteUsername;
    private String sitePassword;
}
