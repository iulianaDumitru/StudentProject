package persistence.dto;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "classrooms")
public class ClassroomsModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int idClassroom;
    private String name;

    @OneToMany
    @JoinColumn(name = "idClassroom")
    List<ScheduleModel> schedules;

    public int getIdClassroom() {
        return idClassroom;
    }

    public void setIdClassroom(int idClassroom) {
        this.idClassroom = idClassroom;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<ScheduleModel> getSchedules() {
        return schedules;
    }

    public void setSchedules(List<ScheduleModel> schedules) {
        this.schedules = schedules;
    }
}
