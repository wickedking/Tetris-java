package pieces;

import java.awt.Point;

/**
 * The instance of the J Piece. 
 * @author cody
 *
 */
public class JPiece extends AbstractPiece{

	/**
	 * Default constructor that takes 2 params
	 * @param the_location The starting locations of the piece. 
	 * @param the_rotation The current Rotation of the piece. 
	 */
	public JPiece(final Point the_location, final Rotation the_rotation) {
		super(PieceName.J, the_location, the_rotation, constructPiece(the_rotation));
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * Constructs the individual blocks of the piece according to the rotation. 
	 * @param the_rotation The Current Rotation.
	 * @return An object of Points for each individual blocks based off a grid. 
	 */
	private static LocalPoint constructPiece(final Rotation the_rotation){
		if(the_rotation == Rotation.UP){
			return new LocalPoint(new Point(0,0), new Point(1,0), new Point(1,1), new Point(1,2));
		}else if (the_rotation == Rotation.RIGHT){
			return new LocalPoint(new Point(0,0), new Point(0,1), new Point(1,0), new Point(2,0));
		} else if(the_rotation == Rotation.DOWN){
			return new LocalPoint(new Point(0,0), new Point(0,1), new Point(0,2), new Point(1,2));
		}else {
			return new LocalPoint(new Point(0,1), new Point(1,1), new Point(2,1), new Point(2,0));
		}
	}

	/**
	 * Changes the rotation of the piece
	 * @return Returns a new piece of the new rotation.
	 */
	@Override
	public AbstractPiece rotate() {
		if(super.my_rotation == Rotation.UP){
			return new JPiece(super.my_location, Rotation.RIGHT);
		} else if(super.my_rotation == Rotation.RIGHT){
			return new JPiece(super.my_location, Rotation.DOWN);
		} else if(super.my_rotation == Rotation.DOWN){
			return new JPiece(super.my_location, Rotation.LEFT);
		} else if(super.my_rotation == Rotation.LEFT){
			return new JPiece(super.my_location, Rotation.UP);
		}
		return null;//TODO fix 
	}

}
