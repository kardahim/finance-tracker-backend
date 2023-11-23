package kardahim.financetrackerbackend;

import kardahim.financetrackerbackend.models.Role;
import kardahim.financetrackerbackend.models.User;
import kardahim.financetrackerbackend.models.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import java.util.List;

@SpringBootApplication
public class FinanceTrackerBackendApplication implements CommandLineRunner {
    @Autowired
    private UserRepository userRepository;

    public static void main(String[] args) {
        SpringApplication.run(FinanceTrackerBackendApplication.class, args);
    }

    public void run(String... args) {

        List<User> adminAccounts = userRepository.findAllByRole(Role.ADMIN);
        if(adminAccounts.isEmpty())  {
            User user = new User();

            user.setEmail("admin@gmail.com");
            user.setFirstName("admin");
            user.setLastName("admin");
            user.setRole(Role.ADMIN);
            user.setPassword(new BCryptPasswordEncoder().encode("admin"));
            userRepository.save(user);
        }
    }
}
