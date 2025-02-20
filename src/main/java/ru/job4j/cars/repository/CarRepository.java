package ru.job4j.cars.repository;

import lombok.AllArgsConstructor;
import ru.job4j.cars.model.Car;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@AllArgsConstructor
public class CarRepository {

    private final CrudRepository crudRepository;

    public Car create(Car car) {
        crudRepository.run(session -> session.persist(car));
        return car;
    }

    public void update(Car car) {
        crudRepository.run(session -> session.persist(car));
    }

    public void delete(int carId) {
        crudRepository.run(
                "Delete From CAR Where id = :fId",
                Map.of("fId", carId));
    }

    public List<Car> findAllOrderById() {
        return crudRepository.query(
                "From Car order by id asc",
                Car.class);
    }

    public Optional<Car> findById(int carId) {
        return crudRepository.optional("From Car Where id :fId",
                Car.class,
                Map.of("fId", carId)
        );
    }
}
