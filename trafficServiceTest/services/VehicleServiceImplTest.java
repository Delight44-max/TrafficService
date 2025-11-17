package services;

import data.repositories.models.Owner;
import data.repositories.models.Vehicle;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

class VehicleServiceImplTest {

    private VehicleService vehicleService;
    private Owner owner1;
    private Owner owner2;
    private Vehicle vehicle1;
    private Vehicle vehicle2;

    @BeforeEach
    void setUp() {
        vehicleService = new VehicleServiceImpl();

        owner1 = new Owner(1, "Alice Johnson", "08060099358");
        owner2 = new Owner(2, "Johnson", "08160099358");

        vehicle1 = new Vehicle(1, "Toyota", "Camry", owner1);
        vehicle2 = new Vehicle(2, "Honda", "Civic", owner2);
    }

    @Test
    void testAddVehicle() {
        vehicleService.addVehicle(vehicle1);
        vehicleService.addVehicle(vehicle2);

        List<Vehicle> allVehicles = vehicleService.getAllVehicles();
        assertEquals(2, allVehicles.size());
        assertTrue(allVehicles.contains(vehicle1));
        assertTrue(allVehicles.contains(vehicle2));
    }

    @Test
    void testAddNullVehicleThrowsException() {
        assertThrows(IllegalArgumentException.class, () -> vehicleService.addVehicle(null));
    }

    @Test
    void testGetVehicleByIdSuccess() {
        vehicleService.addVehicle(vehicle1);

        Vehicle found = vehicleService.getVehicleById(1);
        assertEquals(vehicle1, found);
        assertEquals("Toyota", found.getMake());
    }

    @Test
    void testGetVehicleByIdNotFoundThrowsException() {
        assertThrows(NoSuchElementException.class, () -> vehicleService.getVehicleById(999));
    }

    @Test
    void testGetAllVehiclesReturnsCopy() {
        vehicleService.addVehicle(vehicle1);
        List<Vehicle> allVehicles = vehicleService.getAllVehicles();

        // Modify the returned list
        allVehicles.remove(vehicle1);

        // Original list in service should not change
        List<Vehicle> serviceList = vehicleService.getAllVehicles();
        assertEquals(1, serviceList.size());
        assertTrue(serviceList.contains(vehicle1));
    }

    @Test
    void testRemoveVehicleSuccess() {
        vehicleService.addVehicle(vehicle1);
        vehicleService.addVehicle(vehicle2);

        boolean removed = vehicleService.removeVehicle(1);
        assertTrue(removed);

        List<Vehicle> remaining = vehicleService.getAllVehicles();
        assertEquals(1, remaining.size());
        assertEquals(vehicle2, remaining.get(0));
    }

    @Test
    void testRemoveVehicleNotFoundThrowsException() {
        assertThrows(NoSuchElementException.class, () -> vehicleService.removeVehicle(999));
    }
}
