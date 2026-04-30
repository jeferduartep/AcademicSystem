package cesde.repository;

import cesde.Teacher;
import java.util.ArrayList;

public class TeacherRepository {

    private ArrayList<Teacher> teachers = new ArrayList<>();
    private int nextId = 1;

    public Teacher save(Teacher teacher) {
        teachers.add(teacher);
        return teacher;
    }

    public Teacher findById(int id) {
        for (Teacher t : teachers) {
            if (t.getId() == id) return t;
        }
        return null;
    }

    public ArrayList<Teacher> findAll() {
        return teachers;
    }

    public boolean update(int id, Teacher updated) {
        for (int i = 0; i < teachers.size(); i++) {
            if (teachers.get(i).getId() == id) {
                teachers.set(i, updated);
                return true;
            }
        }
        return false;
    }

    public boolean delete(int id) {
        for (int i = 0; i < teachers.size(); i++) {
            if (teachers.get(i).getId() == id) {
                teachers.remove(i);
                return true;
            }
        }
        return false;
    }

    public int generateId() {
        return nextId++;
    }
}