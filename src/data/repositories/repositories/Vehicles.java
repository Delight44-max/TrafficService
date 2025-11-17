package data.repositories.repositories;

import data.repositories.models.Vehicle;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Vehicles implements VehicleRepositories {

    private List<Vehicle> vehicles = new ArrayList<>();

    private boolean isEmpty() {
        return vehicles.isEmpty();
    }

    @Override
    public Vehicle save(Vehicle vehicle) {
        vehicles.add(vehicle);
        return vehicle;
    }

    @Override
    public Vehicle findById(int id) {
        for (Vehicle vehicle : vehicles) {
            if (vehicle.getId() == id) {
                return vehicle;
            }
        }
        return null;
    }

    @Override
    public List<Vehicle> findAll() {
        if (vehicles.isEmpty()) {
            throw new RuntimeException("Vehicles is empty");
        }
        return vehicles;
    }

    @Override
    public void deleteById(int id) {
        if (vehicles.isEmpty()) {
            throw new RuntimeException("Vehicles is empty");
        }

        Iterator<Vehicle> iterator = vehicles.iterator();
        while (iterator.hasNext()) {
            Vehicle vehicle = iterator.next();
            if (vehicle.getId() == id) {
                iterator.remove();
                break;
            }
        }
    }

    @Override
    public void delete(Vehicle vehicleToDelete) {
        if (vehicles.isEmpty()) {
            throw new RuntimeException("Vehicles is empty");
        }

        Iterator<Vehicle> iterator = vehicles.iterator();
        while (iterator.hasNext()) {
            Vehicle vehicle = iterator.next();
            if (vehicle.equals(vehicleToDelete)) {
                iterator.remove();
                break;
            }
        }
    }

    @Override
    public void deleteAll(Vehicle vehicle) {
        vehicles.remove(vehicle);

    }

    @Override
    public void deleteAll() {
        vehicles.clear();
    }

    @Override
    public Long count() {
        return (long) vehicles.size();
    }
}
