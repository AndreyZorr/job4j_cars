package ru.job4j.cars.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "engine")
@AllArgsConstructor
public class Engine {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
}
