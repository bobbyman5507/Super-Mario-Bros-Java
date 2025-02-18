package Tiles;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Iterator;
import java.util.LinkedList;

/**
 * @author Bobby Orbin
 */
public class AnimatedTile extends Tile
{
    private static final int FRAME_DIFF = 4;
    private static final int NUM_FRAMES = 4;

    private final Iterator<BufferedImage> animation;
    private int frameCount = 0;
    private BufferedImage currentFrame;

    /**
     * Tile that displays an animated image at the location
     *
     * @param img1          The first image for the tile
     * @param img2          The second image for the tile
     * @param img3          The third image for the tile
     * @param img4          The fourth image for the tile
     * @param xSize         the number of pixels of the tile in the X direction
     * @param ySize         the number of pixels of the tile in the Y direction
     * @param collision     can mario collide with the tile
     * @param interactable  If the tile can be interacted with by mario
     */
    public AnimatedTile(BufferedImage img1, BufferedImage img2, BufferedImage img3, BufferedImage img4,
                        int xSize, int ySize, boolean collision, boolean interactable)
    {
        super(xSize, ySize, collision, interactable);

        //setting up image iterator
        LinkedList<BufferedImage> frames = new LinkedList<>();

        frames.add(img1);
        frames.add(img2);
        frames.add(img3);
        frames.add(img4);

        this.animation = frames.iterator();

        this.currentFrame = img1;
    }

    /**
     * Tile that displays an animated image at the location
     *
     * @param img1          The first image for the tile
     * @param img2          The second image for the tile
     * @param img3          The third image for the tile
     * @param img4          The fourth image for the tile
     * @param xSize         the number of pixels of the tile in the X direction
     * @param ySize         the number of pixels of the tile in the Y direction
     * @param collision     can mario collide with the tile
     */
    public AnimatedTile(BufferedImage img1, BufferedImage img2, BufferedImage img3, BufferedImage img4,
                        int xSize, int ySize, boolean collision)
    {
        super(xSize, ySize, collision);

        //setting up image iterator
        LinkedList<BufferedImage> frames = new LinkedList<>();

        frames.add(img1);
        frames.add(img2);
        frames.add(img3);
        frames.add(img4);

        this.animation = frames.iterator();

        this.currentFrame = img1;
    }

    /**
     * Goes to the next frame of animation for the tile
     */
    private void addFrame()
    {
        if(frameCount < FRAME_DIFF*NUM_FRAMES)
            frameCount ++;
        else
            frameCount = 1;

        if(frameCount/FRAME_DIFF == 1)
            currentFrame = animation.next();
    }

    /**
     * Function to draw the Animated tile(s) onto the
     * screen at the given position
     *
     * @param g2 Current graphics processor
     * @param tileX the X position of the tile on the grid
     * @param tileY the Y position of the tile on the grid
     */
    @Override
    public void draw(Graphics2D g2, int tileX, int tileY)
    {
        addFrame();

        int xPos = (tileX * TILE_SIZE);
        int yPos = (tileY * TILE_SIZE) + Y_BUFFER;

        g2.drawImage(this.currentFrame, xPos, yPos, this.getXSize(), this.getYSize(), null);
    }
}
