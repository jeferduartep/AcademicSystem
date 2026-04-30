package cesde;

public class ClassRoom {

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

    public int getId() { return id; }
    public String getNumClassRoom() { return numClassRoom; }
    public int getFloor() { return floor; }
    public int getCapacity() { return capacity; }
    public RoomType getRoomType() { return roomType; }
    public String getStatus() { return status; }

    public void setNumClassRoom(String numClassRoom) { this.numClassRoom = numClassRoom; }
    public void setFloor(int floor) { this.floor = floor; }
    public void setCapacity(int capacity) { this.capacity = capacity; }
    public void setRoomType(RoomType roomType) { this.roomType = roomType; }
    public void setStatus(String status) { this.status = status; }

    public boolean isAvailable() {
        return status.equals("DISPONIBLE");
    }

    @Override
    public String toString() {
        return "Salon " + numClassRoom + " | Piso: " + floor + " | Capacidad: " + capacity
                + " | Tipo: " + roomType + " | Estado: " + status;
    }
}