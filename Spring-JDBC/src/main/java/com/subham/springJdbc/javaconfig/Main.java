package com.subham.springJdbc.javaconfig;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class Main {
    public static void main(String[] args) throws SQLException {
        ApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
        JdbcTemplate jdbc = context.getBean("jdbcTemp", JdbcTemplate.class);
        System.out.println(jdbc.getDataSource().getConnection());

        //insert
//        String insertQuery = "insert into student(id,name,address) values(?,?,?)";
//        int count = jdbc.update(insertQuery,103,"Brabhash","Kendujhar");
//        System.out.println("Successfully "+count+" rows inserted");

        //update
//        String updateQuery = "update student set name=?,address=? where id=?";
//        int count = jdbc.update(updateQuery,"Rashmika","Bhubaneswar",103);
//        System.out.println("Successfully "+count+" rows updated");

        //delete
//        String deleteQuery = "delete from student where id=?";
//        int count = jdbc.update(deleteQuery,103);
//        System.out.println("Successfully "+count+" rows deleted");

        //fetching
//        String fetch = "select * from student where id=?";
//        RowMapper rowMapper = (rs, rowNum) -> rs.getString(2);
//        String name = (String) jdbc.queryForObject(fetch,rowMapper,101);
//        System.out.println(name);

        //fetchingAll
        String fetch = "select * from student";
        RowMapper rowMapper = (rs, rowNum) -> rs.getString(2);
        List<String> list = jdbc.query(fetch,rowMapper);
        for (String res : list){
            System.out.println(res);
        }


    }
}
