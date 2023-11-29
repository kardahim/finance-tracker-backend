package kardahim.financetrackerbackend.services.Impl;

import kardahim.financetrackerbackend.dto.IncomeExpenseRequest;
import kardahim.financetrackerbackend.models.*;
import kardahim.financetrackerbackend.services.ExpenseService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ExpenseServiceImpl implements ExpenseService {
    private final ExpenseRepository expenseRepository;
    private final UserRepository userRepository;
    private final ExpenseSourceRepository expenseSourceRepository;

    @Override
    public void addExpense(IncomeExpenseRequest incomeExpenseRequest) {
        User user = userRepository.findById(incomeExpenseRequest.getUserId()).orElseThrow();
        ExpenseSource expenseSource = expenseSourceRepository.findById(incomeExpenseRequest.getSourceId()).orElseThrow();
        Expense expense = new Expense();

        expense.setName(incomeExpenseRequest.getName());
        expense.setAmount(incomeExpenseRequest.getAmount());
        expense.setDate(incomeExpenseRequest.getDate());
        expense.setUser(user);
        expense.setExpenseSource(expenseSource);
        expenseRepository.save(expense);
    }

    @Override
    public void delete(Long id) {
        expenseRepository.deleteById(id);
    }

    @Override
    public void edit(Long id, IncomeExpenseRequest incomeExpenseRequest) {
        Expense expense = expenseRepository.findById(id).orElseThrow();
        User user = userRepository.findById(incomeExpenseRequest.getUserId()).orElseThrow();
        ExpenseSource expenseSource = expenseSourceRepository.findById(incomeExpenseRequest.getSourceId()).orElseThrow();

        expense.setName(incomeExpenseRequest.getName());
        expense.setAmount(incomeExpenseRequest.getAmount());
        expense.setDate(incomeExpenseRequest.getDate());
        expense.setUser(user);
        expense.setExpenseSource(expenseSource);
        expenseRepository.save(expense);
    }

    @Override
    public List<Expense> getAllByUserId(Long id) {
        return expenseRepository.findAllByUserId(id);
    }

    @Override
    public Expense getById(Long id) {
        return expenseRepository.findById(id).orElseThrow();
    }
}
