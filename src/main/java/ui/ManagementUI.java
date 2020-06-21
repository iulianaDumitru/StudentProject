package ui;

import java.util.Scanner;

public class ManagementUI {

    private StudentUI studentUI = new StudentUI();

    public void startManagementUI() {
        int option = -1;
        while (option != 0) {

            Scanner scanner = new Scanner(System.in);
            System.out.println("ManagementUI");
            System.out.println("1. Students");
            System.out.println("Please insert your option");
            option = scanner.nextInt();
            scanner.nextLine();

            if(option == 1){
                studentUI.startStudent();
            }
        }
    }
}
