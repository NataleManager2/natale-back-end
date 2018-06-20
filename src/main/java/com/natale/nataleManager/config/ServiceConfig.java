package com.natale.nataleManager.config;


import com.natale.nataleManager.repository.ClienteRepository;
import com.natale.nataleManager.service.impl.ClienteServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.convert.threeten.Jsr310JpaConverters;


@Configuration
@EntityScan(basePackageClasses = {Jsr310JpaConverters.class}, basePackages = "com.natale.nataleManager.model")
public class ServiceConfig {

    @Autowired
    private ClienteRepository complaintTypeRepository;

    @Bean
    public ClienteServiceImpl clienteService(){return new ClienteServiceImpl(complaintTypeRepository);}


}
