package ma.escuela.escuela.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ACTIVITY_TABLE")
public class Activity {

    @Id @GeneratedValue
    private Long id;

    private String nom;

    private String description;

    private Integer nbParticipants;

    public Activity(String nom, String description, Integer nbParticipants) {
        this.nom = nom;
        this.description = description;
        this.nbParticipants = nbParticipants;
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

    public Integer getNbParticipants() {
        return nbParticipants;
    }

    public void setNbParticipants(Integer nbParticipants) {
        this.nbParticipants = nbParticipants;
    }
}
