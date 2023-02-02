package it.aesys.esercizio.repositories;

import it.aesys.esercizio.entities.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface UserRepository extends MongoRepository<User, String> {

    public User findUserByFiscalCode(String fiscalCode);
}
