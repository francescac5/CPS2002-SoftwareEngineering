package Part1;

public class Map {

    private int size;

    public boolean setMapSize(int size) {
        //if inputted size is less than minimum of 5
        if(size < 5){
            return false;
        }
        else{
            this.size = size;
            return true;
        }
    }
}
