package kardahim.financetrackerbackend.dto;

import lombok.Data;

import java.util.Date;

@Data
public class IncomeExpenseRequest {
    private String name;
    private double amount;
    private Date date;
    private Long sourceId;
    private Long userId;
}
