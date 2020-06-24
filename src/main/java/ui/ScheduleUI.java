package ui;

import persistence.model.CoursesModel;
import persistence.model.ScheduleModel;
import services.ScheduleService;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

public class ScheduleUI {

    ScheduleService scheduleService = new ScheduleService();
    ScheduleModel scheduleModel = new ScheduleModel();
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
                System.out.println("Insert schedule date");
                String dateToInsert = scanner.nextLine();



                SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
                java.util.Date date = null;
                try {
                    date = sdf1.parse(dateToInsert);
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                java.sql.Date sqlStartDate = new java.sql.Date(date.getTime());


                System.out.println("Insert starting hour");
                String startingHour = scanner.nextLine();

                System.out.println("Insert starting hour");
                String endingHour = scanner.nextLine();

                ScheduleModel scheduleModel = new ScheduleModel();
                scheduleModel.setDate(sqlStartDate);
                scheduleModel.setStartingHour(startingHour);
                scheduleModel.setEndingHour(endingHour);

                scheduleService.addSchedule(scheduleModel);


            }if(option == 2){
                System.out.println("Please insert new date");
                String dateToInsert = scanner.nextLine();
                SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
                java.util.Date date = null;
                try {
                    date = sdf1.parse(dateToInsert);
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                java.sql.Date sqlStartDate = new java.sql.Date(date.getTime());


                System.out.println("Insert  new starting hour");
                String startingHour = scanner.nextLine();

                System.out.println("Insert new starting hour");
                String endingHour = scanner.nextLine();

                System.out.println("Insert id to search for schedule");
                int idSchedule = scanner.nextInt();
                scanner.nextLine();

                ScheduleModel scheduleModel1 = new ScheduleModel();
                scheduleModel1.setDate(sqlStartDate);
                scheduleModel1.setStartingHour(startingHour);
                scheduleModel1.setEndingHour(endingHour);
                scheduleModel1.setIdSchedule(idSchedule);

                scheduleService.updateSchedule(scheduleModel1);


            }if(option == 3){
                System.out.println("Insert id to delete");
                int idToDelete = scanner.nextInt();
                scanner.nextLine();

                ScheduleModel scheduleModel = new ScheduleModel();
                scheduleModel.setIdSchedule(idToDelete);
                scheduleService.deleteSchedule(scheduleModel);

            }if(option == 4 ){
                List<ScheduleModel> list = scheduleService.viewAllSchedules(scheduleModel);
                list.forEach(scheduleModel1 -> System.out.println("Id Schedule: " + scheduleModel1.getIdSchedule()
                        + " Date: " + scheduleModel1.getDate() +
                        " Starting hour: " + scheduleModel1.getStartingHour()+ " Ending hour:"
                        + scheduleModel1.getEndingHour()));
            }
        }
    }

}
