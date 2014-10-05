package pieces;

import java.awt.Point;

/**
 * The instance of the L Piece. 
 * @author cody
 *
 */
public class LPiece extends Piece{

	/**
	 * Default constructor that takes 2 params
	 * @param the_location The starting locations of the piece. 
	 * @param the_rotation The current Rotation of the piece. 
	 */
	public LPiece(Point the_location, Rotation the_rotation) {
		super(PieceName.L, the_location, the_rotation, constructPiece(the_rotation));
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * Constructs the individual blocks of the piece according to the rotation. 
	 * @param the_rotation The Current Rotation.
	 * @return An object of Points for each individual blocks based off a grid. 
	 */
	private static LocalPoint constructPiece(Rotation the_rotation){
		if(the_rotation == Rotation.UP){
			return new LocalPoint(new Point(0,0), new Point(0,1), new Point(0,2), new Point(1,0));
		}else if (the_rotation == Rotation.RIGHT){
			return new LocalPoint(new Point(0,0), new Point(0,1), new Point(1,1), new Point(2,1));
		} else if(the_rotation == Rotation.DOWN){
			return new LocalPoint(new Point(1,0), new Point(1,1), new Point(1,2), new Point(0,2));
		}else {
			return new LocalPoint(new Point(0,0), new Point(1,0), new Point(2,0), new Point(2,1));
		}
	}

	/**
	 * Changes the rotation of the piece
	 * @return Returns a new piece of the new rotation.
	 */
	@Override
	public Piece Rotate() {
		if(super.my_rotation == Rotation.UP){
			return new LPiece(super.my_location, Rotation.RIGHT);
		} else if(super.my_rotation == Rotation.RIGHT){
			return new LPiece(super.my_location, Rotation.DOWN);
		} else if(super.my_rotation == Rotation.DOWN){
			return new LPiece(super.my_location, Rotation.LEFT);
		} else if(super.my_rotation == Rotation.LEFT){
			return new LPiece(super.my_location, Rotation.UP);
		}
		return null;//TODO fix 
	}

}
