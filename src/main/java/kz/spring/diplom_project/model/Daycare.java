package kz.spring.diplom_project.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "t_daycare")
@Data
public class Daycare {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "bin")
    private String bin;

    @ManyToOne
    @JoinColumn(name = "address_id")
    private Address address;

    @Column(name = "capacity")
    private int capacity;

    @Column(name = "empty_places")
    private int emptyPlaces;
}
