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


//Bug class to define all properties of a game object

public class Background
{
	//private global variables
	//current setup - xPos, yPos = center coordinate, shade = color
	//add any other private global variable declarations needed (dimensions, velocities, etc.)
	final static int totalLength = 448;
	private static int[][] status = new int[totalLength][30];
	private static int[] xPosArray = new int[totalLength];
	private static Tiles tile = new Tiles();
	
	
	
	
	//GameObjectConstructor constructor
	//current parameters - x,y = center of object, c = color of object
	//add any other needed parameters
	public Background()
	{
		//xPosArray Initial values
		for (int i = 0; i<totalLength; i++)
		{
			xPosArray[i] = i*64;
		}
		
		//save all instance data from parameters
		//setup all initial values here
		
	}
	
	//add any methods that are required to control your object within the game
	//this should include movement, collisions, resetting, etc.
	
	
	
	//draw the object
	//***Be sure to call this method in the MainGameClass so you can see the object!***
	public void titleScreen()
	{
		status[3][2] = 100;
		status[5][9] = 101;
		status[0][13] = 3;
		status[0][14] = 3;
		status[1][13] = 3;
		status[1][14] = 3;
		status[2][13] = 3;
		status[2][14] = 3;
		status[3][13] = 3;
		status[3][14] = 3;
		status[4][13] = 3;
		status[4][14] = 3;
		status[5][13] = 3;
		status[5][14] = 3;
		status[6][13] = 3;
		status[6][14] = 3;
		status[7][13] = 3;
		status[7][14] = 3;
		status[8][13] = 3;
		status[8][14] = 3;
		status[9][13] = 3;
		status[9][14] = 3;
		status[10][13] = 3;
		status[10][14] = 3;
		status[11][13] = 3;
		status[11][14] = 3;
		status[12][13] = 3;
		status[12][14] = 3;
		status[13][13] = 3;
		status[13][14] = 3;
		status[14][13] = 3;
		status[14][14] = 3;
		status[15][13] = 3;
		status[15][14] = 3;
	}
	
	public void inBetween()
	{
		
	}
	
	public void OneOne()
	{
	//setting what each tile is
		
		
		status[1][13] = 3;
		status[1][14] = 3;
		
		status[2][13] = 3;
		status[2][14] = 3;

		status[3][13] = 3;
		status[3][14] = 3;
		
		status[4][13] = 3;
		status[4][14] = 3;
		
		//brick
		//if(status[4][9] !=10)
			//status[4][9] = 9;
		//else
			//status[4][9] = 10;
		
		status[5][13] = 3;
		status[5][14] = 3;
		
		
	
		
		//question
		if(status[17][9] !=8)
			status[17][9] = 5;
		else
			status[17][9] = 8;
		
		
		status[6][13] = 3;
		status[6][14] = 3;
		
		status[7][13] = 3;
		status[7][14] = 3;
		//coin
		//if (status[7][11] != 10)
		//	status[7][11] = 4;
		//else
		//{
		//	status[7][11] = 10;
		//}


		
		status[8][13] = 3;
		status[8][14] = 3;
		
		status[9][13] = 3;
		status[9][14] = 3;

		
		status[10][13] = 3;
		status[10][14] = 3;
		
		status[11][13] = 3;
		status[11][14] = 3;
		
		status[12][13] = 3;
		status[12][14] = 3;
		
		
		
		status[12][13] = 3;
		status[12][14] = 3;
		
		status[13][13] = 3;
		status[13][14] = 3;
		
		status[14][13] = 3;
		status[14][14] = 3;
		
		status[15][13] = 3;
		status[15][14] = 3;
		
		status[16][13] = 3;
		status[16][14] = 3;
		
		status[17][13] = 3;
		status[17][14] = 3;
		
		
		//////////////////////////////////////////////////////////start of 2nd row
		status[18][13] = 3;
		status[18][14] = 3;

		
		status[19][13] = 3;
		status[19][14] = 3;

		
		status[20][13] = 3;
		status[20][14] = 3;

		
		status[21][13] = 3;
		status[21][14] = 3;
		if(status[21][9] !=10)
			status[21][9] = 9;
		else
			status[21][9] = 10;

		
		status[22][13] = 3;
		status[22][14] = 3;
		if(status[22][9] !=8)
			status[22][9] = 5;
		else
			status[22][9] = 8;

		
		status[23][13] = 3;
		status[23][14] = 3;
		if(status[23][9] !=10)
			status[23][9] = 9;
		else
			status[23][9] = 10;
		if(status[23][5] !=8)
			status[23][5] = 5;
		else
			status[23][5] = 8;
		
		status[24][13] = 3;
		status[24][14] = 3;
		if(status[24][9] !=8)
			status[24][9] = 5;
		else
			status[24][9] = 8;

		
		status[25][13] = 3;
		status[25][14] = 3;
		if(status[25][9] !=10)
			status[25][9] = 9;
		else
			status[25][9] = 10;
		
		status[26][13] = 3;
		status[26][14] = 3;
		
		
		status[27][13] = 3;
		status[27][14] = 3;
		
		
		status[28][13] = 3;
		status[28][14] = 3;
		
		
		status[29][13] = 3;
		status[29][14] = 3;
		
		
		status[30][13] = 3;
		status[30][14] = 3;
		
		
		status[31][13] = 3;
		status[31][14] = 3;
		status[31][12] = 3; //pipe

		
		status[32][13] = 3;
		status[32][14] = 3;
		status[32][12] = 3; //pipe
		//12 - aesthetic Pipe
		//13 - functioning Pipe (Warp 1)
		//14 - functioning Pipe (Warp 2)
		//15 - functioning Pipe (warp 3)
		//16 - functioning Pipe (warp 4)
		//17 - functioning Pipe (warp 5)
		//18 - Pipe Top Right Collision
		//19 - Pipe Bottom aesthetic (left collision)
		//20 - Pipe Bottom right collision

		
		status[33][13] = 3;
		status[33][14] = 3;
		
		
		status[34][13] = 3;
		status[34][14] = 3;
		
		
		status[35][13] = 3;
		status[35][14] = 3;
		
		
		status[36][13] = 3;
		status[36][14] = 3;
		
		
		status[37][13] = 3;
		status[37][14] = 3;
		
		
		status[38][13] = 3;
		status[38][14] = 3;
		
		
		status[39][13] = 3;
		status[39][14] = 3;
		status[39][12] = 19; //pipe

		
		status[40][13] = 3;
		status[40][14] = 3;

		
		status[41][13] = 3;
		status[41][14] = 3;

		
		status[42][13] = 3;
		status[42][14] = 3;

		
		status[43][13] = 3;
		status[43][14] = 3;
		
		
		status[44][13] = 3;
		status[44][14] = 3;
		
		
		//status[45][13] = 3;
		//status[45][14] = 3;
		
		
		//status[46][13] = 3;
		//status[46][14] = 3;
		
		
		status[47][13] = 3;
		status[47][14] = 3;
		
		
		status[48][13] = 3;
		status[48][14] = 3;
		
		
		status[49][13] = 3;
		status[49][14] = 3;
		
		
		status[50][13] = 3;
		status[50][14] = 3;
	
		
		status[51][13] = 3;
		status[51][14] = 3;

		
		status[52][13] = 3;
		status[52][14] = 3;

		
		status[53][13] = 3;
		status[53][14] = 3;
		if(status[53][9] !=10)
			status[53][9] = 9;
		else
			status[53][9] = 10;
		
		
		status[54][13] = 3;
		status[54][14] = 3;
		if(status[54][9] !=8)
			status[54][9] = 5;
		else
			status[54][9] = 8;

		
		status[55][13] = 3;
		status[55][14] = 3;
		if(status[55][9] !=10)
			status[55][9] = 9;
		else
			status[55][9] = 10;

		
		status[56][13] = 3;
		status[56][14] = 3;
		if(status[56][5] !=10)
			status[56][5] = 9;
		else
			status[56][5] = 10;

		
		status[57][13] = 3;
		status[57][14] = 3;
		if(status[57][5] !=10)
			status[57][5] = 9;
		else
			status[57][5] = 10;

		
		status[58][13] = 3;
		status[58][14] = 3;
		if(status[58][5] !=10)
			status[58][5] = 9;
		else
			status[58][5] = 10;

		
		status[59][13] = 3;
		status[59][14] = 3;
		if(status[59][5] !=10)
			status[59][5] = 9;
		else
			status[59][5] = 10;

		
		status[60][13] = 3;
		status[60][14] = 3;
		if(status[60][5] !=10)
			status[60][5] = 9;
		else
			status[60][5] = 10;

		
		status[61][13] = 3;
		status[61][14] = 3;
		if(status[61][5] !=10)
			status[61][5] = 9;
		else
			status[61][5] = 10;

		
		//status[62][13] = 3;
		//status[62][14] = 3;
		if(status[62][5] !=10)
			status[62][5] = 9;
		else
			status[62][5] = 10;

		
		//status[63][13] = 3;
		//status[63][14] = 3;
		if(status[63][5] !=10)
			status[63][5] = 9;
		else
			status[63][5] = 10;
		
		
		//status[64][13] = 3;
		//status[64][14] = 3;
		
		
		status[65][13] = 3;
		status[65][14] = 3;
		
		
		status[66][13] = 3;
		status[66][14] = 3;
		
		
		status[67][13] = 3;
		status[67][14] = 3;
		if(status[67][5] !=10)
			status[67][5] = 9;
		else
			status[67][5] = 10;

		
		status[68][13] = 3;
		status[68][14] = 3;
		if(status[68][5] !=10)
			status[68][5] = 9;
		else
			status[68][5] = 10;
		
		
		status[69][13] = 3;
		status[69][14] = 3;
		if(status[69][5] !=10)
			status[69][5] = 9;
		else
			status[69][5] = 10;
		
		
		status[70][13] = 3;
		status[70][14] = 3;
		if(status[70][5] !=8)
			status[70][5] = 5;
		else
			status[70][5] = 8;
		if(status[70][9] !=10)
			status[70][9] = 9;
		else
			status[70][9] = 10;

		
		
		status[71][13] = 3;
		status[71][14] = 3;
		
		
		status[72][13] = 3;
		status[72][14] = 3;
		
		
		status[73][13] = 3;
		status[73][14] = 3;
		
		
		status[74][13] = 3;
		status[74][14] = 3;
		
		
		status[75][13] = 3;
		status[75][14] = 3;
		
		
		status[76][13] = 3;
		status[76][14] = 3;
		if(status[76][9] !=10)
			status[76][9] = 9;
		else
			status[76][9] = 10;
		
		
		status[77][13] = 3;
		status[77][14] = 3;
		if(status[77][9] !=10)
			status[77][9] = 9;
		else
			status[77][9] = 10;

		
		status[78][13] = 3;
		status[78][14] = 3;
		
		
		status[79][13] = 3;
		status[79][14] = 3;
		
		
		status[80][13] = 3;
		status[80][14] = 3;
		
		
		status[81][13] = 3;
		status[81][14] = 3;
		if(status[81][9] !=8)
			status[81][9] = 5;
		else
			status[81][9] = 8;
		
		
		status[82][13] = 3;
		status[82][14] = 3;
		
		
		status[83][13] = 3;
		status[83][14] = 3;
		
		
		status[84][13] = 3;
		status[84][14] = 3;
		if(status[84][9] !=8)
			status[84][9] = 5;
		else
			status[84][9] = 8;
		if(status[84][5] !=8)
			status[84][5] = 5;
		else
			status[84] [5] = 8;
		
		
		status[85][13] = 3;
		status[85][14] = 3;
		
		
		status[86][13] = 3;
		status[86][14] = 3;
		
		
		
		status[87][13] = 3;
		status[87][14] = 3;
		if(status[87][9] !=8)
			status[87][9] = 5;
		else
			status[87][9] = 8;
		
		
		status[88][13] = 3;
		status[88][14] = 3;
		
		
		status[89][13] = 3;
		status[89][14] = 3;

		
		status[90][13] = 3;
		status[90][14] = 3;
		
		
		status[91][13] = 3;
		status[91][14] = 3;
		
		
		status[92][13] = 3;
		status[92][14] = 3;
		

		status[93][13] = 3;
		status[93][14] = 3;
		if(status[93][9] !=10)
			status[93][9] = 9;
		else
			status[93][9] = 10;
		
		status[94][13] = 3;
		status[94][14] = 3;
		
		
		status[95][13] = 3;
		status[95][14] = 3;
		
		
		status[96][13] = 3;
		status[96][14] = 3;
		if(status[96][5] !=10)
			status[96][5] = 9;
		else
			status[96][5] = 10;
		
		
		status[97][13] = 3;
		status[97][14] = 3;
		if(status[97][5] !=10)
			status[97][5] = 9;
		else
			status[97][5] = 10;
		
		
		status[98][13] = 3;
		status[98][14] = 3;
		if(status[98][5] !=10)
			status[98][5] = 9;
		else
			status[98][5] = 10;
		
		
		status[99][13] = 3;
		status[99][14] = 3;
		
		
		status[100][13] = 3;
		status[100][14] = 3;

		//////////////////////first 100
		
		status[101][13] = 3;
		status[101][14] = 3;

		
		status[102][13] = 3;
		status[102][14] = 3;

		
		status[103][13] = 3;
		status[103][14] = 3;
		if(status[103][5] !=10)
			status[103][5] = 9;
		else
			status[103][5] = 10;
		
		status[104][13] = 3;
		status[104][14] = 3;
		if(status[104][5] !=8)
			status[104][5] = 5;
		else
			status[104][5] = 8;
		if(status[104][9] !=10)
			status[104][9] = 9;
		else
			status[104][9] = 10;
		
		status[105][13] = 3;
		status[105][14] = 3;
		if(status[105][5] !=8)
			status[105][5] = 5;
		else
			status[105][5] = 8;
		if(status[105][9] !=10)
			status[105][9] = 9;
		else
			status[105][9] = 10;
		
		status[106][13] = 3;
		status[106][14] = 3;
		if(status[106][5] !=10)
			status[106][5] = 9;
		else
			status[106][5] = 10;

		
		status[107][13] = 3;
		status[107][14] = 3;

		
		status[108][13] = 3;
		status[108][14] = 3;

		
		status[109][13] = 3;
		status[109][14] = 3;
		status[109][12] = 11;


		
		status[110][13] = 3;
		status[110][14] = 3;
		status[110][12] = 11;
		status[110][11] = 11;



		
		status[111][13] = 3;
		status[111][14] = 3;
		status[111][12] = 11;
		status[111][11] = 11;
		status[111][10] = 11;




		
		status[112][13] = 3;
		status[112][14] = 3;
		status[112][12] = 11;
		status[112][11] = 11;
		status[112][10] = 11;
		status[112][9] = 11;


		status[113][13] = 3;
		status[113][14] = 3;

		
		status[114][13] = 3;
		status[114][14] = 3;

		
		status[115][13] = 3;
		status[115][14] = 3;
		status[115][12] = 11;
		status[115][11] = 11;
		status[115][10] = 11;
		status[115][9] = 11;



		
		status[116][13] = 3;
		status[116][14] = 3;
		status[116][12] = 11;
		status[116][11] = 11;
		status[116][10] = 11;


		
		status[117][13] = 3;
		status[117][14] = 3;
		status[117][12] = 11;
		status[117][11] = 11;


		
		status[118][13] = 3;
		status[118][14] = 3;
		status[118][12] = 11;



		status[119][13] = 3;
		status[119][14] = 3;
		
		
		status[120][13] = 3;
		status[120][14] = 3;
		
		
		status[121][13] = 3;
		status[121][14] = 3;
		
		
		status[122][13] = 3;
		status[122][14] = 3;
		
		////
		status[123][13] = 3;
		status[123][14] = 3;
		status[123][12] = 11;

		
		status[124][13] = 3;
		status[124][14] = 3;
		status[124][12] = 11;
		status[124][11] = 11;

		
		status[125][13] = 3;
		status[125][14] = 3;
		status[125][12] = 11;
		status[125][11] = 11;
		status[125][10] = 11;

		
		status[126][13] = 3;
		status[126][14] = 3;
		status[126][12] = 11;
		status[126][11] = 11;
		status[126][10] = 11;
		status[126][9] = 11;



		status[127][13] = 3;
		status[127][14] = 3;
		status[127][12] = 11;
		status[127][11] = 11;
		status[127][10] = 11;
		status[127][9] = 11;


//
		
		//status[128][13] = 3;
		//status[128][14] = 3;
		
		
		//status[129][13] = 3;
		//status[129][14] = 3;
		
		
		status[130][13] = 3;
		status[130][14] = 3;
		status[130][12] = 11;
		status[130][11] = 11;
		status[130][10] = 11;
		status[130][9] = 11;


		
		status[131][13] = 3;
		status[131][14] = 3;
		status[131][12] = 11;
		status[131][11] = 11;
		status[131][10] = 11;


		
		status[132][13] = 3;
		status[132][14] = 3;
		status[132][12] = 11;
		status[132][11] = 11;


		
		status[133][13] = 3;
		status[133][14] = 3;
		status[133][12] = 11;

		
		status[134][13] = 3;
		status[134][14] = 3;
		
		
		status[135][13] = 3;
		status[135][14] = 3;
		
		
		status[136][13] = 3;
		status[136][14] = 3;
		status[136][12] = 19; //pipe

		
		status[137][13] = 3;
		status[137][14] = 3;

		
		status[138][13] = 3;
		status[138][14] = 3;
		
		
		status[139][13] = 3;
		status[139][14] = 3;
		
		
		status[140][13] = 3;
		status[140][14] = 3;
		
		
		status[141][13] = 3;
		status[141][14] = 3;
		
		
		status[142][13] = 3;
		status[142][14] = 3;
		
		
		status[143][13] = 3;
		status[143][14] = 3;
		if(status[143][9] !=10)
			status[143][9] = 9;
		else
			status[143][9] = 10;
		
		
		status[144][13] = 3;
		status[144][14] = 3;
		if(status[144][9] !=10)
			status[144][9] = 9;
		else
			status[144][9] = 10;
		
		
		status[145][13] = 3;
		status[145][14] = 3;
		if(status[145][9] !=8)
			status[145][9] = 5;
		else
			status[145][9] = 8;
		
		
		status[146][13] = 3;
		status[146][14] = 3;
		if(status[146][9] !=10)
			status[146][9] = 9;
		else
			status[146][9] = 10;
		
		
		status[147][13] = 3;
		status[147][14] = 3;
		
		
		status[148][13] = 3;
		status[148][14] = 3;
		
		
		status[149][13] = 3;
		status[149][14] = 3;
		
		
		status[150][13] = 3;
		status[150][14] = 3;
		
		
		status[151][13] = 3;
		status[151][14] = 3;
	
		
		status[152][13] = 3;
		status[152][14] = 3;

		
		status[153][13] = 3;
		status[153][14] = 3;
		status[153][12] = 3;

		
		status[154][13] = 3;
		status[154][14] = 3;
		status[154][12] = 3;

		
		status[155][13] = 3;
		status[155][14] = 3;


		//////////////////////////////////really tall tile stair before castle
		status[156][13] = 3;
		status[156][14] = 3;
		status[156][12] = 11;

		
		status[157][13] = 3;
		status[157][14] = 3;
		status[157][12] = 11;
		status[157][11] = 11;


		
		status[158][13] = 3;
		status[158][14] = 3;
		status[158][12] = 11;
		status[158][11] = 11;
		status[158][10] = 11;

		
		status[159][13] = 3;
		status[159][14] = 3;
		status[159][12] = 11;
		status[159][11] = 11;
		status[159][10] = 11;
		status[159][9] = 11;

		
		status[160][13] = 3;
		status[160][14] = 3;
		status[160][12] = 11;
		status[160][11] = 11;
		status[160][10] = 11;
		status[160][9] = 11;
		status[160][8] = 11;


		
		status[161][13] = 3;
		status[161][14] = 3;
		status[161][12] = 11;
		status[161][11] = 11;
		status[161][10] = 11;
		status[161][9] = 11;
		status[161][8] = 11;
		status[161][7] = 11;

		
		status[162][13] = 3;
		status[162][14] = 3;
		status[162][12] = 11;
		status[162][11] = 11;
		status[162][10] = 11;
		status[162][9] = 11;
		status[162][8] = 11;
		status[162][7] = 11;
		status[162][6] = 11;

		
		status[163][13] = 3;
		status[163][14] = 3;
		status[163][12] = 11;
		status[163][11] = 11;
		status[163][10] = 11;
		status[163][9] = 11;
		status[163][8] = 11;
		status[163][7] = 11;
		status[163][6] = 11;
		status[163][5] = 11;


		
		status[164][13] = 3;
		status[164][14] = 3;
		
		
		status[165][13] = 3;
		status[165][14] = 3;
		
		
		status[166][13] = 3;
		status[166][14] = 3;
		
		
		status[167][13] = 3;
		status[167][14] = 3;
		
		
		status[168][13] = 3;
		status[168][14] = 3;
		
		
		status[169][13] = 3;
		status[169][14] = 3;
		
		
		status[170][13] = 3;
		status[170][14] = 3;
		
		
		status[171][13] = 3;
		status[171][14] = 3;
		
		
		status[172][13] = 3;
		status[172][14] = 3;
		status[172][12] = 11; //flag pole base spot

		
		status[173][13] = 3;
		status[173][14] = 3;
		
		
		status[174][13] = 3;
		status[174][14] = 3;
		
		
		status[175][13] = 3;
		status[175][14] = 3;
		
		
		status[176][13] = 3;
		status[176][14] = 3;
		
		
		status[177][13] = 3;
		status[177][14] = 3;
		
		
		status[178][13] = 3;
		status[178][14] = 3;
		
		
		status[179][13] = 3;
		status[179][14] = 3;
		
		
		status[180][13] = 3;
		status[180][14] = 3;
		
		
		status[181][13] = 3;
		status[181][14] = 3;
		
		
		status[182][13] = 3;
		status[182][14] = 3;
		
		
		status[183][13] = 3;
		status[183][14] = 3;
		
		
		status[184][13] = 3;
		status[184][14] = 3;
		
		
		status[185][13] = 3;
		status[185][14] = 3;
		
		
		status[186][13] = 3;
		status[186][14] = 3;
		
		
		status[187][13] = 3;
		status[187][14] = 3;
		
		
		status[188][13] = 3;
		status[188][14] = 3;
		
		
		status[189][13] = 3;
		status[189][14] = 3;
		
		
		status[190][13] = 3;
		status[190][14] = 3;
		
		
		status[191][13] = 3;
		status[191][14] = 3;
		
		
		status[192][13] = 3;
		status[192][14] = 3;
		
		
		status[193][13] = 3;
		status[193][14] = 3;
		

		status[194][13] = 3;
		status[194][14] = 3;
		
		
		status[195][13] = 3;
		status[195][14] = 3;
		
		
		status[196][13] = 3;
		status[196][14] = 3;
		
		
		status[197][13] = 3;
		status[197][14] = 3;

		
		status[198][13] = 3;
		status[198][14] = 3;
		
		
		status[199][13] = 3;
		status[199][14] = 3;
		
		
		status[200][13] = 3;
		status[200][14] = 3;
		
		
		status[201][13] = 3;
		status[201][14] = 3;
		
		
		status[202][13] = 3;
		status[202][14] = 3;

		
		status[203][13] = 3;
		status[203][14] = 3;

				
		status[204][13] = 3;
		status[204][14] = 3;

		
		
		status[205][13] = 3;
		status[205][14] = 3;

		
		
		status[206][13] = 3;
		status[206][14] = 3;

		
		
		status[207][13] = 3;
		status[207][14] = 3;

		
		
		status[208][13] = 3;
		status[208][14] = 3;

		
		
		status[209][13] = 3;
		status[209][14] = 3;

		
		
		status[210][13] = 3;
		status[210][14] = 3;

		
		
		status[211][13] = 3;
		status[211][14] = 3;

	}
	
	public void OneOneSublevel()
	{
		
	}
	
	public void test2()
	{
		//setting what each tile is
		
		
		status[1][13] = 3;
		status[1][14] = 3;
		
		status[2][13] = 3;
		status[2][14] = 3;

		status[3][13] = 3;
		status[3][14] = 3;
		
		status[4][13] = 3;
		status[4][14] = 3;
		
		//brick
		if(status[4][9] !=10)
			status[4][9] = 9;
		else
			status[4][9] = 10;
		
		status[5][13] = 3;
		status[5][14] = 3;		
		//question
		if(status[5][9] !=8)
			status[5][9] = 5;
		else
			status[5][9] = 8;
		
		
		status[6][13] = 3;
		status[6][14] = 3;
		
		status[7][13] = 3;
		status[7][14] = 3;
		status[7][12] = 3;
		//coin
		if (status[7][11] != 10)
			status[7][11] = 4;
		else
		{
			status[7][11] = 10;
		}


		
		status[8][13] = 3;
		status[8][14] = 3;
		
		status[9][13] = 3;
		status[9][14] = 3;
		status[9][9] = 3;

		
		status[10][13] = 3;
		status[10][14] = 3;
		
		status[11][12] = 11;
		status[11][13] = 3;
		status[11][14] = 3;
		
		status[12][11] = 11;
		status[12][12] = 11;
		status[12][13] = 3;
		status[12][14] = 3;
		
		status[13][8] = 12;
		status[13][10] = 19;
		status[13][11] = 19;
		status[13][12] = 19;
		status[13][13] = 3;
		status[13][14] = 3;
		
		status[14][13] = 3;
		status[14][14] = 3;
		
		status[15][13] = 3;
		status[15][14] = 3;
		
		status[16][13] = 3;
		status[16][14] = 3;
		
		status[17][13] = 3;
		status[17][14] = 3;
		
		
		
		
	}
	
	public void test()
	{
		//setting what each tile is
		
		//yrow
		status[0][0] = 1;
		status[0][1] = 2;
		status[0][2] = 1;
		status[0][3] = 2;
		status[0][4] = 1;
		status[0][5] = 2;
		status[0][6] = 1;
		status[0][7] = 2;
		status[0][8] = 1;
		status[0][9] = 2;
		status[0][10] = 1;
		status[0][11] = 2;
		status[0][12] = 1;
		status[0][13] = 2;
		status[0][14] = 3;
		
		//xrow
		status[1][0] = 2;
		status[2][0] = 1;
		status[3][0] = 2;
		status[4][0] = 1;
		status[5][0] = 2;
		status[6][0] = 1;
		status[7][0] = 2;
		status[8][0] = 1;
		status[9][0] = 2;
		status[10][0] = 1;
		status[11][0] = 2;
		status[12][0] = 1;
		status[13][0] = 2;
		status[14][0] = 1;
		status[15][0] = 3;
		status[16][0] = 1;
		status[17][0] = 2;
		status[18][0] = 1;
		status[19][0] = 2;
		status[20][0] = 1;
		status[21][0] = 2;
		status[22][0] = 1;
		status[23][0] = 2;
		status[24][0] = 1;
		status[25][0] = 2;	
	}
	
	public void reset()
	{
		for (int row = 0; row < status.length; row++)
		{
			for (int col = 0; col < status[row].length; col++) 
			{
				status[row][col] = 0;
			}
		}
	}
	
	public void Draw(Graphics2D g2)
	{	
		//1 = ground 2 = ??? 3 = ???
		
		//method for deciding what each one is, and drawing it depending on its value
		for (int row = 0; row < status.length; row++)
		{
			for (int col = 0; col < status[row].length; col++) 
			{
				//key:
				//1 - test 1
				//2 - test 2
				//3 - overworld floor
				//4 - coin
				//5 - question block // coin
				//6 - question block // power-up
				//7 - question block // star
				//8 - question block // spent
				//9 - brick
				//10 - blank
				//11 - tile
				//12 - aesthetic Pipe
				//13 - functioning Pipe (Warp 1)
				//14 - functioning Pipe (Warp 2)
				//15 - functioning Pipe (warp 3)
				//16 - functioning Pipe (warp 4)
				//17 - functioning Pipe (warp 5)
				//18 - Pipe Top Right Collision
				//19 - Pipe Bottom aesthetic (left collision)
				//20 - Pipe Bottom right collision
				//100 - Logo
				//101 - title text
	
				// 					To Be Added
				//21 - flag pole peak
				//22 - flag pole
				//23 - flag pole base
				//24 - castle
				
				
				
				
				
				
				if (status[row][col] == 1)
				{
					tile.tileBlack(g2,row,col);
				}
				else if (status[row][col] == 2)
				{
					tile.tileColor(g2, Color.red, row, col);
				}
				else if (status[row][col] == 3)
				{
					//tile.brickcolor(g2, Color.green, row, col);
					tile.overworldFloor(g2, row, col);

				}
				else if (status[row][col] == 4)
				{
					tile.coin(g2, row, col);
				}
				else if (status[row][col] == 5)
				{
					tile.question(g2, row, col);
				}
				else if (status[row][col] == 6)
				{
					tile.question(g2, row, col);
				}
				else if (status[row][col] == 7)
				{
					tile.question(g2, row, col);
				}
				else if (status[row][col] == 8)
				{
					tile.usedQuestion(g2, row, col);
				}
				else if (status[row][col] == 9)
				{
					tile.brick(g2, row, col);
				}
				else if (status[row][col] == 10)
				{
				}
				else if (status[row][col] == 11)
				{
					tile.tile(g2, row, col);
				}
				else if(status[row][col] == 12)
				{
					tile.pipe(g2, col, row, 0);
				}
				else if(status[row][col] == 13)
				{
					tile.pipe(g2, col, row, 1);
				}
				else if (status[row][col] == 14)
				{
					tile.pipe(g2, col, row, 2);
				}
				else if(status[row][col] == 15)
				{
					tile.pipe(g2, col, row, 3);
				}
				else if (status[row][col] == 16	)
				{
					tile.pipe(g2, col, row, 4);
				}
				else if (status[row][col] == 17)
				{
					tile.pipe(g2, col, row, 5);
				}
				else if (status[row][col] == 18)
				{
					
				}
				else if (status[row][col] == 19)
				{
					tile.pipeBottom(g2, row, col);

				}
				else if (status[row][col] == 20)
				{
					
				}
				else if (status[row][col] == 100)
				{
					tile.logo(g2, row, col);
				}
				else if (status[row][col] == 101)
				{
					tile.startText(g2, row, col);
				}
			} 
		}
	}
	
	public static boolean checkTile(int currentTileX, int currentTileY)
	{
		//if statement for collision, the 3 in this case should be continued with an || operator for all collision blocks
		if (status[currentTileX][currentTileY] == 3 || status[currentTileX][currentTileY] == 5 || status[currentTileX][currentTileY] == 8 || status[currentTileX][currentTileY] == 9 || status[currentTileX][currentTileY] == 11 || status[currentTileX][currentTileY] == 12 || status[currentTileX][currentTileY] == 13 || status[currentTileX][currentTileY] == 14 || status[currentTileX][currentTileY] == 15 || status[currentTileX][currentTileY] == 16 || status[currentTileX][currentTileY] == 17 || status[currentTileX][currentTileY] == 19)
		{
			return true;
		}
		else
			return false;
	}
	
	public static int getTile(int currentTileX, int currentTileY)
	{
		return status[currentTileX][currentTileY];
	}
	
	public static void setTile(int xTile, int yTile, int value)
	{
		status[xTile][yTile] = value;	
	}
}
