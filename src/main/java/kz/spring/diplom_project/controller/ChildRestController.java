package kz.spring.diplom_project.controller;

import kz.spring.diplom_project.mapper.ChildMapper;
import kz.spring.diplom_project.model.Child;
import kz.spring.diplom_project.model.dto.ChildDto;
import kz.spring.diplom_project.service.ChildService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/child")
@RestController
@RequiredArgsConstructor
public class ChildRestController {

    private final ChildService childService;
    private final ChildMapper childMapper;

    @GetMapping("/all")
    public ResponseEntity<List<ChildDto>> getAllChild() {
        List<Child> children = childService.getAllChild();
        List<ChildDto> childDtoList = childMapper.toDtoList(children);
        return new ResponseEntity<>(childDtoList, HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<ChildDto> getChild(
            @PathVariable(name = "id") Long id
    ) {
        Child child = childService.getChild(id);
        ChildDto childDto = childMapper.toDto(child);
        return new ResponseEntity<>(childDto, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<ChildDto> addChild(
            @RequestBody ChildDto childDto
    ) {
        return new ResponseEntity<>(childMapper.toDto(childService.addChild(childMapper.toModel(childDto))), HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<ChildDto> updateChild(
            @RequestBody ChildDto childDto
    ) {
        return new ResponseEntity<>(childMapper.toDto(childService.updateChild(childMapper.toModel(childDto))), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteChild(
            @PathVariable(name = "id") Long id
    ) {
        childService.deleteChild(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
