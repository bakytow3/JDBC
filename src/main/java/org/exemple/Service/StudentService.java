package org.exemple.Service;

import org.exemple.model.Student;

import java.util.List;

public interface StudentService {
    void creatTable();

    void saveStudent(Student student);

    void dropTable();

    Student findById(long id);

    void deleteById(long id);

    void  cleanTable();

    List<Student> findAll();

    void updateStudent(long id,Student student);
}
