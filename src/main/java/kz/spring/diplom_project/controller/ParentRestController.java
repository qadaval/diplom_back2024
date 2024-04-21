package kz.spring.diplom_project.controller;

import kz.spring.diplom_project.mapper.ParentMapper;
import kz.spring.diplom_project.model.Parent;
import kz.spring.diplom_project.model.dto.ParentDto;
import kz.spring.diplom_project.service.ParentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/parent")
@RequiredArgsConstructor
public class ParentRestController {
    private final ParentService parentService;
    private final ParentMapper parentMapper;

    @GetMapping("/all")
    public ResponseEntity<List<ParentDto>> getAllParent() {
        List<Parent> parents = parentService.getAllParent();
        List<ParentDto> parentDtoList = parentMapper.toDtoList(parents);
        return new ResponseEntity<>(parentDtoList, HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<ParentDto> getParent(
            @PathVariable(name = "id") Long id
    ) {
        Parent parent = parentService.getParent(id);
        ParentDto parentDto = parentMapper.toDto(parent);
        return new ResponseEntity<>(parentDto, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<ParentDto> addParent(
            @RequestBody ParentDto parentDto
    ) {
        return new ResponseEntity<>(parentMapper.toDto(parentService.addParent(parentMapper.toModel(parentDto))), HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<ParentDto> updateParent(
            @RequestBody ParentDto parentDto
    ) {
        return new ResponseEntity<>(parentMapper.toDto(parentService.updateParent(parentMapper.toModel(parentDto))), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteParent(
            @PathVariable(name = "id") Long id
    ) {
        parentService.deleteParent(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
