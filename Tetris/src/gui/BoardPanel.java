package gui;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.Random;

import javax.swing.JPanel;

import pieces.Piece;
import board.Board;

@SuppressWarnings("serial")
public class BoardPanel extends JPanel{
	
	private final int block_width = 25;
	
	private final int block_height = 25;
	
	private final int x_offset = 0;
	
	private final int y_offset = 0;
	
	Board my_board;

	public BoardPanel(Board the_board){
		super();
		my_board = the_board;
	}
	
	@Override
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D) g;
		Random rand = new Random();
		for(int i = 0; i < Board.HEIGHT; i++){
			for(int j = 0; j < Board.WIDTH; j++){
				if(my_board.isPiece(j, i)){
					g2d.setColor(new Color(rand.nextInt(256), rand.nextInt(256), rand.nextInt(256)));
				} else{
					g2d.setColor(new Color(0,0,0));
				}
				g2d.fillRect(j * block_width , i * block_height , block_width -1, block_height-1);
			}
		}
		Piece currentPiece = my_board.currentPiece;
		g2d.setColor(new Color(rand.nextInt(256), rand.nextInt(256), rand.nextInt(256)));
		g2d.fillRect((currentPiece.my_location.x + currentPiece.my_point1.x) * block_width, (currentPiece.my_location.y - currentPiece.my_point1.y) * block_height, block_width, block_height);
		g2d.fillRect((currentPiece.my_location.x + currentPiece.my_point2.x) * block_width, (currentPiece.my_location.y - currentPiece.my_point2.y) * block_height, block_width, block_height);
		g2d.fillRect((currentPiece.my_location.x + currentPiece.my_point3.x) * block_width, (currentPiece.my_location.y - currentPiece.my_point3.y) * block_height, block_width, block_height);
		g2d.fillRect((currentPiece.my_location.x + currentPiece.my_point4.x) * block_width, (currentPiece.my_location.y - currentPiece.my_point4.y) * block_height, block_width, block_height);
		
	}

}
