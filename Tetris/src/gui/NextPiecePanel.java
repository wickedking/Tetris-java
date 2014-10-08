package gui;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;

import javax.swing.JPanel;

import pieces.AbstractPiece;
import board.Board;

/**
 * A panel to draw the next piece to be played.
 * @author Cody
 *
 */
@SuppressWarnings("serial")
public class NextPiecePanel extends JPanel{
	
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
	 * A reference to the board
	 */
	private final  Board my_board;
	
	/**
	 * Default constructor.
	 * @param the_board A reference to the game board. 
	 */
	public NextPiecePanel(final Board the_board){
		super();
		my_board = the_board;
	}
	
	/**
	 * An override of the paintComponent
	 */
	@Override
	public void paintComponent(final Graphics graphics){
		final Graphics2D g2d = (Graphics2D) graphics;
		final AbstractPiece next = my_board.nextPiece;
		Point p = next.my_point1;
		g2d.fillRect(p.x, p.y, block_width, block_height);
		
		p = next.my_point2;
		g2d.fillRect(p.x, p.y, block_width, block_height);
		
		p = next.my_point3;
		g2d.fillRect(p.x, p.y, block_width, block_height);
		
		p = next.my_point4;
		g2d.fillRect(p.x, p.y, block_width, block_height);
		
	}

}
