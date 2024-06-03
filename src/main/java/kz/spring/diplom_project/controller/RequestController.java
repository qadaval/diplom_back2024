package kz.spring.diplom_project.controller;

import kz.spring.diplom_project.mapper.RequestMapper;
import kz.spring.diplom_project.model.Request;
import kz.spring.diplom_project.model.dto.RequestDto;
import kz.spring.diplom_project.service.RequestService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/request")
@RequiredArgsConstructor
public class RequestController {
    private final RequestService requestService;
    private final RequestMapper requestMapper;

    @GetMapping("/all")
    public ResponseEntity<List<RequestDto>> getAllRequest() {
        List<Request> requestList = requestService.getAllRequest();
        List<RequestDto> requestDtoList = requestMapper.toDtoList(requestList);
        return new ResponseEntity<>(requestDtoList, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<RequestDto> addRequest(
            @RequestBody RequestDto requestDto
    ) {
        return new ResponseEntity<>(requestMapper.toDto(requestService.addRequest(requestMapper.toModel(requestDto))), HttpStatus.CREATED);
    }
}
