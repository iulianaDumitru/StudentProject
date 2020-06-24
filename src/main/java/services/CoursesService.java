package services;

import persistence.dao.GenericDao;
import persistence.model.CoursesModel;

import java.util.List;

public class CoursesService {
    private GenericDao<CoursesModel> coursesModelGenericDao = new GenericDao<CoursesModel>();

    public void addCourse(CoursesModel coursesModel) {
        coursesModelGenericDao.add(coursesModel);
    }

    public List<CoursesModel> viewAllCourses(CoursesModel coursesModel) {
        List<CoursesModel> courses = coursesModelGenericDao.getAll(coursesModel);
        return courses;
    }

    public void deleteCourse(CoursesModel coursesModel) {
        coursesModelGenericDao.delete(coursesModel);
    }

    public void updateCourse(CoursesModel coursesModel) {
        coursesModelGenericDao.update(coursesModel);
    }

    public CoursesModel findCourseById(CoursesModel coursesModel, int id) {
        return coursesModelGenericDao.findById(coursesModel, id);
    }
}
