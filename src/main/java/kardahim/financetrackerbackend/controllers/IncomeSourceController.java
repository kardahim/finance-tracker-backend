package kardahim.financetrackerbackend.controllers;

import kardahim.financetrackerbackend.models.IncomeSource;
import kardahim.financetrackerbackend.services.IncomeSourceService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/income-source")
@RequiredArgsConstructor
public class IncomeSourceController {
    private final IncomeSourceService incomeSourceService;

    @GetMapping("")
    public ResponseEntity<List<IncomeSource>> getAll() {
        return ResponseEntity.ok(incomeSourceService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable Long id) {
        try {
            return ResponseEntity.ok(incomeSourceService.getById(id));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/name/{name}")
    public ResponseEntity<?> getByName(@PathVariable String name) {
        try {
            return ResponseEntity.ok(incomeSourceService.getByName(name));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @PostMapping("")
    public ResponseEntity<?> create(@RequestBody IncomeSource incomeSource) {
        try {
            incomeSourceService.save(incomeSource);
            return ResponseEntity.ok("Added new incomeSource");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @PutMapping("/{id}")
    public ResponseEntity<?> edit(@PathVariable Long id, @RequestBody IncomeSource incomeSource) {
        try {
            incomeSourceService.edit(id, incomeSource);
            return ResponseEntity.ok("Edited incomeSource");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        try {
            incomeSourceService.delete(id);
            return ResponseEntity.ok("Deleted incomeSource");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
