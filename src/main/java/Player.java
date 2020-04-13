public class Player {
    private Position position;

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public static void move(char direction){
        switch(direction){
            case 'U':
                Position.setY(Position.getY()+1);
                break;
            case 'D':
                Position.setY(Position.getY()-1);
                break;
            case 'R':
                Position.setX(Position.getX()+1);
                break;
            case'L':
                Position.setX(Position.getX()-1);
                break;
            default:
                Position.setX(Position.getX());
                Position.setY(Position.getY());
                break;

        }
    }
}
