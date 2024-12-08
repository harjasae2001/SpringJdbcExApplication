package org.example.springjdbcex.repo;

import org.example.springjdbcex.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class StudentRepo {

    private JdbcTemplate jdbc;

    public JdbcTemplate getJdbc() {
        return jdbc;
    }

    @Autowired
    public void setJdbc(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    public void save(Student s){

        String sql = "insert into student (rollno, name, marks) values (104, 'Navin Kumar Sharma Reddy', 56)";
       int rows = jdbc.update(sql, s.getRollNo(), s.getName(), s.getMarks());

    }

    public List<Student> findAll(){
//        List<Student> students = new ArrayList<Student>();
//        return students;

        String sql = "select * from student";
        RowMapper<Student> mapper = new RowMapper<Student>(){
            public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
                Student s = new Student();
                s.setRollNo(rs.getInt("rollno"));
                s.setName(rs.getString("name"));
                s.setMarks(rs.getInt("marks"));

                return null;
            }
        };
        return jdbc.query(sql, mapper);
    }
}
