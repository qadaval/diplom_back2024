package kz.spring.diplom_project.mapper;

import kz.spring.diplom_project.model.Request;
import kz.spring.diplom_project.model.dto.RequestDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface RequestMapper {
    @Mapping(source = "parent.id", target = "parentId")
    @Mapping(source = "child.id", target = "childId")
    RequestDto toDto(Request request);

    List<RequestDto> toDtoList(List<Request> requestList);

    @Mapping(source = "parentId", target = "parent.id")
    @Mapping(source = "childId", target = "child.id")
    Request toModel(RequestDto requestDto);
}
