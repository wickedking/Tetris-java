package pieces;

import java.awt.Point;

/**
 * The instance of the O Piece. 
 * @author cody
 *
 */
public class OPiece extends Piece{

	/**
	 * Default constructor that takes 2 params
	 * @param the_location The starting locations of the piece. 
	 * @param the_rotation The current Rotation of the piece. 
	 */
	public OPiece(Point the_location, Rotation the_rotation) {
		super(PieceName.O, the_location, the_rotation, constructPiece());
		constructPiece();
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * Constructs the individual blocks of the piece according to the rotation. 
	 * @param the_rotation The Current Rotation.
	 * @return An object of Points for each individual blocks based off a grid. 
	 */
	private static LocalPoint constructPiece(){
		return new LocalPoint(new Point(0,0), new Point(0,1), new Point(1,1), new Point(1,0));
	}

	/**
	 * Changes the rotation of the piece
	 * @return Returns a new piece of the new rotation.
	 */
	@Override
	public Piece Rotate() {
		return this;
	}

}
