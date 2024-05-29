package kz.spring.diplom_project.model;

import javax.persistence.*;
import lombok.Data;

@Entity
@Table(name = "t_address")
@Data
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER)
    private City city;

    @Column(name = "region")
    private String region;

    @Column(name = "district")
    private String district;

    @Column(name = "street")
    private String street;

    @Column(name = "house")
    private String house;
}
