package fr.barlords.dndwebappapi.bootstrap;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(scanBasePackages = {"fr.barlords"}, exclude = {SecurityAutoConfiguration.class})
public class DndwebappApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(DndwebappApiApplication.class, args);
    }

}
