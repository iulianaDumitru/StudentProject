package services;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import persistence.dao.GenericDao;
import persistence.model.StudentsModel;

import javax.persistence.Query;
import java.util.List;

public class StudentService {

    SessionFactory sessionFactory;
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
    public StudentsModel findById( int id) {
        Session session = sessionFactory.openSession();

        Transaction transaction = session.beginTransaction();
        Query query = session.createQuery("from StudentsModel" + "where id=" + id, StudentsModel.class);
        StudentsModel  result = (StudentsModel) query.getSingleResult();
        transaction.commit();

        if (session != null) {
            session.close();
        }

        StudentsModel studentsModel1 = studentsModelGenericDao.findById(result, id);
        return studentsModel1;
       /*StudentsModel studentsModel1 = studentsModelGenericDao.findById(studentsModel,id);
       return studentsModel1;*/
    }

    public List<StudentsModel> findByFirstName(String firstName){
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Query query = session.createQuery("from StudentsModel" + "where firstName='" +
                firstName +"'", StudentsModel.class);
        List<StudentsModel> studentsModel= query.getResultList();
        return studentsModel ;
    }

    public void deleteByColumn(StudentsModel studentsModel, String firstName)
    {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        int result = session.createQuery("delete from StudentsModel"  +
                " where firstName='" + firstName + "'" ).executeUpdate();
        transaction.commit();
    }

}
