package ma.escuela.escuela.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "JEUX_TABLE")
public class Jeux {

    @Id @GeneratedValue
    private Long id;

    private String nom;

    private String description;

    private Integer nbVisiteurs;

    private String type;

    private boolean payant;

    private Double prix;

    public Jeux(String nom, String description, Integer nbVisiteurs, String type, boolean payant, Double prix) {
        this.nom = nom;
        this.description = description;
        this.nbVisiteurs = nbVisiteurs;
        this.type = type;
        this.payant = payant;
        this.prix = prix;
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
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
}
