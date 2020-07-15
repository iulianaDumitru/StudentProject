package presentation;

import bussines.GroupeService;
import bussines.SubgroupeService;
import model.dto.GroupeModel;
import model.dto.SubgroupeModel;

import java.util.Scanner;

public class SubgroupeUI {
    private SubgroupeService subgroupeService = new SubgroupeService();
    private SubgroupeModel subgroupeModel = new SubgroupeModel();
    private GroupeService groupeService = new GroupeService();

    Scanner scanner = new Scanner(System.in);
    int option = -1;

    public void startSubgroupe() {
        while (option != 0) {

            System.out.println("Subgroupes");
            System.out.println("----------------------------");
            System.out.println("1. Add subgroupe");
            System.out.println("2. Assing a subgroupe to a groupe");
            System.out.println("----------------------------");
            System.out.println("Please insert your option:");
            option = scanner.nextInt();
            scanner.nextLine();
            if (option == 1) {
                addSubgroupe();
            }
            if(option == 2)
            {
                assignGroupe();
            }
        }
    }

    private void addSubgroupe() {
        System.out.println("Enter subgroupe's name:");
        String name = scanner.nextLine();

        SubgroupeModel subgroupeModel = new SubgroupeModel();
        subgroupeModel.setName(name);

        subgroupeService.addSubGroupe(subgroupeModel);
    }

    private void assignGroupe() {

        System.out.println("Insert the id of the groupe to which you want to assign the subgroupe");
        int idGroupe = scanner.nextInt();
        GroupeModel groupeModel = new GroupeModel();
        groupeModel.setIdGroupe(idGroupe);
        groupeModel.setName(groupeService.findById(groupeModel, idGroupe).getName());


        System.out.println("Insert id of the subgroupe you want to assign");
        int idSubgroupe = scanner.nextInt();
        scanner.nextLine();

        SubgroupeModel subgroupeModel = new SubgroupeModel();
        subgroupeModel.setIdsubgroupe(idSubgroupe);
        subgroupeModel.setName(subgroupeService.findById(subgroupeModel, idSubgroupe).getName());
        subgroupeModel.setGroupeModel(groupeModel);

        groupeService.update(groupeModel);
        subgroupeService.update(subgroupeModel);

        System.out.println( subgroupeModel.toString());

    }
}
