package com.ub.card.config;

import oracle.jdbc.pool.OracleDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.sql.SQLException;

/**
 * Created by matshedisoo on 5/20/2016.
 */
@Configuration
@ConfigurationProperties("card.datasource")
@PropertySource(value = { "classpath:application.properties" })
public class OracleCardConfiguration {

    @Bean(name = "jdbcCard")
    public JdbcTemplate jdbcTemplate(DataSource oracleCardDataSource) {
        return new JdbcTemplate(oracleCardDataSource);
    }

    @Autowired
    private Environment env;

    @Bean
    DataSource oracleCardDataSource() throws SQLException {

        OracleDataSource oracleCardDataSource = new OracleDataSource();
        oracleCardDataSource.setUser(env.getProperty("card.datasource.username"));
        oracleCardDataSource.setPassword(env.getProperty("card.datasource.password"));
        oracleCardDataSource.setURL(env.getProperty("card.datasource.url"));
        oracleCardDataSource.setDriverType(env.getProperty("test.datasource.driver-class-name"));
        oracleCardDataSource.setPortNumber(1522);
        oracleCardDataSource.setDriverType("thin");
        oracleCardDataSource.setImplicitCachingEnabled(true);
        oracleCardDataSource.setFastConnectionFailoverEnabled(true);
        return oracleCardDataSource;
    }
}
