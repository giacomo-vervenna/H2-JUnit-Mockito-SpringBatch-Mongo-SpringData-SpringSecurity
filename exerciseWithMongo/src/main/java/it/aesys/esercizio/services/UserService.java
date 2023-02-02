package it.aesys.esercizio.services;

import it.aesys.esercizio.dto.UserDtoResponse;
import it.aesys.esercizio.dto.UserDtoRequest;
import it.aesys.esercizio.exception.BadInputException;

import java.util.List;

public interface UserService {

   void createUser(UserDtoRequest user) throws BadInputException;
   List<UserDtoResponse> getAllUser();
   UserDtoResponse getUserByFiscalCode(String fiscalCode) throws BadInputException;
   void removeUserByFiscalCode(String fiscalCode) throws BadInputException;

    void updateUserByFiscalCode(String fiscalCode, UserDtoRequest update);
}
