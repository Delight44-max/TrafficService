package respositories;

import data.repositories.models.Owner;
import data.repositories.models.Vehicle;
import data.repositories.repositories.VehicleRepositories;
import data.repositories.repositories.Vehicles;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class VehiclesTest {

    private VehicleRepositories vehicleRepo;
    private Vehicle vehicle1;
    private Vehicle vehicle2;
    private Owner owner;

    @BeforeEach
    void setUp() {
        vehicleRepo = new Vehicles();
        owner = new Owner(1, "John Doe", "08012345678");
        vehicle1 = new Vehicle(1, "ABC123", "Toyota",  owner);
        vehicle2 = new Vehicle(2, "XYZ987", "Honda",  owner);
    }

    @Test
    void testSaveVehicle() {
        Vehicle saved = vehicleRepo.save(vehicle1);
        assertEquals(vehicle1, saved);
    }

    @Test
    void testFindByIdReturnsVehicle() {
        vehicleRepo.save(vehicle1);
        Vehicle found = vehicleRepo.findById(1);
        assertEquals(vehicle1, found);
    }

    @Test
    void testFindByIdReturnsNullWhenNotFound() {
        Vehicle found = vehicleRepo.findById(999);
        assertNull(found);
    }

    @Test
    void testFindAllReturnsList() {
        vehicleRepo.save(vehicle1);
        vehicleRepo.save(vehicle2);

        List<Vehicle> allVehicles = vehicleRepo.findAll();
        assertEquals(2, allVehicles.size());
        assertTrue(allVehicles.contains(vehicle1));
        assertTrue(allVehicles.contains(vehicle2));
    }

    @Test
    void testFindAllThrowsWhenEmpty() {
        assertThrows(RuntimeException.class, () -> vehicleRepo.findAll());
    }

    @Test
    void testDeleteById() {
        vehicleRepo.save(vehicle1);
        vehicleRepo.save(vehicle2);

        vehicleRepo.deleteById(1);
        List<Vehicle> all = vehicleRepo.findAll();
        assertEquals(1, all.size());
        assertFalse(all.contains(vehicle1));
        assertTrue(all.contains(vehicle2));
    }

    @Test
    void testDeleteVehicle() {
        vehicleRepo.save(vehicle1);
        vehicleRepo.save(vehicle2);

        vehicleRepo.delete(vehicle1);
        List<Vehicle> all = vehicleRepo.findAll();
        assertEquals(1, all.size());
        assertFalse(all.contains(vehicle1));
        assertTrue(all.contains(vehicle2));
    }

    @Test
    void testDeleteAll() {
        vehicleRepo.save(vehicle1);
        vehicleRepo.save(vehicle2);

        vehicleRepo.deleteAll();
        assertThrows(RuntimeException.class, () -> vehicleRepo.findAll());
    }

    @Test
    void testCount() {
        vehicleRepo.save(vehicle1);
        vehicleRepo.save(vehicle2);

        assertEquals(2L, vehicleRepo.count());
    }
}
