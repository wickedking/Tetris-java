package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JCheckBoxMenuItem;
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
	private final  JFrame frame;

	/**
	 * A reference to the game board_panel.
	 */
	private final BoardPanel board_panel;

	/**
	 * A reference to the game board.
	 */
	private Board board;

	/**
	 * A reference to a timer. 
	 */
	private final Timer timer;
	
	/**
	 * A check if sound is to be currently played. 
	 */
	private boolean sound;
	
	/**
	 * A check if sound effects are to be played. 
	 */
	private boolean effects;

	/**
	 * Default no-args constructor. Setups up the game, but does not run it. 
	 */
	public GUI(){
		frame = new JFrame();
		board = new Board();
		board_panel = new BoardPanel(board);
		sound = true;
		effects = true;
		timer = new Timer(1000, new ActionListener(){
			
			/**
			 * An override of the Action Performed method.
			 */
			@Override
			public void actionPerformed(final ActionEvent arg0) {
				board.movePieceDown();
				board_panel.repaint();
				//System.out.println(board.currentPiece.my_location);
			}
		});

		frame.addKeyListener(new KeyAdapter(){

			/**
			 * Uses the Keytyped method to determine the key typed.
			 */
			@Override
			public void keyTyped(final KeyEvent e) {
				if(e.getKeyChar() == KeyEvent.VK_4){
					board.movePieceLeft();
				} else if(e.getKeyChar() == KeyEvent.VK_6){
					board.movePieceRight();
				} else if(e.getKeyChar() == KeyEvent.VK_2){
					board.movePieceDown();
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
		createMenu();
		frame.setSize(400, 600);
		frame.add(board_panel);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setVisible(true);
		timer.start();

	}
	
	/**
	 * Creates the menu for the frame. 
	 */
	private void createMenu(){
		final JMenuBar menubar = new JMenuBar();
		final JMenu file = new JMenu("File");
		file.setMnemonic(KeyEvent.VK_F);
		final JMenuItem newgame = new JMenuItem("New Game");
		newgame.setMnemonic(KeyEvent.VK_N);
		final JMenuItem exit = new JMenuItem("Exit");
		exit.setMnemonic(KeyEvent.VK_X);
		exit.addActionListener(new ActionListener(){

			/**
			 * The override of the action performed.
			 */
			@Override
			public void actionPerformed(final ActionEvent e) {
				System.exit(0);				
			}
		});
		file.add(newgame);
		file.add(exit);
		menubar.add(file);
		
		final JMenu settings = new JMenu("Settings");
		settings.setMnemonic(KeyEvent.VK_S);
		final JCheckBoxMenuItem events = new JCheckBoxMenuItem("Music");
		events.setSelected(true);
		events.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(final ActionEvent arg0) {
				sound = events.isSelected();
				
			}
			
		});
		
		final JCheckBoxMenuItem sound_effects = new JCheckBoxMenuItem("Sound Effects");
		sound_effects.setSelected(true);
		sound_effects.addActionListener(new ActionListener(){

			/**
			 * The override of the actionPerformed
			 */
			@Override
			public void actionPerformed(final ActionEvent arg0) {
				effects = sound_effects.isSelected();
				
			}
			
		});
		
		settings.add(events);
		settings.add(sound_effects);
		menubar.add(settings);
		frame.setJMenuBar(menubar);
	}

}
