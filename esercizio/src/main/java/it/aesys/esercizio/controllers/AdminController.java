package it.aesys.esercizio.controllers;

import it.aesys.esercizio.dto.AdminDtoRequest;
import it.aesys.esercizio.dto.AdminDtoResponse;
import it.aesys.esercizio.exception.BadInputException;
import it.aesys.esercizio.services.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    AdminService service;

    @GetMapping
    public ResponseEntity<List<AdminDtoResponse>> getAllAdmin(){
        List<AdminDtoResponse> response = service.getAllAdmin();
        return ResponseEntity.ok(response);
    }

    @PostMapping
    public ResponseEntity<Void> createAdmin(@RequestBody AdminDtoRequest admin) throws BadInputException {
       service.createAdmin(admin);
       return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping("/{fiscalCode}")
    public ResponseEntity<AdminDtoResponse> getAdminByFiscalCode (@PathVariable ("fiscalCode") String fiscalCode) throws BadInputException {
       AdminDtoResponse admin = service.getAdminByFiscalCode(fiscalCode);
        return ResponseEntity.ok(admin);
    }

    @DeleteMapping("/{fiscalCode}")
    public ResponseEntity<Void> deleteAdminByFiscalCode (@PathVariable ("fiscalCode") String fiscalCode) throws BadInputException {
        service.removeAdminByFiscalCode(fiscalCode);

        return ResponseEntity.status(HttpStatus.ACCEPTED).build();
    }


}
