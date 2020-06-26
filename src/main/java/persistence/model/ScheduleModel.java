package persistence.model;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;

@Entity
@Table(name = "schedule")
public class ScheduleModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private int idSchedule;
    private Date date;
    private String startingHour;
    private String endingHour;


    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "schedule_courses", catalog = "studentproject",
            joinColumns =
                    {
                            @JoinColumn(name = "idSchedule", nullable = false, updatable = false)
                    },
            inverseJoinColumns =
                    {
                            @JoinColumn(name = " idCourse", nullable = false, updatable = false)
                    })
    private List<CoursesModel> coursesList;

    @ManyToOne
    @JoinColumn(name = "idClassroom")
    private ClassroomsModel classRoomsModel;

    public int getIdSchedule() {
        return idSchedule;
    }

    public void setIdSchedule(int idSchedule) {
        this.idSchedule = idSchedule;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getStartingHour() {
        return startingHour;
    }

    public void setStartingHour(String startingHour) {
        this.startingHour = startingHour;
    }

    public String getEndingHour() {
        return endingHour;
    }

    public void setEndingHour(String endingHour) {
        this.endingHour = endingHour;
    }

    public List<CoursesModel> getCourses() {
        return coursesList;
    }

    public void setCourses(List<CoursesModel> courses) {
        this.coursesList = courses;
    }

    public ClassroomsModel getClassRoomsModel() {
        return classRoomsModel;
    }

    public void setClassRoomsModel(ClassroomsModel classRoomsModel) {
        this.classRoomsModel = classRoomsModel;
    }
}
