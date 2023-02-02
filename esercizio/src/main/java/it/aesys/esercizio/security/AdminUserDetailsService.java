package it.aesys.esercizio.security;

import it.aesys.esercizio.entities.Admin;
import it.aesys.esercizio.repositories.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class AdminUserDetailsService implements UserDetailsService {

    @Autowired
    AdminRepository repo;

    @Override
    public UserDetails loadUserByUsername(String fiscalCode) throws UsernameNotFoundException {
        try {
            Admin admin = repo.findAdminByFiscalCode(fiscalCode);
            return new User(admin.getFiscalCode(), admin.getPassword(), new ArrayList<>());
        } catch (UsernameNotFoundException e) {
            throw new UsernameNotFoundException("Amministratore non trovato");
        }
    }
}
