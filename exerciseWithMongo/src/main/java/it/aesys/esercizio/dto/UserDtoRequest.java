package it.aesys.esercizio.dto;

import it.aesys.esercizio.entities.Address;
import lombok.*;

import java.util.Date;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserDtoRequest {

    String fiscalCode;
    String name;
    String surname;
    Address address;
    String password;
    Date birthDate;
}
