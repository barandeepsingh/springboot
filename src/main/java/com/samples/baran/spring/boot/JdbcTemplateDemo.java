package com.samples.baran.spring.boot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class JdbcTemplateDemo implements CommandLineRunner {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public static void main(String[] args) {

        SpringApplication.run(JdbcTemplateDemo.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        int result = jdbcTemplate.update("insert into department (id,name,salary,departmentid) values (11,'Abc',100,2)");
        if (result > 0) {
            System.out.println("Data inserted");
        }
        jdbcTemplate.query("select * from department", (rs, i) -> DepartmentDTO.builder()
                .id(rs.getInt("id"))
                .name(rs.getString("name"))
                .salary(rs.getInt("salary"))
                .departmentid(rs.getInt("departmentid"))
                .build()).forEach(System.out::println);
    }
}
