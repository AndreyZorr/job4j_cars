package ru.job4j.cars.repository;

import lombok.AllArgsConstructor;
import ru.job4j.cars.model.Engine;

import java.util.Map;

@AllArgsConstructor
public class EngineRepository {

    private final CrudRepository crudRepository;

    public Engine create(Engine engine) {
        crudRepository.run(session -> session.persist(engine));
        return engine;
    }

    public void update(Engine engine) {
        crudRepository.run(session -> session.persist(engine));
    }

    public void delete(int engineId) {
        crudRepository.run("Delete From Engine Where id = :fId",
                Map.of("fId", engineId));
    }
}
