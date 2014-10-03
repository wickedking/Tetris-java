package pieces;

import java.awt.Point;

/**
 * Abstract class to use for pieces. Use the factory method?
 * @author Cody Shafer
 * @version Summer 2014
 *
 */
public abstract class Piece {
	
	public final PieceName my_name;
	
	public final Point my_location;
	
	public final Rotation my_rotation;
	
	public final Point my_point1;
	public final Point my_point2;
	public final Point my_point3;
	public final Point my_point4;
	
	
	public Piece(PieceName the_name, Point the_location, Rotation the_rotation, LocalPoint the_local){
		my_name = the_name;
		my_location = the_location;
		my_rotation = the_rotation;
		my_point1 = the_local.LOCAL_1;
		my_point2 = the_local.LOCAL_2;
		my_point3 = the_local.LOCAL_3;
		my_point4 = the_local.LOCAL_4; 
	}
	
	//TODO make sure createPiece is the right method.
	public Piece moveDown(){
		return PieceFactory.createPiece(my_name, my_location, my_rotation);
	}
	
	public Piece moveLeft(){
		return PieceFactory.createPiece(my_name, my_location, my_rotation);
	}
	
	public Piece moveRight(){
		return PieceFactory.createPiece(my_name, my_location, my_rotation);
	}
	
	public abstract Piece Rotate();

}
