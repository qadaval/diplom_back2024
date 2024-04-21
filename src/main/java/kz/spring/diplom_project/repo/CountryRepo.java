package kz.spring.diplom_project.repo;

import kz.spring.diplom_project.model.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface CountryRepo extends JpaRepository<Country, Long> {

}
