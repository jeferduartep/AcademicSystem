package cesde.repository;

import cesde.Student;
import java.util.ArrayList;

public class StudentRepository {


    private ArrayList<Student> students = new ArrayList<>();
    private int nextId = 1;


    public Student save(Student student) {
        students.add(student);
        return student;
    }


    public Student findById(int id) {
        for (int i = 0; i < students.size(); i++) {
            Student s = students.get(i);
            if (s.getId() == id) return s;
        }
        return null;
    }


    public ArrayList<Student> findAll() {
        return students;
    }


    public boolean update(int id, Student updated) {
        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).getId() == id) {
                students.set(i, updated);
                return true;
            }
        }
        return false;
    }


    public boolean delete(int id) {
        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).getId() == id) {
                students.remove(i);
                return true;
            }
        }
        return false;
    }


    public int generateId() {
        return nextId++;
    }
}