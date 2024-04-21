package kz.spring.diplom_project.mapper;

import kz.spring.diplom_project.model.Country;
import kz.spring.diplom_project.model.dto.CountryDto;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CountryMapper {
    CountryDto toDto(Country country);

    List<CountryDto> toDtoList(List<Country> countryList);

    Country toModel(CountryDto countryDto);
}
