package it.aesys.esercizio.service;

import it.aesys.esercizio.dto.UserDtoRequest;
import it.aesys.esercizio.exception.BadInputException;
import it.aesys.esercizio.repositories.UserRepository;
import it.aesys.esercizio.services.impl.UserServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.modelmapper.ModelMapper;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class UserServiceTest {

    @Mock
    UserRepository repo;
    @Mock
    ModelMapper mapper;
    @InjectMocks
    UserServiceImpl service;

    @Test
    void createUserTest_MustThrowBadInputEx () {
        UserDtoRequest user = new UserDtoRequest();

        assertThrows(BadInputException.class, () -> service.createUser(user));
    }
}
