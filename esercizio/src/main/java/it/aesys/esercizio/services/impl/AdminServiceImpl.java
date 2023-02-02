package it.aesys.esercizio.services.impl;

import it.aesys.esercizio.dto.AdminDtoResponse;
import it.aesys.esercizio.dto.AdminDtoRequest;
import it.aesys.esercizio.entities.Admin;
import it.aesys.esercizio.exception.BadInputException;
import it.aesys.esercizio.repositories.AdminRepository;
//import it.aesys.esercizio.repositories.AdminRepositoryMongo;
import it.aesys.esercizio.client.service.MongoServiceClient;
import it.aesys.esercizio.services.AdminService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class AdminServiceImpl implements AdminService {

    @Autowired
    MongoServiceClient mongoServiceClient;
    @Autowired
    AdminRepository repo;
    @Autowired
    ModelMapper mapper;

    @Autowired
    PasswordEncoder passwordEncoder;

//    @Autowired
//    AdminRepositoryMongo mongoRepo;

    @Override
    @Transactional
    public void createAdmin(AdminDtoRequest admin) throws BadInputException {
        if (admin != null && admin.getFiscalCode() != null && admin.getFiscalCode().length() == 16) {

            Admin newAdmin = new Admin();
            mapper.map(admin, newAdmin);
            newAdmin.setPassword(passwordEncoder.encode(admin.getPassword()));

            repo.save(newAdmin);
        } else {
            throw new BadInputException();
        }
    }


    @Override
    public List<AdminDtoResponse> getAllAdmin() {

        List<AdminDtoResponse> responseList = new ArrayList<>();

        List<Admin> persistenceList = repo.findAll();
        for (Admin a : persistenceList) {
            AdminDtoResponse adminDtoResponse = new AdminDtoResponse();
            mapper.map(a, adminDtoResponse);
            responseList.add(adminDtoResponse);
        }
        if (responseList.isEmpty()) {
            throw new NullPointerException();
        } else {
            return responseList;
        }
    }

    @Override
    public AdminDtoResponse getAdminByFiscalCode(String fiscalCode) throws BadInputException {
        if (fiscalCode != null) {
            Admin admin = repo.findAdminByFiscalCode(fiscalCode);
            AdminDtoResponse response = new AdminDtoResponse();
            mapper.map(admin, response);

            if (response == null) {
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
    public void removeAdminByFiscalCode(String fiscalCode) throws BadInputException {
        if (fiscalCode.length() == 16) {
            Admin adminToDelete = repo.findAdminByFiscalCode(fiscalCode);
            repo.delete(adminToDelete);
        } else {
            throw new BadInputException();
        }
    }
}
