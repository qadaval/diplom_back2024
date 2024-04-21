package kz.spring.diplom_project.mapper;

import kz.spring.diplom_project.model.Child;
import kz.spring.diplom_project.model.dto.ChildDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ChildMapper {

    @Mapping(source = "address.id",target = "addressId")
    @Mapping(source = "parent.id", target = "parentId")
    ChildDto toDto(Child child);

    List<ChildDto> toDtoList(List<Child> children);

    @Mapping(source = "addressId",target = "address.id")
    @Mapping(source = "parentId", target = "parent.id")
    Child toModel(ChildDto childDto);
}
