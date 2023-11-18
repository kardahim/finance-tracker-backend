package kardahim.financetrackerbackend.models;

import com.fasterxml.jackson.annotation.JsonView;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonView
    private String firstName;

    @JsonView
    private String lastName;

    @JsonView
    private String email;

    @JsonView
    private String password;

    @JsonView
    @ManyToOne
    private Role role;
}
