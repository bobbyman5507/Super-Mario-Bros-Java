package Tiles;

import java.awt.*;


/**
 * Abstract tile class for implementing new
 * types of tiles for rendering
 *
 * @author Bobby Orbin
 */
public abstract class Tile
{
    //Constants
    public static final int TILE_SIZE = 32;
    public static final int Y_BUFFER = 48;


    final private int xSize;
    final private int ySize;
    final private boolean collision;


    /**
     * Abstract tile class for implementation
     * @param xSize the number of pixels of the tile in the X direction
     * @param ySize the number of pixels of the tile in the Y direction
     * @param collision can mario collide with the tile
     */
    public Tile(int xSize, int ySize, boolean collision)
    {
        this.xSize = xSize;
        this.ySize = ySize;
        this.collision = collision;
    }

    public int getXSize()
    {
        return this.xSize;
    }

    public int getYSize()
    {
        return this.ySize;
    }

    public abstract void draw(Graphics2D g2, int tileX, int tileY);
}
