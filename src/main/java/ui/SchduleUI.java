package ui;

import persistence.model.CoursesModel;
import services.ScheduleService;

import java.sql.Date;
import java.util.Scanner;

public class SchduleUI {

    ScheduleService scheduleService = new ScheduleService();
    Scanner scanner = new Scanner(System.in);


    public void startSchedule
            () {
        int option = -1;
        while (option != 0) {
            System.out.println("Schedules");
            System.out.println("----------------------------");
            System.out.println("1. Add schedule");
            System.out.println("2. Update schedule by id");
            System.out.println("3. Delete schedule by id");
            System.out.println("4. View all schedules");

            System.out.println("0.Exit");
            System.out.println("----------------------------");
            System.out.println("Please insert your option:");
            option = scanner.nextInt();
            scanner.nextLine();
            if (option == 1) {
                //System.out.println("Insert schedule date");


            }if(option == 2){


            }if(option == 3){

            }
        }
    }

}
