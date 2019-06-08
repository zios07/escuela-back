package ma.escuela.escuela.domain;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "PANIER_TABLE")
public class Panier {

    @Id
    @GeneratedValue
    private long id;

    @OneToMany
    private List<Cours> courses;

    @OneToOne
    private User user;

    public Panier(List<Cours> courses, User user) {
        this.courses = courses;
        this.user = user;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public List<Cours> getCourses() {
        return courses;
    }

    public void setCourses(List<Cours> courses) {
        this.courses = courses;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
