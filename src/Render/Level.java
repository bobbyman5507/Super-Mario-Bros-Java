package Render;
import Render.Tiles.Tile;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

/**
 * @author Bobby Orbin
 */
public class Level
{
    private final String levelName;
    private final HashMap<Integer, Tile> ColorPalette;

    public Level(String filename) throws FileNotFoundException
    {
        Scanner in = new Scanner(new File(filename));

        /*
        Level file format:
        Line 1:
        <Level Name>$<Color Palette>

        Lines 2-16: level data from time row(0) to bottom (14)
        formatting:
        ! - Separator
        #<ID># - Single tile
        %<ID>,<Length>%
        */
        String currLine;
        ArrayList<String> splitLine = new ArrayList<>();

        //loading line into string
        currLine = in.nextLine();
        splitLine = (ArrayList<String>) Arrays.asList(currLine.split("$"));

        this.levelName = splitLine.getFirst();

        //loading line into array

        for(int i = 1; i<16; i++)
        {

        }
    }
}
