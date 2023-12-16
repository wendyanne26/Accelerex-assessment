package com.chinwendu.accelerexbackendaccessment;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class AccelerexBackendAccessmentApplication {

    public static void main(String[] args) {
        SpringApplication.run(AccelerexBackendAccessmentApplication.class, args);
    }

}
