package ma.escuela.escuela.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ARTICLE_TABLE")
public class Article {

    @Id
    @GeneratedValue
    private Long id;

    private String nom;

    private String description;

    private Integer nbVisiteurs;

    private String auteur;

    private String domaine;

    private String niveau;

    private boolean payant;

    private Double prix;

    public Article(String nom, String description, Integer nbVisiteurs, String auteur, String domaine, String niveau, boolean payant, Double prix) {
        this.nom = nom;
        this.description = description;
        this.nbVisiteurs = nbVisiteurs;
        this.auteur = auteur;
        this.domaine = domaine;
        this.niveau = niveau;
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

    public String getAuteur() {
        return auteur;
    }

    public void setAuteur(String auteur) {
        this.auteur = auteur;
    }

    public String getDomaine() {
        return domaine;
    }

    public void setDomaine(String domaine) {
        this.domaine = domaine;
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
}
