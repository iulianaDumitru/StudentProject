package bussines;


import model.dao.GenericDao;
import model.dto.GroupeModel;
import model.dto.SubgroupeModel;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.List;


public class SubgroupeService {

    private GenericDao<SubgroupeModel> genericDao = new GenericDao<>();

   public void addSubGroupe(SubgroupeModel subgroupeModel){
        genericDao.add(subgroupeModel);
    }

    public List<SubgroupeModel> viewAllGroupes(SubgroupeModel subgroupeModel)
    {
        return genericDao.getAll(subgroupeModel);
    }

    public SubgroupeModel findById(SubgroupeModel subgroupeModel, int id)
    {
        return genericDao.findById(subgroupeModel, id);
    }

    public void update(SubgroupeModel subgroupeModel)
    {
        genericDao.update(subgroupeModel);
    }

}
