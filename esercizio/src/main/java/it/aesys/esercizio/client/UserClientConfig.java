package it.aesys.esercizio.client;

import feign.Retryer;
import org.springframework.context.annotation.Bean;

public class UserClientConfig {
    @Bean
     public CustomErrorDecoder errorDecoder() {
        return new CustomErrorDecoder();
    }
    @Bean
    public Retryer retryer(){
        return new Retryer.Default();
    }
}
