
package presentation;


import persistence.dto.StudentsModel;
import bussines.StudentService;

import java.util.List;
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
            System.out.println("2. Update student");
            System.out.println("3. Delete student");
            System.out.println("4. View all students");
            System.out.println("5. Find student by id");
            System.out.println("0.Exit");
            System.out.println("----------------------------");
            System.out.println("Please insert your option:");
            option = scanner.nextInt();
            scanner.nextLine();

            if (option == 1) {
                addStudent();
            }
            if (option == 2) {
                System.out.println("1. Update by id");
                System.out.println("2. Update by column");
                System.out.println("Enter your option");
                int update = scanner.nextInt();
                scanner.nextLine();
                if (update == 1) {
                    updateStudentById();
                }
                if (update == 2) {
                    updateStudentById();
                }
            }
            if (option == 3) {
                System.out.println("1. Delete by id");
                System.out.println("2. Delete by column");
                System.out.println("Enter your option:");
                int delete = scanner.nextInt();
                scanner.nextLine();

                if (delete == 1) {
                    deleteByID();
                }
                if (delete == 2) {
                    deleteStudentByColumn();
                }
            }

            if (option == 4) {

                viewAllStudentsUI();

            }

            if (option == 5) {
                findByIdUI();

            }
        }
    }

    private void viewAllStudentsUI() {

        List<StudentsModel> list = studentService.viewAllStudents(studentsModel);
        for (StudentsModel studentsModel : list) {
            System.out.println("CNP student: " + studentsModel.getCnpStudent()  +
                    " First Name: " + studentsModel.getFirstName() +
                    " Last Name: " + studentsModel.getLastName());
        }
    }

    private void deleteByID() {
        System.out.println("Enter id to delete");
        int idToBeDeleted = scanner.nextInt();
        scanner.nextLine();

        StudentsModel studentsModel = new StudentsModel();
        studentsModel.setCnpStudent(idToBeDeleted);
        studentService.deleteStudent(studentsModel);
    }

    private void addStudent() {
        System.out.println("Insert first name:");
        String firstName = scanner.nextLine();
        System.out.println("Insert last name: ");
        String lastName = scanner.nextLine();

        StudentsModel studentsModel = new StudentsModel();
        studentsModel.setFirstName(firstName);
        studentsModel.setLastName(lastName);


        studentService.addStudent(studentsModel);
    }

    private void updateStudentById() {
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

    private void updateByColumn() {
        System.out.println("Enter first name to search for a row");
        String firstName = scanner.nextLine();

        System.out.println("Enter last name to be updated");
        String lastName = scanner.nextLine();

        StudentsModel studentsModel = new StudentsModel();
        studentsModel.setLastName(lastName);

        studentService.updateByColumn(studentsModel, firstName, lastName);
    }

    public void deleteStudentByColumn() {
        System.out.println("Enter first name of the student to be deleted");
        String firstName = scanner.nextLine();
        System.out.println("Enter last name of the student to be deleted");
        String lastName = scanner.nextLine();

        StudentsModel studentsModel = new StudentsModel();

        studentsModel.setFirstName(firstName);
        studentsModel.setLastName(lastName);

        studentService.deleteByColumn(studentsModel, firstName);
    }

    private void findByIdUI() {
        System.out.println("Insert cnp to search for");
        int cnp = scanner.nextInt();
        scanner.nextLine();

        studentsModel.setCnpStudent(cnp);
        System.out.println("The student with id: " + cnp + " is " +
                studentService.findStudentById(studentsModel, cnp).getFirstName() + " " +
                studentService.findStudentById(studentsModel, cnp).getLastName());
    }
}







