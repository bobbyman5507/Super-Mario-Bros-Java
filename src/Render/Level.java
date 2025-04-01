package Render;
import Render.Tiles.AnimatedTile;
import Render.Tiles.ImageTile;
import Render.Tiles.Tile;

import javax.imageio.ImageIO;
import java.awt.*;
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
    private final HashMap<Integer, Tile> colorPalette;
    private final Tile[][] level;

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

        //palette config
        PaletteData currPalette = new PaletteData();
        int paletteNum = Integer.parseInt(splitLine.get(3));

        if (paletteNum == 1)
        {
            this.colorPalette = currPalette.getOverworld();
        }
        else
        {
            this.colorPalette = currPalette.getOverworld();
        }



        //loading level data lines into array
        level = new Tile[maxLength][16];
        char detChar;
        String[] segmentSplit;

        for(int i = 1; i<16; i++)
        {
            int currPos = 0;

            //getting next line
            currLine = in.nextLine();
            splitLine = (ArrayList<String>) Arrays.asList(currLine.split("!"));

            //loop to get to end
            for (String segment: splitLine)
            {
                detChar = segment.charAt(0);

                //concatenating and splitting the string up
                segmentSplit = segment.substring(1).split(",");

                if(detChar == '#')
                {
                    if(!segmentSplit[0].equals("0"))
                    {
                        level[currPos][i] = colorPalette.get(Integer.parseInt(segmentSplit[0]));
                        currPos++;
                    }
                }
                else
                {
                    if(!segmentSplit[0].equals("0"))
                    {
                        for(int j = 0; j<Integer.parseInt(segmentSplit[0]); j++)
                        {
                            level[currPos][i] = colorPalette.get(Integer.parseInt(segmentSplit[1]));
                            currPos++;
                        }
                    }
                    else
                    {
                        currPos += Integer.parseInt(segmentSplit[1]);

                    }
                }
            }
        }
    }

    public boolean isSolid(int x, int y)
    {
        Tile currTile = level[x][y];

        if(currTile == null)
            return false;
        else
        {
            return currTile.getCollision();
        }
    }

    /**
     * gets the 2d array of tiles which represents the level
     * @return the level array
     */
    public Tile[][] getLevel()
    {
        return level;
    }

    public void draw(Graphics2D g2, int offset)
    {
        for(int y = 0; y<=16; y++)
        {
            for(int x = 0; x<=maxLength; x++)
            {
                if(level[x][y] != null)
                {
                    level[x][y].draw(g2, x, y, offset);
                }
            }
        }

    }


    public static class PaletteData
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
            overworld.put(3, new ImageTile(floor, 1, 1, true));


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
            overworld.put(5, new AnimatedTile(coinImg0,coinImg1,coinImg2, 1, 1, true));



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
            overworld.put(4, new AnimatedTile(questionImg0,questionImg1,questionImg2, 1, 1, true));

            //used question
            try
            {
                usedQuestionImg = ImageIO.read(getClass().getResourceAsStream("/usedQuestion.png"));
            }
            catch(IOException e)
            {
                e.printStackTrace();
            }
            overworld.put(8, new ImageTile(usedQuestionImg, 1, 1, true));


            try
            {
                brickImg = ImageIO.read(getClass().getResourceAsStream("/brick.png"));
            }
            catch(IOException e)
            {
                e.printStackTrace();
            }
            overworld.put(9, new ImageTile(brickImg, 1, 1, true));


            try
            {
                tileImg = ImageIO.read(getClass().getResourceAsStream("/tile.png"));
            }
            catch(IOException e)
            {
                e.printStackTrace();
            }
            overworld.put(11, new ImageTile(tileImg, 1, 1, true));


            return overworld;
        }
    }
}