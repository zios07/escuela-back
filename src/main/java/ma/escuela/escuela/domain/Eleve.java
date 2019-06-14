package ma.escuela.escuela.domain;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "ELEVE_TABLE")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Eleve extends User {

    private String niveauScolaire;

    @ManyToOne
    private User parent;

    @ManyToMany
    private List<Jeux> jeux;

    @ManyToMany
    private List<Article> articles;

    @ManyToMany
    private List<Matiere> matieres;

    @ManyToMany
    private List<Activity> activities;

    public Eleve () {

    }

    public Eleve(User user, String niveauScolaire, List<Jeux> jeux, List<Article> articles, List<Matiere> matieres, List<Activity> activities, User parent) {
        this(user.getFirstName(), user.getLastName(), user.getPhoto(), user.getbDate(), user.getAccount(), user.getRole(), niveauScolaire, parent, jeux, articles, matieres, activities);
    }


    public Eleve(String firstName, String lastName, byte[] photo, LocalDate bDate, Account account, Role role, String niveauScolaire, User parent, List<Jeux> jeux, List<Article> articles, List<Matiere> matieres, List<Activity> activities) {
        super(firstName, lastName, photo, bDate, account, role);
        this.niveauScolaire = niveauScolaire;
        this.parent = parent;
        this.jeux = jeux;
        this.articles = articles;
        this.matieres = matieres;
        this.activities = activities;
    }

    public Eleve(String firstName, String lastName, byte[] photo, LocalDate bDate, Account account, Role role, String gender, String niveauScolaire, User parent, List<Jeux> jeux, List<Article> articles, List<Matiere> matieres, List<Activity> activities) {
        super(firstName, lastName, photo, bDate, account, role, gender);
        this.niveauScolaire = niveauScolaire;
        this.parent = parent;
        this.jeux = jeux;
        this.articles = articles;
        this.matieres = matieres;
        this.activities = activities;
    }

    public String getNiveauScolaire() {
        return niveauScolaire;
    }

    public void setNiveauScolaire(String niveauScolaire) {
        this.niveauScolaire = niveauScolaire;
    }

    public List<Jeux> getJeux() {
        return jeux;
    }

    public void setJeux(List<Jeux> jeux) {
        this.jeux = jeux;
    }

    public List<Article> getArticles() {
        return articles;
    }

    public void setArticles(List<Article> articles) {
        this.articles = articles;
    }

    public List<Matiere> getMatieres() {
        return matieres;
    }

    public void setMatieres(List<Matiere> matieres) {
        this.matieres = matieres;
    }

    public List<Activity> getActivities() {
        return activities;
    }

    public void setActivities(List<Activity> activities) {
        this.activities = activities;
    }

    public User getParent() {
        return parent;
    }

    public void setParent(User parent) {
        this.parent = parent;
    }
}
