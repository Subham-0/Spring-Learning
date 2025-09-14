package com.subham.java_config.service;


import com.subham.java_config.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;



public class StudentService {

    private final HibernateTemplate template;

    public StudentService(HibernateTemplate template) {
        this.template = template;
    }


    @Transactional
    public void saveStudent(Student student) {
        template.save(student);
        System.out.println("✅ Student saved: " + student.getName());
    }

}
