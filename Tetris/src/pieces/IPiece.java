package pieces;

import java.awt.Point;

public class IPiece extends Piece{

	public IPiece(Point the_location, Rotation the_rotation) {
		super(PieceName.I, the_location, the_rotation, constructPiece(the_rotation));
		// TODO Auto-generated constructor stub
	}
	
	private static LocalPoint constructPiece(Rotation the_rotation){
		if(the_rotation == Rotation.UP){
			return new LocalPoint(new Point(0,0), new Point(0, 1), new Point(0,2), new Point(0,3));
		} else {
			return new LocalPoint(new Point(0,0), new Point(1,0), new Point(2,0), new Point(3,0));
		}
	}

	@Override
	public Piece Rotate() {
		if(super.my_rotation == Rotation.UP){
			return new IPiece(super.my_location, Rotation.RIGHT);
		} else{
			return new IPiece(super.my_location, Rotation.UP);
		}
	}

}
