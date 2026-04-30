package cesde.view;

import cesde.ClassRoom;
import cesde.RoomType;
import cesde.service.ClassRoomService;
import java.util.ArrayList;
import java.util.Scanner;

public class ClassRoomView {

    private ClassRoomService service = new ClassRoomService();
    private Scanner sc = new Scanner(System.in);

    public void create() {
        System.out.println("\n════════ REGISTRAR SALÓN ═════════");

        System.out.print("Número de salón         : "); String num = sc.nextLine();
        System.out.print("Piso                    : "); int floor = Integer.parseInt(sc.nextLine());
        System.out.print("Capacidad               : "); int capacity = Integer.parseInt(sc.nextLine());
        System.out.println("Tipo (GRANDE/MEDIANO/PEQUENO): ");
        System.out.print("Tipo: "); RoomType type = RoomType.valueOf(sc.nextLine().toUpperCase());
        System.out.print("Estado                  : "); String status = sc.nextLine();

        service.create(num, floor, capacity, type, status);
    }


    public void search() {
        System.out.println("\n═════════ BUSCAR SALÓN ═════════");

        System.out.print("ID a buscar: ");
        int id = Integer.parseInt(sc.nextLine());

        ClassRoom cr = service.getById(id);
        if (cr != null) {
            System.out.println("Resultado → " + cr);
        }
    }


    public void searchAll() {
        System.out.println("\n════════ TODOS LOS SALONES ════════");

        ArrayList<ClassRoom> list = service.getAll();
        for (ClassRoom cr : list) {                     // .for mejorado sobre ArrayList
            System.out.println("  • " + cr);
        }
    }


    public void update() {
        System.out.println("\n═══════ ACTUALIZAR SALÓN ═══════");

        System.out.print("ID a actualizar: ");
        int id = Integer.parseInt(sc.nextLine());

        ClassRoom existing = service.getById(id);
        if (existing == null) return;

        System.out.println("Datos actuales → " + existing);
        System.out.print("Nuevo número    : "); String num = sc.nextLine();
        System.out.print("Nuevo piso      : "); int floor = Integer.parseInt(sc.nextLine());
        System.out.print("Nueva capacidad : "); int capacity = Integer.parseInt(sc.nextLine());
        System.out.print("Nuevo tipo      : "); RoomType type = RoomType.valueOf(sc.nextLine().toUpperCase());
        System.out.print("Nuevo estado    : "); String status = sc.nextLine();

        service.update(id, num, floor, capacity, type, status);
    }


    public void delete() {
        System.out.println("\n═══════ ELIMINAR SALÓN ════════");

        System.out.print("ID a eliminar: ");
        int id = Integer.parseInt(sc.nextLine());
        service.delete(id);
    }


    public void showMenu() {
        int option;
        do {

            System.out.println("\n════════ MÓDULO SALONES ════════");
            System.out.println("║  1. Registrar salón          ║");
            System.out.println("║  2. Buscar por ID            ║");
            System.out.println("║  3. Listar todos             ║");
            System.out.println("║  4. Actualizar               ║");
            System.out.println("║  5. Eliminar                 ║");
            System.out.println("║  0. Volver                   ║");

            System.out.print("Opción: ");
            option = Integer.parseInt(sc.nextLine());

            switch (option) {
                case 1 -> create();
                case 2 -> search();
                case 3 -> searchAll();
                case 4 -> update();
                case 5 -> delete();
                case 0 -> System.out.println("Volviendo...");
                default -> System.out.println("Opción inválida.");
            }
        } while (option != 0);
    }
}