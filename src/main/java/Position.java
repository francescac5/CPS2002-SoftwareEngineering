public class Position {

    //variables for the x-axis and y-axis
    private static int x;
    private static int y;

    //constructor for position
    public Position(int x, int y)
    {
        Position.x = x;
        Position.y = y;
    }

    //getters and setters for the x-axis and y-axis
    public static int getX() {
        return x;
    }

    public static void setX(int x) {
        Position.x = x;
    }

    public static int getY() {
        return y;
    }

    public static void setY(int y) {
        Position.y = y;
    }

}
