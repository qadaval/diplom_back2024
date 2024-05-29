package kz.spring.diplom_project.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddressDto {
    private Long id;
    private Long cityId;
    private String region;
    private String district;
    private String street;
    private String house;

}
