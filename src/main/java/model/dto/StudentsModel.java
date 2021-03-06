package model.dto;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "students")
public class    StudentsModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int cnpStudent;
    private String firstName;
    private String lastName;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "student_courses", catalog = " studentproject",
    joinColumns =
            {
                    @JoinColumn(name = " cnpStudent", nullable = false, updatable = false)
            },
     inverseJoinColumns =
             {
                     @JoinColumn(name = "idCourse", nullable = false, updatable = false)
    })
    private List<CoursesModel> coursesModelList;

    @ManyToOne
    @JoinColumn(name = "idsubgroupe")
    private SubgroupeModel subgroupeModel;

    public int getCnpStudent() {
        return cnpStudent;
    }

    public void setCnpStudent(int cnpStudent) {
        this.cnpStudent = cnpStudent;
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

    public List<CoursesModel> getCoursesModelList() {
        return coursesModelList;
    }

    public SubgroupeModel getSubgroupeModel() {
        return subgroupeModel;
    }

    public void setSubgroupeModel(SubgroupeModel subgroupeModel) {
        this.subgroupeModel = subgroupeModel;
    }

    public String toString()
    {
        return "Student " + firstName + " "+ lastName+ " belongs to subgroupe "+ subgroupeModel.getIdsubgroupe();

    }

    public void setCoursesModelList(List<CoursesModel> coursesModelList) {
        this.coursesModelList = coursesModelList;
    }
}
