package it.aesys.esercizio.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RawUser {

    String fiscalCode;
    String name;
    String surname;
    String street;
    String civic;
    String password;
    Integer postalCode;
    String birthDate;

}
