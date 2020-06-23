package ui;

import persistence.model.ClassroomsModel;
import persistence.model.CoursesModel;
import services.ClassroomsService;

import java.util.Scanner;

public class ClassroomUI {
    private ClassroomsService classroomsService = new ClassroomsService();

    Scanner scanner = new Scanner(System.in);


    public void startClassroom
            () {
        int option = -1;
        while (option != 0) {
            System.out.println("Classrooms");
            System.out.println("----------------------------");
            System.out.println("1. Add classroom");
            System.out.println("2. Update classroom by id");
            System.out.println("3. Delete classroom by id");
            System.out.println("4. View all classrooms");

            System.out.println("0.Exit");
            System.out.println("----------------------------");
            System.out.println("Please insert your option:");
            option = scanner.nextInt();
            scanner.nextLine();
            if (option == 1) {
                System.out.println("Insert classroom name");
                String name = scanner.nextLine();

                ClassroomsModel classroomsModel = new ClassroomsModel();
                classroomsModel.setName(name);

                classroomsService.addClassroom(classroomsModel);
            }
            if (option == 2) {
                System.out.println("Insert new classroom name");
                String newName = scanner.nextLine();

                System.out.println("Insert id to search for update");
                int id = scanner.nextInt();
                scanner.nextLine();

                ClassroomsModel classroomsModel = new ClassroomsModel();
                classroomsModel.setName(newName);
                classroomsModel.setIdClassroom(id);
               classroomsService.updateClassroom(classroomsModel);
            }if(option == 3){
                System.out.println("Enter id to delete");
                int idToBeDeleted = scanner.nextInt();
                scanner.nextLine();

                ClassroomsModel classroomsModel = new ClassroomsModel();
                classroomsModel.setIdClassroom(idToBeDeleted);
                classroomsService.deleteClassroom(classroomsModel);
            }
        }
    }
}