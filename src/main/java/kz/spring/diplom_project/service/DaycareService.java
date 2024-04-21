package kz.spring.diplom_project.service;

import kz.spring.diplom_project.model.Daycare;
import kz.spring.diplom_project.repo.DaycareRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DaycareService {
    private final DaycareRepo daycareRepo;

    public List<Daycare> getAllDaycare() {
        return daycareRepo.findAll();
    }

    public Daycare getDaycare(Long id) {
        return daycareRepo.getOne(id);
    }

    public Daycare addDaycare(Daycare daycare) {
        return daycareRepo.save(daycare);
    }

    public Daycare updateDaycare(Daycare daycare) {
        return daycareRepo.save(daycare);
    }

    public void deleteDaycare(Long id) {
        daycareRepo.deleteById(id);
    }
}
