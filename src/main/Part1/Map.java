package Part1;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

public class Map {

    private int size;
    private static int mapCount;

    public void initMapCount() {
        mapCount = 0;
    }

    //only for testing purposes
    public int getMapCount() {
        return mapCount;
    }

    public boolean setMapSize(int size) {
        //if inputted size is less than minimum of 5
        if (size < 5) {
            return false;
        } else {
            this.size = size;
            return true;
        }
    }

    public boolean generate() {
        File mapFile = generateHTMLFile();
        if(mapFile == null){
            return false;
        }

        return true;
    }

    private File generateHTMLFile() {
        File mapFile;
        try {
            mapFile = new File("src\\GameMaps\\map" + mapCount + ".html");
            if (mapFile.createNewFile()) {
                System.out.println("File created: " + mapFile.getName());
                mapCount++;
                return mapFile;
            } else {
                System.out.println("File already exists.");
            }
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        return null;
    }
}