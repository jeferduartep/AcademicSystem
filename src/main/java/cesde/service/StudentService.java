package cesde.service;

import cesde.Student;
import cesde.repository.StudentRepository;
import java.util.ArrayList;

public class StudentService {

    private StudentRepository repository = new StudentRepository();


    public Student create(String name, String lastname, String email, String documentNumber, String status) {
        int id = repository.generateId();
        Student student = new Student(id, name, lastname, email, documentNumber, status);
        repository.save(student);
        System.out.println("✔ Estudiante creado: " + student);
        return student;
    }


    public Student getById(int id) {
        Student student = repository.findById(id);
        if (student == null) {
            System.out.println("✘ Estudiante con ID " + id + " no encontrado.");
        }
        return student;
    }


    public ArrayList<Student> getAll() {
        ArrayList<Student> list = repository.findAll();
        if (list.isEmpty()) {
            System.out.println("✘ No hay estudiantes registrados.");
        }
        return list;
    }


    public boolean update(int id, String name, String lastname, String email, String documentNumber, String status) {
        Student existing = repository.findById(id);
        if (existing == null) {
            System.out.println("✘ No se puede actualizar: estudiante ID " + id + " no existe.");
            return false;
        }
        Student updated = new Student(id, name, lastname, email, documentNumber, status);
        boolean result = repository.update(id, updated);
        if (result) System.out.println("✔ Estudiante actualizado: " + updated);
        return result;
    }


    public boolean delete(int id) {
        boolean result = repository.delete(id);
        if (result) {
            System.out.println("✔ Estudiante ID " + id + " eliminado.");
        } else {
            System.out.println("✘ No se encontró estudiante ID " + id + " para eliminar.");
        }
        return result;
    }
}