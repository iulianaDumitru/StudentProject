package presentation;

import bussines.GroupeService;
import bussines.SubgroupeService;
import model.dto.GroupeModel;
import model.dto.SubgroupeModel;


import java.util.List;
import java.util.Scanner;

public class GroupeUI {
    private GroupeService groupeService = new GroupeService();
    private GroupeModel groupeModel = new GroupeModel();
    private SubgroupeService subgroupeService = new SubgroupeService();

    Scanner scanner = new Scanner(System.in);
    int option = -1;

    public void startGroupe()
    {
        while(option != 0)
        {

            System.out.println("Groupes");
            System.out.println("----------------------------");
            System.out.println("1. Add groupe");
            System.out.println("2. View all groupes");
            System.out.println("----------------------------");
            System.out.println("Please insert your option:");
            option = scanner.nextInt();
            scanner.nextLine();
            if(option == 1)
            {
                addGroupe();
            }
            if(option == 2)
            {
                viewAllGroupes();
            }

        }
    }

    private void assignSubgroupe() {


    }

    private void viewAllGroupes() {
        List<GroupeModel> groupes = groupeService.viewAllGroupes(groupeModel);
        groupes.toString();
    }

    private void addGroupe() {
        System.out.println("Enter groupe's name:");
        String name = scanner.nextLine();

        GroupeModel groupeModel = new GroupeModel();
        groupeModel.setName(name);

        groupeService.addGroupe(groupeModel);
    }

}
