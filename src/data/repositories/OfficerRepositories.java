package data.repositories;

import data.models.Officer;
import data.models.Vehicle;

import java.util.List;

public interface OfficerRepositories {
    Officer save(Officer officer);
    Officer findById(int id);
    List<Officer> findAll();
    void deleteById(int id);
    void delete(Officer officer);
    void deleteAll(Officer officer);
    Long  count();

}
