package kz.spring.diplom_project.mapper;

import kz.spring.diplom_project.model.City;
import kz.spring.diplom_project.model.dto.CityDto;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CityMapper {
    CityDto toDto(City city);

    List<CityDto> toDtoList(List<City> cityList);

    City toModel(CityDto cityDto);
}
