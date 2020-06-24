package ui;

import persistence.model.ProfessorsModel;
import services.ProfessorService;

import java.util.List;
import java.util.Scanner;

public class ProfessorUI {
    private ProfessorService professorService = new ProfessorService();
    private ProfessorsModel professorsModel = new ProfessorsModel();
    Scanner scanner = new Scanner(System.in);

    public void startProfessor
            () {
        int option = -1;
        while (option != 0) {
            System.out.println("Professors");
            System.out.println("----------------------------");
            System.out.println("1. Add professor");
            System.out.println("2. Update professor");
            System.out.println("3. Delete professor");
            System.out.println("4. Find professor by id");
            System.out.println("5. View all professors");


            System.out.println("0.Exit");
            System.out.println("----------------------------");
            System.out.println("Please insert your option:");
            option = scanner.nextInt();
            scanner.nextLine();

            if (option == 1) {

                addProfessorUI();

            }
            if (option == 2) {
                System.out.println("1. Update by id");
                System.out.println("2. Update by column");
                System.out.println("Enter your option:");
                int update = scanner.nextInt();
                scanner.nextLine();

                if (update == 1) {
                    updateProfessorByIdUI();
                }
                if (update == 2) {
                    updateProfessorByColumn();
                }

            }
            if (option == 3) {
                System.out.println("1. Delete by id");
                System.out.println("2. Delete by column");
                System.out.println("Enter your option:");
                int delete = scanner.nextInt();
                scanner.nextLine();

                if (delete == 1) {
                    deleteProfessorByIdUI();                }
                if (delete == 2) {
                    deleteProfessorByColumnUI();
                }
            }
            if (option == 4) {

                findProfessorByIdUI();

            }

            }if (option == 5) {
                viewAllProfessorsUI();
            }


        }




    private void viewAllProfessorsUI() {

        List<ProfessorsModel> list = professorService.viewAllProfessors(professorsModel);
        list.forEach(professorsModel1 -> System.out.println("CNP professor: " +
                professorsModel1.getCnpProfessor() + "\n" +
                "First Name: " + professorsModel1.getFirstName() + " \n" +
                "Last Name: " + professorsModel1.getLastName()));
    }

    private void findProfessorByIdUI() {
        System.out.println("Insert cnp to search for");
        int cnp = scanner.nextInt();
        scanner.nextLine();

        professorsModel.setCnpProfessor(cnp);
        System.out.println("The professor with id: " + cnp + " is " +
                professorService.findProfessorById(professorsModel, cnp).getFirstName() + " " +
                professorService.findProfessorById(professorsModel, cnp).getLastName() );
    }

    private void deleteProfessorByColumnUI() {
        System.out.println("Enter first name of the professor to be deleted");
        String firstName = scanner.nextLine();
        System.out.println("Enter last name of the professor to be deleted");
        String lastName = scanner.nextLine();

        ProfessorsModel professorsModel = new ProfessorsModel();

        professorsModel.setFirstName(firstName);
        professorsModel.setLastName(lastName);

        professorService.deleteProfessorByColumn(professorsModel, firstName);
    }

    private void deleteProfessorByIdUI() {
        System.out.println("Enter id to delete");
        int idToBeDeleted = scanner.nextInt();
        scanner.nextLine();

        ProfessorsModel professorsModel = new ProfessorsModel();
        professorsModel.setCnpProfessor(idToBeDeleted);
        professorService.deleteProfessor(professorsModel);
    }

    private void updateProfessorByIdUI() {
        System.out.println("Insert new value for first name");
        String firstName = scanner.nextLine();

        System.out.println("Insert new value for last name");
        String lastName = scanner.nextLine();

        System.out.println("Insert cnp to search for update");
        int cnp = scanner.nextInt();
        scanner.nextLine();

        ProfessorsModel professorsModel = new ProfessorsModel();
        professorsModel.setFirstName(firstName);
        professorsModel.setLastName(lastName);
        professorsModel.setCnpProfessor(cnp);

        professorService.updateProfessor(professorsModel);
    }

    private void addProfessorUI() {
        System.out.println("Insert first name:");
        String firstName = scanner.nextLine();
        System.out.println("Insert last name: ");
        String lastName = scanner.nextLine();

        ProfessorsModel professorsModel = new ProfessorsModel();
        professorsModel.setFirstName(firstName);
        professorsModel.setLastName(lastName);


        professorService.addProfessor(professorsModel);
    }

    private void updateProfessorByColumn(){
        System.out.println("Enter first name to search for a row");
        String firstName = scanner.nextLine();

        System.out.println("Enter last name to be updated");
        String lastName = scanner.nextLine();

        ProfessorsModel professorsModel = new ProfessorsModel();

        professorsModel.setFirstName(firstName);
        professorsModel.setLastName(lastName);

        professorService.updateProfessorByColumn(professorsModel, firstName, lastName);
    }
}
