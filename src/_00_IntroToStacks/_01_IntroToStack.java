package _00_IntroToStacks;

import java.util.ArrayList;
import java.util.Random;
import java.util.Stack;

import javax.swing.JOptionPane;

public class _01_IntroToStack {
    public static void main(String[] args) {
    	double temp = 0.0;
    	String total = "";
    	ArrayList<Double> list = new ArrayList<Double>(); 
        // 1. Create a Stack of Doubles
        //    Don't forget to import the Stack class
    	Stack<Double>  doubles = new Stack<Double>();
    	Random rand = new Random();
        // 2. Use a loop to push 100 random doubles between 0 and 100 to the Stack.
    	for(int i =0; i<100; i++) {
    		doubles.push(0 + (100 - 0) * rand.nextDouble());
    	}
        // 3. Ask the user to enter in two numbers between 0 and 100, inclusive. 
    	JOptionPane.showMessageDialog(null, "Enter 2 numbers between 0 and 100, inclusive");
    	String number1 = JOptionPane.showInputDialog("Input 1st Number: ");
    	String number2 = JOptionPane.showInputDialog("Input 2nd Number: ");
    	int number1Int = Integer.parseInt(number1);
    	int number2Int = Integer.parseInt(number2);
    	if(number1Int > 100 || number2Int > 100) {
    		JOptionPane.showMessageDialog(null, "Numbers exceeded 100.");
    		System.exit(0);
    	}
    	if(number1Int <0 || number2Int <0) {
    		JOptionPane.showMessageDialog(null, "Numbers below 0");
    		System.exit(0);

    	}
    	else {
    		JOptionPane.showMessageDialog(null, "Popping elements off stack between: " + number1Int + " and "+ number2Int);
    		for(int i = 0; i<doubles.size(); i++) {
    			temp = doubles.pop();
    			if(temp>number1Int && temp<number2Int) {
    				list.add(temp);
    			}
    		}
    		for(int i = 0; i<list.size(); i++) {
    			total += list.get(i);
    			total += '\n';

    		}
			JOptionPane.showMessageDialog(null, "Popped: " + total + " off stack!");


    	}
    	
        // 4. Pop all the elements off of the Stack. Every time a double is popped that is
        //    between the two numbers entered by the user, print it to the screen.


        // EXAMPLE:
        // NUM 1: 65
        // NUM 2: 75

        // Popping elements off stack...
        // Elements between 65 and 75:
        // 66.66876846
        // 74.51651681
        // 70.05110654
        // 69.21350456
        // 71.54506465
        // 66.47984807
        // 74.12121224
    }
}

