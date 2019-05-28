package ma.escuela.escuela.domain;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "USER_TABLE")
public class User {

    @Id
    @GeneratedValue
    private Long id;

    private String firstName;

    private String lastName;

    @Lob
    private byte[] photo;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate bDate;

    @OneToOne(cascade = CascadeType.ALL)
    private Account account;

    @ManyToOne
    private Role role;


    public User() {
        super();
    }

    public User(String firstName, String lastName, byte[] photo, LocalDate bDate, Account account, Role role) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.photo = photo;
        this.bDate = bDate;
        this.account = account;
        this.role = role;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public byte[] getPhoto() {
        return photo;
    }

    public void setPhoto(byte[] photo) {
        this.photo = photo;
    }

    public LocalDate getbDate() {
        return bDate;
    }

    public void setbDate(LocalDate bDate) {
        this.bDate = bDate;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}
