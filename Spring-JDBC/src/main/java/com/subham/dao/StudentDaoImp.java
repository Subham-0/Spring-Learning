package com.subham.dao;

import com.subham.model.Student;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class StudentDaoImp implements StudentDao {

    private JdbcTemplate template;

    public JdbcTemplate getTemplate() {
        return template;
    }

    public void setTemplate(JdbcTemplate template) {
        this.template = template;
    }

    @Override
    public int insert(Student student) {
        String query = "insert into student(id,name,address) values(?,?,?)";
        int i = template.update(query, student.getId(), student.getName(), student.getAddress());
        return i;
    }

    @Override
    public int updateDetails(Student student) {
        String updateQuery = "update student set name=?,address=? where id=?";
        int i = template.update(updateQuery, student.getName(), student.getAddress(), student.getId());
        return i;
    }

    @Override
    public int delete(int id) {
        String deleteQuery = "delete from student where id=?";
        int i = template.update(deleteQuery, id);
        return i;
    }

    @Override
    public Student getStudentById(int id) {
        String fetch = "select * from student where id=?";
        RowMapper rowMapper = new RowMapper() {
            @Override
            public Object mapRow(ResultSet rs, int rowNum) throws SQLException {

                Student s = new Student();
                s.setId(rs.getInt(1));
                s.setName(rs.getString(2));
                s.setAddress(rs.getString(3));
                return s;
            }
        };
        Student student = (Student) template.queryForObject(fetch, rowMapper, id);
        return student;
    }

    @Override
    public List<Student> getAllStudent() {
        String fetch = "select * from student";
        RowMapper rowMapper = new RowMapper() {
            @Override
            public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
                Student s = new Student();
                s.setId(rs.getInt(1));
                s.setName(rs.getString(2));
                s.setAddress(rs.getString(3));
                return s;
            }
        };
        List<Student> studentList = template.query(fetch,rowMapper);
        return  studentList;
    }
}
