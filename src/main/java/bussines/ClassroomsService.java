package bussines;

import org.hibernate.SessionFactory;
import model.dto.ClassroomsModel;
import model.dao.GenericDao;

import java.util.List;

public class ClassroomsService  {

    SessionFactory sessionFactory ;


    private GenericDao<ClassroomsModel> classroomsModelGenericDao = new GenericDao<ClassroomsModel>();

    public  void addClassroom(ClassroomsModel classroomsModel)
    {
        classroomsModelGenericDao.add(classroomsModel);
    }

    public List<ClassroomsModel> viewAllClassrooms(ClassroomsModel classroomsModel){
        List<ClassroomsModel> classrooms = classroomsModelGenericDao.getAll(classroomsModel);
        return classrooms;
    }

    public void deleteClassroom(ClassroomsModel classroomsModel)
    {
        classroomsModelGenericDao.delete(classroomsModel);
    }

    public void updateClassroom(ClassroomsModel classroomsModel){
        classroomsModelGenericDao.update(classroomsModel);
    }


    public ClassroomsModel findById(ClassroomsModel classroomsModel, int id)
    {
       ClassroomsModel classroomsModel1 =  classroomsModelGenericDao.findById(classroomsModel, id);
       return  classroomsModel1;
    }

}
