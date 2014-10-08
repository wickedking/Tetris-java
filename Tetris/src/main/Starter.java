package main;

import gui.GUI;

/**
 * Class to start the game.
 * @author Cody
 *
 */
public final class Starter {
	
	/**
	 * Private constructor to prevent instantiation
	 */
	private Starter(){
		
	}
	
	/**
	 * Basic main method.
	 * @param the_args Not used.
	 */
	public static void main(final String[] the_args){
		final GUI gui = new GUI();
		gui.start();
	}

}
