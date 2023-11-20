package kardahim.financetrackerbackend.services;

import jakarta.validation.ConstraintViolationException;
import kardahim.financetrackerbackend.dto.JWTAuthenticationResponse;
import kardahim.financetrackerbackend.dto.RefreshTokenRequest;
import kardahim.financetrackerbackend.dto.SignInRequest;
import kardahim.financetrackerbackend.dto.SignUpRequest;
import kardahim.financetrackerbackend.models.User;

public interface AuthenticationService {
    User signup(SignUpRequest signUpRequest) throws ConstraintViolationException;
    JWTAuthenticationResponse signin(SignInRequest signInRequest);
    JWTAuthenticationResponse refreshToken(RefreshTokenRequest refreshTokenRequest);
}
