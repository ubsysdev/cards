package com.ub.card.model;

import org.springframework.jdbc.core.RowMapper;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by matshedisoo on 5/19/2016.
 */
public class PersonMapper implements RowMapper<Person> {

    public Person mapRow(ResultSet resultSet,int rowNum) throws SQLException{
        Person person = new Person();
        //person.setEMPLID(resultSet.getString("EMPLID"));

        return person;
    }
}
