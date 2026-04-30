package cesde.view;

import cesde.Program;
import cesde.School;
import cesde.service.ProgramService;
import cesde.service.SchoolService;
import java.util.ArrayList;
import java.util.Scanner;

public class ProgramView {

    private ProgramService service  = new ProgramService();
    private SchoolService scService = new SchoolService();
    private Scanner sc = new Scanner(System.in);


    public void create() {
        System.out.println("\n╔══════════════════════════════╗");
        System.out.println("║      REGISTRAR PROGRAMA      ║");
        System.out.println("╚══════════════════════════════╝");

        System.out.print("Nombre del programa : "); String name = sc.nextLine();
        System.out.print("Total créditos      : "); int credits = Integer.parseInt(sc.nextLine());
        System.out.print("Título              : "); String degree = sc.nextLine();
        System.out.print("Estado              : "); String status = sc.nextLine();
        System.out.print("ID de la escuela    : "); int schoolId = Integer.parseInt(sc.nextLine());

        School school = scService.getById(schoolId);
        if (school == null) {
            System.out.println("✘ Escuela no encontrada. Programa no creado.");
            return;
        }

        service.create(name, credits, degree, status, school);
    }


    public void search() {
        System.out.println("\n╔══════════════════════════════╗");
        System.out.println("║       BUSCAR PROGRAMA        ║");
        System.out.println("╚══════════════════════════════╝");

        System.out.print("ID a buscar: ");
        int id = Integer.parseInt(sc.nextLine());

        Program p = service.getById(id);
        if (p != null) {
            System.out.println("Resultado → " + p);
        }
    }


    public void searchAll() {
        System.out.println("\n╔══════════════════════════════╗");
        System.out.println("║      TODOS LOS PROGRAMAS     ║");
        System.out.println("╚══════════════════════════════╝");

        ArrayList<Program> list = service.getAll();
        for (Program p : list) {                        // .for mejorado sobre ArrayList
            System.out.println("  • " + p);
        }
    }


    public void update() {
        System.out.println("\n╔══════════════════════════════╗");
        System.out.println("║      ACTUALIZAR PROGRAMA     ║");
        System.out.println("╚══════════════════════════════╝");

        System.out.print("ID a actualizar: ");
        int id = Integer.parseInt(sc.nextLine());

        Program existing = service.getById(id);
        if (existing == null) return;

        System.out.println("Datos actuales → " + existing);
        System.out.print("Nuevo nombre    : "); String name = sc.nextLine();
        System.out.print("Nuevos créditos : "); int credits = Integer.parseInt(sc.nextLine());
        System.out.print("Nuevo título    : "); String degree = sc.nextLine();
        System.out.print("Nuevo estado    : "); String status = sc.nextLine();
        System.out.print("ID nueva escuela: "); int schoolId = Integer.parseInt(sc.nextLine());

        School school = scService.getById(schoolId);
        if (school == null) {
            System.out.println("✘ Escuela no encontrada.");
            return;
        }

        service.update(id, name, credits, degree, status, school);
    }


    public void delete() {
        System.out.println("\n╔══════════════════════════════╗");
        System.out.println("║       ELIMINAR PROGRAMA      ║");
        System.out.println("╚══════════════════════════════╝");

        System.out.print("ID a eliminar: ");
        int id = Integer.parseInt(sc.nextLine());
        service.delete(id);
    }


    public void showMenu() {
        int option;
        do {
            System.out.println("\n══════════ MÓDULO PROGRAMAS ═════════");
            System.out.println("║  1. Registrar programa       ║");
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