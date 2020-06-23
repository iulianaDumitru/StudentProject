package ui;

import persistence.model.ProfessorsModel;
import persistence.model.StudentsModel;
import services.ProfessorService;

import java.util.Scanner;

public class ProfessorUI {
    private ProfessorService professorService = new ProfessorService();
    Scanner scanner = new Scanner(System.in);

    public void startProfessor
            () {
        int option = -1;
        while (option != 0) {
            System.out.println("Professors");
            System.out.println("----------------------------");
            System.out.println("1. Add professor");
            System.out.println("2. Update professor by id");
            System.out.println("3. Update professor by specified column");
            System.out.println("4. Delete professor by id");
            System.out.println("5. Delete professor by specified column");
            System.out.println("6. View all professors");

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

                ProfessorsModel professorsModel = new ProfessorsModel();
                professorsModel.setFirstName(firstName);
                professorsModel.setLastName(lastName);


                professorService.addProfessor(professorsModel);

            }
            if (option == 2) {
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
            if (option == 3) {
                System.out.println("Enter first name to search for a row");
                String firstName = scanner.nextLine();

                System.out.println("Enter last name to be updated");
                String lastName = scanner.nextLine();

                ProfessorsModel professorsModel = new ProfessorsModel();

                professorsModel.setFirstName(firstName);
                professorsModel.setLastName(lastName);

                professorService.updateProfessorByColumn(professorsModel, firstName, lastName);
            }
            if (option == 4) {

                System.out.println("Enter id to delete");
                int idToBeDeleted = scanner.nextInt();
                scanner.nextLine();

                ProfessorsModel professorsModel = new ProfessorsModel();
                professorsModel.setCnpProfessor(idToBeDeleted);
                professorService.deleteProfessor(professorsModel);

            }if(option == 5){
                System.out.println("Enter first name of the professor to be deleted");
                String firstName = scanner.nextLine();
                System.out.println("Enter last name of the professor to be deleted");
                String lastName = scanner.nextLine();

               ProfessorsModel professorsModel = new ProfessorsModel();

                professorsModel.setFirstName(firstName);
                professorsModel.setLastName(lastName);

                professorService.deleteProfessorByColumn(professorsModel, firstName);

            }

        }
    }
}
