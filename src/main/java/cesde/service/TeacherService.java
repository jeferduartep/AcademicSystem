package cesde.service;

import cesde.Teacher;
import cesde.repository.TeacherRepository;
import java.util.ArrayList;

public class TeacherService {

    private TeacherRepository repository = new TeacherRepository();


    public Teacher create(String name, String lastname, String speciality, String email, String status) {
        int id = repository.generateId();
        Teacher teacher = new Teacher(id, name, lastname, speciality, email, status);
        repository.save(teacher);
        System.out.println("✔ Docente creado: " + teacher);
        return teacher;
    }


    public Teacher getById(int id) {
        Teacher teacher = repository.findById(id);
        if (teacher == null) {
            System.out.println("✘ Docente con ID " + id + " no encontrado.");
        }
        return teacher;
    }


    public ArrayList<Teacher> getAll() {
        ArrayList<Teacher> list = repository.findAll();
        if (list.isEmpty()) {
            System.out.println("✘ No hay docentes registrados.");
        }
        return list;
    }


    public boolean update(int id, String name, String lastname, String speciality, String email, String status) {
        Teacher existing = repository.findById(id);
        if (existing == null) {
            System.out.println("✘ No se puede actualizar: docente ID " + id + " no existe.");
            return false;
        }
        Teacher updated = new Teacher(id, name, lastname, speciality, email, status);
        boolean result = repository.update(id, updated);
        if (result) System.out.println("✔ Docente actualizado: " + updated);
        return result;
    }


    public boolean delete(int id) {
        boolean result = repository.delete(id);
        if (result) {
            System.out.println("✔ Docente ID " + id + " eliminado.");
        } else {
            System.out.println("✘ No se encontró docente ID " + id + " para eliminar.");
        }
        return result;
    }
}