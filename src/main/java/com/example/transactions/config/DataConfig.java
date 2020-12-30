package com.example.transactions.config;

import org.springframework.context.annotation.AdviceMode;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.aspectj.AnnotationTransactionAspect;

import javax.sql.DataSource;

@Configuration
@EnableTransactionManagement(mode = AdviceMode.ASPECTJ)
public class DataConfig {
    //@Bean
    public DataSource h2() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("org.h2.Driver");
        dataSource.setUrl("jdbc:h2:mem:testdb");
        dataSource.setUsername("sa");
        dataSource.setPassword("password");
        return dataSource;
    }

    @Bean
    public PlatformTransactionManager transactionManager() {
        DataSourceTransactionManager transactionManager = new DataSourceTransactionManager(h2());
        // Make native AspectJ declarative transactions work with compile-time weaving
        AnnotationTransactionAspect.aspectOf().setTransactionManager(transactionManager);
        return transactionManager;
    }
}
