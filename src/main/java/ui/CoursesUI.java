package ui;

import persistence.model.CoursesModel;
import services.CoursesService;

import java.util.Scanner;

public class CoursesUI {
    private CoursesService coursesService = new CoursesService();
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
            }if(option == 2){
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
            }if(option == 3){
                System.out.println("Enter id to delete");
                int idToBeDeleted = scanner.nextInt();
                scanner.nextLine();

                CoursesModel coursesModel = new CoursesModel();
                coursesModel.setIdCourse(idToBeDeleted);
                coursesService.deleteCourse(coursesModel);
            }
        }
    }
}
