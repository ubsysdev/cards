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
@PropertySource(value = { "classpath:application.properties" })
@ConfigurationProperties("ebs-test.datasource")
public class OracleEbsConfiguration {

    @Bean(name = "jdbcEBSTest")
    public JdbcTemplate jdbcTemplate(DataSource oracleEbsDataSource) {
        return new JdbcTemplate(oracleEbsDataSource);
    }

    @Autowired
    private Environment env;

    @Bean
    DataSource oracleEbsDataSource() throws SQLException {

        OracleDataSource oracleEbsDataSource = new OracleDataSource();
        oracleEbsDataSource.setUser(env.getProperty("ebs-test.datasource.username"));
        oracleEbsDataSource.setPassword(env.getProperty("ebs-test.datasource.password"));
        oracleEbsDataSource.setURL(env.getProperty("ebs-test.datasource.url"));
        oracleEbsDataSource.setPortNumber(1528);
        oracleEbsDataSource.setDriverType("thin");
        oracleEbsDataSource.setImplicitCachingEnabled(true);
        oracleEbsDataSource.setFastConnectionFailoverEnabled(true);
        return oracleEbsDataSource;
    }
}
