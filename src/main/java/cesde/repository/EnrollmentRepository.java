package cesde.repository;

import cesde.Enrollment;
import java.util.ArrayList;

public class EnrollmentRepository {

    private ArrayList<Enrollment> enrollments = new ArrayList<>();
    private int nextId = 1;

    public Enrollment save(Enrollment enrollment) {
        enrollments.add(enrollment);
        return enrollment;
    }

    public Enrollment findById(int id) {
        for (Enrollment e : enrollments) {
            if (e.getId() == id) return e;
        }
        return null;
    }

    public ArrayList<Enrollment> findAll() {
        return enrollments;
    }

    public boolean update(int id, Enrollment updated) {
        for (int i = 0; i < enrollments.size(); i++) {
            if (enrollments.get(i).getId() == id) {
                enrollments.set(i, updated);
                return true;
            }
        }
        return false;
    }

    public boolean delete(int id) {
        for (int i = 0; i < enrollments.size(); i++) {
            if (enrollments.get(i).getId() == id) {
                enrollments.remove(i);
                return true;
            }
        }
        return false;
    }

    public int generateId() {
        return nextId++;
    }
}