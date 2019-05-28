package ma.escuela.escuela.domain;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "MATIERE_TABLE")
public class Matiere {

    @Id
    @GeneratedValue
    private Long id;

    private String nom;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Cours> courses;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Badge> badges;

    public Matiere() {}

    public Matiere(String nom, List<Cours> courses, List<Badge> badges) {
        this.nom = nom;
        this.courses = courses;
        this.badges = badges;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public List<Cours> getCourses() {
        return courses;
    }

    public void setCourses(List<Cours> courses) {
        this.courses = courses;
    }

    public List<Badge> getBadges() {
        return badges;
    }

    public void setBadges(List<Badge> badges) {
        this.badges = badges;
    }
}
