package it.aesys.esercizio.repositories;

import it.aesys.esercizio.entities.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

//@NoRepositoryBean
@Repository
public interface AdminRepository extends JpaRepository<Admin, String> {

   Admin findAdminByFiscalCode(String fiscalCode);
}
