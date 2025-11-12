package data.repositories;

import data.models.Ticket;
import data.models.Vehicle;

import java.util.ArrayList;
import java.util.List;

public class Vehicles implements  VehicleRepositories {
    private List<Vehicle>  vehicles = new ArrayList<>();

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
    return  null;
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
        for (Vehicle vehicle : vehicles) {
            if (vehicle.getId() == id) {
                vehicles.remove(vehicle);
            } else if (vehicles.isEmpty()) {
                throw new RuntimeException("Vehicles is empty");

            }
        }

    }

    @Override
    public void delete(Vehicle vehicle) {
        for (Vehicle vehicle1 : vehicles) {
            vehicles.remove(vehicle1);

        }

    }

    @Override
    public void deleteAll(Vehicle vehicle) {
        vehicles.remove(vehicle);


    }

    @Override
    public Long count() {
        return 0L;
    }
}
