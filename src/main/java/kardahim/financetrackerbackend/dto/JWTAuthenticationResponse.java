package kardahim.financetrackerbackend.dto;

import kardahim.financetrackerbackend.models.User;
import lombok.Data;

@Data
public class JWTAuthenticationResponse {
    private String token;
    private String refreshToken;
    private User user;
}
