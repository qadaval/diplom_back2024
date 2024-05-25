package kz.spring.diplom_project.repo;

import kz.spring.diplom_project.model.Parent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ParentRepo extends JpaRepository<Parent, Long> {
    Parent findByIin(String iin);
}
