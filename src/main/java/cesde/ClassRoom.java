package cesde;

import java.util.Scanner;

public class ClassRoom {

    Scanner sc = new Scanner(System.in);

    private int id;
    private String numClassRoom;
    private int floor;
    private int capacity;
    private RoomType roomType;
    private String status;

    public ClassRoom(int id, String numClassRoom, int floor, int capacity, RoomType roomType, String status) {
        this.id = id;
        this.numClassRoom = numClassRoom;
        this.floor = floor;
        this.capacity = capacity;
        this.roomType = roomType;
        this.status = status;
    }

    public void createClassRoom() {
        System.out.print("Número: "); numClassRoom = sc.nextLine();
        System.out.print("Capacidad: "); capacity = sc.nextInt();
        System.out.println("Salon de clase creado.");
    }

    public void getClassRoomDetails() {
        System.out.println("= Salon De Clase =");
        System.out.println(numClassRoom + " | Capacidad: " + capacity);
    }

    public boolean isAvailable() {
        return status.equals("DISPONIBLE");
    }
}
