package com.subham.springJdbc.javaconfig;

import com.subham.dao.StudentDao;
import com.subham.dao.StudentDaoImp;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

@Configuration
public class Config {

    @Bean
    public DataSource getDataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/spring_jdbc");
        dataSource.setUsername("root");
        dataSource.setPassword("Run@0");
        return dataSource;
    }

    @Bean("jdbcTemp")
    public JdbcTemplate getJdbctemplate() {
        JdbcTemplate jd = new JdbcTemplate();
        jd.setDataSource(getDataSource());
        return jd;
    }

    @Bean("stdao")
    public StudentDao studentDao(){
        StudentDaoImp studentDaoImp = new StudentDaoImp();
        studentDaoImp.setTemplate(getJdbctemplate());
        return studentDaoImp;
    }
}
