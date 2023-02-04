package it.aesys.esercizio.security;

import it.aesys.esercizio.entities.Admin;
import it.aesys.esercizio.repositories.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collections;


@Service
public class AdminDetailsService implements UserDetailsService {

    @Autowired
    private AdminRepository repo;

    @Override
    public UserDetails loadUserByUsername(String fiscalCode) throws UsernameNotFoundException {
        Admin admin = repo.findAdminByFiscalCode(fiscalCode);
        if (admin.equals(null)) {
            throw new UsernameNotFoundException("Admin with fiscal code " + fiscalCode + " not found");
        }
        return new User(
                fiscalCode,
                admin.getPassword(),
                Collections.singletonList(new SimpleGrantedAuthority("ADMIN")));
    }
}
