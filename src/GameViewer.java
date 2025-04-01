import javax.swing.JFrame;//access to the frame files

/**
 * @author Justin Vincent
 * @author Bobby Orbin
 */
public class GameViewer  
{
	public static void main(String[] args)
	{
		JFrame frame = new JFrame();//create a frame
		
		frame.setSize(524, 560);//set the frame size (currently 1000 x 800 viewable)
		frame.setTitle("Super Mario Bros.");//title
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//close the executing code with the window
		
		//create main game component object here
		MainGameClass anim = new MainGameClass();
		
		//add objects to the frame here
		frame.add(anim);
		
		frame.setVisible(true);//make "seeable"
		
	}
}


