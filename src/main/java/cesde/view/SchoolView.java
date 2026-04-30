package cesde.view;

import cesde.School;
import cesde.service.SchoolService;
import java.util.ArrayList;
import java.util.Scanner;

public class SchoolView {

    private SchoolService service = new SchoolService();
    private Scanner sc = new Scanner(System.in);


    public void create() {
        System.out.println("\n════════ REGISTRAR ESCUELA ════════");

        System.out.print("Nombre    : "); String name = sc.nextLine();
        System.out.print("Director  : "); String director = sc.nextLine();
        System.out.print("Dirección : "); String address = sc.nextLine();
        System.out.print("Email     : "); String email = sc.nextLine();
        System.out.print("Estado    : "); String status = sc.nextLine();

        service.create(name, director, address, email, status);
    }


    public void search() {
        System.out.println("\n════════ BUSCAR ESCUELA ════════");

        System.out.print("ID a buscar: ");
        int id = Integer.parseInt(sc.nextLine());

        School school = service.getById(id);
        if (school != null) {
            System.out.println("Resultado → " + school);
        }
    }


    public void searchAll() {
        System.out.println("\n═════════ TODAS LAS ESCUELAS ════════");

        ArrayList<School> list = service.getAll();
        for (School s : list) {                         // .for mejorado sobre ArrayList
            System.out.println("  • " + s);
        }
    }


    public void update() {
        System.out.println("\n═════════ ACTUALIZAR ESCUELA ══════════");

        System.out.print("ID a actualizar: ");
        int id = Integer.parseInt(sc.nextLine());

        School existing = service.getById(id);
        if (existing == null) return;

        System.out.println("Datos actuales → " + existing);
        System.out.print("Nuevo nombre    : "); String name = sc.nextLine();
        System.out.print("Nuevo director  : "); String director = sc.nextLine();
        System.out.print("Nueva dirección : "); String address = sc.nextLine();
        System.out.print("Nuevo email     : "); String email = sc.nextLine();
        System.out.print("Nuevo estado    : "); String status = sc.nextLine();

        service.update(id, name, director, address, email, status);
    }


    public void delete() {
        System.out.println("\n══════════ ELIMINAR ESCUELA ═════════");

        System.out.print("ID a eliminar: ");
        int id = Integer.parseInt(sc.nextLine());
        service.delete(id);
    }


    public void showMenu() {
        int option;
        do {
            System.out.println("\n══════════ MÓDULO ESCUELAS ═════════");
            System.out.println("║  1. Registrar escuela        ║");
            System.out.println("║  2. Buscar por ID            ║");
            System.out.println("║  3. Listar todas             ║");
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