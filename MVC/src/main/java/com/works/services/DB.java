package com.works.services;

import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.stereotype.Service;

@Service
public class DB {

    public DriverManagerDataSource dataSource() {
        DriverManagerDataSource source = new DriverManagerDataSource();
        source.setDriverClassName("org.h2.Driver");
        source.setUrl("jdbc:h2:file:~/bank_of_tokyo_1");
        source.setUsername("sa");
        source.setPassword("sa");
        return source;
    }

}
