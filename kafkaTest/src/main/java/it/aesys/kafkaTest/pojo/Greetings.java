package it.aesys.kafkaTest.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Greetings {

    private String msg;
    private String name;
}
