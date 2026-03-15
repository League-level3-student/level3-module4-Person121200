package _03_Hangman;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Hangman implements KeyListener {
	Stack<String> stack = new Stack<String>(); 
	String input = "";
	JFrame frame;
	JPanel panel;
	JLabel label;
	JLabel lives;
	String word = "";
	int life = 6;
	
	ArrayList<JLabel> labels = new ArrayList<JLabel>();

	Hangman(){
		setup();
	}
	public static void main(String[] args) {
		Hangman hang = new Hangman();

	}
	public void setup() {
		frame = new JFrame();
		panel = new JPanel();
		lives = new JLabel("Lives = " + life);
		frame.add(panel);
		panel.addKeyListener(this);
		panel.add(lives);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		input = JOptionPane.showInputDialog("Enter a number: ");
		int number = Integer.parseInt(input);
		for(int i = 0; i<number; i++) {
			if(stack.contains(Utilities.readRandomLineFromFile("dictionary.txt")) == false) {
				stack.push(Utilities.readRandomLineFromFile("dictionary.txt"));
			
			}
		}
		word = stack.pop();
		for(int i = 0; i<word.length(); i++) {
			label = new JLabel("___");
			labels.add(label);
			panel.add(label);
			
		}
		frame.pack();

	}
	@Override
	public void keyPressed(KeyEvent arg0) {
		for(int i = 0; i<word.length(); i++) {
			if(arg0.getKeyChar() == word.charAt(i)) {
				//replace labels of __ with the letter pressed
			}
			else {
				life-=1;
				lives.setText("Lives = " + life);
			}
			

		}
	}
	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void keyTyped(KeyEvent arg0) {

		
	}

}
