package com.subham.springJdbc.xml;


import com.subham.dao.StudentDao;
import com.subham.dao.StudentDaoImp;
import com.subham.model.Student;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class App {
    public static void main(String[] args) throws SQLException {
        ApplicationContext context = new ClassPathXmlApplicationContext("config.xml");
//        JdbcTemplate jdTemp = context.getBean("jdbcTemp",JdbcTemplate.class);
//        System.out.println(jdTemp.getDataSource().getConnection());

//        String query = "insert into student(id,name,address) values(?,?,?)";
//        jdTemp.update(query,102,"rajib","Baleswar");
//        System.out.println("Successfully inserted");

        //fetch data using dao layer
        StudentDao dao = context.getBean("dao", StudentDaoImp.class);

//        Student s = new Student();
//        s.setId(5);
//        s.setName("Hari");
//        s.setAddress("Kutarang");
//        int i = dao.insert(s);
//        System.out.println(i+" row inserted");

//        Student s = new Student();
//        s.setId(5);
//        s.setName("Haria");
//        s.setAddress("KutarangGain");
//        int i = dao.updateDetails(s);
//        System.out.println(i + " row updated");

//        int i = dao.delete(5);
//        System.out.println(i + " row deleted");

//        Student s = dao.getStudentById(101);
//        System.out.println(s);

//        List<Student> stlist = dao.getAllStudent();
//        stlist.forEach(System.out::println);

    }
}
