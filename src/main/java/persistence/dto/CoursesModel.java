package persistence.dto;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name ="courses")
public class CoursesModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int idCourse;
    private String name;
    private String description;

    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "coursesList")
    private List<ScheduleModel> scheduleModelList;

    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "coursesModelList" )
    private List<StudentsModel> studentsModelList;

    @ManyToMany(fetch = FetchType.LAZY, mappedBy =  "coursesProfessorsList")
    List<ProfessorsModel> professorsModels;

    public int getIdCourse() {
        return idCourse;
    }

    public void setIdCourse(int idCourse) {
        this.idCourse = idCourse;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<ScheduleModel> getScheduleModelList() {
        return scheduleModelList;
    }

    public void setScheduleModelList(List<ScheduleModel> scheduleModelList) {
        this.scheduleModelList = scheduleModelList;
    }

    public List<StudentsModel> getStudentsModelList() {
        return studentsModelList;
    }

    public void setStudentsModelList(List<StudentsModel> studentsModelList) {
        this.studentsModelList = studentsModelList;
    }

    public List<ProfessorsModel> getProfessorsModels() {
        return professorsModels;
    }

    public void setProfessorsModels(List<ProfessorsModel> professorsModels) {
        this.professorsModels = professorsModels;
    }
}
