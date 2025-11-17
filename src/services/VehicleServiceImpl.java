package services;

import data.repositories.models.Vehicle;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class VehicleServiceImpl implements VehicleService {

    private List<Vehicle> vehicleList = new ArrayList<>();

    @Override
    public void addVehicle(Vehicle vehicle) {
        if (vehicle == null) {
            throw new IllegalArgumentException("Vehicle cannot be null");
        }
        vehicleList.add(vehicle);
    }

    @Override
    public Vehicle getVehicleById(int vehicleId) {
        for (Vehicle vehicle : vehicleList) {
            if (vehicle.getId() == vehicleId) {
                return vehicle;
            }
        }
        throw new NoSuchElementException("Vehicle with ID " + vehicleId + " not found");
    }

    @Override
    public List<Vehicle> getAllVehicles() {
        return new ArrayList<>(vehicleList);
    }

    @Override
    public boolean removeVehicle(int vehicleId) {
        for (int i = 0; i < vehicleList.size(); i++) {
            Vehicle vehicle = vehicleList.get(i);
            if (vehicle.getId() == vehicleId) {
                vehicleList.remove(i);
                return true;
            }
        }
        throw new NoSuchElementException("Vehicle with ID " + vehicleId + " not found");
    }
}
