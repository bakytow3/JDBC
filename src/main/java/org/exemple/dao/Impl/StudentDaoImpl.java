package org.exemple.dao.Impl;

import org.exemple.config.JDBCConfig;
import org.exemple.dao.StudentDao;
import org.exemple.model.Student;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentDaoImpl implements StudentDao {
    public final Connection connection;

    public StudentDaoImpl() throws SQLException {
        connection=new JDBCConfig().getConnection();
    }

    @Override
    public void creatTable() {
String sql= """
        create table students(
        id serial primary key,
        name varchar(50),
        age int
        );
        """;
try (Statement statement = connection.createStatement()){
statement.execute(sql);
} catch (SQLException e) {
    e.printStackTrace();
}
    }

    @Override
    public void saveStudent(Student student) {
String sql= """
        insert into students(name,age)values(?,?);
        """;
try (PreparedStatement preparedStatement=connection.prepareStatement(sql)){
preparedStatement.setString(1,student.getName());
preparedStatement.setInt(2,student.getAge());
preparedStatement.execute();
} catch (SQLException e) {
    e.printStackTrace();
}
    }

    @Override
    public void dropTable() {
String sql="drop table students";
try (Statement statement = connection.createStatement()){
statement.execute(sql);
} catch (SQLException e) {
    e.printStackTrace();
}
    }

    @Override
    public Student findById(long id) {
String sql= """
        select * from students where id=?
        """;
try (PreparedStatement preparedStatement=connection.prepareStatement(sql)){
    preparedStatement.setLong(1,id);
    preparedStatement.setLong(1,id);
    ResultSet resultSet= preparedStatement.executeQuery();
    if(!resultSet.next()){
        System.out.print("ERROR NOT ID:");
    }
    Student student=new Student();
    student.setId(resultSet.getLong(1));
    student.setName(resultSet.getString(2));
    student.setAge(resultSet.getInt(3));
return student;
} catch (SQLException e) {
   e.printStackTrace();
}
return null;
    }

    @Override
    public void deleteById(long id) {
String sql ="delete from students where id=?";
try (PreparedStatement preparedStatement=connection.prepareStatement(sql)){
    preparedStatement.setLong(1,id);
preparedStatement.execute();
} catch (SQLException e) {
    throw new RuntimeException(e);
}
    }

    @Override
    public void cleanTable() {
        String sql ="trancate students";
try(Statement statement=connection.createStatement()){
statement.execute(sql);
} catch (SQLException e) {
    throw new RuntimeException(e);
}
    }

    @Override
    public List<Student> findAll() {
        String sql ="select * from students";
        List<Student>list=new ArrayList<>();
        try (Statement statement=connection.createStatement()){
            ResultSet resultSet=statement.executeQuery(sql);
            while (resultSet.next()){
                Student student =new Student();
                student.setId(resultSet.getLong(1));
                student.setName(resultSet.getString("name"));
                student.setAge(resultSet.getInt(3));
                list.add(student);
            }
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void updateStudent(long id, Student student) {
String sql="update  students set name=?,age=? where id = ?";
try (PreparedStatement preparedStatement =connection.prepareStatement(sql)){
preparedStatement.setString(1,student.getName());
preparedStatement.setInt(2,student.getAge());
preparedStatement.setLong(3,id);
preparedStatement.execute();
} catch (SQLException e) {
    e.printStackTrace();
}
    }
}
