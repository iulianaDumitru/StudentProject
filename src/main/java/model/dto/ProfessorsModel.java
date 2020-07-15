package model.dto;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "professors")
public class ProfessorsModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int cnpProfessor;
    private String firstName;
    private String lastName;


    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "professor_courses", catalog = "studentproject",
            joinColumns =
                    {
                            @JoinColumn(name = "cnpProfessor", nullable = false, updatable = false)
                    },
            inverseJoinColumns =
                    {
            @JoinColumn(name = "idCourse", nullable = false, updatable = false)
            })
    List<CoursesModel> coursesProfessorsList;

    public int getCnpProfessor() {
        return cnpProfessor;
    }

    public void setCnpProfessor(int cnpProfessor) {
        this.cnpProfessor = cnpProfessor;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public List<CoursesModel> getCoursesProfessorsList() {
        return coursesProfessorsList;
    }

    public void setCoursesProfessorsList(List<CoursesModel> coursesProfessorsList) {
        this.coursesProfessorsList = coursesProfessorsList;
    }

    public String toString()
    {
        return firstName + " "+ lastName;
    }
}
