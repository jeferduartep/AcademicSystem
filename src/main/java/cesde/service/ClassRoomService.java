package cesde.service;

import cesde.ClassRoom;
import cesde.RoomType;
import cesde.repository.ClassRoomRepository;
import java.util.ArrayList;

public class ClassRoomService {

    private ClassRoomRepository repository = new ClassRoomRepository();

    public ClassRoom create(String numClassRoom, int floor, int capacity, RoomType roomType, String status) {
        int id = repository.generateId();
        ClassRoom classRoom = new ClassRoom(id, numClassRoom, floor, capacity, roomType, status);
        repository.save(classRoom);
        System.out.println("✔ Salón creado: " + classRoom);
        return classRoom;
    }

    public ClassRoom getById(int id) {
        ClassRoom classRoom = repository.findById(id);
        if (classRoom == null) {
            System.out.println("✘ Salón con ID " + id + " no encontrado.");
        }
        return classRoom;
    }


    public ArrayList<ClassRoom> getAll() {
        ArrayList<ClassRoom> list = repository.findAll();
        if (list.isEmpty()) {
            System.out.println("✘ No hay salones registrados.");
        }
        return list;
    }


    public boolean update(int id, String numClassRoom, int floor, int capacity, RoomType roomType, String status) {
        ClassRoom existing = repository.findById(id);
        if (existing == null) {
            System.out.println("✘ No se puede actualizar: salón ID " + id + " no existe.");
            return false;
        }
        ClassRoom updated = new ClassRoom(id, numClassRoom, floor, capacity, roomType, status);
        boolean result = repository.update(id, updated);
        if (result) System.out.println("✔ Salón actualizado: " + updated);
        return result;
    }


    public boolean delete(int id) {
        boolean result = repository.delete(id);
        if (result) {
            System.out.println("✔ Salón ID " + id + " eliminado.");
        } else {
            System.out.println("✘ No se encontró salón ID " + id + " para eliminar.");
        }
        return result;
    }
}