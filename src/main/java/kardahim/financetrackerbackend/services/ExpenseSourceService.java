package kardahim.financetrackerbackend.services;

import kardahim.financetrackerbackend.models.ExpenseSource;

import java.util.List;

public interface ExpenseSourceService {
    List<ExpenseSource> getAll();
    ExpenseSource getById(Long id);
    ExpenseSource getByName(String name);
    void delete(Long id);
    void save(ExpenseSource incomeSource);
    void edit(Long id, ExpenseSource incomeSource);
}