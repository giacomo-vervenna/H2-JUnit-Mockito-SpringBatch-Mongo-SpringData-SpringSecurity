package it.aesys.esercizio.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import java.util.Date;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AdminDtoRequest {

    String fiscalCode;
    String name;
    String surname;

    String password;
    Date birthDate;
}
