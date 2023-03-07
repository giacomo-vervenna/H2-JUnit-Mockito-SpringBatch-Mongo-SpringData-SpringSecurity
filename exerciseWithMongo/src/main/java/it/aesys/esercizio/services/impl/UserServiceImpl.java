package it.aesys.esercizio.services.impl;

import it.aesys.esercizio.dto.UserDtoResponse;
import it.aesys.esercizio.dto.UserDtoRequest;
import it.aesys.esercizio.entities.User;
import it.aesys.esercizio.exception.BadInputException;
import it.aesys.esercizio.repositories.UserRepository;
//import it.aesys.esercizio.repositories.UserRepositoryMongo;
import it.aesys.esercizio.services.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional(readOnly = true)
public class UserServiceImpl implements UserService {
    @Autowired
    ModelMapper mapper;

    @Autowired
    UserRepository mongoRepo;

    @Override
    @Transactional
    public void createUser(UserDtoRequest user) {
        try {
            if (user != null && user.getFiscalCode() != null && user.getFiscalCode().length() == 16) {

                User newUser = new User();
                mapper.map(user, newUser);

                mongoRepo.save(newUser);
            } else {
                throw new BadInputException();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    @Override
    public List<UserDtoResponse> getAllUser() {

        List<UserDtoResponse> responseList = new ArrayList<>();

        List<User> persistenceList = mongoRepo.findAll();
        for (User u : persistenceList) {
            UserDtoResponse userDtoResponse = new UserDtoResponse();
            mapper.map(u, userDtoResponse);
            responseList.add(userDtoResponse);
        }
        if (responseList.isEmpty()) {
            throw new NullPointerException();
        } else {
            return responseList;
        }
    }

    @Override
    public UserDtoResponse getUserByFiscalCode(String fiscalCode) throws BadInputException {
        if (fiscalCode != null) {

            User user = mongoRepo.findUserByFiscalCode(fiscalCode);
            UserDtoResponse response = new UserDtoResponse();
            mapper.map(user, response);

            if (response.getName().isEmpty()) {
                throw new IllegalArgumentException();
            } else {
                return response;
            }
        } else {
            throw new BadInputException();
        }
    }

    @Override
    @Transactional
    public void removeUserByFiscalCode(String fiscalCode) throws BadInputException {
        if (fiscalCode.length() == 16) {

            User userToDelete = mongoRepo.findUserByFiscalCode(fiscalCode);
            mongoRepo.delete(userToDelete);
        } else {
            throw new BadInputException();
        }
    }

    @Override
    @Transactional
    public void updateUserByFiscalCode(String fiscalCode, UserDtoRequest update) {
        if (fiscalCode.length() == 16) {

            User userToUpdate = mongoRepo.findUserByFiscalCode(fiscalCode);

            mapper.map(update, userToUpdate);
            mongoRepo.save(userToUpdate);
        }

    }


}
