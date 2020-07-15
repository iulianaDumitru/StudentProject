package presentation;

import java.util.Scanner;

public class ManagementUI {

    private StudentUI studentUI = new StudentUI();
    private ProfessorUI professorUI = new ProfessorUI();
    private CoursesUI coursesUI = new CoursesUI();
    ClassroomUI classroomUI = new ClassroomUI();
    ScheduleUI scheduleUI = new ScheduleUI();
    GroupeUI groupeUI  = new GroupeUI();
    SubgroupeUI subgroupeUI = new SubgroupeUI();

    public void startManagementUI() {
        int option = -1;
        while (option != 0) {

            Scanner scanner = new Scanner(System.in);
            System.out.println("----------------------------");
            System.out.println("ManagementUI");
            System.out.println("1. Students");
            System.out.println("2. Professors");
            System.out.println("3. Courses");
            System.out.println("4. Classrooms");
            System.out.println("5. Schedules");
            System.out.println("6. Goupes");
            System.out.println("7. Subgroupes");
            System.out.println("0. Exit");
            System.out.println("----------------------------");
            System.out.println("Please insert your option");
            option = scanner.nextInt();
            scanner.nextLine();

            if(option == 1){
                studentUI.startStudent();
            }if(option == 2){
                professorUI.startProfessor();
            }if(option ==3){
                coursesUI.startCourses();
            }if(option == 4){
                classroomUI.startClassroom();
            }if(option == 5){
                scheduleUI.startSchedule();
            }if(option == 6){
                groupeUI.startGroupe();
            }if(option == 7)
            {
                subgroupeUI.startSubgroupe();
            }
        }
    }
}
