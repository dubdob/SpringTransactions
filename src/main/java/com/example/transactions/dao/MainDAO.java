package com.example.transactions.dao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import javax.sql.DataSource;

@Repository
public class MainDAO {
    private final JdbcTemplate jdbcTemplate;
    private final Logger logger = LoggerFactory.getLogger(MainDAO.class);


    public MainDAO(DataSource postgres) {
        this.jdbcTemplate = new JdbcTemplate(postgres);
    }

    public Integer getSoundsCount() {
        return jdbcTemplate.queryForObject(
                "SELECT COUNT(*) FROM Sound", Integer.class);
    }


    @Transactional(propagation = Propagation.MANDATORY)
    public void insertSound() {
        insertAuthor();
        jdbcTemplate.update(
                "INSERT INTO Sound (author, name, id) VALUES (?,?,?)",
                0, "Spring", 0);
    }

    public void insertAuthor() {
        jdbcTemplate.update(
                "INSERT INTO Author (name, id) VALUES (?,?)",
                "Michael", 0);
    }

    public void delete() {
        jdbcTemplate.update(
                "TRUNCATE TABLE Author");

        jdbcTemplate.update(
                "TRUNCATE TABLE Sound\n");
    }
}
