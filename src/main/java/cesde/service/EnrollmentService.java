package cesde.service;

import cesde.Course;
import cesde.Enrollment;
import cesde.Student;
import cesde.repository.EnrollmentRepository;
import java.time.LocalDate;
import java.util.ArrayList;

public class EnrollmentService {

    private EnrollmentRepository repository = new EnrollmentRepository();


    public Enrollment create(Student student, Course course, String semester, double notes) {
        int id = repository.generateId();
        Enrollment enrollment = new Enrollment(id, student, course, LocalDate.now(), semester, notes);
        repository.save(enrollment);
        System.out.println("✔ Matrícula creada: " + enrollment);
        return enrollment;
    }


    public Enrollment getById(int id) {
        Enrollment enrollment = repository.findById(id);
        if (enrollment == null) {
            System.out.println("✘ Matrícula con ID " + id + " no encontrada.");
        }
        return enrollment;
    }


    public ArrayList<Enrollment> getAll() {
        ArrayList<Enrollment> list = repository.findAll();
        if (list.isEmpty()) {
            System.out.println("✘ No hay matrículas registradas.");
        }
        return list;
    }


    public boolean update(int id, Student student, Course course, String semester, double notes) {
        Enrollment existing = repository.findById(id);
        if (existing == null) {
            System.out.println("✘ No se puede actualizar: matrícula ID " + id + " no existe.");
            return false;
        }
        Enrollment updated = new Enrollment(id, student, course, existing.getEnrollmentDate(), semester, notes);
        boolean result = repository.update(id, updated);
        if (result) System.out.println("✔ Matrícula actualizada: " + updated);
        return result;
    }


    public boolean delete(int id) {
        boolean result = repository.delete(id);
        if (result) {
            System.out.println("✔ Matrícula ID " + id + " eliminada.");
        } else {
            System.out.println("✘ No se encontró matrícula ID " + id + " para eliminar.");
        }
        return result;
    }
}