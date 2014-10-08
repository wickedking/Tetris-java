package pieces;

import java.awt.Point;

/**
 * A factory class to create the different Pieces.
 * @author Cody
 *
 */
public class PieceFactory {
	
	/**
	 * Private constructor.
	 */
	private PieceFactory(){
	}
	
	/**
	 * Used to move the piece down 1 spot. Used to keep the pieces immutable.
	 * @param the_name The name of the Piece to create.
	 * @param the_location The current location of the piece.
	 * @return The newly created piece. 
	 */
	protected static AbstractPiece newPiece(final PieceName the_name, final Point the_location){
		the_location.y = the_location.y + 1;
		return createPiece(the_name, the_location, Rotation.UP);
	}
	
	/**
	 * This method will create a new piece of the requested type.
	 * @param the_name The type of the piece to create.
	 * @param the_location The location of the piece.
	 * @param the_rotation The rotation of the piece. 
	 * @return The newly created piece. 
	 */
	public static AbstractPiece createPiece(final PieceName the_name, final Point the_location, final Rotation the_rotation){
		final AbstractPiece the_piece;
		switch (the_name) {
		case I:
			the_piece = new IPiece(the_location, the_rotation);
			break;
		case J:
			the_piece = new JPiece(the_location, the_rotation);
			break;
		case L:
			the_piece = new LPiece(the_location, the_rotation);
			break;
		case O:
			the_piece = new OPiece(the_location, the_rotation);
			break;
		case S:
			the_piece = new SPiece(the_location, the_rotation);
			break;
		case Z:
			the_piece = new ZPiece(the_location, the_rotation);
			break;
		case T:
			the_piece = new TPiece(the_location, the_rotation);
			break;
		default:
			the_piece = new IPiece(the_location, the_rotation);
			break;
		}
		return the_piece;
	}

}
