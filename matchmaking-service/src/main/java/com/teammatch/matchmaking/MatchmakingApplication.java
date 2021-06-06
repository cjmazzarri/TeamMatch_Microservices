package com.teammatch.matchmaking;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.Bean;

@SpringBootApplication(scanBasePackages={"com.teammatch.matchmaking","com.teammatch.matchmaking"})
public class MatchmakingApplication {

    public static void main(String[] args) {
        SpringApplication.run(MatchmakingApplication.class, args);
    }

    @Bean //agregar
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }
}
