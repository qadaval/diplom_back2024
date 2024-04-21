package kz.spring.diplom_project.repo;

import kz.spring.diplom_project.model.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface CityRepo extends JpaRepository<City, Long> {
}
