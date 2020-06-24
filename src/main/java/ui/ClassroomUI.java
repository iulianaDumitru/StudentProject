package ui;

import persistence.model.ClassroomsModel;
import services.ClassroomsService;

import java.util.List;
import java.util.Scanner;

public class ClassroomUI {
    private ClassroomsService classroomsService = new ClassroomsService();
    ClassroomsModel classroomsModel = new ClassroomsModel();

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
            System.out.println("5. Search classroom by id");

            System.out.println("0.Exit");
            System.out.println("----------------------------");
            System.out.println("Please insert your option:");
            option = scanner.nextInt();
            scanner.nextLine();
            if (option == 1) {

                addClassroomUI();
                ;
            }
            if (option == 2) {

                updateClassroomByID();

            }
            if (option == 3) {
                deleteClasssromById();

            }
            if (option == 4) {
                viewAllClassroomsUI();

            }
            if (option == 5) {

                searchClassroomById();

            }
        }
    }

    private void searchClassroomById() {
        System.out.println("Insert id to search for");
        int idClassroom = scanner.nextInt();
        scanner.nextLine();

        ClassroomsModel classroomsModel1 = new ClassroomsModel();
        classroomsModel1.setIdClassroom(idClassroom);
        System.out.println("The classroom with id: " + idClassroom + " is " +
                classroomsService.findById(classroomsModel1, idClassroom).getName());
    }

    private void viewAllClassroomsUI() {

        List<ClassroomsModel> list = classroomsService.viewAllClassrooms(classroomsModel);
        list.forEach(coursesModel1 -> System.out.println("Id classroom: " + classroomsModel.getIdClassroom()
                + " " + classroomsModel.getName()));
    }

    private void deleteClasssromById() {

        System.out.println("Enter id to delete");
        int idToBeDeleted = scanner.nextInt();
        scanner.nextLine();

        ClassroomsModel classroomsModel = new ClassroomsModel();
        classroomsModel.setIdClassroom(idToBeDeleted);
        classroomsService.deleteClassroom(classroomsModel);
    }

    private void updateClassroomByID() {
        System.out.println("Insert new classroom name");
        String newName = scanner.nextLine();

        System.out.println("Insert id to search for update");
        int id = scanner.nextInt();
        scanner.nextLine();

        ClassroomsModel classroomsModel = new ClassroomsModel();
        classroomsModel.setName(newName);
        classroomsModel.setIdClassroom(id);
        classroomsService.updateClassroom(classroomsModel);
    }

    private void addClassroomUI() {

        System.out.println("Insert classroom name");
        String name = scanner.nextLine();

        ClassroomsModel classroomsModel = new ClassroomsModel();
        classroomsModel.setName(name);

        classroomsService.addClassroom(classroomsModel);
    }
}
