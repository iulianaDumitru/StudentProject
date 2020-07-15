package bussines;

import model.dao.GenericDao;
import model.dto.StudentsModel;

import java.util.List;

public class StudentService {


    private GenericDao<StudentsModel> studentsModelGenericDao = new GenericDao<StudentsModel>();

    public void addStudent(StudentsModel studentsModel) {
        studentsModelGenericDao.add(studentsModel);
    }


    public List<StudentsModel> viewAllStudents(StudentsModel studentsModel) {
        List<StudentsModel> students = studentsModelGenericDao.getAll(studentsModel);
        return students;
    }

    public void deleteStudent(StudentsModel studentsModel) {
        studentsModelGenericDao.delete(studentsModel);
    }

    public void updateStudent(StudentsModel studentsModel)
    {
        studentsModelGenericDao.update(studentsModel);
    }
    //StudentsModel studentsModel,
    public StudentsModel findStudentById( StudentsModel studentsModel, int id) {
        return studentsModelGenericDao.findById(studentsModel, id);
    }


    public void deleteByColumn(StudentsModel studentsModel, String firstName)
    {
        studentsModelGenericDao.deleteByColumn(studentsModel, firstName);
    }

    public void updateByColumn(StudentsModel studentsModel, String firstName, String lastName){
        studentsModelGenericDao.updateByColumn(studentsModel, firstName, lastName);
    }

}
