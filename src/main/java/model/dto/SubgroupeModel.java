package model.dto;

import org.hibernate.annotations.ManyToAny;
import org.hibernate.annotations.Tables;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "subgroupe")

public class SubgroupeModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int idsubgroupe;
    private String name;

    @ManyToOne
    @JoinColumn(name = "idGroupe")
    private GroupeModel groupeModel;

    @OneToMany
    @JoinColumn(name = "idsubgroupe")
    private List<StudentsModel> students;

    public int getIdsubgroupe() {
        return idsubgroupe;
    }

    public void setIdsubgroupe(int idsubgroupe) {
        this.idsubgroupe = idsubgroupe;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public GroupeModel getGroupeModel() {
        return groupeModel;
    }

    public void setGroupeModel(GroupeModel groupeModel) {
        this.groupeModel = groupeModel;
    }

    public List<StudentsModel> getStudents() {
        return students;
    }

    public void setStudents(List<StudentsModel> students) {
        this.students = students;
    }

    public String toString()
    {
        return "Subgroupe " + idsubgroupe + " belongs to groupe "+ groupeModel.getIdGroupe();
    }
}
