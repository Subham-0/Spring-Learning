package com.subham.xml.dao;


import com.subham.xml.model.Student;
import org.springframework.orm.hibernate5.HibernateTemplate;

import java.util.List;

public class StudentDaoImp implements StudentDao {
    private HibernateTemplate template;

    public HibernateTemplate getTemplate() {
        return template;
    }

    public void setTemplate(HibernateTemplate template) {
        this.template = template;
    }

    @Override
    public void insert(Student student) {

    }

    @Override
    public void updateDetails(Student student) {

    }


    @Override
    public void delete(int id) {

    }

    @Override
    public Student getStudentById(int id) {
        return null;
    }

    @Override
    public List<Student> getAllStudent() {
        return template.loadAll(Student.class);
    }
}
