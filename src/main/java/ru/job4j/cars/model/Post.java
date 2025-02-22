package ru.job4j.cars.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
@Table(name = "post")
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private int id;

    private String description;

    private LocalDateTime create = LocalDateTime.now();

    @ManyToOne
    @JoinColumn(name = "auto_user_id")
    private User user;

    @OneToMany
    @JoinColumn(name = "post_id")
    private List<PriceHistory> messengers = new ArrayList<>();

    @OneToOne
    @JoinColumn(name = "brand_id")
    private Brand brand;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "foto_id", foreignKey = @ForeignKey(name = "FOTO_ID_FK"))
    private List<Photo> foto = new ArrayList<>();
}