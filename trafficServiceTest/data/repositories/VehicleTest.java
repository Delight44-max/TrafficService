package data.repositories;

import data.models.Vehicle;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class VehiclesTest {

    private Vehicles vehicleRepository;
    private Vehicle vehicle1;
    private Vehicle vehicle2;

    @BeforeEach
    void setUp() {
        vehicleRepository = new Vehicles();
    }

    @Test
    void testSaveAddsVehicle() {
        Vehicle saved = vehicleRepository.save(vehicle1);
        assertEquals(vehicle1, saved);
        assertFalse(vehicleRepository.findAll().isEmpty());
    }


    @Test
    void testFindAllReturnsAllVehicles() {
        vehicleRepository.save(vehicle1);
        vehicleRepository.save(vehicle2);

        List<Vehicle> all = vehicleRepository.findAll();
        assertEquals(2, all.size());
        assertTrue(all.contains(vehicle1));
        assertTrue(all.contains(vehicle2));
    }

    @Test
    void testFindAllThrowsWhenEmpty() {
        assertThrows(RuntimeException.class, () -> vehicleRepository.findAll());
    }


    @Test
    void testDeleteAllClearsRepository() {
        vehicleRepository.save(vehicle1);
        vehicleRepository.save(vehicle2);

        vehicleRepository.deleteAll(vehicle1);
        assertEquals(1, vehicleRepository.findAll().size());
    }
}