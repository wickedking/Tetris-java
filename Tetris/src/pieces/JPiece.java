package pieces;

import java.awt.Point;

public class JPiece extends Piece{

	public JPiece(Point the_location, Rotation the_rotation) {
		super(PieceName.J, the_location, the_rotation, constructPiece(the_rotation));
		// TODO Auto-generated constructor stub
	}
	
	private static LocalPoint constructPiece(Rotation the_rotation){
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
