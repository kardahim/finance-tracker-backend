package kardahim.financetrackerbackend.controllers;

import kardahim.financetrackerbackend.dto.IncomeExpenseRequest;
import kardahim.financetrackerbackend.models.Income;
import kardahim.financetrackerbackend.services.IncomeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/income")
@RequiredArgsConstructor
public class IncomeController {
    private final IncomeService incomeService;

    @PostMapping("")
    public ResponseEntity<?> add(@RequestBody IncomeExpenseRequest incomeExpenseRequest) {
        try {
            incomeService.addIncome(incomeExpenseRequest);
            return ResponseEntity.ok().body(Map.of("message", "Added new Income"));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> edit(@PathVariable Long id, @RequestBody IncomeExpenseRequest incomeExpenseRequest) {
        try {
            incomeService.edit(id, incomeExpenseRequest);
            return ResponseEntity.ok().body(Map.of("message", "Income edited"));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        try {
            incomeService.delete(id);
//            return ResponseEntity.ok("Deleted income");
            return ResponseEntity.ok().body(Map.of("message", "Deleted income"));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("user/{id}")
    public ResponseEntity<?> getAllByUserId(@PathVariable Long id) {
        try {
            return ResponseEntity.ok(incomeService.getAllByUserId(id));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable Long id) {
        try {
            return ResponseEntity.ok(incomeService.getById(id));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
