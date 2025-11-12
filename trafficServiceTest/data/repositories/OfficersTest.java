package data.repositories;

import data.models.Officer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class OfficersTest {

    private Officers officerRepository;
    private Officer officer1;
    private Officer officer2;

    @BeforeEach
    void setUp() {
        officerRepository = new Officers();

    }

    @Test
    void testSaveOfficer() {
        Officer saved = officerRepository.save(officer1);
        assertEquals(officer1, saved);
        assertFalse(officerRepository.isEmpty());
    }

    @Test
    void testFindAllReturnsListOfOfficers() {
        officerRepository.save(officer1);
        officerRepository.save(officer2);

        List<Officer> officers = officerRepository.findAll();
        assertEquals(2, officers.size());
    }

    @Test
    void testFindAllThrowsWhenEmpty() {
        assertThrows(RuntimeException.class, () -> officerRepository.findAll());
    }


    @Test
    void testCountReturnsZeroInitially() {
        assertEquals(0L, officerRepository.count());
    }
}
