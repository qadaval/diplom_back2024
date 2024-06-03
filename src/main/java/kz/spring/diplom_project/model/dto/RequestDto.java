package kz.spring.diplom_project.model.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class RequestDto {
    private Long id;
    private LocalDate dateOfRequest;
    private Long parentId;
    private Long childId;
    private boolean isApproved;
}
