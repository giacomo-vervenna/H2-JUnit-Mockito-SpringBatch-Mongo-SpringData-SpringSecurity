package it.aesys.esercizio.controllers;

import it.aesys.esercizio.dto.UserDtoRequest;
import it.aesys.esercizio.dto.UserDtoResponse;
import it.aesys.esercizio.exception.BadInputException;
import it.aesys.esercizio.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user-mongo")
public class UserController {
    @Autowired
    UserService service;

    @GetMapping
    public ResponseEntity<List<UserDtoResponse>> getAllUser(){
        List<UserDtoResponse> response = service.getAllUser();
        return ResponseEntity.ok(response);
    }

    @PostMapping
    public ResponseEntity<Void> createUser(@RequestBody UserDtoRequest user) throws BadInputException {
       service.createUser(user);
       return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping("/{fiscalCode}")
    public ResponseEntity<UserDtoResponse> getUserByFiscalCode (@PathVariable ("fiscalCode") String fiscalCode) throws BadInputException {
       UserDtoResponse user = service.getUserByFiscalCode(fiscalCode);
        return ResponseEntity.ok(user);
    }

    @DeleteMapping("/{fiscalCode}")
    public ResponseEntity<Void> deleteUserByFiscalCode (@PathVariable ("fiscalCode") String fiscalCode) throws BadInputException {
        service.removeUserByFiscalCode(fiscalCode);

        return ResponseEntity.status(HttpStatus.ACCEPTED).build();
    }

    @PutMapping("/{fiscalCode}")
    public ResponseEntity<Void> updateUserByFiscalCode (@PathVariable ("fiscalCode") String fiscalCode, @RequestBody UserDtoRequest update) throws BadInputException {
        service.updateUserByFiscalCode(fiscalCode, update);

        return ResponseEntity.status(HttpStatus.ACCEPTED).build();
    }

}
