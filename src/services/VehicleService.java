package services;

import data.repositories.models.Vehicle;
import java.util.List;

public interface VehicleService {

    void addVehicle(Vehicle vehicle);
    Vehicle getVehicleById(int id);
    List<Vehicle> getAllVehicles();
    boolean removeVehicle(int id);
}
