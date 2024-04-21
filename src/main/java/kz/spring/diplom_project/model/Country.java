package kz.spring.diplom_project.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "t_country")
@Data
public class Country {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "code")
    private String code;
}
