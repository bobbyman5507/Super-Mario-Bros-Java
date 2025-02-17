package Tiles;

import java.awt.image.BufferedImage;



public abstract class Tile
{
    final private int xSize;
    final private int ySize;
    final private BufferedImage mainImg;

    public Tile(int xSize, int ySize, BufferedImage mainImg)
    {
        this.xSize = xSize;
        this.ySize = ySize;
        this.mainImg = mainImg;
    }

    public int getXSize()
    {
        return this.xSize;
    }

    public int getYSize()
    {
        return this.ySize;
    }

    public BufferedImage getMainImg()
    {
        return this.mainImg;
    }
}
