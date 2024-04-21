package kz.spring.diplom_project.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "t_city")
@Data
public class City {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;
}
