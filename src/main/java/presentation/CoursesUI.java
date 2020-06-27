package presentation;

import persistence.dto.CoursesModel;
import persistence.dto.ProfessorsModel;
import persistence.dto.StudentsModel;
import bussines.CoursesService;
import bussines.ProfessorService;
import bussines.StudentService;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CoursesUI {
    private CoursesService coursesService = new CoursesService();
    CoursesModel coursesModel = new CoursesModel();
    StudentsModel studentsModel = new StudentsModel();
    StudentService studentService = new StudentService();
    ProfessorService professorService = new ProfessorService();
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
            System.out.println("6. Assign course to a professor");
            System.out.println("7. Find a course by id");

            System.out.println("0.Exit");
            System.out.println("----------------------------");
            System.out.println("Please insert your option:");
            option = scanner.nextInt();
            scanner.nextLine();
            if (option == 1) {
                addCourse();
            }
            if (option == 2) {
                updateCourse();
            }
            if (option == 3) {
                deleteCourse();
            }
            if (option == 4) {
                viewAllCourses();
            }
            if (option == 5) {
                assignCourseToStudent();
            }
            if(option == 6)
            {
                assignCourseToProfessor();
            }

            if (option == 7) {
                searchById();
            }
        }
    }

    private void assignCourseToProfessor() {
        System.out.println("Insert id of the course to be assigned:");
        int idCourse = scanner.nextInt();
        scanner.nextLine();

        CoursesModel coursesModel = new CoursesModel();
        coursesModel.setIdCourse(idCourse);
        coursesModel.setName(coursesService.findCourseById(coursesModel, idCourse).getName());
        coursesModel.setDescription(coursesService.findCourseById(coursesModel, idCourse).getDescription());
        List<CoursesModel> courses = new ArrayList<>();
        courses.add(coursesModel);

        System.out.println("Insert the id of the professor to be assigned");
        int idProfessor = scanner.nextInt();
        scanner.nextLine();

        ProfessorsModel professorsModel = new ProfessorsModel();
        professorsModel.setCnpProfessor(idProfessor);
        professorsModel.setFirstName(professorService.findProfessorById(professorsModel, idProfessor).getFirstName());
        professorsModel.setLastName(professorService.findProfessorById(professorsModel, idProfessor).getLastName());

        List<ProfessorsModel> professors = new ArrayList<>();
        professors.add(professorsModel);

        coursesModel.setProfessorsModels(professors);
        professorsModel.setCoursesProfessorsList(courses);
        coursesService.updateCourse(coursesModel);
        professorService.updateProfessor(professorsModel);
    }

    private void assignCourseToStudent() {

        System.out.println("Insert id of the course to be assigned:");
        int idCourse = scanner.nextInt();
        scanner.nextLine();

        CoursesModel coursesModel = new CoursesModel();
        coursesModel.setIdCourse(idCourse);
        coursesModel.setName(coursesService.findCourseById(coursesModel, idCourse).getName());
        coursesModel.setDescription(coursesService.findCourseById(coursesModel, idCourse).getDescription());
        List<CoursesModel> courses = new ArrayList<>();
        courses.add(coursesModel);

        System.out.println("Insert the id of the student to be assigned");
        int idStudent = scanner.nextInt();
        scanner.nextLine();

        StudentsModel studentsModel = new StudentsModel();
        studentsModel.setCnpStudent(idStudent);
        studentsModel.setFirstName(studentService.findStudentById(studentsModel, idStudent).getFirstName());
        studentsModel.setLastName(studentService.findStudentById(studentsModel, idStudent).getLastName());

        List<StudentsModel> students = new ArrayList<>();
        students.add(studentsModel);

        coursesModel.setStudentsModelList(students);
        studentsModel.setCoursesModelList(courses);
        coursesService.updateCourse(coursesModel);
        studentService.updateStudent(studentsModel);
    }

    private void addCourse() {
        System.out.println("Insert course name");
        String name = scanner.nextLine();
        System.out.println("Insert course description");
        String description = scanner.nextLine();

        CoursesModel coursesModel = new CoursesModel();
        coursesModel.setName(name);
        coursesModel.setDescription(description);

        coursesService.addCourse(coursesModel);
    }

    private void updateCourse() {
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

    private void deleteCourse() {
        System.out.println("Enter id to delete");
        int idToBeDeleted = scanner.nextInt();
        scanner.nextLine();

        CoursesModel coursesModel = new CoursesModel();
        coursesModel.setIdCourse(idToBeDeleted);
        coursesService.deleteCourse(coursesModel);
    }

    private void viewAllCourses() {
        List<CoursesModel> list = coursesService.viewAllCourses(coursesModel);
        list.forEach(coursesModel1 -> System.out.println("Id Course: " + coursesModel1.getIdCourse()
                + " " + coursesModel1.getName() + " " + coursesModel1.getDescription()));
    }

    private void searchById() {
        System.out.println("Insert id to search for");
        int id = scanner.nextInt();
        scanner.nextLine();

        coursesModel.setIdCourse(id);
        System.out.println("The course with id: " + id + " is " + " name: " +
                coursesService.findCourseById(coursesModel, id).getName() + " " + "description: " +
                coursesService.findCourseById(coursesModel, id).getDescription());
    }
}


