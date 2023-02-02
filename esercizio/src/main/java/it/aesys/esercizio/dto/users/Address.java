package it.aesys.esercizio.dto.users;

import lombok.*;
@Data
public class Address {
    @NonNull
    String street;
    @NonNull
    String civic;
    @NonNull
    Integer postalCode;
}
