package com.bbdd2promocion.config;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.core.env.Environment;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;

import javax.sql.DataSource;
import java.util.Properties;

@Configuration
public class HibernateConfiguration {

    private final JSONObject springProperties;

    public HibernateConfiguration(Environment env) throws JSONException {
        springProperties = new JSONObject(env.getProperty("SPRING_APPLICATION_JSON"));
    }

    @Bean(destroyMethod="close")
    public DataSource dataSource() throws JSONException {
        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setDriverClassName("org.postgresql.Driver");
        dataSource.setUrl(springProperties.getString("spring.datasource.url"));
        dataSource.setUsername(springProperties.getString("spring.datasource.username"));
        dataSource.setPassword(springProperties.getString("spring.datasource.password"));
        return dataSource;
    }

    @Bean(name="entityManagerFactory")
    public LocalSessionFactoryBean sessionFactory() throws JSONException {
        LocalSessionFactoryBean factory = new LocalSessionFactoryBean();
        factory.setHibernateProperties(hibernateProperties());
        factory.setDataSource(dataSource());
        factory.setPackagesToScan(new String[]{"com.bbdd2promocion.model"});
        return factory;
    }

    @Bean
    public Properties hibernateProperties() throws JSONException {
        Properties hibernateProperties = new Properties();
        hibernateProperties.put("hibernate.dialect", springProperties.getString("spring.jpa.hibernate.dialect"));
        hibernateProperties.put("hibernate.show_sql", springProperties.getString("spring.jpa.hibernate.show_sql"));
        hibernateProperties.put("hibernate.hbm2ddl.auto", springProperties.getString("spring.jpa.hibernate.ddl-auto"));
        return hibernateProperties;
    }

}