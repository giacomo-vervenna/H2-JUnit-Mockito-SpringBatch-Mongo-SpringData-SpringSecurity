package it.aesys.esercizio.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import it.aesys.esercizio.dto.users.UserDtoRequest;
import it.aesys.esercizio.dto.users.UserDtoResponse;
import it.aesys.esercizio.exception.BadInputException;
import it.aesys.esercizio.client.service.MongoServiceClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/mongo-user")
public class UserClientController {

    @Autowired
    MongoServiceClient mongoClient;

    @PostMapping
    public ResponseEntity<Void> createUser(@RequestBody UserDtoRequest user) {
        return mongoClient.createUser(user);
    }

    @GetMapping
    @Operation(security = @SecurityRequirement(name = "bearer-authentication"))
    ResponseEntity<List<UserDtoResponse>> getAllUser() {
        return mongoClient.getAllUser();
    }

    @GetMapping("/{fiscalCode}")
    ResponseEntity<UserDtoResponse> getUserByFiscalCode(@PathVariable("fiscalCode") String fiscalCode) {
        return mongoClient.getUserByFiscalCode(fiscalCode);
    }

    @DeleteMapping("/{fiscalCode}")
    ResponseEntity<Void> deleteUserByFiscalCode(@PathVariable("fiscalCode") String fiscalCode) {
        return mongoClient.deleteUserByFiscalCode(fiscalCode);
    }

    @PutMapping("/{fiscalCode}")
    public ResponseEntity<Void> updateUserByFiscalCode(@PathVariable("fiscalCode") String fiscalCode,
                                                       @RequestBody UserDtoRequest update) {
        return mongoClient.updateUserByFiscalCode(fiscalCode, update);
    }
}
