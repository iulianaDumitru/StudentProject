package services;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import persistence.dao.GenericDao;
import persistence.model.StudentsModel;

import javax.persistence.Query;
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

   /* public List<StudentsModel> findByFirstName(String firstName){
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Query query = session.createQuery("from StudentsModel" + "where firstName='" +
                firstName +"'", StudentsModel.class);
        List<StudentsModel> studentsModel= query.getResultList();
        return studentsModel ;
    }*/

    public void deleteByColumn(StudentsModel studentsModel, String firstName)
    {
        studentsModelGenericDao.deleteByColumn(studentsModel, firstName);
    }

    public void updateByColumn(StudentsModel studentsModel, String firstName, String lastName){
        studentsModelGenericDao.updateByColumn(studentsModel, firstName, lastName);
    }

}
