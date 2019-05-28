package ma.escuela.escuela.domain;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "ELEVE_TABLE")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Eleve extends User {

    private String niveauScolaire;

    @ManyToMany
    private List<Jeux> jeux;

    @ManyToMany
    private List<Article> articles;

    @ManyToMany
    private List<Matiere> matieres;

    @ManyToMany
    private List<Activity> activities;


    public Eleve(User user, String niveauScolaire, List<Jeux> jeux, List<Article> articles, List<Matiere> matieres, List<Activity> activities) {
        this(user.getFirstName(), user.getLastName(), user.getPhoto(), user.getbDate(), user.getAccount(), user.getRole(), niveauScolaire, jeux, articles, matieres, activities);
    }

    public Eleve(String niveauScolaire, List<Jeux> jeux, List<Article> articles, List<Matiere> matieres, List<Activity> activities) {
        this.niveauScolaire = niveauScolaire;
        this.jeux = jeux;
        this.articles = articles;
        this.matieres = matieres;
        this.activities = activities;
    }

    public Eleve(String firstName, String lastName, byte[] photo, LocalDate bDate, Account account, Role role, String niveauScolaire, List<Jeux> jeux, List<Article> articles, List<Matiere> matieres, List<Activity> activities) {
        super(firstName, lastName, photo, bDate, account, role);
        this.niveauScolaire = niveauScolaire;
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
}
