package kz.spring.diplom_project.controller;

import kz.spring.diplom_project.mapper.CityMapper;
import kz.spring.diplom_project.model.City;
import kz.spring.diplom_project.model.dto.CityDto;
import kz.spring.diplom_project.service.CityService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/city")
@RestController
public class CityRestController {
    @Autowired
    private CityService cityService;

    @Autowired
    private CityMapper cityMapper;

    @GetMapping(value = "/all")
    public ResponseEntity<List<CityDto>> getAllCity() {
        List<City> cityList = cityService.getAllCity();
        List<CityDto> cityDtoList = cityMapper.toDtoList(cityList);
        return new ResponseEntity<>(cityDtoList, HttpStatus.OK);
    }
    @GetMapping(value = "/find/{id}")
    public ResponseEntity<CityDto> getCity(
            @PathVariable (name = "id") Long id
    ) {
        City city = cityService.getCity(id);
        CityDto cityDto = cityMapper.toDto(city);
        return new ResponseEntity<>(cityDto, HttpStatus.OK);
    }
}
