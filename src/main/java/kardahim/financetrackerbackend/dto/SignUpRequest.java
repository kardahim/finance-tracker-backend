package kardahim.financetrackerbackend.dto;

import lombok.Data;

@Data
public class SignUpRequest {
    private String firstName;
    private String lastName;
    private String password;
    private String email;
}
