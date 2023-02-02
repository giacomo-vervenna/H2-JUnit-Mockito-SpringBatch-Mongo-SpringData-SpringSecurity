package it.aesys.esercizio.dto.users;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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
