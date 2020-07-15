package bussines;

import model.dao.GenericDao;
import model.dto.GroupeModel;

import java.util.List;

public class GroupeService {

    private GenericDao<GroupeModel> genericDao = new GenericDao<>();

    public void addGroupe(GroupeModel groupeModel){
        genericDao.add(groupeModel);
    }

    public List<GroupeModel> viewAllGroupes(GroupeModel groupeModel)
    {
       return genericDao.getAll(groupeModel);
    }

    public GroupeModel findById(GroupeModel groupeModel, int id)
    {
        return genericDao.findById(groupeModel, id);
    }

    public void update(GroupeModel groupeModel)
    {
        genericDao.update(groupeModel);
    }
}
