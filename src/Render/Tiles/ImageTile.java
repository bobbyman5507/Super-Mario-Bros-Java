package Render.Tiles;

import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * @author Bobby Orbin
 */
public class ImageTile extends Tile
{
    final private BufferedImage mainImg;

    /**
     * Tile that displays an image at the location
     * @param mainImg       The image for the tile
     * @param xSize         the number of pixels of the tile in the X direction
     * @param ySize         the number of pixels of the tile in the Y direction
     * @param collision     can mario collide with the tile
     * @param interactable  can mario collide with the tile
     */
    public ImageTile(BufferedImage mainImg, int xSize, int ySize, boolean collision, boolean interactable)
    {
        super(xSize,ySize,collision, interactable);
        this.mainImg = mainImg;
    }

    /**
     * Tile that displays an image at the location
     * @param mainImg The image for the tile
     * @param xSize the number of pixels of the tile in the X direction
     * @param ySize the number of pixels of the tile in the Y direction
     * @param collision can mario collide with the tile
     */
    public ImageTile(BufferedImage mainImg, int xSize, int ySize, boolean collision)
    {
        super(xSize,ySize,collision);
        this.mainImg = mainImg;
    }

    /**
     * gets Main Image
     * @return returns main image
     */
    public BufferedImage getMainImg()
    {
        return this.mainImg;
    }

    /**
     * Function to draw the Image tile(s) onto the
     * screen at the given position
     *
     * @param g2 Current graphics processor
     * @param tileX the X position of the tile on the grid
     * @param tileY the Y position of the tile on the grid
     * @param offset    The distance that mario has traveled since starting
     */
    @Override
    public void draw(Graphics2D g2, int tileX, int tileY, int offset)
    {
        int xPos = (tileX * TILE_SIZE) - offset;
        int yPos = ((tileY * TILE_SIZE) + Y_BUFFER);

        g2.drawImage(this.mainImg, xPos, yPos, this.getXSize(), this.getYSize(), null);
    }
}
