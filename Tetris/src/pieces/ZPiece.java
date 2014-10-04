package pieces;

import java.awt.Point;

public class ZPiece extends Piece{

	public ZPiece(Point the_location, Rotation the_rotation) {
		super(PieceName.Z, the_location, the_rotation, constructPiece(the_rotation));
	}
	
	private static LocalPoint constructPiece(Rotation the_rotation){
		if(the_rotation == Rotation.UP){
			return new LocalPoint(new Point(0,1), new Point(1,1), new Point(1,0), new Point(2,0));
		}else{
			return new LocalPoint(new Point(0,0), new Point(0,1), new Point(1,1), new Point(1,2));
		} 
	}

	@Override
	public Piece Rotate() {
		if(super.my_rotation == Rotation.UP){
			return new ZPiece(super.my_location, Rotation.RIGHT);
		} else{
			return new ZPiece(super.my_location, Rotation.UP);
		}
	}

}
