package kardahim.financetrackerbackend.models;

import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface IncomeSourceRepository extends CrudRepository<IncomeSource, Long> {
    Optional<IncomeSource> findByName(String name);
}
