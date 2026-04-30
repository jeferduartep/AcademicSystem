package cesde.repository;

import cesde.School;
import java.util.ArrayList;

public class SchoolRepository {

    private ArrayList<School> schools = new ArrayList<>();
    private int nextId = 1;

    public School save(School school) {
        schools.add(school);                            // .add()
        return school;
    }

    public School findById(int id) {
        for (School s : schools) {
            if (s.getId() == id) return s;
        }
        return null;
    }

    public ArrayList<School> findAll() {
        return schools;
    }

    public boolean update(int id, School updated) {
        for (int i = 0; i < schools.size(); i++) {
            if (schools.get(i).getId() == id) {
                schools.set(i, updated);
                return true;
            }
        }
        return false;
    }

    public boolean delete(int id) {
        for (int i = 0; i < schools.size(); i++) {
            if (schools.get(i).getId() == id) {
                schools.remove(i);
                return true;
            }
        }
        return false;
    }

    public int generateId() {
        return nextId++;
    }
}