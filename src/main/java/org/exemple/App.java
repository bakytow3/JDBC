package org.exemple;
import org.exemple.Service.Impl.StudentSrviceImpl;
import org.exemple.Service.StudentService;
import org.exemple.model.Student;

import java.sql.SQLException;
import java.util.Scanner;

public class App {
    public static final Scanner scanner = new Scanner(System.in);
    public static final Scanner sc = new Scanner(System.in);

    public static void main(String[] args) throws SQLException {

        StudentService studentService = new StudentSrviceImpl();
        while (true) {

            System.out.println("Number:");
            int a = scanner.nextInt();
            if (a == 1) {
                studentService.creatTable();
            } else if (a==2) {
                System.out.print("NAME:");
                String name=sc.nextLine();
                System.out.print("AGE:");
                int age=scanner.nextInt();
                studentService.saveStudent(new Student(name,age));

            } else if (a==3) {
                studentService.dropTable();
                System.out.println("SUCCESSFULLY");
            } else if (a==4) {
                System.out.print("ID:");
                int id=scanner.nextInt();
                System.out.println(studentService.findById(id));
            } else if (a==5) {
                System.out.println("ID:");
int id =scanner.nextInt();
studentService.deleteById(id);
                System.out.println("OCHTU");
            } else if (a==6) {
                studentService.findAll().forEach(System.out::println);

            } else if (a==7) {
                System.out.println("STUDENT ID:");
int id =scanner.nextInt();
                System.out.println("NAME:");
                String name =sc.nextLine();
                System.out.println("AGE:");
                int age=scanner.nextInt();
                studentService.updateStudent(id,new Student(name,age));
            } else if (a==8) {
                studentService.cleanTable();
                System.out.println("SUCCESSFULLY");

            } else{
                System.err.println("ERROR");
                
            }
        }
    }
}
