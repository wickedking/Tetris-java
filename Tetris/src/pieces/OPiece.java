package pieces;

import java.awt.Point;

public class OPiece extends Piece{

	public OPiece(Point the_location, Rotation the_rotation) {
		super(PieceName.O, the_location, the_rotation, constructPiece());
		constructPiece();
		// TODO Auto-generated constructor stub
	}
	
	private static LocalPoint constructPiece(){
		return new LocalPoint(new Point(0,0), new Point(0,1), new Point(1,1), new Point(1,0));
	}

	@Override
	public Piece Rotate() {
		return this;
	}

}
