package kardahim.financetrackerbackend.services;

import kardahim.financetrackerbackend.dto.IncomeExpenseRequest;
import kardahim.financetrackerbackend.models.Expense;

import java.util.List;

public interface ExpenseService {
    public void addExpense(IncomeExpenseRequest incomeExpenseRequest);
    void delete(Long id);
    void edit(Long id, IncomeExpenseRequest incomeExpenseRequest);
    List<Expense> getAllByUserId(Long id);
}
