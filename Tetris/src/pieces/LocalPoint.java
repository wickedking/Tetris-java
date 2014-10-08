package pieces;

import java.awt.Point;

/**
 * A basic object to hold the sub points.
 * @author Cody
 *
 */
public class LocalPoint {
	
	/**
	 * The first sub piece point.
	 */
	public final Point LOCAL_1;
	
	/**
	 * The second sub piece point.
	 */
	public final Point LOCAL_2;
	
	/**
	 * The third sub piece point.
	 */
	public final Point LOCAL_3;
	
	/**
	 * The fourth sub piece point.
	 */
	public final Point LOCAL_4;
	
	/**
	 * Default constructor
	 * @param first The first sub piece point
	 * @param second The second sub piece point
	 * @param third The third sub piece point
	 * @param fourth The fourth sub piece point
	 */
	public LocalPoint(final Point first, final Point second, final Point third, final Point fourth){
		LOCAL_1 = first;
		LOCAL_2 = second;
		LOCAL_3 = third;
		LOCAL_4 = fourth;
	}

}
