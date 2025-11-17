package data.repositories.repositories;

import data.repositories.models.Vehicle;

import java.util.List;

public interface VehicleRepositories {
    Vehicle save(Vehicle vehicle);
    Vehicle findById(int id);
    List<Vehicle> findAll();
    void deleteById(int id);
    void delete(Vehicle vehicle);
    void deleteAll(Vehicle vehicle);

    void deleteAll();

    Long  count();


}
