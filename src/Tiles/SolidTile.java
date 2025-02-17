package Tiles;

import java.awt.*;
import java.awt.image.BufferedImage;

public class SolidTile extends Tile
{
    private final Color color;

    public SolidTile(int xSize, int ySize, BufferedImage mainImg, Color color)
    {
        super(xSize, ySize, mainImg);
        this.color = color;
    }

    public Color getColor()
    {
        return color;
    }
}
