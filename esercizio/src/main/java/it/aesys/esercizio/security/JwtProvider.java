package it.aesys.esercizio.security;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTCreator;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;

import java.util.Calendar;
import java.util.Date;
import java.util.Map;

public class JwtProvider {

    public static DecodedJWT verifyJwt(String jwt) {
        return JWT.require(Algorithm.HMAC256(SecurityConfig.secret)).build().verify(jwt);
    }

    public static String createJwt(String subject, Map<String, Object> payloadClaims) {
        Calendar cal = Calendar.getInstance();
        Date now = cal.getTime();
        cal.set(Calendar.HOUR_OF_DAY, cal.get(Calendar.HOUR_OF_DAY) + 1);
        Date nowMoreHour = cal.getTime();

        JWTCreator.Builder builder = JWT.create()
                .withSubject(subject)
                .withIssuer("Admin-JWT")
                .withIssuedAt(now)
                .withExpiresAt(nowMoreHour);

        if (payloadClaims != null && !payloadClaims.isEmpty()) {
            for (Map.Entry<String, Object> entry : payloadClaims.entrySet()) {
                builder.withClaim(entry.getKey(), entry.getValue().toString());
            }
        }
        return builder.sign(Algorithm.HMAC256(SecurityConfig.secret));
    }
    private JwtProvider() {
    }
}

