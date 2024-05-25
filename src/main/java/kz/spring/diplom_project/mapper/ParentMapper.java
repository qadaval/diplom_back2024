package kz.spring.diplom_project.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import kz.spring.diplom_project.model.Parent;
import kz.spring.diplom_project.model.dto.ParentDto;

@Mapper(componentModel = "spring")
public interface ParentMapper {

    @Mapping(source = "children", target = "children")
//    @Mapping(source = "country.id", target = "countryId")
    @Mapping(source = "city.id", target = "cityId")
    ParentDto toDto(Parent parent);

    @Mapping(source = "children", target = "children")
//    @Mapping(source = "countryId", target = "country.id")
    @Mapping(source = "cityId", target = "city.id")
    Parent toModel(ParentDto parentDto);


    List<ParentDto> toDtoList(List<Parent> parents);
}
