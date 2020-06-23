
package ui;


import persistence.model.StudentsModel;
import services.StudentService;

import java.util.Scanner;

public class StudentUI {

    private StudentService studentService = new StudentService();
    private StudentsModel studentsModel = new StudentsModel();
    Scanner scanner = new Scanner(System.in);

    public void startStudent() {
        int option = -1;
        while (option != 0) {
            System.out.println("Students");
            System.out.println("----------------------------");
            System.out.println("1. Add student");
            System.out.println("2. Update student by id");
            System.out.println("3. Update student by specified column");
            System.out.println("4. Delete student by id");
            System.out.println("5. Delete student by specified column");
            System.out.println("6. View all students");
            System.out.println("7. Find student by id");
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

            }
            if (option == 2) {
                System.out.println("Insert value for firstName to be updated");
                String firstName = scanner.nextLine();

                System.out.println("Insert value for lastName to be updated");
                String lastName = scanner.nextLine();

                System.out.println("Insert cnp to search for update");
                int cnp = scanner.nextInt();

                StudentsModel studentsModel = new StudentsModel();
                studentsModel.setCnpStudent(cnp);
                studentsModel.setFirstName(firstName);
                studentsModel.setLastName(lastName);

                studentService.updateStudent(studentsModel);
            }
            if (option == 3) {
                System.out.println("Enter first name to search for a row");
                String firstName = scanner.nextLine();

                System.out.println("Enter last name to be updated");
                String lastName = scanner.nextLine();

                StudentsModel studentsModel = new StudentsModel();
                studentsModel.setLastName(lastName);

                studentService.updateByColumn(studentsModel, firstName, lastName);
            }

            if (option == 4) {

                System.out.println("Enter id to delete");
                int idToBeDeleted = scanner.nextInt();
                scanner.nextLine();

                StudentsModel studentsModel = new StudentsModel();
                studentsModel.setCnpStudent(idToBeDeleted);
                studentService.deleteStudent(studentsModel);

            }
            if (option == 5) {
                System.out.println("Enter first name of the student to be deleted");
                String firstName = scanner.nextLine();
                System.out.println("Enter last name of the student to be deleted");
                String lastName = scanner.nextLine();

                StudentsModel studentsModel = new StudentsModel();

                studentsModel.setFirstName(firstName);
                studentsModel.setLastName(lastName);

                studentService.deleteByColumn(studentsModel, firstName);

            }

            if (option == 6) {
               /* List<StudentsModel> list = studentService.viewAllStudents(studentsModel);
                list.forEach(studentsModel1 -> System.out.println(studentsModel1.getFirstName()+
                        " "+ studentsModel1.getLastName()));
                for (StudentsModel studentsModel:list
                     ) {
                    System.out.println(studentsModel.getCnpStudent() + " " + studentsModel.getFirstName()+
                            " "+ studentsModel.getLastName());*/

            }
            if (option == 7) {
                System.out.println("Insert cnp to search for");
                int cnp = scanner.nextInt();
                scanner.nextLine();

                StudentsModel studentsModel = new StudentsModel();
                studentsModel.setCnpStudent(cnp);
                studentService.findStudentById(studentsModel, cnp);
            }
        }
    }
}






