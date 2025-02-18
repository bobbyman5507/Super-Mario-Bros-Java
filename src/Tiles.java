import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import java.io.IOException;
import javax.imageio.ImageIO;


//Bug class to define all properties of a game object

/**
 * Depreciated class that holds all images and rendering methods for them
 * @author Bobby Orbin
 * @deprecated
 */
public class Tiles
{
	
	int xPos,yPos;
	private final int width = 32;
	private final int height = 32;
	private final int Size = 32;
	private final int yBuffer = 48;
	
	private BufferedImage coinImg0;
	private BufferedImage coinImg1;
	private BufferedImage coinImg2;

	private BufferedImage questionImg0;
	private BufferedImage questionImg1;
	private BufferedImage questionImg2;
	
	private BufferedImage usedQuestionImg;

	private BufferedImage overworldFloorImg;
	
	private BufferedImage brickImg;
	
	private BufferedImage tileImg;
	
	private BufferedImage pipeImg;
	private BufferedImage pipeBottomImg;
	
	private BufferedImage logoImg;
	private BufferedImage startTextImg;
	







	
	//animation variables
	private int coinAnim = 0;
	private int questionAnim = 0;

	//private global variables
	//current setup - xPos, yPos = center coordinate, shade = color
	//add any other private global variable declarations needed (dimensions, velocities, etc.) 
	
	//GameObjectConstructor constructor
	//current parameters - x,y = center of object, c = color of object
	//add any other needed parameters
	public Tiles()
	{
		//overworld floor creation
		try
		{
			overworldFloorImg = ImageIO.read(getClass().getResourceAsStream("/overworldFloor.png"));
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
		
		//question block frames
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
		
		try
		{
			pipeImg = ImageIO.read(getClass().getResourceAsStream("/pipe.png"));
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
		
		try
		{
			pipeBottomImg = ImageIO.read(getClass().getResourceAsStream("/pipeBottom.png"));
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
		
		try
		{
			logoImg = ImageIO.read(getClass().getResourceAsStream("/logo.png"));
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
		
		try
		{
			startTextImg = ImageIO.read(getClass().getResourceAsStream("/startText.png"));
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
		
		
		
		
		
		
		//save all instance data from parameters
		
		//setup all initial values here
		
	}
	
	//add any methods that are required to control your object within the game
	//this should include movement, collisions, resetting, etc.
	
	
	
	//draw the object
	//***Be sure to call this method in the MainGameClass so you can see the object!***
	public void drawGeneric(Graphics2D g2, Color shade, int tileX, int tileY)
	{
		xPos = (tileX * Size) + -Player.getOffset();
		yPos = tileY * Size + yBuffer;	
		Rectangle tile = new Rectangle(xPos,yPos,width,height);
		g2.setColor(shade);
		g2.fill(tile);
	}
	
	public void tileBlack(Graphics2D g2, int tileX, int tileY)
	{
		xPos = (tileX * Size) + -Player.getOffset();
		yPos = tileY * Size + yBuffer;	
		g2.setColor(Color.black);
		Rectangle brick = new Rectangle(xPos,yPos,width,height);
		g2.fill(brick);
	}
	
	public void tileColor(Graphics2D g2, Color shade, int tileX, int tileY)
	{
		xPos = (tileX * Size) + -Player.getOffset();
		yPos = tileY * Size + yBuffer;	
		Rectangle brick = new Rectangle(xPos,yPos,width,height);
		g2.setColor(shade);
		g2.fill(brick);
	}
	
	public void coin(Graphics2D g2, int tileX, int tileY)
	{
		xPos = (tileX * Size) + -Player.getOffset();
		yPos = tileY * Size + yBuffer;	
		
		if (coinAnim <24)
		{
			coinAnim++;
		}
		else
		{
			coinAnim = 1;
		}
		
		//calculations to see if image has been up for enough frames
		if (coinAnim <=12)
		{
			g2.drawImage(coinImg0, xPos,yPos,width,height, null);
		}
		else if (coinAnim <=16)
		{
			g2.drawImage(coinImg1, xPos,yPos,width,height, null);
		}
		else if (coinAnim <=20)
		{
			g2.drawImage(coinImg2, xPos,yPos,width,height, null);
		}
		else if(coinAnim <=24)
		{
			g2.drawImage(coinImg1, xPos,yPos,width,height, null);
		}		
	}
	
	public void question(Graphics2D g2, int tileX, int tileY)
	{
		xPos = (tileX * Size) + -Player.getOffset();
		yPos = tileY * Size + yBuffer;	
		
		if (questionAnim <24)
		{
			questionAnim++;
		}
		else
		{
			questionAnim = 1;
		}
		
		//calculations to see if image has been up for enough frames
		if (questionAnim <=12)
		{
			g2.drawImage(questionImg0, xPos,yPos,width,height, null);
		}
		else if (questionAnim <=16)
		{
			g2.drawImage(questionImg1, xPos,yPos,width,height, null);
		}
		else if (questionAnim <=20)
		{
			g2.drawImage(questionImg2, xPos,yPos,width,height, null);
		}
		else if(questionAnim <=24)
		{
			g2.drawImage(questionImg1, xPos,yPos,width,height, null);
		}
	}
	
	public void usedQuestion(Graphics2D g2, int tileX, int tileY)
	{
		xPos = (tileX * Size) + -Player.getOffset();
		yPos = tileY * Size + yBuffer;	

		g2.drawImage(usedQuestionImg, xPos,yPos,width,height, null);
	}
	
	public void overworldFloor(Graphics2D g2, int tileX, int tileY)
	{
		xPos = (tileX * Size) + -Player.getOffset();
		yPos = tileY * Size + yBuffer;	
		
		g2.drawImage(overworldFloorImg, xPos,yPos,width,height, null);
	}
	
	public void brick (Graphics2D g2, int tileX, int tileY)
	{
		xPos = (tileX * Size) + -Player.getOffset();
		yPos = tileY * Size + yBuffer;
		
		g2.drawImage(brickImg, xPos,yPos,width,height, null);

	}
	
	public void tile (Graphics2D g2, int tileX, int tileY)
	{
		xPos = (tileX * Size) + -Player.getOffset();
		yPos = tileY * Size + yBuffer;
		
		g2.drawImage(tileImg, xPos,yPos,width,height, null);
	}
	
	public void pipe (Graphics2D g2, int pipeX, int pipeY, int warpNum)
	{
		xPos = (pipeX * Size) + -Player.getOffset();
		yPos = pipeY * Size + yBuffer;
		
		g2.drawImage(pipeImg, xPos,yPos,64,64, null);
		
		//0 - no warp
		//otherwise warp coincides with warpnum
	}
	
	public void pipeBottom (Graphics2D g2, int pipeBottomX, int pipeBottomY)
	{
		xPos = (pipeBottomX * Size) + -Player.getOffset();
		yPos = pipeBottomY * Size + yBuffer;
		
		g2.drawImage(pipeBottomImg, xPos,yPos,64,height, null);
	}
	
	public void logo (Graphics2D g2, int pipeBottomX, int pipeBottomY)
	{
		xPos = (pipeBottomX * Size) + -Player.getOffset();
		yPos = pipeBottomY * Size + yBuffer;
		
		g2.drawImage(logoImg, xPos,yPos,352,190, null);
	}
	
	public void startText (Graphics2D g2, int pipeBottomX, int pipeBottomY)
	{
		xPos = (pipeBottomX * Size) + -Player.getOffset();
		yPos = pipeBottomY * Size + yBuffer;
		
		g2.drawImage(startTextImg, xPos,yPos,210,104, null);
	}





}
