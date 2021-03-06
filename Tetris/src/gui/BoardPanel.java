package gui;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.Random;

import javax.swing.JPanel;

import pieces.AbstractPiece;
import board.Board;

/**
 * Is a panel that is used to draw the actual game board. 
 * @author cody
 *
 */
@SuppressWarnings("serial")
public class BoardPanel extends JPanel{
	
	/**
	 * The width of the blocks to be displayed.
	 */
	private final static int block_width = 25;
	
	/**
	 * The height of the blocks to be displayed
	 */
	private final static int block_height = 25;
	
	/**
	 * The x offset for the blocks to be displayed.
	 */
	private final static int x_offset = 0;
	
	/**
	 * The Y offset for the blocks to be displayed.
	 */
	private final static int y_offset = 0;
	
	/**
	 * The reference to the game board.
	 */
	private final Board board;

	/**
	 * Default constructor.
	 * @param the_board A reference to the board that is created.
	 *  To ensure only 1 reference. 
	 */
	public BoardPanel(final Board the_board){
		super();
		board = the_board;
	}
	
	/**
	 * An override of the PaintComponent method. Displays the board and the pieces on the screen.
	 */
	@Override
	public void paintComponent(final Graphics graphics){
		super.paintComponent(graphics);
		final Graphics2D g2d = (Graphics2D) graphics;
		final Random rand = new Random();
		for(int i = 0; i < Board.HEIGHT; i++){
			for(int j = 0; j < Board.WIDTH; j++){
				if(board.isPiece(j, i)){
					g2d.setColor(new Color(rand.nextInt(250) + 6, rand.nextInt(250) + 6, rand.nextInt(250) + 6));
				} else{
					g2d.setColor(new Color(0,0,0));
				}
				g2d.fillRect(j * block_width , i * block_height , block_width -1, block_height-1);
			}
		}
		final AbstractPiece currentPiece = board.currentPiece;
		g2d.setColor(new Color(rand.nextInt(240) + 16, rand.nextInt(240) + 16, rand.nextInt(240) + 16));
		g2d.fillRect((currentPiece.my_location.x + currentPiece.my_point1.x) * block_width, (currentPiece.my_location.y - currentPiece.my_point1.y) * block_height, block_width-1, block_height-1);
		g2d.fillRect((currentPiece.my_location.x + currentPiece.my_point2.x) * block_width, (currentPiece.my_location.y - currentPiece.my_point2.y) * block_height, block_width-1, block_height-1);
		g2d.fillRect((currentPiece.my_location.x + currentPiece.my_point3.x) * block_width, (currentPiece.my_location.y - currentPiece.my_point3.y) * block_height, block_width-1, block_height-1);
		g2d.fillRect((currentPiece.my_location.x + currentPiece.my_point4.x) * block_width, (currentPiece.my_location.y - currentPiece.my_point4.y) * block_height, block_width-1, block_height-1);
		
	}

}
