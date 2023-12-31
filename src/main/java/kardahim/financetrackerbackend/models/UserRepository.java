package kardahim.financetrackerbackend.models;

import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends CrudRepository<User, Long> {
    Optional<User> findByEmail(String email);
    List<User> findAllByRole(Role role);
}
