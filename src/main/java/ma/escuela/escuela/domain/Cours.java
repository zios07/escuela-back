package ma.escuela.escuela.domain;


import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "COURS_TABLE")
public class Cours {

    @Id
    @GeneratedValue
    private Long id;

    private String nom;

    private String description;

    private Integer nbVisiteurs;

    private String niveau;

    private boolean payant;

    private Double prix;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Test> tests;

    public Cours() {}

    public Cours(String nom, String description, Integer nbVisiteurs, String niveau, boolean payant, Double prix, List<Test> tests) {
        this.nom = nom;
        this.description = description;
        this.nbVisiteurs = nbVisiteurs;
        this.niveau = niveau;
        this.payant = payant;
        this.prix = prix;
        this.tests = tests;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getNbVisiteurs() {
        return nbVisiteurs;
    }

    public void setNbVisiteurs(Integer nbVisiteurs) {
        this.nbVisiteurs = nbVisiteurs;
    }

    public String getNiveau() {
        return niveau;
    }

    public void setNiveau(String niveau) {
        this.niveau = niveau;
    }

    public boolean isPayant() {
        return payant;
    }

    public void setPayant(boolean payant) {
        this.payant = payant;
    }

    public Double getPrix() {
        return prix;
    }

    public void setPrix(Double prix) {
        this.prix = prix;
    }

    public List<Test> getTests() {
        return tests;
    }

    public void setTests(List<Test> tests) {
        this.tests = tests;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Cours)) return false;
        Cours cours = (Cours) o;
        return payant == cours.payant &&
                Objects.equals(id, cours.id) &&
                Objects.equals(nom, cours.nom) &&
                Objects.equals(description, cours.description) &&
                Objects.equals(nbVisiteurs, cours.nbVisiteurs) &&
                Objects.equals(niveau, cours.niveau) &&
                Objects.equals(prix, cours.prix) &&
                Objects.equals(tests, cours.tests);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nom, description, nbVisiteurs, niveau, payant, prix, tests);
    }
}
