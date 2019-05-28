package ma.escuela.escuela.domain;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "TUTEUR_TABLE")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Tuteur extends User {

    @Column(unique = true)
    private String CIN;

    public Tuteur(String CIN) {
        this.CIN = CIN;
    }

    public Tuteur(String firstName, String lastName,byte[] photo, LocalDate bDate, Account account, Role role, String CIN) {
        super(firstName, lastName, photo, bDate, account, role);
        this.CIN = CIN;
    }

    public Tuteur(User user, String CIN) {
        this(user.getFirstName(), user.getLastName(), user.getPhoto(), user.getbDate(), user.getAccount(), user.getRole(), CIN);
    }

    public String getCIN() {
        return CIN;
    }

    public void setCIN(String CIN) {
        this.CIN = CIN;
    }
}
