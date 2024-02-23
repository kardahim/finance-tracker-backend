package kardahim.financetrackerbackend.controllers;

import kardahim.financetrackerbackend.dto.IncomeExpenseRequest;
import kardahim.financetrackerbackend.services.ExpenseService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/v1/expense")
@RequiredArgsConstructor
public class ExpenseController {
    private final ExpenseService expenseService;

    @PostMapping("")
    public ResponseEntity<?> add(@RequestBody IncomeExpenseRequest incomeExpenseRequest) {
        try {
            expenseService.addExpense(incomeExpenseRequest);
            return ResponseEntity.ok().body(Map.of("message", "Added new Expense"));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> edit(@PathVariable Long id, @RequestBody IncomeExpenseRequest incomeExpenseRequest) {
        try {
            expenseService.edit(id, incomeExpenseRequest);
            return ResponseEntity.ok().body(Map.of("message", "Expense edited"));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        try {
            expenseService.delete(id);
            return ResponseEntity.ok("Deleted expense");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("user/{id}")
    public ResponseEntity<?> getAllByUserId(@PathVariable Long id) {
        try {
            return ResponseEntity.ok(expenseService.getAllByUserId(id));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable Long id) {
        try {
            return ResponseEntity.ok(expenseService.getById(id));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
