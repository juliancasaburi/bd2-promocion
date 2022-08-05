package com.bbdd2promocion.config;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;

import javax.sql.DataSource;
import java.util.Properties;

@Configuration
@PropertySource("classpath:application.properties")
public class HibernateConfiguration {

    @Autowired
    private Environment env;

    @Bean(destroyMethod="close")
    public DataSource dataSource() {
        HikariConfig hikariConfig = new HikariConfig();
        hikariConfig.setDriverClassName(env.getProperty("spring.datasource.hikari.driver-class-name"));
        hikariConfig.setJdbcUrl(env.getProperty("spring.datasource.hikari.jdbc-url"));
        hikariConfig.setUsername(env.getProperty("spring.datasource.hikari.username"));
        hikariConfig.setPassword(env.getProperty("spring.datasource.hikari.password"));
        hikariConfig.setMaximumPoolSize(Integer.parseInt(env.getProperty("spring.datasource.hikari.maximum-pool-size")));

        HikariDataSource dataSource = new HikariDataSource(hikariConfig);
        return dataSource;
    }

    @Bean(name="entityManagerFactory")
    public LocalSessionFactoryBean sessionFactory() {
        LocalSessionFactoryBean factory = new LocalSessionFactoryBean();
        factory.setHibernateProperties(hibernateProperties());
        factory.setDataSource(dataSource());
        factory.setPackagesToScan("com.bbdd2promocion.model");
        return factory;
    }

    @Bean
    public Properties hibernateProperties() {
        Properties hibernateProperties = new Properties();
        hibernateProperties.put("hibernate.dialect", env.getProperty("spring.jpa.hibernate.dialect"));
        hibernateProperties.put("hibernate.show_sql", env.getProperty("spring.jpa.hibernate.show_sql"));
        hibernateProperties.put("hibernate.hbm2ddl.auto", env.getProperty("spring.jpa.hibernate.ddl-auto"));
        return hibernateProperties;
    }

}