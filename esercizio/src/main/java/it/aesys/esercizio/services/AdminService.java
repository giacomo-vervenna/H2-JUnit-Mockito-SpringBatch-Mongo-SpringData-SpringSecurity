package it.aesys.esercizio.services;

import it.aesys.esercizio.dto.AdminDtoResponse;
import it.aesys.esercizio.dto.AdminDtoRequest;
import it.aesys.esercizio.exception.BadInputException;

import java.util.List;

public interface AdminService {

   void createAdmin(AdminDtoRequest Admin) throws BadInputException;
   List<AdminDtoResponse> getAllAdmin();
   AdminDtoResponse getAdminByFiscalCode(String fiscalCode) throws BadInputException;
   void removeAdminByFiscalCode(String fiscalCode) throws BadInputException;
}
