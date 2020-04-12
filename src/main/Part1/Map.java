package Part1;

import java.io.*;
import java.util.Scanner;

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

        boolean success = true;
        success = generateInitMap(mapFile);

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

    private boolean generateInitMap(File mapFile) {
        return true;
    }

    public String getHTMLFileContent(File file){
        //read contents of file
        Scanner sc = null;
        String contents = "";

        try {
            sc = new Scanner(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        while (sc.hasNextLine()) {
            contents = contents.concat(sc.nextLine());
        }

        sc.close();

        return contents;
    }
}