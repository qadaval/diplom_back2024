package kz.spring.diplom_project.service;

import kz.spring.diplom_project.model.Country;
import kz.spring.diplom_project.repo.CountryRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CountryService {
    private final CountryRepo countryRepo;

    public List<Country> getAllCountry() {
        return countryRepo.findAll();
    }

    public Country getCountry(Long id) {
        return countryRepo.getOne(id);
    }

    public Country addCountry(Country country) {
        return countryRepo.save(country);
    }

    public Country updateCountry(Country country) {
        return countryRepo.save(country);
    }

    public void deleteCountry(Long id) {
        countryRepo.deleteById(id);
    }
}
