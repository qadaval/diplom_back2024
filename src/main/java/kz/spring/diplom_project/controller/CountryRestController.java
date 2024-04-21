package kz.spring.diplom_project.controller;

import kz.spring.diplom_project.mapper.CountryMapper;
import kz.spring.diplom_project.model.Country;
import kz.spring.diplom_project.model.dto.CountryDto;
import kz.spring.diplom_project.service.CountryService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/country")
@RequiredArgsConstructor
public class CountryRestController {
    @Autowired
    private CountryService countryService;

    @Autowired
    private CountryMapper countryMapper;

    @GetMapping(value = "/all")
    public ResponseEntity<List<CountryDto>> getAllCountry() {
        List<Country> countryList = countryService.getAllCountry();
        List<CountryDto> countryDtoList = countryMapper.toDtoList(countryList);
        return new ResponseEntity<>(countryDtoList, HttpStatus.OK);
    }

}
