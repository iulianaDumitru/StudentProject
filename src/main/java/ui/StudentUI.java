
package ui;


import persistence.model.StudentsModel;
import services.StudentService;

import java.util.List;
import java.util.Scanner;

public class StudentUI {

    StudentService studentService = new StudentService();
    StudentsModel studentsModel = new StudentsModel();
    Scanner scanner = new Scanner(System.in);

    public void startStudent() {
        int option = -1;
        while (option != 0) {
            System.out.println("Students");
            System.out.println("----------------------------");
            System.out.println("1. Add student");
            System.out.println("2. Update student");
            System.out.println("3. View all students");
            System.out.println("4. Delete student");
            System.out.println("0.Exit");
            System.out.println("----------------------------");
            System.out.println("Please insert your option:");
            option = scanner.nextInt();
            scanner.nextLine();

            if (option == 1) {
                System.out.println("Insert first name:");
                String firstName = scanner.nextLine();
                System.out.println("Insert last name: ");
                String lastName = scanner.nextLine();

                StudentsModel studentsModel = new StudentsModel();
                studentsModel.setFirstName(firstName);
                studentsModel.setLastName(lastName);


                studentService.addStudent(studentsModel);

            }if(option ==2)
            {



               /* System.out.println("Enter id ");
                int id = scanner.nextInt();
                scanner.nextLine();

                StudentsModel studentsModelFound = studentService.findById(id);
                System.out.println("Enter new last name:");
                String lastName = scanner.nextLine();

                studentsModelFound.setLastName(lastName);
                studentService.updateStudent(studentsModelFound);*/


            }
            if(option ==3)
            {
               /* List<StudentsModel> list = studentService.viewAllStudents(studentsModel);
                list.forEach(student-> System.out.println(student.getCnpStudent() + " "
                + student.getFirstName()+ " "+ student.getLastName()));*/
            }

            if (option == 4) {


               /* System.out.println("Insert first name");
                String firstName = scanner.nextLine();
                *//*System.out.println("Insert last name");
                String lastName = scanner.nextLine();*//*

                StudentsModel studentsModel = new StudentsModel();
                //studentsModel.setFirstName(firstName);
                //studentsModel.setLastName(lastName);
                studentsModel.setCnpStudent(8);

                studentService.deleteStudent(studentsModel);*/

                System.out.println("Enter first name");
                String firstName = scanner.nextLine();
                System.out.println("Enter new last name");
                String lastName = scanner.nextLine();

                StudentsModel studentsModel = new StudentsModel();

                studentService.deleteByColumn(studentsModel, firstName);

            }
        }
    }
}





