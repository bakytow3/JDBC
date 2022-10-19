package org.exemple.Service.Impl;

import org.exemple.Service.StudentService;
import org.exemple.dao.Impl.StudentDaoImpl;
import org.exemple.dao.StudentDao;
import org.exemple.model.Student;

import java.sql.SQLException;
import java.util.List;

public class StudentSrviceImpl implements StudentService {
    StudentDao studentDao =new StudentDaoImpl();

    public StudentSrviceImpl() throws SQLException {
    }

    @Override
    public void creatTable() {
studentDao.creatTable();
    }

    @Override
    public void saveStudent(Student student) {
studentDao.saveStudent(student);
    }

    @Override
    public void dropTable() {
studentDao.dropTable();
    }

    @Override
    public Student findById(long id) {
return studentDao.findById(id);
    }

    @Override
    public void deleteById(long id) {
studentDao.deleteById(id);
    }

    @Override
    public void cleanTable() {
studentDao.cleanTable();
    }

    @Override
    public List<Student> findAll() {

        return studentDao.findAll();
    }

    @Override
    public void updateStudent(long id, Student student) {
studentDao.updateStudent(id, student);
    }
}
