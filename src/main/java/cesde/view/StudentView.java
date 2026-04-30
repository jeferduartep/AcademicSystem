package cesde.view;

import cesde.Student;
import cesde.service.StudentService;
import java.util.ArrayList;
import java.util.Scanner;

public class StudentView {

    private StudentService service = new StudentService();
    private Scanner sc = new Scanner(System.in);


    public void create() {
        System.out.println("\n══════════ REGISTRAR ESTUDIANTE ══════════");

        System.out.print("Nombre        : "); String name = sc.nextLine();
        System.out.print("Apellido      : "); String lastname = sc.nextLine();
        System.out.print("Email         : "); String email = sc.nextLine();
        System.out.print("N° Documento  : "); String doc = sc.nextLine();
        System.out.print("Estado        : "); String status = sc.nextLine();

        service.create(name, lastname, email, doc, status);
    }


    public void search() {
        System.out.println("\n═════════ BUSCAR ESTUDIANTE ══════════");


        System.out.print("ID a buscar: ");
        int id = Integer.parseInt(sc.nextLine());

        Student student = service.getById(id);
        if (student != null) {
            System.out.println("Resultado → " + student);
        }
    }


    public void searchAll() {
        System.out.println("\n══════════ TODOS LOS ESTUDIANTES ══════════");

        ArrayList<Student> list = service.getAll();
        for (Student s : list) {                        // .for mejorado sobre ArrayList
            System.out.println("  • " + s);
        }
    }


    public void update() {
        System.out.println("\n══════════ ACTUALIZAR ESTUDIANTE ══════════");


        System.out.print("ID a actualizar: ");
        int id = Integer.parseInt(sc.nextLine());

        // Verificar existencia antes de pedir datos
        Student existing = service.getById(id);
        if (existing == null) return;

        System.out.println("Datos actuales → " + existing);
        System.out.print("Nuevo nombre       : "); String name = sc.nextLine();
        System.out.print("Nuevo apellido     : "); String lastname = sc.nextLine();
        System.out.print("Nuevo email        : "); String email = sc.nextLine();
        System.out.print("Nuevo N° Documento : "); String doc = sc.nextLine();
        System.out.print("Nuevo estado       : "); String status = sc.nextLine();

        service.update(id, name, lastname, email, doc, status);
    }


    public void delete() {
        System.out.println("\n══════════ ELIMINAR ESTUDIANTE ══════════");

        System.out.print("ID a eliminar: ");
        int id = Integer.parseInt(sc.nextLine());
        service.delete(id);
    }


    public void showMenu() {
        int option;
        do {
            System.out.println("\n═════════ MÓDULO ESTUDIANTES ════════");
            System.out.println("║  1. Registrar estudiante     ║");
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