package Render.Tiles;

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
    final private boolean interactable;


    /**
     * Abstract tile class constructor for implementation
     * @param xSize         the number of pixels of the tile in the X direction
     * @param ySize         the number of pixels of the tile in the Y direction
     * @param collision     can mario collide with the tile
     * @param interactable  can mario collide with the tile
     */
    public Tile(int xSize, int ySize, boolean collision, boolean interactable)
    {
        this.xSize = xSize;
        this.ySize = ySize;
        this.collision = collision;
        this.interactable = interactable;
    }

    /**
     * Abstract tile class constructor for implementation
     * @param xSize the number of pixels of the tile in the X direction
     * @param ySize the number of pixels of the tile in the Y direction
     * @param collision can mario collide with the tile
     */
    public Tile(int xSize, int ySize, boolean collision)
    {
        this.xSize = xSize;
        this.ySize = ySize;
        this.collision = collision;
        this.interactable = false;
    }

    /**
     * gets x size
     * @return X size
     */
    public int getXSize()
    {
        return this.xSize;
    }

    /**
     * gets y size
     * @return y size
     */
    public int getYSize()
    {
        return this.ySize;
    }

    /**
     * gets the current tile's collision value and if it can be colided
     * @return Colission value
     */
    public boolean getCollision()
    {
        return collision;
    }

    /**
     * Function to draw the colored tile(s) onto the
     * screen at the given position
     *
     * @param g2 Current graphics processor
     * @param tileX the X position of the tile on the grid
     * @param tileY the Y position of the tile on the grid
     * @param offset    The distance that mario has traveled since starting
     */
    public abstract void draw(Graphics2D g2, int tileX, int tileY, int offset);
}
