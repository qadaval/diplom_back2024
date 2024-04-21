package kz.spring.diplom_project.controller;

import kz.spring.diplom_project.mapper.DaycareMapper;
import kz.spring.diplom_project.model.Daycare;
import kz.spring.diplom_project.model.dto.DaycareDto;
import kz.spring.diplom_project.service.DaycareService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/daycare")
@RequiredArgsConstructor
public class DaycareRestController {
    private final DaycareService daycareService;
    private final DaycareMapper daycareMapper;

    @GetMapping("/all")
    public ResponseEntity<List<DaycareDto>> getAllDaycare() {
        List<Daycare> daycareList = daycareService.getAllDaycare();
        List<DaycareDto> daycareDtoList = daycareMapper.toDtoList(daycareList);
        return new ResponseEntity<>(daycareDtoList, HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<DaycareDto> getDaycare(
            @PathVariable(name = "id") Long id
    ) {
        Daycare daycare = daycareService.getDaycare(id);
        DaycareDto daycareDto = daycareMapper.toDto(daycare);
        return new ResponseEntity<>(daycareDto, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<DaycareDto> addDaycare(
            @RequestBody DaycareDto daycareDto
    ) {
        return new ResponseEntity<>(daycareMapper.toDto(daycareService.addDaycare(daycareMapper.toModel(daycareDto))), HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<DaycareDto> updateDaycare(
            @RequestBody DaycareDto daycareDto
    ) {
        return new ResponseEntity<>(daycareMapper.toDto(daycareService.updateDaycare(daycareMapper.toModel(daycareDto))), HttpStatus.CREATED);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteDaycare(
            @PathVariable(name = "id") Long id
    ) {
        daycareService.deleteDaycare(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
