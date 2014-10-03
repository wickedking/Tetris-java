package pieces;

import java.awt.Point;

public class LPiece extends Piece{

	public LPiece(Point the_location, Rotation the_rotation) {
		super(PieceName.L, the_location, the_rotation, constructPiece());
		constructPiece();
		// TODO Auto-generated constructor stub
	}
	
	private static LocalPoint constructPiece(){
		return null;
	}

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
