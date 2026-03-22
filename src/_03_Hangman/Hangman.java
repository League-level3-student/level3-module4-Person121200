package _03_Hangman;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Hangman implements KeyListener, ActionListener {
	Stack<String> stack = new Stack<String>(); 
	String input = "";
	JPanel panel;
	JLabel label;
	JPanel seperator;
	char getCode;
	JPanel gameOver;
	JButton restart;
	JButton quit;
	JLabel lives;
	String word = "";
	int check;
	int life = 6;
	
	ArrayList<JLabel> labels = new ArrayList<JLabel>();
	JFrame frame = new JFrame();

	Hangman(){
		setup();
	}
	public static void main(String[] args) {
		Hangman hang = new Hangman();

	}
	public void setup() {
		panel = new JPanel();
		restart = new JButton("Play Again");
		quit = new JButton("Leave");
		gameOver = new JPanel();
		gameOver.add(quit);
		gameOver.add(restart);
		seperator = new JPanel();
		restart.addActionListener(this);
		quit.addActionListener(this);
		lives = new JLabel("Lives = " + life);
		frame.add(panel);
		frame.addKeyListener(this);
		panel.add(lives);
		panel.add(seperator);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		numberGetter();
		stackPopper();
		frame.pack();
		System.out.println(word);

	}
	public void numberGetter() {
		input = JOptionPane.showInputDialog("Enter a number: ");
		int number = Integer.parseInt(input);
		for(int i = 0; i<number; i++) {
			if(stack.contains(Utilities.readRandomLineFromFile("dictionary.txt")) == false) {
				stack.push(Utilities.readRandomLineFromFile("dictionary.txt"));
			
			}
		}

	}
	public void stackPopper() {
		word = stack.pop();
		for(int i = 0; i<word.length(); i++) {
			label = new JLabel("___");
			labels.add(label);
			panel.add(label);
			
		}
	}
	@Override
	public void keyPressed(KeyEvent arg0) {
		check = 0;
		getCode = arg0.getKeyChar();
		for(int i = 0; i<word.length(); i++) {
			if(getCode == word.charAt(i)) {
				labels.get(i).setText(getCode + " ");
				
			}
			
		

			
		}
		if(word.indexOf(getCode) == -1) {
			life-=1;
			lives.setText("Lives = " + life);
		}
		if(life ==0) {
			frame.remove(panel);
			frame.add(gameOver);
		}
		for(int i = 0; i<labels.size(); i++) {
			
			if(labels.get(i).getText() != "___") {
				check+=1;
			}
			
		}
		if(check ==word.length()) {
			frame.remove(panel);
			frame.add(gameOver);
			JOptionPane.showMessageDialog(frame, "YOU WON!!!");
		}

	}
	public void reset() {
		life =6;
		labels.clear();
		frame.remove(gameOver);
		setup();
	}
	
	@Override
	public void keyReleased(KeyEvent arg0) {
		
	}
	@Override
	public void keyTyped(KeyEvent arg0) {
		
		
	}
	@Override
	public void actionPerformed(ActionEvent arg0) {
		if(arg0.getSource() == restart) {
			
			reset();
		}
		if(arg0.getSource() == quit) {
			frame.dispose();
		}
	}

}
