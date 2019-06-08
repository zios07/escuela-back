package ma.escuela.escuela;

import ma.escuela.escuela.domain.Account;
import ma.escuela.escuela.domain.Cours;
import ma.escuela.escuela.domain.Role;
import ma.escuela.escuela.domain.User;
import ma.escuela.escuela.repository.CoursRepository;
import ma.escuela.escuela.repository.RoleRepository;
import ma.escuela.escuela.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.Collections;

@SpringBootApplication
public class EScuelaApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(EScuelaApplication.class, args);
    }

    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private CoursRepository coursRepository;

    @Autowired
    private BCryptPasswordEncoder encoder;


    // Some data to initialize the database (for test purposes)

    @Override
    public void run(String... args) throws Exception {

        if (userRepository.count() == 0) {

            // Init users and roles

            Role adminRole = roleRepository.save(new Role("ADMIN", "Administrator"));
            Role eleveRole = roleRepository.save(new Role("ELEVE", "Eleve"));
            Role parentRole = roleRepository.save(new Role("PARENT", "Parent"));

            Account account = new Account("admin", encoder.encode("demo"));
            Account account2 = new Account("eleve", encoder.encode("demo"));
            Account account3 = new Account("parent", encoder.encode("demo"));

            User admin = new User();
            admin.setRole(adminRole);
            admin.setAccount(account);

            User eleve = new User();
            eleve.setRole(eleveRole);
            eleve.setAccount(account2);

            User parent = new User();
            parent.setRole(parentRole);
            parent.setAccount(account3);

            userRepository.save(admin);
            userRepository.save(eleve);
            userRepository.save(parent);


        }

        if(coursRepository.count() == 0) {
            // Init courses

            Cours cours = coursRepository.save(new Cours("Java", "Java and Java EE course", 11, "Advanced", true, 999.99, Collections.emptyList()));
            Cours cours1 = coursRepository.save(new Cours("Angular", "Angular course", 11, "Intermediate", true, 599.00, Collections.emptyList()));
            Cours cours2 = coursRepository.save(new Cours("C#", "C sharp and .Net course", 22, "Beginner", true, 999.99, Collections.emptyList()));
            Cours cours3 = coursRepository.save(new Cours("Python", "Machine learning using python course", 11, "Advanced", true, 1299.99, Collections.emptyList()));
            Cours cours4 = coursRepository.save(new Cours("Scala", "Scala course", 11, "Advanced", true, 999.99, Collections.emptyList()));
            Cours cours5 = coursRepository.save(new Cours("Docker", "Docker CE and docker EE course", 9, "Advanced", true, 2999.99, Collections.emptyList()));

        }

    }

}
