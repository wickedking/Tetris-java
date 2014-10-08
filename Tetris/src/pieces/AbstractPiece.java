package pieces;

import java.awt.Point;

/**
 * Abstract class to use for pieces. Use the factory method?
 * @author Cody Shafer
 * @version Summer 2014
 *
 */
public abstract class AbstractPiece {
	
	/**
	 * The type of the piece.
	 */
	public final PieceName my_name;
	
	/**
	 * The current location of the piece.
	 */
	public final Point my_location;
	
	/**
	 * The current rotation of the piece.
	 */
	public final Rotation my_rotation;
	
	/**
	 * The first sub point.
	 */
	public final Point my_point1;
	
	/**
	 * The second sub point.
	 */
	public final Point my_point2;
	
	/**
	 * The third sub point.
	 */
	public final Point my_point3;
	
	/**
	 * The fourth sub point.
	 */
	public final Point my_point4;
	
	/**
	 * Basic constructor.
	 * @param the_name The type of the piece.
	 * @param the_location The starting location of the piece.
	 * @param the_rotation The current rotation of the piece.
	 * @param the_local The local coordinates of the sub pieces. 
	 */
	public AbstractPiece(final PieceName the_name, final Point the_location, final Rotation the_rotation, final LocalPoint the_local){
		my_name = the_name;
		my_location = the_location;
		my_rotation = the_rotation;
		my_point1 = the_local.LOCAL_1;
		my_point2 = the_local.LOCAL_2;
		my_point3 = the_local.LOCAL_3;
		my_point4 = the_local.LOCAL_4; 
	}
	
	/**
	 * Rotates the current piece.
	 * @return The rotated piece.
	 */
	public abstract AbstractPiece rotate();

}
