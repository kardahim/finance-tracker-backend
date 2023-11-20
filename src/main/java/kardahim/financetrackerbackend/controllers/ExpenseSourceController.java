package kardahim.financetrackerbackend.controllers;

import kardahim.financetrackerbackend.models.ExpenseSource;
import kardahim.financetrackerbackend.services.ExpenseSourceService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/expense-source")
@RequiredArgsConstructor
public class ExpenseSourceController {
    private final ExpenseSourceService expenseSourceService;

    @GetMapping("")
    public ResponseEntity<List<ExpenseSource>> getAll() {
        return ResponseEntity.ok(expenseSourceService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable Long id) {
        try {
            return ResponseEntity.ok(expenseSourceService.getById(id));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/name/{name}")
    public ResponseEntity<?> getByName(@PathVariable String name) {
        try {
            return ResponseEntity.ok(expenseSourceService.getByName(name));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @PostMapping("")
    public ResponseEntity<?> create(@RequestBody ExpenseSource expenseSource) {
        try {
            expenseSourceService.save(expenseSource);
            return ResponseEntity.ok("Added new incomeSource");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @PutMapping("/{id}")
    public ResponseEntity<?> edit(@PathVariable Long id, @RequestBody ExpenseSource expenseSource) {
        try {
            expenseSourceService.edit(id, expenseSource);
            return ResponseEntity.ok("Edited incomeSource");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        try {
            expenseSourceService.delete(id);
            return ResponseEntity.ok("Deleted incomeSource");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
