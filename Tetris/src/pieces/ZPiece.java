package pieces;

import java.awt.Point;

public class ZPiece extends Piece{

	public ZPiece(Point the_location, Rotation the_rotation) {
		super(PieceName.Z, the_location, the_rotation, constructPiece());
		constructPiece();
	}
	
	private static LocalPoint constructPiece(){
		return null;
	}

	@Override
	public Piece Rotate() {
		if(super.my_rotation == Rotation.UP){
			return new ZPiece(super.my_location, Rotation.RIGHT);
		} else if(super.my_rotation == Rotation.RIGHT){
			return new ZPiece(super.my_location, Rotation.DOWN);
		} else if(super.my_rotation == Rotation.DOWN){
			return new ZPiece(super.my_location, Rotation.LEFT);
		} else if(super.my_rotation == Rotation.LEFT){
			return new ZPiece(super.my_location, Rotation.UP);
		}
		return null;//TODO fix 
	}

}
