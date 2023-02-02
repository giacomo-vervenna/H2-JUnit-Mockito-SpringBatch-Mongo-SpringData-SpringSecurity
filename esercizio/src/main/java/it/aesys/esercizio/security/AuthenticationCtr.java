package it.aesys.esercizio.security;

import it.aesys.esercizio.entities.Admin;
import it.aesys.esercizio.repositories.AdminRepository;
import it.aesys.esercizio.security.dto.LoginOutput;
import it.aesys.esercizio.security.dto.LoginInput;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/authentication")
public class AuthenticationCtr {

    @Autowired
    AdminRepository repo;

    @PostMapping
    public ResponseEntity<LoginOutput> signIn(@RequestBody LoginInput body) {

        Admin admin = repo.findAdminByFiscalCode(body.getFiscalCode());
        String auth = "";
        if (body.getPassword().equals(admin.getPassword())) {

            auth = "ok";
        }

            Map claimMap = new HashMap<>();
            claimMap.put("ok", auth);

            String jwt = JwtProvider.createJwt(auth, claimMap);
            LoginOutput tmp = new LoginOutput();
            tmp.setJwt(jwt);
            return ResponseEntity.ok(tmp);

    }
}
