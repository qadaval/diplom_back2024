package kz.spring.diplom_project.service;

import kz.spring.diplom_project.model.City;
import kz.spring.diplom_project.repo.CityRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CityService {
    private final CityRepo cityRepo;

    public List<City> getAllCity() {
        return cityRepo.findAll();
    }

    public City getCity(Long id) {
        return cityRepo.getOne(id);
    }

    public City addCity(City city) {
        return cityRepo.save(city);
    }

    public City updateCity(City city) {
        return cityRepo.save(city);
    }

    public void deleteCity(Long id) {
        cityRepo.deleteById(id);
    }
}
