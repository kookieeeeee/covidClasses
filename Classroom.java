public class Classroom {
    
    private String roomNum;
    private int length;
    private int width;
    private boolean hasComputer;

    public Classroom(String roomNum, int length, int width, boolean hasComputer)
    {
        this.roomNum = roomNum;
        this.length = length;
        this.width = width;
        this.hasComputer = hasComputer;
    }

    public String getRoomNumber()
    {
        return roomNum;
    }

    public boolean hasComputer()
    {
        return hasComputer;
    }

    public int getMaxOccupancy()
    {
        //using length and width, you can find the amount of students to fit in this room
        return length*width/4;
    }
}