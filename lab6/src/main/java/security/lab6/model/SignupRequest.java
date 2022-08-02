package security.lab6.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class SignupRequest {
    private String email;
    private String password;
    private String firstname;
    private String lastname;
}
