package cesde.view;

import cesde.Teacher;
import cesde.service.TeacherService;
import java.util.ArrayList;
import java.util.Scanner;

public class TeacherView {

    private TeacherService service = new TeacherService();
    private Scanner sc = new Scanner(System.in);


    public void create() {
        System.out.println("\n══════════ REGISTRAR DOCENTE ═════════");

        System.out.print("Nombre        : "); String name = sc.nextLine();
        System.out.print("Apellido      : "); String lastname = sc.nextLine();
        System.out.print("Especialidad  : "); String speciality = sc.nextLine();
        System.out.print("Email         : "); String email = sc.nextLine();
        System.out.print("Estado        : "); String status = sc.nextLine();

        service.create(name, lastname, speciality, email, status);
    }


    public void search() {
        System.out.println("\n═════════ BUSCAR DOCENTE ══════════");

        System.out.print("ID a buscar: ");
        int id = Integer.parseInt(sc.nextLine());

        Teacher teacher = service.getById(id);
        if (teacher != null) {
            System.out.println("Resultado → " + teacher);
        }
    }


    public void searchAll() {
        System.out.println("\n══════════ TODOS LOS DOCENTES ═════════");

        ArrayList<Teacher> list = service.getAll();
        for (Teacher t : list) {                        // .for mejorado sobre ArrayList
            System.out.println("  • " + t);
        }
    }


    public void update() {
        System.out.println("\n══════════ ACTUALIZAR DOCENTE ═════════");


        System.out.print("ID a actualizar: ");
        int id = Integer.parseInt(sc.nextLine());

        Teacher existing = service.getById(id);
        if (existing == null) return;

        System.out.println("Datos actuales → " + existing);
        System.out.print("Nuevo nombre       : "); String name = sc.nextLine();
        System.out.print("Nuevo apellido     : "); String lastname = sc.nextLine();
        System.out.print("Nueva especialidad : "); String speciality = sc.nextLine();
        System.out.print("Nuevo email        : "); String email = sc.nextLine();
        System.out.print("Nuevo estado       : "); String status = sc.nextLine();

        service.update(id, name, lastname, speciality, email, status);
    }


    public void delete() {
        System.out.println("\n══════════ ELIMINAR DOCENTE ══════════");

        System.out.print("ID a eliminar: ");
        int id = Integer.parseInt(sc.nextLine());
        service.delete(id);
    }


    public void showMenu() {
        int option;
        do {
            System.out.println("\n══════════ MÓDULO DOCENTES  ══════════");
            System.out.println("║  1. Registrar docente        ║");
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