package Part1;

import java.io.*;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Map {

    enum Tiles{
        GRASS,
        WATER,
        TREASURE //1 tile
    }

    private int size = -1;
    private static int mapCount;
    private Tiles tiles[][];
    private boolean tilesGenerated = false;

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

    //used for testing purposes only to ensure setMapSize is implemented correctly
    public int getMapSize() {
        return size;
    }

    public boolean generate() {
        //single set of tiles
        if(!tilesGenerated){
            generateTiles();
            tilesGenerated = true;
        }

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

    //used for testing purposes to compare file content
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

    private void generateTiles() {
        int amountTiles = size*size;
        int tileCount = 1;

        //generate grass tiles
        ArrayList<Integer> grass = generateGrassTiles(amountTiles);

        //generate treasure tile
        int treasure = generateTreasureTile(amountTiles, grass);

        //generate water tiles
        ArrayList<Integer> water = generateWaterTiles(amountTiles, grass, treasure);

        tiles = new Tiles[size][size];
        for (int y = 0; y < size; y++) {
            for (int x = 0; x < size; x++) {
                if(tileCount == treasure){
                    tiles[x][y] = Tiles.TREASURE;
                }
                else if(grass.contains(tileCount)){
                    tiles[x][y] = Tiles.GRASS;
                }
                else if(water.contains(tileCount)){
                    tiles[x][y] = Tiles.WATER;
                }
                tileCount++;

                //to display map tile types
                //System.out.print(tiles[x][y]+"\t");
            }
            //System.out.println();
        }
    }

    private ArrayList<Integer> generateGrassTiles(int amountTiles) {
        ArrayList<Integer> grassTiles = new ArrayList<Integer>();
        Random r = new Random();
        int randNum;
        int amountGrass = (int)Math.ceil(0.85*amountTiles);

        randNum = r.nextInt(amountGrass) + 1;
        grassTiles.add(randNum);

        for (int i = 1; i < amountGrass; i++) {
            do{
                randNum = r.nextInt(amountTiles) + 1;
            }while(grassTiles.contains(randNum));
            grassTiles.add(randNum);
        }
        return grassTiles;
    }

    private int generateTreasureTile(int amountTiles, ArrayList<Integer> grass) {
        //set treasure tile to a tile which is not a grass tile
        Random r = new Random();
        int treasure;
        do{
            treasure = r.nextInt(amountTiles) + 1;
        }while(grass.contains(treasure));
        return treasure;
    }

    private ArrayList<Integer> generateWaterTiles(int amountTiles, ArrayList<Integer> grass, int treasure) {
        ArrayList<Integer> waterTiles = new ArrayList<Integer>();

        for (int i = 1; i < amountTiles+1; i++) {
            if(!grass.contains(i) && i != treasure){
                waterTiles.add(i);
            }
        }
        return waterTiles;
    }

    //used for testing purpose only to ensure correct amount of tile types are generated
    public int[] getTileTypeAmounts() {
        int tileTypeAmounts[] = new int[4];

        int grass = 0, water = 0, treasure = 0, tileCount = 0;
        for (int i = 0; i < tiles.length; i++) {
            for (int j = 0; j < tiles.length; j++) {
                if(tiles[j][i] == Map.Tiles.GRASS){
                    grass++;
                }
                else if(tiles[j][i] == Map.Tiles.WATER){
                    water++;
                }
                else if(tiles[j][i] == Map.Tiles.TREASURE){
                    treasure++;
                }
                tileCount++;
            }
        }
        tileTypeAmounts[0] = grass;
        tileTypeAmounts[1] = water;
        tileTypeAmounts[2] = treasure;
        tileTypeAmounts[3] = tileCount;

        return tileTypeAmounts;
    }
}