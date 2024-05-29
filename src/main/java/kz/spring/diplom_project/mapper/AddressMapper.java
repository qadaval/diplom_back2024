package kz.spring.diplom_project.mapper;

import java.util.List;
import org.mapstruct.Mapper;
import kz.spring.diplom_project.model.Address;
import kz.spring.diplom_project.model.dto.AddressDto;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface AddressMapper {

    @Mapping(source = "city.id", target = "cityId")
    AddressDto toDto(Address address);

    @Mapping(source = "cityId", target = "city.id")
    Address toModel(AddressDto addressDto);

    List<AddressDto> toDtoList(List<Address> addresses);
}
