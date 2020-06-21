package services;

import persistence.dao.GenericDao;
import persistence.model.ProfessorsModel;

public class ProfessorService {

    private GenericDao<ProfessorsModel> professorsModelGenericDao = new GenericDao<ProfessorsModel>();

    public void addProfessor(ProfessorsModel professorsModel)
    {
        professorsModelGenericDao.add(professorsModel);
    }
}
