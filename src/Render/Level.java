package Render;
import Render.Tiles.AnimatedTile;
import Render.Tiles.ImageTile;
import Render.Tiles.Tile;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;

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
                {

                }
            }


        }
    }
    public class PaletteData
    {
        //key:
        //1 - test 1
        //2 - test 2
        //3 - overworld floor
        //4 - coin
        //5 - question block // coin
        //6 - question block // power-up
        //7 - question block // star
        //8 - question block // spent
        //9 - brick
        //10 - blank
        //11 - tile
        //12 - aesthetic Pipe
        //13 - functioning Pipe (Warp 1)
        //14 - functioning Pipe (Warp 2)
        //15 - functioning Pipe (warp 3)
        //16 - functioning Pipe (warp 4)
        //17 - functioning Pipe (warp 5)
        //18 - Pipe Top Right Collision
        //19 - Pipe Bottom aesthetic (left collision)
        //20 - Pipe Bottom right collision
        //100 - Logo
        //101 - title text

        // 					To Be Added
        //21 - flag pole peak
        //22 - flag pole
        //23 - flag pole base
        //24 - castle
        private BufferedImage coinImg0;
        private BufferedImage coinImg1;
        private BufferedImage coinImg2;

        private BufferedImage questionImg0;
        private BufferedImage questionImg1;
        private BufferedImage questionImg2;

        private BufferedImage usedQuestionImg;

        private BufferedImage floor;

        private BufferedImage brickImg;

        private BufferedImage tileImg;


        /**
         * loads the images for and gets the overwold color palette
         * @return The color palette
         */
        public HashMap<Integer, Tile> getOverworld()
        {
            HashMap<Integer, Tile> overworld = new HashMap<>();

            //overworld floor creation
            try
            {
                floor = ImageIO.read(getClass().getResourceAsStream("/overworldFloor.png"));
            }
            catch(IOException e)
            {
                e.printStackTrace();
            }
            overworld.put(3, new ImageTile(floor, 2, 32, true));


            //coin block frames
            try
            {
                coinImg0 = ImageIO.read(getClass().getResourceAsStream("/coin_0.png"));
            }
            catch(IOException e)
            {
                e.printStackTrace();
            }

            try
            {
                coinImg1 = ImageIO.read(getClass().getResourceAsStream("/coin_1.png"));
            }
            catch(IOException e)
            {
                e.printStackTrace();
            }

            try
            {
                coinImg2 = ImageIO.read(getClass().getResourceAsStream("/coin_2.png"));
            }
            catch(IOException e)
            {
                e.printStackTrace();
            }
            overworld.put(4, new AnimatedTile(coinImg0,coinImg1,coinImg2, 2, 32, true));



            //question block frames
            try
            {
                questionImg0 = ImageIO.read(getClass().getResourceAsStream("/question_0.png"));
            }
            catch(IOException e)
            {
                e.printStackTrace();
            }

            try
            {
                questionImg1 = ImageIO.read(getClass().getResourceAsStream("/question_1.png"));
            }
            catch(IOException e)
            {
                e.printStackTrace();
            }

            try
            {
                questionImg2 = ImageIO.read(getClass().getResourceAsStream("/question_2.png"));
            }
            catch(IOException e)
            {
                e.printStackTrace();
            }

            //used question
            try
            {
                usedQuestionImg = ImageIO.read(getClass().getResourceAsStream("/usedQuestion.png"));
            }
            catch(IOException e)
            {
                e.printStackTrace();
            }

            try
            {
                brickImg = ImageIO.read(getClass().getResourceAsStream("/brick.png"));
            }
            catch(IOException e)
            {
                e.printStackTrace();
            }

            try
            {
                tileImg = ImageIO.read(getClass().getResourceAsStream("/tile.png"));
            }
            catch(IOException e)
            {
                e.printStackTrace();
            }


            return overworld;
        }
    }
}