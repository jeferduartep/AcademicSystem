package cesde.service;

import cesde.Course;
import cesde.Program;
import cesde.Teacher;
import cesde.repository.CourseRepository;
import java.util.ArrayList;

public class CourseService {

    private CourseRepository repository = new CourseRepository();


    public Course create(String name, int credits, String status, Program program, Teacher teacher) {
        int id = repository.generateId();
        Course course = new Course(id, name, credits, status, program, teacher);
        repository.save(course);
        System.out.println("✔ Curso creado: " + course);
        return course;
    }


    public Course getById(int id) {
        Course course = repository.findById(id);
        if (course == null) {
            System.out.println("✘ Curso con ID " + id + " no encontrado.");
        }
        return course;
    }


    public ArrayList<Course> getAll() {
        ArrayList<Course> list = repository.findAll();
        if (list.isEmpty()) {
            System.out.println("✘ No hay cursos registrados.");
        }
        return list;
    }


    public boolean update(int id, String name, int credits, String status, Program program, Teacher teacher) {
        Course existing = repository.findById(id);
        if (existing == null) {
            System.out.println("✘ No se puede actualizar: curso ID " + id + " no existe.");
            return false;
        }
        Course updated = new Course(id, name, credits, status, program, teacher);
        boolean result = repository.update(id, updated);
        if (result) System.out.println("✔ Curso actualizado: " + updated);
        return result;
    }


    public boolean delete(int id) {
        boolean result = repository.delete(id);
        if (result) {
            System.out.println("✔ Curso ID " + id + " eliminado.");
        } else {
            System.out.println("✘ No se encontró curso ID " + id + " para eliminar.");
        }
        return result;
    }
}