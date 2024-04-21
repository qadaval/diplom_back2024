package kz.spring.diplom_project.service;

import kz.spring.diplom_project.model.Child;
import kz.spring.diplom_project.repo.ChildRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ChildService {
    private final ChildRepo childRepo;

    public List<Child> getAllChild() {
        return childRepo.findAll();
    }

    public Child getChild(Long id) {
        return childRepo.getOne(id);
    }

    public Child addChild(Child child) {
        return childRepo.save(child);
    }

    public Child updateChild(Child child) {
        return childRepo.save(child);
    }

    public void deleteChild(Long id) {
        childRepo.deleteById(id);
    }
}
