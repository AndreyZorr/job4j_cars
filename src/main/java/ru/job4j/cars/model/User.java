package ru.job4j.cars.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;

@Data
@Entity
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Table(name = "auto_user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private int id;
    private String login;
    private String password;

    @ManyToMany
    @JoinTable(name = "participates",
    joinColumns =  { @JoinColumn(name = "user_id") },
    inverseJoinColumns = { @JoinColumn(name = "post_id ") }
    )
    private String participates;
}