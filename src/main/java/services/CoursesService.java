package services;

import persistence.model.ClassroomsModel;
import persistence.model.CoursesModel;
import persistence.dao.GenericDao;

import java.util.List;

public class CoursesService {
    private GenericDao<CoursesModel> coursesModelGenericDao = new GenericDao<CoursesModel>();

    public void addCourse(CoursesModel coursesModel)
    {
        coursesModelGenericDao.add(coursesModel);
    }

    public List<CoursesModel> viewAllCourses (CoursesModel coursesModel)
    {
        List<CoursesModel> courses = coursesModelGenericDao.getAll(coursesModel);
        return courses;
    }

    public void deleteCourse (CoursesModel coursesModel)
    {
        coursesModelGenericDao.delete(coursesModel);
    }

    public void updateCourse(CoursesModel coursesModel)
    {
        coursesModelGenericDao.update(coursesModel);
    }


}
