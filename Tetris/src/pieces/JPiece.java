package pieces;

import java.awt.Point;

public class JPiece extends Piece{

	public JPiece(Point the_location, Rotation the_rotation) {
		super(PieceName.J, the_location, the_rotation, constructPiece());
		constructPiece();
		// TODO Auto-generated constructor stub
	}
	
	private static LocalPoint constructPiece(){
		return null;
	}

	@Override
	public Piece Rotate() {
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