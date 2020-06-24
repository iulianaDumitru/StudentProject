package ui;


import persistence.model.CoursesModel;
import persistence.model.ScheduleModel;
import services.CoursesService;
import services.ScheduleService;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ScheduleUI {

    ScheduleService scheduleService = new ScheduleService();
    ScheduleModel scheduleModel = new ScheduleModel();
    CoursesModel coursesModel = new CoursesModel();
    CoursesService coursesService = new CoursesService();
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
            System.out.println(("5. Find a schedule by id"));
            System.out.println("6. Assign a schedule to a course");

            System.out.println("0.Exit");
            System.out.println("----------------------------");
            System.out.println("Please insert your option:");
            option = scanner.nextInt();
            scanner.nextLine();
            if (option == 1) {

                addingSchedule();

            }
            if (option == 2) {

                updatingScheduleById();

            }
            if (option == 3) {

                deletingSchduleById();

            }
            if (option == 4) {

                viewAllSchedules();

            }
            if (option == 5) {

                findById();

            }
            if (option == 6) {

                assignScheduleToCourse();

            }
        }
    }

    private void addingSchedule() {
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


    }

    private void updatingScheduleById() {
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


    }

    private void deletingSchduleById() {
        System.out.println("Insert id to delete");
        int idToDelete = scanner.nextInt();
        scanner.nextLine();

        ScheduleModel scheduleModel = new ScheduleModel();
        scheduleModel.setIdSchedule(idToDelete);
        scheduleService.deleteSchedule(scheduleModel);
    }

    private void viewAllSchedules() {
        List<ScheduleModel> list = scheduleService.viewAllSchedules(scheduleModel);
        list.forEach(scheduleModel1 -> System.out.println("Id Schedule: " + scheduleModel1.getIdSchedule()
                + " Date: " + scheduleModel1.getDate() +
                " Starting hour: " + scheduleModel1.getStartingHour() + " Ending hour:"
                + scheduleModel1.getEndingHour()));
    }

    private void findById() {
        System.out.println("Insert id to search for");
        int idSchedule = scanner.nextInt();
        scanner.nextLine();

        scheduleModel.setIdSchedule(idSchedule);
        System.out.println("The schedule with id: " + idSchedule + " is " + "date: " +
                scheduleService.findScheduleById(scheduleModel, idSchedule).getDate() + " " +
                "starting hour: " + scheduleService.findScheduleById(scheduleModel, idSchedule).getStartingHour()
                + " ending hour: " + scheduleService.findScheduleById(scheduleModel, idSchedule).getEndingHour());
    }

    private void assignScheduleToCourse() {
        System.out.println("Insert id of the schedule to be assigned: ");
        int idToAssign = scanner.nextInt();
        scanner.nextLine();
        ScheduleModel scheduleModel1 = new ScheduleModel();
        scheduleModel1.setIdSchedule(idToAssign);
        scheduleModel1.setDate(scheduleService.findScheduleById(scheduleModel1, idToAssign).getDate());
        scheduleModel1.setStartingHour(scheduleService.findScheduleById(scheduleModel1, idToAssign).getStartingHour());
        scheduleModel1.setEndingHour(scheduleService.findScheduleById(scheduleModel1, idToAssign).getEndingHour());

        List<ScheduleModel> scheduleModels = new ArrayList<>();
        scheduleModels.add(scheduleModel1);


        System.out.println("Insert id of the course to be assigned: ");
        int idCourse = scanner.nextInt();
        scanner.nextLine();
        CoursesModel coursesModel = new CoursesModel();
        coursesModel.setIdCourse(idCourse);
        coursesModel.setName(coursesService.findCourseById(coursesModel, idCourse).getName());
        coursesModel.setDescription(coursesService.findCourseById(coursesModel, idCourse).getDescription());

        List<CoursesModel> coursesModels = new ArrayList<>();
        coursesModels.add(coursesModel);

        coursesModel.setScheduleModelList(scheduleModels);
        scheduleModel1.setCourses(coursesModels);
        coursesService.updateCourse(coursesModel);
        scheduleService.updateSchedule(scheduleModel1);

    }
}
