package kz.spring.diplom_project.mapper;

import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import kz.spring.diplom_project.model.Daycare;
import kz.spring.diplom_project.model.dto.DaycareDto;

@Mapper(componentModel = "spring")
public interface DaycareMapper {

    @Mapping(source = "address.id", target = "addressId")
    DaycareDto toDto(Daycare daycare);

    @Mapping(source = "addressId", target = "address.id") // Map the addressId back to the address entity
    Daycare toModel(DaycareDto daycareDto);

    List<DaycareDto> toDtoList(List<Daycare> daycares);
}
