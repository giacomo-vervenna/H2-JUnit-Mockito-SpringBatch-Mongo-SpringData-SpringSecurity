package it.aesys.esercizio.items;

import it.aesys.esercizio.dto.RawUser;
import it.aesys.esercizio.entities.Address;
import it.aesys.esercizio.entities.User;
import lombok.Getter;
import lombok.Setter;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

@Component
@Getter
@Setter

public class UserProcessor implements ItemProcessor<RawUser, User> {

    @Override
    public User process(RawUser rawUser) throws Exception {
        User user = new User();
        Address address = new Address();

        address.setStreet(rawUser.getStreet());
        address.setCivic(rawUser.getCivic());
        address.setPostalCode(rawUser.getPostalCode());

        user.setSurname(rawUser.getSurname());
        user.setName(rawUser.getName());
        user.setFiscalCode(rawUser.getFiscalCode());
        user.setBirthDate(rawUser.getBirthDate());
        user.setAddress(address);

        return user;
    }
}

