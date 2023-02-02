package it.aesys.esercizio.client.service;
import it.aesys.esercizio.client.UserClientConfig;
import it.aesys.esercizio.dto.users.UserDtoRequest;
import it.aesys.esercizio.dto.users.UserDtoResponse;
import it.aesys.esercizio.exception.BadInputException;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(name= "${spring.cloud.openfeign.client.config.feign.name}",url = "${spring.cloud.openfeign.client.config.feign.url}", configuration = UserClientConfig.class)
public interface MongoServiceClient {

    @RequestMapping(method = RequestMethod.POST, produces = "application/json")
    ResponseEntity<Void> createUser(@RequestBody UserDtoRequest user);
    @RequestMapping(method = RequestMethod.GET, produces =  "application/json")
    ResponseEntity<List<UserDtoResponse>> getAllUser();
    @RequestMapping(method = RequestMethod.GET, produces = "application/json", value ="/{fiscalCode}")
    ResponseEntity<UserDtoResponse> getUserByFiscalCode (@PathVariable ("fiscalCode") String fiscalCode);
    @RequestMapping(method = RequestMethod.DELETE, value ="/{fiscalCode}" )
    ResponseEntity<Void> deleteUserByFiscalCode (@PathVariable ("fiscalCode") String fiscalCode);
    @RequestMapping(method = RequestMethod.PUT, value ="/{fiscalCode}")
     ResponseEntity<Void> updateUserByFiscalCode (@PathVariable ("fiscalCode") String fiscalCode,
                                                        @RequestBody UserDtoRequest update);
}
