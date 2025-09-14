package com.subham.xml;

import com.subham.xml.dao.StudentDao;
import com.subham.xml.dao.StudentDaoImp;
import com.subham.xml.model.Student;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.orm.hibernate5.HibernateTemplate;

import java.util.List;

public class App {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("config.xml");
//        HibernateTemplate temp = context.getBean("template", HibernateTemplate.class);
//        System.out.println(temp);

        StudentDao studentDao = context.getBean("studDao", StudentDao.class);
        Student s = new Student();
        s.setId(109);
        s.setName("Prakash Dash");
        s.setAddress("Henner");
        studentDao.insert(s);
//        studentDao.updateDetails(s);
//        studentDao.delete(109);
//        Student st = studentDao.getStudentById(105);
//        System.out.println(st);
//        List<Student> studentList =  studentDao.getAllStudent();
//        studentList.forEach(System.out::println);

    }
}
