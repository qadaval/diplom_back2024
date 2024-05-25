package kz.spring.diplom_project.model;

import javax.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "t_queue")
@Data
public class Queue {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne
    private Daycare daycare;

    @OneToMany(mappedBy = "queue", cascade = CascadeType.ALL)
    private List<Request> requestList = new ArrayList<>();
}
