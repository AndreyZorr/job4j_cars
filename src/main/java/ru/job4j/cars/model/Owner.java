package ru.job4j.cars.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "owner")
@AllArgsConstructor
public class Owner {

    private int id;
}
