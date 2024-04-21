package kz.spring.diplom_project.model.dto;

import kz.spring.diplom_project.model.Child;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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
    private Long countryId;
    private Long cityId;
    private String gender;
    private String phoneNumber;
    private List<Child> children;
}
