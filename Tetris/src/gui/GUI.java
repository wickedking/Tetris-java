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
				System.out.println(e.getKeyChar());
				if(e.getKeyChar() == KeyEvent.VK_4){
					System.out.println("Left");
					if(board.boundsCheck(new Point(board.currentPiece.my_location.x - 1, board.currentPiece.my_location.y), board.currentPiece.my_point1, board.currentPiece.my_point2, board.currentPiece.my_point3, board.currentPiece.my_point4)){
						board.movePieceLeft();
					}
				} else if(e.getKeyChar() == KeyEvent.VK_6){
					if(board.boundsCheck(new Point(board.currentPiece.my_location.x + 1, board.currentPiece.my_location.y), board.currentPiece.my_point1, board.currentPiece.my_point2, board.currentPiece.my_point3, board.currentPiece.my_point4)){
						board.movePieceRight();
					}
					System.out.println("right");
				} else if(e.getKeyChar() == KeyEvent.VK_2){
					board.movePieceDown();
					System.out.println("down");
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
