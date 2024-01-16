package fr.barlords.dndwebappapi.bootstrap.config.domain;


import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EntityScan(basePackages = {"fr.barlords.dndwebappapi.server.entity"})
@EnableJpaRepositories(basePackages = {"fr.barlords.dndwebappapi.server.repository"})
public class DomainConfiguration {



}
