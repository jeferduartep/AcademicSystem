package cesde.repository;

import cesde.Course;
import java.util.ArrayList;

public class CourseRepository {

    private ArrayList<Course> courses = new ArrayList<>();
    private int nextId = 1;

    public Course save(Course course) {
        courses.add(course);
        return course;
    }

    public Course findById(int id) {
        for (Course c : courses) {
            if (c.getId() == id) return c;
        }
        return null;
    }

    public ArrayList<Course> findAll() {
        return courses;
    }

    public boolean update(int id, Course updated) {
        for (int i = 0; i < courses.size(); i++) {
            if (courses.get(i).getId() == id) {
                courses.set(i, updated);
                return true;
            }
        }
        return false;
    }

    public boolean delete(int id) {
        for (int i = 0; i < courses.size(); i++) {
            if (courses.get(i).getId() == id) {
                courses.remove(i);
                return true;
            }
        }
        return false;
    }

    public int generateId() {
        return nextId++;
    }
}