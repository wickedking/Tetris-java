package board;

import java.awt.Point;
import java.util.ArrayList;
import java.util.Random;

import pieces.Piece;
import pieces.PieceFactory;
import pieces.PieceName;
import pieces.Rotation;

/**
 * The board class to hold the references to the pieces.
 * @author Cody Shafer
 * @version Summer 2014
 *
 */
public class Board {
	
	/**
	 * An array of all the different types of pieces.
	 */
	private static final PieceName next_piece[] = {PieceName.I, PieceName.J, PieceName.L, PieceName.O, PieceName.S, PieceName.Z};
	
	/**
	 * A reference to a random object. The actual random not just a random object.4
	 */
	private static final Random rand = new Random();
	
	/**
	 * The start point for all new pieces. 
	 */
	private static final Point start_location = new Point(4,2);
	
	/**
	 * The Height of the board
	 */
	public static final int HEIGHT = 22;
	
	/**
	 * The Width of the board
	 */
	public static final int WIDTH = 10;
	
	/**
	 * The actual board
	 */
	private ArrayList<ArrayList<Piece>> my_board;
	
	public Piece currentPiece;
	
	/**
	 * Default constructor
	 */
	public Board(){
		createBoard();
		currentPiece = PieceFactory.createPiece(PieceName.L, start_location, Rotation.UP);
	}
	
	/**
	 * Lays the board all out.
	 */
	private void createBoard(){
		my_board = new ArrayList<ArrayList<Piece>>();
		for(int i = 0; i < HEIGHT; i++){
			my_board.add(new ArrayList<Piece>(WIDTH));
			for(int j = 0; j < WIDTH; j++){
				my_board.get(i).add(null);
			}
		}
	}
	
	/**
	 * Adds a reference of the piece to the board. 
	 * @param the_piece The reference of the piece to add to the board.
	 * @return A boolean if successful. Passes bounds check.
	 */
	public boolean addPiece(Piece the_piece){
		Point location = the_piece.my_location;
		if (!boundsCheck(location, the_piece.my_point1, the_piece.my_point2, the_piece.my_point3, the_piece.my_point4)){
			return false;
		}
		int x = location.x;
		int y = location.y;
		x = x + the_piece.my_point1.x;
		y = y - the_piece.my_point1.y;

		my_board.get(y).add(x, the_piece);
		
		x = location.x;
		y = location.y;
		x = x + the_piece.my_point2.x;
		y = y - the_piece.my_point2.y;
		
		my_board.get(y).add(x, the_piece);
		
		x = location.x;
		y = location.y;
		x = x + the_piece.my_point3.x;
		y = y - the_piece.my_point3.y;
		
		my_board.get(y).add(x, the_piece);
		
		x = location.x;
		y = location.y;
		x = x + the_piece.my_point4.x;
		y = y - the_piece.my_point4.y;
		
		my_board.get(y).add(x, the_piece);
		createNextPiece();
		return true;
	}
	
	private void createNextPiece(){
		PieceName name = next_piece[rand.nextInt(next_piece.length)];
		currentPiece = PieceFactory.createPiece(name, start_location, Rotation.UP);
	}
	
	/**
	 * Checks if the initial location the and sub points are all within the board bounds.
	 * @param the_location The current location
	 * @param the_1 The first sub piece location
	 * @param the_2 The second sub piece location
	 * @param the_3 The third sub piece location
	 * @param the_4 The fourth sub piece location
	 * @return A boolean if the points all allign within the board. 
	 */
	private boolean boundsCheck(Point the_location, Point the_1, Point the_2, Point the_3, Point the_4){
		if(the_location.x > 0 && the_location.x < WIDTH){
			if (the_location.y > 0 && the_location.y < HEIGHT){
				if(the_location.x + the_1.x > 0 && the_location.x + the_1.x < WIDTH){
					if(the_location.y - the_1.y > 0 && the_location.y - the_1.y < HEIGHT){
						if(the_location.x + the_2.x > 0 && the_location.x + the_2.x < WIDTH){
							if(the_location.y - the_2.y > 0 && the_location.y - the_2.y < HEIGHT){
								if(the_location.x + the_3.x > 0 && the_location.x + the_3.x < WIDTH){
									if(the_location.y - the_3.y > 0 && the_location.y - the_3.y < HEIGHT){
										if(the_location.x + the_4.x > 0 && the_location.x + the_4.x < WIDTH){
											if(the_location.y - the_4.y > 0 && the_location.y - the_4.y < HEIGHT){
												return true;
											}
										}
									}
								}
							}
						}
					}
				}
			}
		}
		return false;
	}
	
	
	/**
	 * Is there a piece in this location on the board.
	 * @param the_x The x location on the board.
	 * @param the_y The y location on the board.
	 * @return True if there is a piece, false if no piece in location.
	 */
	public boolean isPiece(final int the_x, final int the_y){
		if(the_x > WIDTH || the_x < 0){
			return false;
		} else if (the_y > HEIGHT || the_y < 0){
			return false;
		}
		Piece test = my_board.get(the_y).get(the_x);
		if (test == null){
			return false;
		}
		return true;
	}
	
	/**
	 * Check if a row in the board is full
	 * @param the_row The row to check if it is full
	 * @return A boolean if the row is full. 
	 */
	public boolean isRowFull(final int the_row){
		ArrayList<Piece> row = my_board.get(the_row);
		boolean check = true;
		for(int i = 0; i < row.size(); i++){
			if(row.get(i) == null){
				check = false;
				break;
			}
		}
		return check;
	}
	
	/**
	 * Removes row and add a new one to the board.
	 * @param the_row
	 * @return
	 */
	public boolean removeRow(final int the_row){
		if(the_row < 0 || the_row > HEIGHT){
			return false;
		}
		my_board.remove(the_row);
		my_board.add(new ArrayList<Piece>(WIDTH));
		return true;
	}
	
	public boolean movePieceDown(){
		if(boundsCheck(new Point(currentPiece.my_location.x, currentPiece.my_location.y + 1), currentPiece.my_point1, currentPiece.my_point2, currentPiece.my_point3, currentPiece.my_point4)){
			currentPiece = PieceFactory.createPiece(currentPiece.my_name, new Point(currentPiece.my_location.x, currentPiece.my_location.y + 1), currentPiece.my_rotation);
			return true;
		} else {
			addPiece(currentPiece);
			return false;
		}

	}
	
	public boolean movePieceLeft(){
		currentPiece = PieceFactory.createPiece(currentPiece.my_name, new Point(currentPiece.my_location.x - 1, currentPiece.my_location.y), currentPiece.my_rotation);
		return true;
	}
	
	public boolean movePieceRight(){
		currentPiece = PieceFactory.createPiece(currentPiece.my_name, new Point(currentPiece.my_location.x + 1, currentPiece.my_location.y), currentPiece.my_rotation);
		return true;
	}
	
	public boolean rotate(){
		currentPiece = currentPiece.Rotate();
		return true;
	}
	
	//method to remove rows
	

}
