package kz.spring.diplom_project.model.dto;

import javax.validation.constraints.NotEmpty;
import kz.spring.diplom_project.model.Child;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ParentDto {
    private Long id;
    private String name;
    private String f_name;
    private String surname;
    private String iin;
    @NotEmpty(message = "Password cannot be empty")
    private String password;
    private Date dateOfBirth;
    private String citizenship;
    private Long cityId;
    private String gender;
    private String phoneNumber;
    private List<Child> children;
}
