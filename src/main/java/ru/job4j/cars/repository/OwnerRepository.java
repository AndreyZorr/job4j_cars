package ru.job4j.cars.repository;

import lombok.AllArgsConstructor;
import ru.job4j.cars.model.Owner;

import java.util.Map;

@AllArgsConstructor
public class OwnerRepository {

    private final CrudRepository crudRepository;

    public Owner create(Owner owner) {
        crudRepository.run(session -> session.persist(owner));
        return owner;
    }

    public void update(Owner owner) {
        crudRepository.run(session -> session.persist(owner));
    }

    public void delete(int ownerId) {
        crudRepository.run("Delete From OWNER Where id = :fId",
                Map.of("fId", ownerId)
        );
    }
}
