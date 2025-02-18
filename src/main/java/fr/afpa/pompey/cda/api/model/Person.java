package fr.afpa.pompey.cda.api.model;

import jakarta.persistence.*;
import lombok.Data;


@Data

@Entity
@Table(name = "Person")
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name="id")
    private int id;

    @Column(name="firstname")
    private String firstName;

    @Column(name="lastname")
    private String lastName;




}
