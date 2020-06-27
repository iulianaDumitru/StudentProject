package bussines;

import persistence.dao.GenericDao;
import persistence.dto.ProfessorsModel;

import java.util.List;

public class ProfessorService {

    private GenericDao<ProfessorsModel> professorsModelGenericDao = new GenericDao<ProfessorsModel>();

    public void addProfessor(ProfessorsModel professorsModel)
    {

        professorsModelGenericDao.add(professorsModel);
    }

    public List<ProfessorsModel > viewAllProfessors(ProfessorsModel professorsModel){
        return professorsModelGenericDao.getAll(professorsModel);
    }

    public void updateProfessor(ProfessorsModel professorsModel){
        professorsModelGenericDao.update(professorsModel);
    }

    public void deleteProfessor(ProfessorsModel professorsModel){
        professorsModelGenericDao.delete(professorsModel);
    }

    public ProfessorsModel findProfessorById(ProfessorsModel professorsModel, int id) {
        return professorsModelGenericDao.findById(professorsModel, id);
    }

    public void deleteProfessorByColumn(ProfessorsModel professorsModel, String firstName)
    {
        professorsModelGenericDao.deleteByColumn(professorsModel, firstName);
    }

    public void updateProfessorByColumn(ProfessorsModel professorsModel, String firstName, String lastName){
        professorsModelGenericDao.updateByColumn(professorsModel, firstName, lastName);
    }
}
