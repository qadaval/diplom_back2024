package kz.spring.diplom_project.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DaycareDto {
    private Long id;
    private String name;
    private String bin;
    private Long addressId;
    private int capacity;
    private int emptyPlaces;
}
