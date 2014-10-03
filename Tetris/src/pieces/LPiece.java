package pieces;

import java.awt.Point;

public class LPiece extends Piece{

	public LPiece(Point the_location, Rotation the_rotation) {
		super(PieceName.L, the_location, the_rotation, constructPiece(the_rotation));
		// TODO Auto-generated constructor stub
	}
	
	private static LocalPoint constructPiece(Rotation the_rotation){
		if(the_rotation == Rotation.UP){
			return new LocalPoint(new Point(0,0), new Point(0,1), new Point(0,2), new Point(1,0));
		}else if (the_rotation == Rotation.RIGHT){
			return new LocalPoint(new Point(0,0), new Point(0,1), new Point(1,1), new Point(2,10));
		} else if(the_rotation == Rotation.DOWN){
			return new LocalPoint(new Point(2,0), new Point(2,1), new Point(1,1), new Point(1,0));
		}else {
			return new LocalPoint(new Point(0,0), new Point(1,0), new Point(2,0), new Point(2,1));
		}
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
