package kardahim.financetrackerbackend.services;

import kardahim.financetrackerbackend.models.IncomeSource;

import java.util.List;
import java.util.Optional;

public interface IncomeSourceService {
    List<IncomeSource> getAll();
    IncomeSource getById(Long id);
    IncomeSource getByName(String name);
    void delete(Long id);
    void save(IncomeSource incomeSource);
    void edit(Long id, IncomeSource incomeSource);
}
