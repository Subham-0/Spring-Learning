package com.subham;


import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import java.sql.SQLException;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws SQLException {
        ApplicationContext context = new ClassPathXmlApplicationContext("config.xml");
        JdbcTemplate jdTemp = context.getBean("jdbcTemp",JdbcTemplate.class);
        System.out.println(jdTemp.getDataSource().getConnection());

        String query = "insert into student(id,name,address) values(?,?,?)";
        jdTemp.update(query,102,"rajib","Baleswar");
        System.out.println("Successfully inserted");
    }
}
