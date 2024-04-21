package kz.spring.diplom_project.repo;

import kz.spring.diplom_project.model.Daycare;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DaycareRepo extends JpaRepository<Daycare, Long> {
}
