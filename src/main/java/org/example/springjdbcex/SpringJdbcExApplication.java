package org.example.springjdbcex;

import org.example.springjdbcex.model.Student;
import org.example.springjdbcex.service.StudentService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.List;

@SpringBootApplication
public class SpringJdbcExApplication {

    public static void main(String[] args) {


//        SpringApplication.run(SpringJdbcExApplication.class, args);

        ApplicationContext context = SpringApplication.run(SpringJdbcExApplication.class, args);

        Student s = context.getBean(Student.class);
        s.setRollNo(101);
        s.setName("Navin");
        s.setMarks(78);

        StudentService service = context.getBean(StudentService.class);
//        service.addStudent(s);


        List<Student> students= service.getStudents();
        System.out.println(students);
    }


}
