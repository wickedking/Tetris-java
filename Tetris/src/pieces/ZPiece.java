package pieces;

import java.awt.Point;

/**
 * The instance of the Z Piece. 
 * @author cody
 *
 */
public class ZPiece extends Piece{

	/**
	 * Default constructor that takes 2 params
	 * @param the_location The starting locations of the piece. 
	 * @param the_rotation The current Rotation of the piece. 
	 */
	public ZPiece(Point the_location, Rotation the_rotation) {
		super(PieceName.Z, the_location, the_rotation, constructPiece(the_rotation));
	}
	
	/**
	 * Constructs the individual blocks of the piece according to the rotation. 
	 * @param the_rotation The Current Rotation.
	 * @return An object of Points for each individual blocks based off a grid. 
	 */
	private static LocalPoint constructPiece(Rotation the_rotation){
		if(the_rotation == Rotation.UP){
			return new LocalPoint(new Point(0,1), new Point(1,1), new Point(1,0), new Point(2,0));
		}else{
			return new LocalPoint(new Point(0,0), new Point(0,1), new Point(1,1), new Point(1,2));
		} 
	}

	/**
	 * Changes the rotation of the piece
	 * @return Returns a new piece of the new rotation.
	 */
	@Override
	public Piece Rotate() {
		if(super.my_rotation == Rotation.UP){
			return new ZPiece(super.my_location, Rotation.RIGHT);
		} else{
			return new ZPiece(super.my_location, Rotation.UP);
		}
	}

}
