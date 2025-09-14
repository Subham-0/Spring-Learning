package com.subham.xml;

import com.subham.xml.dao.StudentDao;
import com.subham.xml.dao.StudentDaoImp;
import com.subham.xml.model.Student;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.orm.hibernate5.HibernateTemplate;

import java.util.List;

public class App
{
    public static void main( String[] args )
    {
        ApplicationContext context = new ClassPathXmlApplicationContext("config.xml");
//        HibernateTemplate temp = context.getBean("template", HibernateTemplate.class);
//        System.out.println(temp);
        StudentDao studentDao =  context.getBean("studDao", StudentDaoImp.class);
        List<Student> studentList =  studentDao.getAllStudent();
        studentList.forEach(System.out::println);

    }
}
