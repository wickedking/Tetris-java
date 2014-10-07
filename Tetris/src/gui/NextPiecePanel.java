package gui;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;

import javax.swing.JPanel;

import pieces.Piece;
import board.Board;

@SuppressWarnings("serial")
public class NextPiecePanel extends JPanel{
	
	/**
	 * The width of the blocks to be displayed.
	 */
	private final int block_width = 25;
	
	/**
	 * The height of the blocks to be displayed
	 */
	private final int block_height = 25;
	
	/**
	 * The x offset for the blocks to be displayed.
	 */
	private final int x_offset = 0;
	
	/**
	 * The Y offset for the blocks to be displayed.
	 */
	private final int y_offset = 0;
	
	Board my_board;
	
	public NextPiecePanel(Board the_board){
		super();
		my_board = the_board;
	}
	
	@Override
	public void paintComponent(Graphics g){
		Graphics2D g2d = (Graphics2D) g;
		Piece next = my_board.nextPiece;
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
