package kz.spring.diplom_project.repo;

import kz.spring.diplom_project.model.Queue;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QueueRepo extends JpaRepository<Queue, Long> {
}
