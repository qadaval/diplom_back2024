package kz.spring.diplom_project.request;

// AuthenticationRequest.java
import lombok.Data;

@Data
public class AuthenticationRequest {
    private String iin;
    private String password;
}
