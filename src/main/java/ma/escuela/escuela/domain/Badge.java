package ma.escuela.escuela.domain;

import javax.persistence.*;

@Entity
@Table(name = "BADGE_TABLE")
public class Badge {

    @Id
    @GeneratedValue
    private Long id;

    private String nom;

    private String description;

    @Lob
    private byte[] img;

    private Double scoreBadge;

    public Badge(String nom, String description, byte[] img, Double scoreBadge) {
        this.nom = nom;
        this.description = description;
        this.img = img;
        this.scoreBadge = scoreBadge;
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

    public byte[] getImg() {
        return img;
    }

    public void setImg(byte[] img) {
        this.img = img;
    }

    public Double getScoreBadge() {
        return scoreBadge;
    }

    public void setScoreBadge(Double scoreBadge) {
        this.scoreBadge = scoreBadge;
    }
}
