package kardahim.financetrackerbackend.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Income {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    @NotBlank(message = "Name is mandatory")
    private String name;

    @Column(nullable = false)
    @NotBlank(message = "Amount is mandatory")
    private double amount;

    @Column(nullable = false)
    @NotBlank(message = "Date is mandatory")
    private Date date;

    @ManyToOne
    private IncomeSource incomeSource;

    @ManyToOne
    private User user;
}
