package kardahim.financetrackerbackend.models;

import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface ExpenseSourceRepository extends CrudRepository<ExpenseSource, Long> {
    Optional<ExpenseSource> findByName(String name);
}
