package _00_IntroToStacks;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Stack;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class _02_TextUndoRedo implements KeyListener {
    /* 
     * Create a JFrame with a JPanel and a JLabel.
     * 
     * Every time a key is pressed, add that character to the JLabel. It should
     * look like a basic text editor.
     * 
     * Make it so that every time the BACKSPACE key is pressed, the last
     * character is erased from the JLabel.
     * 
     * Save that deleted character onto a Stack of Characters.
     * 
     * Choose a key to be the Undo key. Make it so that when that key is
     * pressed, the top Character is popped  off the Stack and added back to
     * the JLabel.
     */
	_02_TextUndoRedo(){

		setup();
	}
	JPanel panel;
	JFrame frame;
	JLabel label;
	String textHolder = "";
	Stack<Character> undo = new Stack<Character>();
	public static void main(String[] args) {
		
		_02_TextUndoRedo thingy = new _02_TextUndoRedo();

	}
	
	
	
	public void setup() {
		frame = new JFrame();
		panel = new JPanel();
		label = new JLabel();
		frame.add(panel);
		panel.add(label);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.addKeyListener(this);
		frame.pack();
		
	}
	@Override
	public void keyPressed(KeyEvent arg0) {
		// TODO Auto-generated method stub
			//System.out.println(arg0.getKeyChar());


		if(arg0.getKeyCode() != KeyEvent.VK_BACK_SPACE && arg0.getKeyCode() != KeyEvent.VK_ALT) {
			textHolder += arg0.getKeyChar();
			label.setText(textHolder);
			frame.pack();
		}
			
			if(arg0.getKeyCode() == KeyEvent.VK_BACK_SPACE) {
				undo.add(textHolder.charAt(textHolder.length()-1));

				textHolder = textHolder.substring(0, textHolder.length()-1);
				label.setText(textHolder);
			}
			if (arg0.getKeyCode() == KeyEvent.VK_ALT) {
				char check = undo.pop();
				textHolder+=check;
				label.setText(textHolder);
				frame.pack();
			}

		
		
	}
	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}
