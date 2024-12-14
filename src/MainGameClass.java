import java.awt.Color;
import java.awt.Font;
import java.awt.FontFormatException;
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
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import java.awt.Graphics2D;

import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;


public class MainGameClass extends JPanel implements Runnable, KeyListener, MouseListener, MouseMotionListener
{
	//**********************************************
	//private global variables
	private Image image;
	
	private Background background;
	private static int gameState;
	private Player Mario;	
	
	//Font
	Font UI;
	
	//input booleans
	private boolean spaceBool;
	private static boolean dBool;
	private static boolean aBool;
	private boolean shiftBool;
	
	//UI Animation
	private BufferedImage smallCoinImg0;
	private BufferedImage smallCoinImg1;
	private BufferedImage smallCoinImg2;
	private int smallCoinAnim;
	private final int smallCoinXPos;
	private final int smallCoinYPos;
	private final int smallCoinWidth;
	private final int smallCoinHeight;
	
	private int inbetweenCount;
	private static boolean firstTimeRunning;
	private BufferedImage smallMario;




	
	//end private global variables
	//**********************************************
	
	//constructor
	public MainGameClass() 
	{ 
		//create a new thread
		Thread th = new Thread (this);
		th.start ();
		
	    //*******************************************
		//setup all initial values
		gameState = 0;
		Mario = new Player();
		
		//input booleans
		spaceBool = false;
		dBool = false;
		aBool = false;
		
		inbetweenCount = 0;
		firstTimeRunning = false;
		
		//UI animation
		try
		{
			smallCoinImg0 = ImageIO.read(getClass().getResourceAsStream("/smallCoin_0.png"));
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
		
		try
		{
			smallCoinImg1 = ImageIO.read(getClass().getResourceAsStream("/smallCoin_1.png"));
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
		
		try
		{
			smallCoinImg2 = ImageIO.read(getClass().getResourceAsStream("/smallCoin_2.png"));
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
		
		try
		{
			smallMario = ImageIO.read(getClass().getResourceAsStream("/smallMario.png"));
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}

		smallCoinAnim = 0;
		smallCoinXPos = 160;
		smallCoinYPos = 20;
		smallCoinWidth = 16;
		smallCoinHeight = 16;
		
		

		
		//end setup initial values
	    //******************************************* 
		
		//setup the ability to get events
		this.setFocusable(true);   // set focus for panel.
		this.addKeyListener(this); // listen for key events.
		this.addMouseListener(this); // listen for mouse button events.
		this.addMouseMotionListener(this); // listen for mouse motion events.
	}

	//this allows the animation to "run"
	public void run() 
	{
		// lower ThreadPriority 
		Thread.currentThread().setPriority(Thread.MIN_PRIORITY);
        
		//loop as long as the program is running (infinite)
		//each iteration of the loop is one "step" of our animation
		while (true)
		{ 
			
			try 
            {
				//*******************************************
				//add all position calculations here
				background = new Background();
				if (gameState == 0)
				{
					if (!firstTimeRunning)
					{
						background.reset();
						firstTimeRunning = true;
					}
					background.titleScreen();
				}
				else if (gameState == 1)
				{
					if (firstTimeRunning)
					{
						background.reset();
						firstTimeRunning = false;
					}
					background.inBetween();
					
					if (inbetweenCount >=125)
					{
						gameState = 2;
						inbetweenCount = 0;
						firstTimeRunning = true;
					}
					else
						inbetweenCount ++;
				}
				else if (gameState == 2)
				{
					if (firstTimeRunning)
					{
						background.reset();
						firstTimeRunning = false;
					}
					background.OneOne();
				}
				
				Mario.physics();
				
				//input boolean checks
				if (spaceBool)
					Mario.jump();
				
				if (dBool)
					Mario.goRight();
				
				if (aBool)
					Mario.goLeft();
				
				if (shiftBool)
					Mario.Run();			


				
				
				//end position calculations
				//*******************************************
            } 
            catch (Exception ex) 
            { 
            	//do nothing
            }
			           
			
			//Redraw the picture using the new position information
            repaint();            
            
            //pause momentarily so we can view the changes
            try 
            {
               Thread.sleep(20);  // milliseconds
            } 
            catch (InterruptedException ex) 
            { 
            	//do nothing
            }
            
            // set ThreadPriority to maximum value
            Thread.currentThread().setPriority(Thread.MAX_PRIORITY);
         }
      }
	
	
	//*******************************************
	//Keyboard and Mouse Event Handling Methods
	
	//this method is called when a key is pressed
	public void keyPressed(KeyEvent e) 
	{
		// left right booleans
		if (e.getKeyCode() == 68)
		{
			//	d key || move right
			if (!dBool)
			{
				dBool = true;
				Mario.resetWalk();
			}
		}
		else if (e.getKeyCode() == 65)
		{
			//	a key || move left
			if (!aBool)
			{
				aBool = true;
				Mario.resetWalk();
			}
		}
		
		//jump booleans
		if (e.getKeyCode() == 32)
		{
			if (!spaceBool)
				spaceBool = true;
		}	
		
		//shift boolean
		if (e.getKeyCode() == 16)
		{
			if (!shiftBool)
				shiftBool = true;
		}
		
		if (e.getKeyCode() == 10 && gameState == 0)
		{
			gameState = 1;
		}
		
		//output the code of the key pressed
		//System.out.println("key: "+e.getKeyCode());
	}
	//this method is called when a key is released
	public void keyReleased(KeyEvent e) 
	{		
		if (e.getKeyCode() == 32)
		{
			Mario.stoppedJumping();
			spaceBool = false;
		}	
		
		//	d key || move right
		if (e.getKeyCode() == 68)
		{
			dBool = false;
		}
		
		//	a key || move right
		if (e.getKeyCode() == 65)
		{
			aBool = false;
		}
		
		// shift key 
		if (e.getKeyCode() == 16)
		{
			shiftBool = false;
			Mario.Walk();
		}
		//output the code of the key released
		//System.out.println("key: "+e.getKeyCode());
	}
	
	//this method is called when a standard character key is typed
	//(we will ignore this method, it just has to exist)
	public void keyTyped(KeyEvent e) 
	{
		
	}
	
	
	//this method is called when the mouse is clicked
	public void mouseClicked(MouseEvent e) 
	{
		
	}
	//this method is called when the mouse enters the our component
	public void mouseEntered(MouseEvent e) 
	{
			
	}
	//this method is called when the mouse exits our component
	public void mouseExited(MouseEvent e) 
	{
			
	}
	//this method is called when the mouse button is pressed and held
	public void mousePressed(MouseEvent e) 
	{
		
	}
	//this method is called when the held mouse button is released
	public void mouseReleased(MouseEvent e) 
	{
			
	}
	//this method is called when the mouse button is held and mouse moves
	public void mouseDragged(MouseEvent e) 
	{
		
	}
	//this method is called when the mouse  moves
	public void mouseMoved(MouseEvent e) 
	{
		
	}
	
	//end keyboard and mouse event handlers
	//*******************************************
	
	
	//draw all of the shapes	
	public void paintComponent(Graphics g)
	{
		//recovering Graphics2D
		Graphics2D g2 = (Graphics2D)g;
		
		background = new Background();


		
		//*******************************************
		//place all drawn shapes here
		
		//backdrop start
		Color Sky = new Color(92, 148, 252);
		if(gameState == 0 || gameState == 2 )
		{
			g2.setColor(Sky);
		}
		//
		Rectangle BG = new Rectangle(0,0,5000,5000);
		g2.fill(BG);
		//backdrop stop
		
		background.Draw(g2);
		
		//UI
		UI = new Font("Super Mario Bros. NES Regular", Font.PLAIN, 15); //make this to ./Fonts/UI-Font.ttf
		g2.setFont(UI);
		g2.setColor(Color.white);
		
		g2.drawString("MARIO",50,20);
		g2.drawString("0000000",50,35);
		//g2.drawString(Integer.toString(Mario.getScore()),50,35);
		
		if(gameState == 1)
		{
			g2.drawString("World 1-1", 175,200);
			g2.drawString("X", 235,250);
			g2.drawString(Integer.toString(Mario.getLife()), 275,250);
			g2.drawImage(smallMario, 185,225,32,32, null);
		}

		
		if (smallCoinAnim <24)
		{
			smallCoinAnim++;
		}
		else
		{
			smallCoinAnim = 1;
		}
		
		//calculations to see if image has been up for enough frames
		if (smallCoinAnim <=12)
		{
			g2.drawImage(smallCoinImg0, smallCoinXPos,smallCoinYPos,smallCoinWidth,smallCoinHeight, null);
		}
		else if (smallCoinAnim <=16)
		{
			g2.drawImage(smallCoinImg1, smallCoinXPos,smallCoinYPos,smallCoinWidth,smallCoinHeight, null);
		}
		else if (smallCoinAnim <=20)
		{
			g2.drawImage(smallCoinImg2, smallCoinXPos,smallCoinYPos,smallCoinWidth,smallCoinHeight, null);
		}
		else if(smallCoinAnim <=24)
		{
			g2.drawImage(smallCoinImg1, smallCoinXPos,smallCoinYPos,smallCoinWidth,smallCoinHeight, null);
		}	
		g2.drawString("x"+Mario.getCoin(),175,35);
		
		g2.drawString("WORLD",250,20);
		g2.drawString("1-1",275,35);
		
		g2.drawString("TIME",375,20);
		g2.drawString("999",380,35);

		    
		//mario Calculations
		Mario.draw(g2);
			
		
		
		//end drawn shapes
		//*******************************************
		
	}
	
	public static boolean isMoving()
	{
		if (aBool || dBool)
			return true;
		else
			return false;
	}
	
	public static int getGamestate()
	{
		return gameState;
	}
	
	public static void setGameState(int state)
	{
		gameState = state;
	}
	
	public static void ResetfirstTimeRunning()
	{
		firstTimeRunning = true;
	}
}

