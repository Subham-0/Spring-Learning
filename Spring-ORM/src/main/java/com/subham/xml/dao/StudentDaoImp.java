package com.subham.xml.dao;


import com.subham.xml.model.Student;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public class StudentDaoImp implements StudentDao {
    private HibernateTemplate template;

    public HibernateTemplate getTemplate() {
        return template;
    }

    public void setTemplate(HibernateTemplate template) {
        this.template = template;
    }

    @Transactional
    @Override
    public void insert(Student student) {
        template.save(student);
    }

    @Transactional
    @Override
    public void updateDetails(Student student) {
        template.update(student);
    }

    @Transactional
    @Override
    public void delete(int id) {
        Student st = template.get(Student.class,id);
        if (st != null) {
            template.delete(st);
        }
    }

    @Override
    public Student getStudentById(int id) {
        return template.get(Student.class, id);
    }

    @Override
    public List<Student> getAllStudent() {
        return template.loadAll(Student.class);
    }
}
