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
    private final int maxLength;
    private final int sublevel;
    private final HashMap<Integer, Tile> ColorPalette;
    private final int[][] level;

    public Level(String filename) throws FileNotFoundException
    {
        Scanner in = new Scanner(new File(filename));

        /*
        Level file format:
        Line 1:
        <Level Name>$<sublevel>$<maxLength>$<Color Palette>

        Lines 2-16: level data from time row(0) to bottom (14)
        formatting:
        ! - Separator
        #<ID> - Single tile
        %<ID>,<Length>
        */
        String currLine;
        ArrayList<String> splitLine = new ArrayList<>();

        //loading line into string
        currLine = in.nextLine();
        splitLine = (ArrayList<String>) Arrays.asList(currLine.split("$"));

        this.levelName = splitLine.getFirst();
        this.sublevel = Integer.parseInt(splitLine.get(1));
        this.maxLength = Integer.parseInt(splitLine.get(2));



        //loading line into array

        int currPos = 0;
        char detChar;

        for(int i = 1; i<16; i++)
        {
            //getting next line
            currLine = in.nextLine();
            splitLine = (ArrayList<String>) Arrays.asList(currLine.split("!"));

            //loop to get to end
            for (int j = 0; i < splitLine.size(); i++)
            {
                detChar = splitLine.get(i).charAt(0);

                if(detChar == '#')
            }


        }
    }
}
