package kz.spring.diplom_project.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ChildDto {
    private Long id;
    private String name;
    private String f_name;
    private String surname;
    private String iin;
    private LocalDate dateOfBirth;
    private Long parentId;
}
