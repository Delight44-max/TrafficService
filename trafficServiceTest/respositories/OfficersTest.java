package respositories;

import data.repositories.models.Officer;
import data.repositories.repositories.Officers;
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
        officer1 = new Officer(1, "James Bond", "fiveStar");
        officer2 = new Officer(2, "Ethan Hunt", "fiveStar");
    }

    @Test
    void testSaveOfficer() {
        Officer saved = officerRepository.save(officer1);
        assertEquals(officer1, saved);
        assertFalse(officerRepository.isEmpty());
        assertEquals(1, officerRepository.count());
    }

    @Test
    void testFindAllReturnsListOfOfficers() {
        officerRepository.save(officer1);
        officerRepository.save(officer2);

        List<Officer> officers = officerRepository.findAll();
        assertEquals(2, officers.size());
        assertTrue(officers.contains(officer1));
        assertTrue(officers.contains(officer2));
    }

    @Test
    void testFindAllThrowsWhenEmpty() {
        assertThrows(RuntimeException.class, () -> officerRepository.findAll());
    }





    @Test
    void testIsEmptyReturnsTrueInitially() {
        assertTrue(officerRepository.isEmpty());
    }

    @Test
    void testIsEmptyReturnsFalseAfterSave() {
        officerRepository.save(officer1);
        assertFalse(officerRepository.isEmpty());
    }

    @Test
    void testDeleteOfficer() {
        officerRepository.save(officer1);
        officerRepository.save(officer2);

        officerRepository.delete(officer1);
        assertEquals(1, officerRepository.count());
        assertFalse(officerRepository.findAll().contains(officer1));
        assertTrue(officerRepository.findAll().contains(officer2));
    }

    @Test
    void testDeleteOfficerNotInRepo() {
        officerRepository.save(officer2);
        assertDoesNotThrow(() -> officerRepository.delete(officer1));
        assertEquals(1, officerRepository.count());
        assertTrue(officerRepository.findAll().contains(officer2));
    }
}
