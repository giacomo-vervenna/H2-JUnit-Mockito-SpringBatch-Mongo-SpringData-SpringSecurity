package it.aesys.esercizio.service;

import it.aesys.esercizio.dto.AdminDtoRequest;
import it.aesys.esercizio.dto.AdminDtoResponse;
import it.aesys.esercizio.entities.Admin;
import it.aesys.esercizio.exception.BadInputException;
import it.aesys.esercizio.repositories.AdminRepository;
import it.aesys.esercizio.services.impl.AdminServiceImpl;
import it.aesys.esercizio.services.impl.AdminServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;


import static org.junit.jupiter.api.Assertions.*;

import org.modelmapper.ModelMapper;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
public class TestService {

    @Mock
    AdminRepository repo;

    @InjectMocks
    AdminServiceImpl service;

    @Mock
    ModelMapper mapper;

    @Test
    void testCreateAdmin() throws BadInputException {

        AdminDtoRequest admin = new AdminDtoRequest();
        admin.setFiscalCode("vrvgcm95t06c632k");
        admin.setName("Gennaro");
        admin.setSurname("Mosconi");
        admin.setPassword("password");
        admin.setBirthDate(new Date(1999 - 12 - 21));

        assertDoesNotThrow(() -> {
            service.createAdmin(admin);
        });
    }

    @Test
    void testDeleteByFiscalCode() throws BadInputException {

        Admin admin = new Admin();
        admin.setFiscalCode("vrvgcm95t06c632k");

        repo.save(admin);
        assertThat(repo).isNotNull();


        assertDoesNotThrow(() -> {
            service.removeAdminByFiscalCode("vrvgcm95t06c632k");
        });
    }

    @Test
    void testDeleteByFiscalCode_noFiscalCode() throws BadInputException {

        Admin admin = new Admin();
        admin.setFiscalCode("vrvgcm95t06c632k");

        repo.save(admin);
        assertThat(repo).isNotNull();

        Assertions.assertThrows(BadInputException.class, () -> {
            service.removeAdminByFiscalCode("");
        });
    }

    @Test
    void testGetAll() {
        AdminDtoResponse admin1 = new AdminDtoResponse();
        List<AdminDtoResponse> response = new ArrayList<>();
        response.add(admin1);

        assertDoesNotThrow(() -> {
        });
    }

    @Test
    void testFindAdminByFiscalCode() {
        Assertions.assertThrows(BadInputException.class, () -> {
            service.getAdminByFiscalCode(null);
        });
    }

    @Test
    void createAdmin_nullObjectRequest() throws BadInputException {
        assertThrows(BadInputException.class, () -> {
            service.createAdmin(null);
        });
    }

}
