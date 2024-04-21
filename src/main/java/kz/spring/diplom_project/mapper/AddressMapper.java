package kz.spring.diplom_project.mapper;

import java.util.List;
import org.mapstruct.Mapper;
import kz.spring.diplom_project.model.Address;
import kz.spring.diplom_project.model.dto.AddressDto;

@Mapper(componentModel = "spring")
public interface AddressMapper {

    AddressDto toDto(Address address);

    Address toModel(AddressDto addressDto);

    List<AddressDto> toDtoList(List<Address> addresses);
}
