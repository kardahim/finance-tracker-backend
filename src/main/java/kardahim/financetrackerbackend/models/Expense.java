package kardahim.financetrackerbackend.models;

import com.fasterxml.jackson.annotation.JsonView;
import jakarta.persistence.*;
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

    @JsonView
    private String name;

    @JsonView
    private double amount;

    @JsonView
    private Date date;

    @JsonView
    @ManyToOne
    private ExpenseSource expenseSource;

    @JsonView
    @ManyToOne
    private User user;
}
