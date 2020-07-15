package model.dto;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "groupe")

public class GroupeModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int idGroupe;
    private String name;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "courses_groupe", catalog = "studentproject",
            joinColumns = {
                             @JoinColumn(name = "idGroupe", nullable = false, updatable = false)
                           },
            inverseJoinColumns = {
                                  @JoinColumn(name = "idCourse", nullable = false, updatable = false
                                  )
    })
    private List<CoursesModel> courses;

    @OneToMany
    @JoinColumn(name = "idGroupe")
    private List<SubgroupeModel> subgroupeModel;

    public int getIdGroupe() {
        return idGroupe;
    }

    public void setIdGroupe(int idGroupe) {
        this.idGroupe = idGroupe;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<CoursesModel> getCourses() {
        return courses;
    }

    public void setCourses(List<CoursesModel> courses) {
        this.courses = courses;
    }



    public String toString(){
        return idGroupe + " " + name + " "+ subgroupeModel;
    }
}
