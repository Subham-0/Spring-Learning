package com.subham.java_config.service;


import com.subham.java_config.model.Student;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;


public class StudentService implements StudentDao {

    private final HibernateTemplate template;

    public StudentService(HibernateTemplate template) {
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
        Student st = template.get(Student.class, id);
        if (st != null) {
            template.delete(st);
        }

    }

    @Transactional
    @Override
    public Student getStudentById(int id) {
        Student st = template.get(Student.class, id);
        return st;
    }

    @Transactional
    @Override
    public List<Student> getAllStudent() {
        List<Student> studentList = template.loadAll(Student.class);
        return studentList;
    }
}
