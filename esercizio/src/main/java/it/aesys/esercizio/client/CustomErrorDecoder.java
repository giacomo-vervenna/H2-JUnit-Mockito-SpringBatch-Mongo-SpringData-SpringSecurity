package it.aesys.esercizio.client;

import feign.Response;
import feign.codec.ErrorDecoder;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class CustomErrorDecoder implements ErrorDecoder {
    @Override
    public Exception decode(String s, Response response) {
        HttpStatus responseStatus = HttpStatus.valueOf(response.status());
        if (responseStatus.equals(HttpStatus.NOT_FOUND)) {
            return new ResponseStatusException(HttpStatus.NOT_FOUND);
        } else if (responseStatus.equals(HttpStatus.UNAUTHORIZED) || responseStatus.equals(HttpStatus.FORBIDDEN)) {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED);
        } else if (responseStatus.is4xxClientError()) {
            return new Exception(response.status() + " " + response.reason());
        } else {
            return new Exception(String.valueOf(response.status()));
        }
    }
}