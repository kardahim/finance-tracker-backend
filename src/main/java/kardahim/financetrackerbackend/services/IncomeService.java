package kardahim.financetrackerbackend.services;

import kardahim.financetrackerbackend.dto.IncomeExpenseRequest;
import kardahim.financetrackerbackend.models.Income;

import java.util.List;

public interface IncomeService {
    public void addIncome(IncomeExpenseRequest incomeExpenseRequest);
    void delete(Long id);
    void edit(Long id, IncomeExpenseRequest incomeExpenseRequest);
    List<Income> getAllByUserId(Long id);
    Income getById(Long id);
}
