package kardahim.financetrackerbackend.services.Impl;

import kardahim.financetrackerbackend.dto.IncomeExpenseRequest;
import kardahim.financetrackerbackend.models.*;
import kardahim.financetrackerbackend.services.IncomeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class IncomeServiceImpl implements IncomeService {
    private final IncomeRepository incomeRepository;
    private final UserRepository userRepository;
    private final IncomeSourceRepository incomeSourceRepository;

    @Override
    public void addIncome(IncomeExpenseRequest incomeExpenseRequest) {
        User user = userRepository.findById(incomeExpenseRequest.getUserId()).orElseThrow();
        IncomeSource incomeSource = incomeSourceRepository.findById(incomeExpenseRequest.getSourceId()).orElseThrow();
        Income income = new Income();

        income.setName(incomeExpenseRequest.getName());
        income.setAmount(incomeExpenseRequest.getAmount());
        income.setDate(incomeExpenseRequest.getDate());
        income.setUser(user);
        income.setIncomeSource(incomeSource);
        incomeRepository.save(income);
    }

    @Override
    public void delete(Long id) {
        incomeRepository.deleteById(id);
    }

    @Override
    public void edit(Long id, IncomeExpenseRequest incomeExpenseRequest) {
        Income income = incomeRepository.findById(id).orElseThrow();
        User user = userRepository.findById(incomeExpenseRequest.getUserId()).orElseThrow();
        IncomeSource incomeSource = incomeSourceRepository.findById(incomeExpenseRequest.getSourceId()).orElseThrow();

        income.setName(incomeExpenseRequest.getName());
        income.setAmount(incomeExpenseRequest.getAmount());
        income.setDate(incomeExpenseRequest.getDate());
        income.setUser(user);
        income.setIncomeSource(incomeSource);
        incomeRepository.save(income);
    }

    @Override
    public List<Income> getAllByUserId(Long id) {
        return incomeRepository.findAllByUserId(id);
    }
}
