package kz.spring.diplom_project.model;

import javax.persistence.*;
import lombok.Data;

import java.util.Date;
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

    @Column(name = "iin", unique = true)
    private String iin;

    private String password;

    @Column(name = "date_of_birth")
    private Date dateOfBirth;

    @Column(name = "citizenship")
    private String citizenship;

    @ManyToOne(fetch = FetchType.EAGER)
    private City city;

    @Column(name = "phoneNumber")
    private String phoneNumber;

    @Column(name = "gender")
    private String gender;

    @OneToMany(mappedBy = "parent", fetch = FetchType.LAZY)
    private List<Child> children;

}
