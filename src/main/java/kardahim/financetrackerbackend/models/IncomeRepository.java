package kardahim.financetrackerbackend.models;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface IncomeRepository extends CrudRepository<Income, Long> {
    List<Income> findAllByUserId(Long id);
}
