package cesde.service;

import cesde.ClassRoom;
import cesde.Course;
import cesde.DayOfWeekEnum;
import cesde.Schedule;
import cesde.Teacher;
import cesde.repository.ScheduleRepository;
import java.time.LocalTime;
import java.util.ArrayList;

public class ScheduleService {

    private ScheduleRepository repository = new ScheduleRepository();


    public Schedule create(Course course, Teacher teacher, ClassRoom classroom, DayOfWeekEnum day, LocalTime startTime) {
        int id = repository.generateId();
        Schedule schedule = new Schedule(id, course, teacher, classroom, day, startTime);
        repository.save(schedule);
        System.out.println("✔ Horario creado: " + schedule);
        return schedule;
    }


    public Schedule getById(int id) {
        Schedule schedule = repository.findById(id);
        if (schedule == null) {
            System.out.println("✘ Horario con ID " + id + " no encontrado.");
        }
        return schedule;
    }


    public ArrayList<Schedule> getAll() {
        ArrayList<Schedule> list = repository.findAll();
        if (list.isEmpty()) {
            System.out.println("✘ No hay horarios registrados.");
        }
        return list;
    }


    public boolean update(int id, Course course, Teacher teacher, ClassRoom classroom, DayOfWeekEnum day, LocalTime startTime) {
        Schedule existing = repository.findById(id);
        if (existing == null) {
            System.out.println("✘ No se puede actualizar: horario ID " + id + " no existe.");
            return false;
        }
        Schedule updated = new Schedule(id, course, teacher, classroom, day, startTime);
        boolean result = repository.update(id, updated);
        if (result) System.out.println("✔ Horario actualizado: " + updated);
        return result;
    }


    public boolean delete(int id) {
        boolean result = repository.delete(id);
        if (result) {
            System.out.println("✔ Horario ID " + id + " eliminado.");
        } else {
            System.out.println("✘ No se encontró horario ID " + id + " para eliminar.");
        }
        return result;
    }
}