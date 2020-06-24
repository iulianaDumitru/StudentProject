package ui;

import persistence.model.CoursesModel;
import persistence.model.StudentsModel;
import services.CoursesService;
import services.StudentService;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CoursesUI {
    private CoursesService coursesService = new CoursesService();
    CoursesModel coursesModel = new CoursesModel();
    StudentsModel studentsModel = new StudentsModel();
    StudentService studentService = new StudentService();
    Scanner scanner = new Scanner(System.in);


    public void startCourses
            () {
        int option = -1;
        while (option != 0) {
            System.out.println("Courses");
            System.out.println("----------------------------");
            System.out.println("1. Add course");
            System.out.println("2. Update course by id");
            System.out.println("3. Delete course by id");
            System.out.println("4. View all courses");
            System.out.println("5. Assign course to a student");
            System.out.println("6.Find a course by id");

            System.out.println("0.Exit");
            System.out.println("----------------------------");
            System.out.println("Please insert your option:");
            option = scanner.nextInt();
            scanner.nextLine();
            if (option == 1) {
                System.out.println("Insert course name");
                String name = scanner.nextLine();
                System.out.println("Insert course description");
                String description = scanner.nextLine();

                CoursesModel coursesModel = new CoursesModel();
                coursesModel.setName(name);
                coursesModel.setDescription(description);

                coursesService.addCourse(coursesModel);
            }
            if (option == 2) {
                System.out.println("Insert new course name");
                String newName = scanner.nextLine();
                System.out.println("Insert new description");
                String newDescription = scanner.nextLine();

                System.out.println("Insert id to search for update");
                int id = scanner.nextInt();
                scanner.nextLine();

                CoursesModel coursesModel = new CoursesModel();
                coursesModel.setName(newName);
                coursesModel.setDescription(newDescription);
                coursesModel.setIdCourse(id);
                coursesService.updateCourse(coursesModel);
            }
            if (option == 3) {
                System.out.println("Enter id to delete");
                int idToBeDeleted = scanner.nextInt();
                scanner.nextLine();

                CoursesModel coursesModel = new CoursesModel();
                coursesModel.setIdCourse(idToBeDeleted);
                coursesService.deleteCourse(coursesModel);
            }
            if (option == 4) {
                List<CoursesModel> list = coursesService.viewAllCourses(coursesModel);
                list.forEach(coursesModel1 -> System.out.println("Id Course: " + coursesModel1.getIdCourse()
                        + " " + coursesModel1.getName() + " " + coursesModel1.getDescription()));
            }
            if (option == 5) {

                System.out.println("Choose a course from the list: ");
                List<CoursesModel> list = coursesService.viewAllCourses(coursesModel);
                list.forEach(coursesModel1 -> System.out.println("Id Course: " + coursesModel1.getIdCourse()
                        + " " + coursesModel1.getName() + " " + coursesModel1.getDescription()));

                System.out.println("Insert the id of the course you want to assign");
                int idCourse = scanner.nextInt();
                scanner.nextLine();

                CoursesModel coursesModel1 = new CoursesModel();
                coursesModel1.setIdCourse(idCourse);
                List<CoursesModel> courseList = new ArrayList<>();
                courseList.add(coursesService.findCourseById(coursesModel1, idCourse));

                System.out.println("Choose a student from the list");
                List<StudentsModel> studentModelList = studentService.viewAllStudents(studentsModel);
                for (StudentsModel studentsModel : studentModelList) {
                    System.out.println("CNP student: " + studentsModel.getCnpStudent() + "\n" +
                            "First Name: " + studentsModel.getFirstName() + " \n" +
                            "Last Name: " + studentsModel.getLastName());

                    System.out.println("Insert cnp");
                    int cnp = scanner.nextInt();
                    scanner.nextLine();

                    StudentsModel studentsModel1 = new StudentsModel();
                    studentsModel1.setCnpStudent(cnp);
                    List<StudentsModel> studentList = new ArrayList<>();
                    studentList.add(studentService.findStudentById(studentsModel1, cnp));

                    coursesModel1.setStudentsModelList(studentList);
                    studentsModel1.setCoursesModelList(courseList);

                    coursesService.updateCourse(coursesModel1);
                    studentService.updateStudent(studentsModel1);

                }
                if (option == 6) {
                    System.out.println("Insert id to search for");
                    int id = scanner.nextInt();
                    scanner.nextLine();

                    coursesModel.setIdCourse(id);
                    System.out.println("The course with id: " + id + " is " + " name: " +
                            coursesService.findCourseById(coursesModel, id).getName() + " " + "description: " +
                            coursesService.findCourseById(coursesModel, id).getDescription());
                }
            }
        }
    }
}
