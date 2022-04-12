/**
 * UC Berkeley CS 61B Spring 2018
 * https://sp18.datastructur.es/materials/lab/lab5/lab5
 * Lab 5: Getting Started on Project 2
 * Draws a world consisting of 19 random hexagonal regions, with size specified for each hexagon
 */

package byog.lab5;

import byog.TileEngine.TERenderer;
import byog.TileEngine.TETile;
import byog.TileEngine.Tileset;

import java.util.Random;


public class HexWorld {
    /**
     * Coordinates that specify the lower left corner of the hexagon
     */
    private static class Position {
        private int x;
        private int y;

        public Position (int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    private static final int WIDTH = 50;
    private static final int HEIGHT = 50;
    private static final int XPOS = 20; // the x coordinate of the lower left corner of the lowest hexagon
    private static final int YPOS = 5; // the y coordinate of the lower left corner of the lowest hexagon
    private static final int SIZE = 3; // the size of each hexagon

    private static final long SEED = 2873123;
    private static final Random RANDOM = new Random(SEED);

    /**
     * Picks a RANDOM tile with a 20% chance of being
     * a tree, grass, flower, mountain and sand
     */
    private static TETile randomTile() {
        int tileNum = RANDOM.nextInt(5);
        switch (tileNum) {
            case 0: return Tileset.TREE;
            case 1: return Tileset.GRASS;
            case 2: return Tileset.FLOWER;
            case 3: return Tileset.MOUNTAIN;
            case 4: return Tileset.SAND;
            default: return Tileset.NOTHING;
        }
    }

    /**
     * Adds a hexagon to the world
     * @param world the world to draw on
     * @param tile the tile to draw
     * @param pos the bottom left coordinates of the hexagon
     * @param size the size of the hexagon
     */
    public static void addHexagon(TETile[][] world, TETile tile, Position pos, int size) {
        int xPos = pos.x;
        int yPos = pos.y;

        if (size < 2) {
            throw new IllegalArgumentException("Hexagon must be at least size 2.");
        }

        if (xPos < 0 || yPos < 0) {
            throw new IllegalArgumentException("x and y coordinates must be non-negative.");
        }

        if (xPos - size + 1 < 0 || xPos + 2 * size - 2 >= WIDTH || yPos + 2 * size - 1 >= HEIGHT) {
            throw new IllegalArgumentException("Hexagon too large to be placed into the world.");
        }

        // Draws the lower half of the hexagon
        for (int i = 0; i < size; i++) {
            int num = size + 2 * i;
            int xCurr = xPos;
            for (int j = 0; j < num; j++) {
                world[xCurr][yPos] = tile;
                xCurr++;
            }
            xPos--;
            yPos++;
        }

        xPos++;

        // Draws the upper half of the hexagon
        for (int i = 0; i < size; i++) {
            int num = 3 * size - 2 * i - 2;
            int xCurr = xPos;
            for (int j = 0; j < num; j++) {
                world[xCurr][yPos] = tile;
                xCurr++;
            }
            xPos++;
            yPos++;
        }
    }

    /**
     * Compute the bottom left coordinates of the 19 hexagons, and stores them in an array
     * @param xPos the x coordinate of the lower left corner of the lowest hexagon
     * @param yPos the y coordinate of the lower left corner of the lowest hexagon
     * @param size the size of each hexagon
     * @return
     */
    public static Position[] positionCalculator(int xPos, int yPos, int size) {
        Position[] posArray = new Position[19];

        // Coordinates of the 5 hexagons in the middle
        int x = xPos;
        int y = yPos;
        for (int i = 0; i < 5; i++) {
            posArray[i] = new Position(x, y);
            y += 2 * size;
        }

        // Coordinates of the 4 hexagons, second from the left
        x = xPos - (2 * size - 1);
        y = yPos + size;
        for (int i = 5; i < 9; i++) {
            posArray[i] = new Position(x, y);
            y += 2 * size;
        }

        // Coordinates of the 3 leftmost hexagons
        x = xPos + (2 * size - 1);
        y = yPos + size;
        for (int i = 9; i < 13; i++) {
            posArray[i] = new Position(x, y);
            y += 2 * size;
        }

        // Coordinates of the 4 hexagons, second from the right
        x = xPos - 2 * (2 * size - 1);
        y = yPos + 2 * size;
        for (int i = 13; i < 16; i++) {
            posArray[i] = new Position(x, y);
            y += 2 * size;
        }

        // Coordinates of the 3 rightmost hexagons
        x = xPos + 2 * (2 * size - 1);
        y = yPos + 2 * size;
        for (int i = 16; i < 19; i++) {
            posArray[i] = new Position(x, y);
            y += 2 * size;
        }

        return posArray;
    }

    public static void main(String[] args) {
        // initialize the tile rendering engine with a window of size WIDTH x HEIGHT
        TERenderer ter = new TERenderer();
        ter.initialize(WIDTH, HEIGHT);

        // initialize tiles
        TETile[][] world = new TETile[WIDTH][HEIGHT];
        for (int x = 0; x < WIDTH; x += 1) {
            for (int y = 0; y < HEIGHT; y += 1) {
                world[x][y] = Tileset.NOTHING;
            }
        }

        // fills the world with 19 RANDOM tiles
        Position[] pos = positionCalculator(XPOS, YPOS, SIZE);
        for (Position p : pos) {
            addHexagon(world, randomTile(), p, SIZE);
        }

        ter.renderFrame(world);
    }
}
