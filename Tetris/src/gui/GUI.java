package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
