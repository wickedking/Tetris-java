package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.Timer;
import javax.swing.JFrame;

import board.Board;

/**
 * The frame and key / mouse event handler for the program. 
 * @author cody
 *
 */
public class GUI {

	/**
	 * A reference to the Frame.
	 */
	JFrame frame;

	/**
	 * A reference to the game board_panel.
	 */
	BoardPanel board_panel;

	/**
	 * A reference to the game board.
	 */
	Board board;

	/**
	 * A reference to a timer. 
	 */
	Timer timer;

	/**
	 * Default no-args constructor. Setups up the game, but does not run it. 
	 */
	public GUI(){
		frame = new JFrame();
		board = new Board();
		board_panel = new BoardPanel(board);
		timer = new Timer(1000, new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {
				board.movePieceDown();
				board_panel.repaint();
				//System.out.println(board.currentPiece.my_location);
			}
		});

		frame.addKeyListener(new KeyListener(){

			@Override
			public void keyPressed(KeyEvent arg0) {
				// TODO Auto-generated method stub
				//nothing
			}

			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				//nothing
			}

			@Override
			public void keyTyped(KeyEvent e) {
				if(e.getKeyChar() == KeyEvent.VK_4){
					//System.out.println("Left");
					board.movePieceLeft();
				} else if(e.getKeyChar() == KeyEvent.VK_6){
					board.movePieceRight();
					//System.out.println("right");
				} else if(e.getKeyChar() == KeyEvent.VK_2){
					board.movePieceDown();
					//System.out.println("down");
				} else if(e.getKeyChar() == KeyEvent.VK_5) {
					board.rotate();
				} else if(e.getKeyChar() == KeyEvent.VK_0){
					board.fallPiece();
				}
				board_panel.repaint();
			}

		});
		
		
	}

	/**
	 * Starts up the game. 
	 */
	public void start(){
		JMenuBar menubar = new JMenuBar();
		JMenu file = new JMenu("File");
		file.setMnemonic(KeyEvent.VK_F);
		JMenuItem newgame = new JMenuItem("New Game");
		JMenuItem exit = new JMenuItem("Exit");
		file.add(newgame);
		file.add(exit);
		menubar.add(file);
		frame.setJMenuBar(menubar);
		
		frame.setSize(400, 600);
		frame.add(board_panel);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setVisible(true);
		timer.start();

	}

}
