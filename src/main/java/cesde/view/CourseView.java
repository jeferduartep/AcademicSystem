package cesde.view;

import cesde.Course;
import cesde.Program;
import cesde.Teacher;
import cesde.service.CourseService;
import cesde.service.ProgramService;
import cesde.service.TeacherService;
import java.util.ArrayList;
import java.util.Scanner;

public class CourseView {

    private CourseService service     = new CourseService();
    private TeacherService tService   = new TeacherService();
    private ProgramService pService   = new ProgramService();
    private Scanner sc = new Scanner(System.in);


    public void create() {
        System.out.println("\n═══════ REGISTRAR CURSO ════════");

        System.out.print("Nombre del curso : "); String name = sc.nextLine();
        System.out.print("Créditos         : "); int credits = Integer.parseInt(sc.nextLine());
        System.out.print("Estado           : "); String status = sc.nextLine();
        System.out.print("ID del programa  : "); int programId = Integer.parseInt(sc.nextLine());
        System.out.print("ID del docente   : "); int teacherId = Integer.parseInt(sc.nextLine());

        Program program = pService.getById(programId);
        Teacher teacher = tService.getById(teacherId);

        if (program == null || teacher == null) {
            System.out.println("✘ Programa o docente no encontrado. Curso no creado.");
            return;
        }

        service.create(name, credits, status, program, teacher);
    }


    public void search() {
        System.out.println("\n═════════ BUSCAR CURSO ═════════");


        System.out.print("ID a buscar: ");
        int id = Integer.parseInt(sc.nextLine());

        Course course = service.getById(id);
        if (course != null) {
            System.out.println("Resultado → " + course);
        }
    }


    public void searchAll() {
        System.out.println("\n════════ TODOS LOS CURSOS ════════");

        ArrayList<Course> list = service.getAll();
        for (Course c : list) {                         // .for mejorado sobre ArrayList
            System.out.println("  • " + c);
        }
    }


    public void update() {
        System.out.println("\n═════════ ACTUALIZAR CURSO ════════");

        System.out.print("ID a actualizar: ");
        int id = Integer.parseInt(sc.nextLine());

        Course existing = service.getById(id);
        if (existing == null) return;

        System.out.println("Datos actuales → " + existing);
        System.out.print("Nuevo nombre     : "); String name = sc.nextLine();
        System.out.print("Nuevos créditos  : "); int credits = Integer.parseInt(sc.nextLine());
        System.out.print("Nuevo estado     : "); String status = sc.nextLine();
        System.out.print("ID nuevo programa: "); int programId = Integer.parseInt(sc.nextLine());
        System.out.print("ID nuevo docente : "); int teacherId = Integer.parseInt(sc.nextLine());

        Program program = pService.getById(programId);
        Teacher teacher = tService.getById(teacherId);

        if (program == null || teacher == null) {
            System.out.println("✘ Programa o docente no encontrado.");
            return;
        }

        service.update(id, name, credits, status, program, teacher);
    }


    public void delete() {
        System.out.println("\n══════════ ELIMINAR CURSO ════════");

        System.out.print("ID a eliminar: ");
        int id = Integer.parseInt(sc.nextLine());
        service.delete(id);
    }

    public void showMenu() {
        int option;
        do {
            System.out.println("\n════════ MÓDULO CURSOS ═════════");
            System.out.println("║  1. Registrar curso          ║");
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