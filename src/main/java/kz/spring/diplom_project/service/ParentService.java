package kz.spring.diplom_project.service;

import kz.spring.diplom_project.model.Parent;
import kz.spring.diplom_project.repo.ParentRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ParentService {
    private final ParentRepo parentRepo;

    public List<Parent> getAllParent() {
        return parentRepo.findAll();
    }

    public Parent getParent(Long id) {
        return parentRepo.getOne(id);
    }

    public Parent addParent(Parent parent) {
        return parentRepo.save(parent);
    }

    public Parent updateParent(Parent parent) {
        return parentRepo.save(parent);
    }

    public void deleteParent(Long id) {
        parentRepo.deleteById(id);
    }
}
