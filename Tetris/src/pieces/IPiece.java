package pieces;

import java.awt.Point;

/**
 * The instance of the I Piece. 
 * @author cody
 *
 */
public class IPiece extends AbstractPiece{

	/**
	 * Default constructor that takes 2 params
	 * @param the_location The starting locations of the piece. 
	 * @param the_rotation The current Rotation of the piece. 
	 */
	public IPiece(final Point the_location,final Rotation the_rotation) {
		super(PieceName.I, the_location, the_rotation, constructPiece(the_rotation));
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * Constructs the individual blocks of the piece according to the rotation. 
	 * @param the_rotation The Current Rotation.
	 * @return An object of Points for each individual blocks based off a grid. 
	 */
	private static LocalPoint constructPiece(final Rotation the_rotation){
		if(the_rotation == Rotation.UP){
			return new LocalPoint(new Point(0,0), new Point(0, 1), new Point(0,2), new Point(0,3));
		} else {
			return new LocalPoint(new Point(0,0), new Point(1,0), new Point(2,0), new Point(3,0));
		}
	}

	/**
	 * Changes the rotation of the piece
	 * @return Returns a new piece of the new rotation.
	 */
	@Override
	public AbstractPiece rotate() {
		if(super.my_rotation == Rotation.UP){
			return new IPiece(super.my_location, Rotation.RIGHT);
		} else{
			return new IPiece(super.my_location, Rotation.UP);
		}
	}

}
