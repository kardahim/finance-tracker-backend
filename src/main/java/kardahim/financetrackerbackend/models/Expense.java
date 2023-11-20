package kardahim.financetrackerbackend.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "expenses")
public class Expense {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    @NotBlank(message = "Name is mandatory")
    private String name;

    @Column(nullable = false)
    @NotNull(message = "Amount is mandatory")
    private double amount;

    @Column(nullable = false)
    @NotNull(message = "Date is mandatory")
    private Date date;

    @ManyToOne
    private ExpenseSource expenseSource;

    @ManyToOne
    private User user;
}
