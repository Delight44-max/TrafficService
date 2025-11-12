package data.repositories;

import data.models.Officer;

import java.util.ArrayList;
import java.util.List;

public class Officers implements OfficerRepositories {
    private List<Officer> officers = new ArrayList<>();

    public boolean isEmpty() {
        return officers.isEmpty();
    }


    @Override
    public Officer save(Officer officer) {
        officers.add(officer);
        return officer;
        }


    @Override
    public Officer findById(int id) {
        for (Officer officer : officers) {
            if (officer.getId() == id) {
                return officer;
            }
        }
        return null;
    }

    @Override
    public List<Officer> findAll() {
        if  (officers.isEmpty()) {
            throw new RuntimeException("No officers found");
        }
        return officers;
    }

    @Override
    public void deleteById(int id) {
        for(Officer officer : officers) {
            if (officer.getId() == id) {
                officers.remove(officer);
            }
        }

    }

    @Override
    public void delete(Officer officer) {
        officers.remove(officer);

    }

    @Override
    public void deleteAll(Officer officer) {
        officers.remove(officer);

    }

    @Override
    public Long count() {
        return 0L;
    }
}
