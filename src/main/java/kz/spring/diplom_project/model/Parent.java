package kz.spring.diplom_project.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Table(name = "t_parent")
@Data
public class Parent {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "f_name")
    private String f_name;

    @Column(name = "surname")
    private String surname;

    @Column(name = "iin")
    private String iin;

    @ManyToOne(fetch = FetchType.EAGER)
    private Country country;

    @ManyToOne(fetch = FetchType.EAGER)
    private City city;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Enumerated(EnumType.STRING)
    private Gender gender;

    @OneToMany(mappedBy = "parent", fetch = FetchType.LAZY)
    private List<Child> children;

}
