package kardahim.financetrackerbackend.services.Impl;

import kardahim.financetrackerbackend.models.ExpenseSource;
import kardahim.financetrackerbackend.models.ExpenseSourceRepository;
import kardahim.financetrackerbackend.services.ExpenseSourceService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ExpenseSourceServiceImpl implements ExpenseSourceService {
    private final ExpenseSourceRepository expenseSourceRepository;

    @Override
    public List<ExpenseSource> getAll() {
        return (List<ExpenseSource>) expenseSourceRepository.findAll();
    }

    @Override
    public ExpenseSource getById(Long id) {
        return expenseSourceRepository.findById(id).orElseThrow();
    }

    @Override
    public ExpenseSource getByName(String name) {
        return expenseSourceRepository.findByName(name).orElseThrow();
    }

    @Override
    public void delete(Long id) {
        expenseSourceRepository.deleteById(id);
    }

    @Override
    public void save(ExpenseSource expenseSource) {
        expenseSourceRepository.save(expenseSource);
    }

    @Override
    public void edit(Long id, ExpenseSource expenseSource) {
        ExpenseSource source = expenseSourceRepository.findById(id).orElseThrow();

        source.setName(expenseSource.getName());
        expenseSourceRepository.save(source);
    }
}
