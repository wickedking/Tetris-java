package gui;

import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.Timer;
import javax.swing.JFrame;

import board.Board;

public class GUI {

	JFrame frame;

	BoardPanel board_panel;

	Board board;

	Timer timer;

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
				}
				board_panel.repaint();
			}

		});
	}

	public void start(){
		frame.setSize(400, 600);
		frame.add(board_panel);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setVisible(true);
		timer.start();

	}

}
