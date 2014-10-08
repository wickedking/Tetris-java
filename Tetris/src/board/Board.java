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
	private static final PieceName next_piece[] = {PieceName.I, PieceName.J, PieceName.L, PieceName.O, PieceName.S, PieceName.Z, PieceName.T};

	/**
	 * A reference to a random object. The actual random not just a random object.4
	 */
	private static final Random rand = new Random();

	/**
	 * The start point for all new pieces. 
	 */
	private static final Point start_location = new Point(4,0);

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

	/**
	 * A reference to the current Piece. 
	 */
	public Piece currentPiece;
	
	/**
	 * A reference to the next piece to drop.
	 */
	public Piece nextPiece;

	/**
	 * Default constructor
	 */
	public Board(){
		createBoard();
		nextPiece = PieceFactory.createPiece(PieceName.L, start_location, Rotation.UP);
		createNextPiece();
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
	 * Quits the game. Handle this better
	 //TODO
	 */
	private void gameOver(){
		//System.out.println("Game Over Man!");
		System.exit(0);
		
	}

	/**
	 * Adds a reference of the piece to the board. 
	 * @param the_piece The reference of the piece to add to the board.
	 * @return A boolean if successful. Passes bounds check.
	 */
	public boolean addPiece(Piece the_piece){
		Point location = the_piece.my_location;

		int x = location.x;
		int y = location.y;
		
		if(y < 0 || y - the_piece.my_point1.y < 0 || y - the_piece.my_point2.y < 0 || y - the_piece.my_point3.y < 0 || y - the_piece.my_point4.y < 0) {
			gameOver();
		}
		
		
		
		x = x + the_piece.my_point1.x;
		y = y - the_piece.my_point1.y;

		my_board.get(y).set(x, the_piece);

		x = location.x;
		y = location.y;
		x = x + the_piece.my_point2.x;
		y = y - the_piece.my_point2.y;

		my_board.get(y).set(x, the_piece);

		x = location.x;
		y = location.y;
		x = x + the_piece.my_point3.x;
		y = y - the_piece.my_point3.y;

		my_board.get(y).set(x, the_piece);

		x = location.x;
		y = location.y;
		x = x + the_piece.my_point4.x;
		y = y - the_piece.my_point4.y;

		my_board.get(y).set(x, the_piece);
		createNextPiece();
		checkFullRows();
		return true;
	}

	/**
	 * Creates the Next piece and assigns the current next piece to the current.
	 */
	private void createNextPiece(){
		PieceName name = next_piece[rand.nextInt(next_piece.length)];
		currentPiece = nextPiece;
		nextPiece = PieceFactory.createPiece(name, start_location, Rotation.UP);
	}

	/**
	 * Checks the positions of the points and returns a boolean if possible. No side
	 * effects.
	 * @param the_location The current location of the piece.
	 * @param the_1 The first sub piece point.
	 * @param the_2 The second sub piece point.
	 * @param the_3 The third sub piece point.
	 * @param the_4 The fourth sub piece point.
	 * @return If the position is possible. 
	 */
	public boolean boundsCheck(Point the_location, Point the_1, Point the_2, Point the_3, Point the_4){
		//if(the_location.x > 0 && the_location.x < WIDTH){
		//	if (the_location.y > 0 && the_location.y < HEIGHT){
		//System.out.println(0);
		if(the_location.x + the_1.x >= 0 && the_location.x + the_1.x < WIDTH){
		//	System.out.println(1);
			if(the_location.y - the_1.y >= 0 && the_location.y - the_1.y < HEIGHT){
		//		System.out.println(2);
				if(the_location.x + the_2.x >= 0 && the_location.x + the_2.x < WIDTH){
		//			System.out.println(3);
					if(the_location.y - the_2.y >= 0 && the_location.y - the_2.y < HEIGHT){
		//				System.out.println(4);
						if(the_location.x + the_3.x >= 0 && the_location.x + the_3.x < WIDTH){
		//					System.out.println(5);
							if(the_location.y - the_3.y >= 0 && the_location.y - the_3.y < HEIGHT){
		//						System.out.println(6);
								if(the_location.x + the_4.x >= 0 && the_location.x + the_4.x < WIDTH){
		//							System.out.println(7);
									if(the_location.y - the_4.y >= 0 && the_location.y - the_4.y < HEIGHT){
		//								System.out.println(8);
										if(checkPieceAt(the_location, the_1, the_2, the_3, the_4)){
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
		//}
		//}
		return false;
	}

	/**
	 * Checks if the initial location the and sub points are all within the board bounds.
	 * If not possible will freeze the piece and create a new one. 
	 * @param the_location The current location
	 * @param the_1 The first sub piece location
	 * @param the_2 The second sub piece location
	 * @param the_3 The third sub piece location
	 * @param the_4 The fourth sub piece location
	 * @return A boolean if the points all align within the board. 
	 */
	public boolean boundsCheckPlus(Point the_location, Point the_1, Point the_2, Point the_3, Point the_4){
		if(the_location.x + the_1.x >= 0 && the_location.x + the_1.x < WIDTH){
			if(the_location.y - the_1.y < HEIGHT){
				if(the_location.x + the_2.x >= 0 && the_location.x + the_2.x < WIDTH){
					if(the_location.y - the_2.y < HEIGHT){
						if(the_location.x + the_3.x >= 0 && the_location.x + the_3.x < WIDTH){
							if(the_location.y - the_3.y < HEIGHT){
								if(the_location.x + the_4.x >= 0 && the_location.x + the_4.x < WIDTH){
									if(the_location.y - the_4.y < HEIGHT){
										if(the_location.y - the_1.y < 0 || the_location.y - the_2.y < 0 || the_location.y - the_3.y < 0 || the_location.y - the_4.y < 0) {
											return true;
										}else if(!checkPieceAt(the_location, the_1, the_2, the_3, the_4)){
											addPiece(currentPiece);
										}
										return true;
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
	 * Checks if there is a piece in the locations. Returns false if no piece.
	 * @param the_location
	 * @param the_1
	 * @param the_2
	 * @param the_3
	 * @param the_4
	 * @return False if there is no piece in the locations asked.
	 */
	private boolean checkPieceAt(Point the_location, Point the_1, Point the_2, Point the_3, Point the_4){
		if(isPiece(the_location.x + the_1.x, the_location.y - the_1.y)){
			return false;
		} if(isPiece(the_location.x + the_2.x, the_location.y - the_2.y)){
			return false;
		} if(isPiece(the_location.x + the_3.x, the_location.y - the_3.y)){
			return false;
		} if(isPiece(the_location.x + the_4.x, the_location.y - the_4.y)){
			return false;
		}
		return true;
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
		ArrayList<Piece> row = my_board.get(the_y);
		Piece test = null;
		if(row.size() > the_x){
			test = row.get(the_x);
		}
		if (test == null){
			return false;
		}
		return true;
	}

	/**
	 * Checks all rows to determine if a row is full of pieces. 
	 * Will remove rows if full. 
	 */
	private void checkFullRows(){
		for(int i = 0; i < HEIGHT; i++){
			if(isRowFull(i)){
				my_board.remove(i);
				my_board.add(0, new ArrayList<Piece>());
				for(int j = 0; j < WIDTH; j++){
					my_board.get(0).add(null);
				}
				i--;
			}
		}

	}

	/**
	 * Check if a row in the board is full
	 * @param the_row The row to check if it is full
	 * @return A boolean if the row is full. 
	 */
	private boolean isRowFull(final int the_row){
		ArrayList<Piece> row = my_board.get(the_row);
		boolean check = true;
		//System.out.println("Row size: " +row.size());
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

	/**
	 * Will move the piece down if possible, if not will freeze piece and create new one. 
	 * @return If the move was successful with the current piece. 
	 */
	public boolean movePieceDown(){
		if(boundsCheckPlus(new Point(currentPiece.my_location.x, currentPiece.my_location.y + 1), currentPiece.my_point1, currentPiece.my_point2, currentPiece.my_point3, currentPiece.my_point4)){
			currentPiece = PieceFactory.createPiece(currentPiece.my_name, new Point(currentPiece.my_location.x, currentPiece.my_location.y + 1), currentPiece.my_rotation);
			return true;
		} else {
			addPiece(currentPiece);
			return false;
		}

	}

	/**
	 * Will attempt to move the current piece to the left. If not nothing happens. 
	 * @return A boolean if successful.
	 */
	public boolean movePieceLeft(){
		if(boundsCheck(new Point(currentPiece.my_location.x - 1, currentPiece.my_location.y), currentPiece.my_point1, currentPiece.my_point2, currentPiece.my_point3, currentPiece.my_point4)){
			currentPiece = PieceFactory.createPiece(currentPiece.my_name, new Point(currentPiece.my_location.x - 1, currentPiece.my_location.y), currentPiece.my_rotation);
			return true;
		} else {
			return false;
		}
	}

	/**
	 * WIll attempt to move the current piece to the right. If not nothing happens.
	 * @return A boolean if successful. 
	 */
	public boolean movePieceRight(){
		if(boundsCheck(new Point(currentPiece.my_location.x + 1, currentPiece.my_location.y), currentPiece.my_point1, currentPiece.my_point2, currentPiece.my_point3, currentPiece.my_point4)){
			currentPiece = PieceFactory.createPiece(currentPiece.my_name, new Point(currentPiece.my_location.x + 1, currentPiece.my_location.y), currentPiece.my_rotation);
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Will rotate the current piece. If bounds checking fails, nothing happens. 
	 * @return A boolean if successful. 
	 */
	public boolean rotate(){
		Piece next = currentPiece.Rotate();
		if(boundsCheck(next.my_location, next.my_point1, next.my_point2, next.my_point3, next.my_point4)){
			currentPiece = next;
			return true;
		}
		return false;
	}
	
	/**
	 * Move the piece all the way down and freeze it. 
	 * @return A boolean if successful.
	 */
	public boolean fallPiece(){
		int move = fallPieceNumber();
		for(int i = 0; i < move; i++){
			movePieceDown();
		}
		return true;
	}
	
	/**
	 * Calculates the number of moves down the piece could move in the current position. 
	 * @return The number of rows the piece could move down. 
	 */
	public int fallPieceNumber(){
		int fall = 0;
		for(int i = 1; i < HEIGHT; i++){
			if(boundsCheck(new Point(currentPiece.my_location.x, currentPiece.my_location.y + i), currentPiece.my_point1, currentPiece.my_point2, currentPiece.my_point3, currentPiece.my_point4)){
				fall = i;
			}
		}
		return fall;
	}
	
}
