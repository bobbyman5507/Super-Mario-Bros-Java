import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.geom.Ellipse2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import java.awt.Graphics2D;

import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;


//Bug class to define all properties of a game object

public class Player
{
	//private global variables
	//current setup - xPos, yPos = center coordinate, shade = color
	//add any other private global variable declarations needed (dimensions, velocities, etc.) 
	private int xPos, yPos;
	private static int Offset = 0;
	private int speed;
	
	private int jumpTime;
	private boolean ableToJump;
	private static boolean isJumping;
	
	int tileData;

	//player data
	private static int coin;
	private static int score;
	private static int life;
	private static boolean isWalking;
	private static boolean isStarman;
	private static int power;	
	//0 - little mario 
	//1 - big mario
	//2 - fire mario
	
	//mario images
	private int marioWalk;
		//big Mario
	private BufferedImage bigMario_jumpIMG;
	private BufferedImage bigMario_standIMG;
	private BufferedImage bigMario_walk_0IMG;
	private BufferedImage bigMario_walk_1IMG;
	private BufferedImage bigMario_walk_2IMG;
	

	
	//universal values
	private final int jumpHeight = 17;
	
	//GameObjectConstructor constructor
	//current parameters - x,y = center of object, c = color of object
	//add any other needed parameters
	public Player()
	{
		//save all instance data from parameters
		Offset = 0;
		
		speed = 5;
		xPos = 96;
		yPos = 300;
		jumpTime = 0;
		
		coin = 0;
		score = 0;
		life = 3;
		power = 0;
		isStarman = false;
		
		marioWalk = 0;
		//mario images
		try
		{
			bigMario_jumpIMG = ImageIO.read(getClass().getResourceAsStream("/bigMario_jump.png"));
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
		
		try
		{
			bigMario_standIMG = ImageIO.read(getClass().getResourceAsStream("/bigMario_stand.png"));
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
		
		try
		{
			bigMario_walk_0IMG = ImageIO.read(getClass().getResourceAsStream("/bigMario_walk_0.png"));
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
		
		try
		{
			bigMario_walk_1IMG = ImageIO.read(getClass().getResourceAsStream("/bigMario_walk_1.png"));
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
		
		try
		{
			bigMario_walk_2IMG = ImageIO.read(getClass().getResourceAsStream("/bigMario_walk_2.png"));
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
		
		
	}
	
	//add any methods that are required to control your object within the game
	//this should include movement, collisions, resetting, etc.
	
	
	
	//draw the object
	//***Be sure to call this method in the MainGameClass so you can see the object!***
	public void draw(Graphics2D g2)
	{		
		if (MainGameClass.getGamestate() != 1)
			{
			if (isJumping || !ableToJump)
			{
				g2.drawImage(bigMario_jumpIMG, xPos,yPos,32,64, null);
			}
			else if (!MainGameClass.isMoving())
			{
				g2.drawImage(bigMario_standIMG, xPos,yPos,32,64, null);
			}
			else if (MainGameClass.isMoving() && MainGameClass.getGamestate() == 2)
			{
				if (speed == 5)
				{
					if (marioWalk <7)
					{
						marioWalk++;
					}
					else
					{
						marioWalk = 1;
					}
					//calculations to see if image has been up for enough frames
					if (marioWalk <=3)
					{
						g2.drawImage(bigMario_walk_0IMG, xPos,yPos,32,64, null);
					}
					else if (marioWalk <=5)
					{
						g2.drawImage(bigMario_walk_1IMG, xPos,yPos,32,64, null);
					}
					else if (marioWalk <=8)
					{
						g2.drawImage(bigMario_walk_2IMG, xPos,yPos,32,64, null);
					}
				}
				else
				{
					if (marioWalk <6)
					{
						marioWalk++;
					}
					else
					{
						marioWalk = 1;
					}
					
					
					//calculations to see if image has been up for enough frames
					if (marioWalk <=2)
					{
						g2.drawImage(bigMario_walk_0IMG, xPos,yPos,32,64, null);
					}
					else if (marioWalk <=4)
					{
						g2.drawImage(bigMario_walk_1IMG, xPos,yPos,32,64, null);
					}
					else if (marioWalk <=6)
					{
						g2.drawImage(bigMario_walk_2IMG, xPos,yPos,32,64, null);
					}
				}
			}
			else
			{
				g2.drawImage(bigMario_standIMG, xPos,yPos,32,64, null);
			}
			}
		
	
		//build the object with reference to all global variables (position, dimensions, colors)
	}
	
	public void goRight()
	{
		if (!checkRight() && MainGameClass.getGamestate() == 2)
		{
			Offset +=speed;
		}
	}
	
	public void goLeft()
	{
		if(!checkLeft() && MainGameClass.getGamestate() == 2)
		{
			Offset -=speed;
		}
	}
	
	public static int getOffset()
	{
		return Offset;
	}
	
	public void jump()
	{
		if (MainGameClass.getGamestate() == 2)
		{
			//full height jump
			if (jumpTime <= jumpHeight && !isJumping && ableToJump)
				{
				jumpTime++;
				yPos -= 7;
				ableToJump = false;
				isJumping = true;
			}
			else if (isJumping && jumpTime <= jumpHeight)
			{
				jumpTime++;
				yPos -= 7;
			}
			else if(jumpTime >= jumpHeight)
			{
				ableToJump = false;
				isJumping = false;
			}
		}
	}
	
	public void stoppedJumping()
	{
		isJumping = false;
		jumpTime = 0;
		ableToJump = false;
	}
	
	public void physics()
	{	
		if (MainGameClass.getGamestate() != 1)
		{
			checkAbove();
			
			
			if (Background.checkTile((Offset/32)+3, (yPos+20)/32) == false && !isJumping)
			{
				yPos += 10;
				ableToJump = false;
			}
			else
				ableToJump = true;
			
			//specific collisions
			checkCollisionData((Offset/32)+3, (yPos+20)/32, 3);
			
			if(yPos >= 464)
			{
				Die(false);
			}
		}
	}
	
	private boolean checkRight()
	{
		//specific collisions
		checkCollisionData(((Offset+1)/32)+4, yPos/32, 0);
		checkCollisionData(((Offset+1)/32)+4, (yPos/32)-1, 0);
		
		//regular collisions
		if(Background.checkTile(((Offset+1)/32)+4, yPos/32))
		{
			return true;
		}
		else if(Background.checkTile((Offset/32)+4, (yPos/32)-1))
		{
			return true;
		}
		else 
			return false;
	}
	
	private boolean checkLeft()
	{
		//specific collisions
		checkCollisionData(((Offset+94)/32), yPos/32, 1);
		checkCollisionData(((Offset+94)/32), (yPos/32)-1, 1);
		
		//regular collisions
		if(Background.checkTile(((Offset+94)/32), yPos/32))
		{
			return true;
		}
		else if(Background.checkTile((Offset+94/32), (yPos/32)-1))
		{
			return true;
		}
		else 
		{
			return false;
		}
	}
	
	private void checkAbove()
	{
		//specific collisions
		checkCollisionData((Offset/32)+3, (yPos-40)/32, 2);
		
		//regular collisions
		if (Background.checkTile((Offset/32)+3, (yPos-40)/32) == true)
		{
			stoppedJumping();
		}
	}
	
	//to check for collision specialties, with an option for sides; 0 = left, 1 = right, 2 = top, 3 = bottom
	private void checkCollisionData(int xTile, int yTile, int Side)
	{
		tileData = Background.getTile(xTile, yTile);
		
		if (tileData == 5 && Side == 2 && isJumping)
		{
			//question block
			Background.setTile(xTile, yTile, 8);
			coin++;
		}
		else if (tileData == 4)
		{
			//coin
			Background.setTile(xTile, yTile, 10);
			coin++;
		}
		else if (tileData == 9 && Side == 2 && isJumping)
		{
			//brick
			Background.setTile(xTile, yTile, 10);
			stoppedJumping();
		}
		
		
		
		//set to 0, no specific side
		//if (tileData == )
		
		
	}
	
	public void Die(boolean deathType)
	{
		System.out.println("died");
		//if deathType == true, then do the jump, otherwise, don't
		if (deathType)
		{
			
		}
		
		life --;
		Reset();
		MainGameClass.ResetfirstTimeRunning();
		MainGameClass.setGameState(1);
		
	}
	
	public void Reset()
	{
		Offset = 0;
		
		speed = 5;
		xPos = 96;
		yPos = 300;
		jumpTime = 0;
		
		coin = 0;
		score = 0;
		life = 0;
		power = 0;
		isStarman = false;
	}
	
	public void Run()
	{
		speed = 8;
	}
	
	public void Walk()
	{
		speed = 5;
	}
	
	public static int getCoin()
	{
		return coin;
	}
	
	public static int getScore()
	{
		return score;
	}
	
	public static int getLife()
	{
		return life;
	}
	
	public void resetWalk()
	{
		marioWalk = 0;
	}


}
