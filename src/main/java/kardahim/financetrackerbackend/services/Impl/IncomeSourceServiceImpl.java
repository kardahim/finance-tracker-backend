package kardahim.financetrackerbackend.services.Impl;

import kardahim.financetrackerbackend.models.IncomeSource;
import kardahim.financetrackerbackend.models.IncomeSourceRepository;
import kardahim.financetrackerbackend.services.IncomeSourceService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class IncomeSourceServiceImpl implements IncomeSourceService {
    private final IncomeSourceRepository incomeSourceRepository;

    @Override
    public List<IncomeSource> getAll() {
        return (List<IncomeSource>) incomeSourceRepository.findAll();
    }

    @Override
    public IncomeSource getById(Long id) {
        return incomeSourceRepository.findById(id).orElseThrow();
    }

    @Override
    public IncomeSource getByName(String name) {
        return incomeSourceRepository.findByName(name).orElseThrow();
    }

    @Override
    public void delete(Long id) {
        incomeSourceRepository.deleteById(id);
    }

    @Override
    public void save(IncomeSource incomeSource) {
        incomeSourceRepository.save(incomeSource);
    }

    @Override
    public void edit(Long id, IncomeSource incomeSource) {
        IncomeSource source = incomeSourceRepository.findById(id).orElseThrow();

        source.setName(incomeSource.getName());
        incomeSourceRepository.save(source);
    }
}
