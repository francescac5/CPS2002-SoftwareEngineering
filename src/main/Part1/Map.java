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

        //returns true if successful generation of initial map
        return generateInitMap(mapFile);
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
        FileWriter fWriter;
        BufferedWriter writer;
        try {
            fWriter = new FileWriter(mapFile);
            writer = new BufferedWriter(fWriter);
            writer.write("<html>" +
                    "<body>" +
                    "<table border ='1'>" +
                    "<thead>" +
                    "<tr>" +
                    "<th colspan=\"" + size + "\">Player " + mapCount + "</th>" +
                    "</tr>" +
                    "<tbody>");

            //inputting grid according to map size
            for (int i = 0; i < size; i++) {
                writer.write("<tr>");
                for (int j = 0; j < size; j++) {
                    writer.write("<td height=\"50\" width=\"50\" style=\"background-color:grey;\"></td>");
                }
                writer.write("</tr>");
            }

            writer.write("</tbody>" +
                    "</thead>" +
                    "</table>");
            writer.newLine();
            writer.close();
            return true;
        }
        catch (Exception e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
            return false;
        }
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