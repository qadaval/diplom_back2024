package kz.spring.diplom_project.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import javax.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Table(name = "t_child")
@Data
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Child {
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

    @Column(name = "date_of_birth")
    private LocalDate dateOfBirth;

    @ManyToOne
    @JoinColumn(name = "parent_id")
    @JsonIgnoreProperties("children")
    private Parent parent;
}
