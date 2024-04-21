package kz.spring.diplom_project.repo;

import kz.spring.diplom_project.model.Child;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChildRepo extends JpaRepository<Child, Long> {
}
