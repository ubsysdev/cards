package com.ub.card.config;


import oracle.jdbc.pool.OracleDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.*;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.JdbcTemplate;


import javax.sql.DataSource;
import javax.validation.constraints.NotNull;
import java.sql.SQLException;

/**
 * Created by matshedisoo on 5/19/2016.
 */

@Configuration
@ConfigurationProperties("asas-test.datasource")
@PropertySource(value = { "classpath:application.properties" })
public class OracleTestConfiguration {

    @Bean(name = "jdbcTest")
    public JdbcTemplate jdbcTemplate(DataSource oracleTestDataSource) {
        return new JdbcTemplate(oracleTestDataSource);
    }

    @Autowired
    private Environment env;

    @Primary
    @Bean
    DataSource oracleTestDataSource() throws SQLException {

        OracleDataSource oracleTestDataSource = new OracleDataSource();
        oracleTestDataSource.setUser(env.getProperty("asas-test.datasource.username"));
        oracleTestDataSource.setPassword(env.getProperty("asas-test.datasource.password"));
        oracleTestDataSource.setURL(env.getProperty("asas-test.datasource.url"));
        oracleTestDataSource.setDriverType(env.getProperty("asas-test.datasource.driver-class-name"));
        //dataSource.setPortNumber(1521);
        oracleTestDataSource.setDriverType("thin");
        oracleTestDataSource.setImplicitCachingEnabled(true);
        oracleTestDataSource.setFastConnectionFailoverEnabled(true);
        return oracleTestDataSource;
    }
}
