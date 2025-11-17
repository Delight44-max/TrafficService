package data.repositories.repositories;

import data.repositories.models.Officer;

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
