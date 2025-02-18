package Tiles;

import java.awt.*;

/**
 * @author Bobby Orbin
 */
public class SolidTile extends Tile
{
    private final Color color;

    /**
     *
     * @param color         The color of the tile
     * @param xSize         the number of pixels of the tile in the X direction
     * @param ySize         the number of pixels of the tile in the Y direction
     * @param collision     can mario collide with the tile
     * @param interactable  can mario collide with the tile
     */
    public SolidTile(Color color, int xSize, int ySize, boolean collision, boolean interactable)
    {
        super(xSize, ySize, collision, interactable);
        this.color = color;
    }

    /**
     * Tile of a singular color, defined by java.awt.color
     * @param color         The color of the tile
     * @param xSize         the number of pixels of the tile in the X direction
     * @param ySize         the number of pixels of the tile in the Y direction
     * @param collision     can mario collide with the tile
     * @see java.awt.color
     */
    public SolidTile(Color color, int xSize, int ySize, boolean collision)
    {
        super(xSize, ySize, collision);
        this.color = color;
    }

    /**
     * gets the Color
     * @return color
     */
    public Color getColor()
    {
        return color;
    }

    /**
     * Function to draw the colored tile(s) onto the
     * screen at the given position
     *
     * @param g2 Current graphics processor
     * @param tileX the X position of the tile on the grid
     * @param tileY the Y position of the tile on the grid
     */
    @Override
    public void draw(Graphics2D g2, int tileX, int tileY)
    {
        int xPos = (tileX * TILE_SIZE);
        int yPos = (tileY * TILE_SIZE) + Y_BUFFER;

        Rectangle tile = new Rectangle(xPos,yPos, this.getXSize(), this.getYSize());
        g2.setColor(this.color);
        g2.fill(tile);
    }
}
