package com.fashionboutique.fashionstore.config;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;

import javax.sql.DataSource;
import java.util.HashMap;

@Configuration
@RequiredArgsConstructor
public class ProductConfigDataSource {
    @Autowired
    private CommonConfig commonConfig;
    @Bean
    public DataSource productDataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(commonConfig.getProductDriver());
        dataSource.setUrl(commonConfig.getProductUrl());
        dataSource.setUsername(commonConfig.getProductUsername());
        dataSource.setPassword(commonConfig.getProductPassword());
        return dataSource;
    }
    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
        LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
        em.setDataSource(productDataSource());
        em.setPackagesToScan("com.fashionboutique.fashionstore");
        HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
        em.setJpaVendorAdapter(vendorAdapter);
        HashMap<String, Object> properties = new HashMap<>();
        properties.put("hibernate.dialect", commonConfig.getProductDialect());
        properties.put("hibernate.show_sql", true);
        em.setJpaPropertyMap(properties);
        return em;
    }
    @Bean
    public JpaTransactionManager productTransactionManager() {
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(entityManagerFactory().getObject());
        return transactionManager;
    }
    @Bean
    public JdbcTemplate productJdbcTemplate() {
        return new JdbcTemplate(productDataSource());
    }
    @Bean
    public NamedParameterJdbcTemplate productNamedParameterJdbcTemplate() {
        return new NamedParameterJdbcTemplate(productDataSource());
    }
}

