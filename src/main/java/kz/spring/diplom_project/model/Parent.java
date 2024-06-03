package kz.spring.diplom_project.model;

import javax.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

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
    private LocalDate dateOfBirth;

    @Column(name = "citizenship")
    private String citizenship;

    @ManyToOne(fetch = FetchType.EAGER)
    private City city;

    @Column(name = "phoneNumber")
    private String phoneNumber;

    @Column(name = "gender")
    private String gender;

    @OneToMany(mappedBy = "parent", fetch = FetchType.EAGER)
    private List<Child> children;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "parent_roles",
            joinColumns = @JoinColumn(name = "parent_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id")
    )
    private Set<Role> roles;

}
