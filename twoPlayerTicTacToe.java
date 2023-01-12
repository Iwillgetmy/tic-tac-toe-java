
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class twoPlayerTicTacToe{
	
	static private JFrame frame;
	private JPanel panel;
	private static JButton button1;
	private static JButton button2;
	private static JButton button3;
	private static JButton button4;
	private static JButton button5;
	private static JButton button6;
	private static JButton button7;
	private static JButton button8;
	private static JButton button9;
	private static JButton button10;
	private static JLabel winDeclaration = new JLabel();
	private static JLabel score = new JLabel("Score:");
	private static JLabel outputScoreP1 = new JLabel();
	private static JLabel outputScoreP2 = new JLabel();
	private static JLabel outputScoreTie = new JLabel();
	private static int userDecider; //
	private static int p1Score;
	private static int p2Score;
	private static int tiesTotal;
	private static List<JButton> p1 = new ArrayList<JButton>();
	private static List<JButton> p2 = new ArrayList<JButton>();
	
	public twoPlayerTicTacToe() {
		
		scoreText(score, "Score:", 665, 10);
	    scoreText(outputScoreP1, "P1: " + p1Score, 670, 40);
	    scoreText(outputScoreP2, "P2: " + p2Score, 670, 70);
	    scoreText(outputScoreTie, "Ties: " + tiesTotal, 655, 100);
		
		frame  = new JFrame();
		
		button1 = new JButton();
		button1.setBounds(0,0,200,200);
		
		button2 = new JButton();
		button2.setBounds(200,0,200,200);
		
		button3 = new JButton();
		button3.setBounds(400,0,200,200);
		
		button4 = new JButton();
		button4.setBounds(0,200,200,200);
		
		button5 = new JButton();
		button5.setBounds(200,200,200,200);
		
		button6 = new JButton();
		button6.setBounds(400,200,200,200);
		
		button7 = new JButton();
		button7.setBounds(0,400,200,200);
		
		button8 = new JButton();
		button8.setBounds(200,400,200,200);
		
		button9 = new JButton();
		button9.setBounds(400,400,200,200);
		
		button10 = new JButton("Play Again?");
		button10.setBounds(650, 500, 200, 100);
		button10.setSize(100,20);
		button10.setVisible(false);
		
		panel = new JPanel();
		panel.setLayout(null);
		panel.add(button1);
		panel.add(button2);
		panel.add(button3);
		panel.add(button4);
		panel.add(button5);
		panel.add(button6);
		panel.add(button7);
		panel.add(button8);
		panel.add(button9);
		panel.add(winDeclaration);
		panel.add(outputScoreP1);
		panel.add(outputScoreP2);
		panel.add(outputScoreTie);
		panel.add(button10);
		panel.add(score);
		
		frame.add(panel);
		frame.setSize(800,647);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		
		instantiateButtons(button1);
		
		instantiateButtons(button2);
		
		instantiateButtons(button3);
		
		instantiateButtons(button4);
		
		instantiateButtons(button5);
		
		instantiateButtons(button6);
		
		instantiateButtons(button7);
		
		instantiateButtons(button8);
		
		instantiateButtons(button9);
		
	}
	
	public static void instantiateButtons(JButton button) {
		
		button.addActionListener(new ActionListener(){
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				userDecider+=1;
				button.setBorderPainted(false);
				button.setFocusPainted(false);
				button.setContentAreaFilled(false);
				if(userDecider%2 == 0) {
					button.setText("O");
					p2.add(button);
				} else {
					button.setText("X");
					p1.add(button);
				};
				button.setFont(new Font("Arial", Font.PLAIN, 120));
				button.setForeground(Color.BLACK);
				button.setEnabled(false);	
				checkWinner();
			}
			
		});
		
	}
	
	public static void disableButtons() {
		button1.setEnabled(false);
		button2.setEnabled(false);
		button3.setEnabled(false);
		button4.setEnabled(false);
		button5.setEnabled(false);
		button6.setEnabled(false);
		button7.setEnabled(false);
		button8.setEnabled(false);
		button9.setEnabled(false);
	}
	
	public static void enableButtons() {
		button1.setEnabled(true);
		button2.setEnabled(true);
		button3.setEnabled(true);
		button4.setEnabled(true);
		button5.setEnabled(true);
		button6.setEnabled(true);
		button7.setEnabled(true);
		button8.setEnabled(true);
		button9.setEnabled(true);
	}
	
	public static void checkWinner() {

		List topRow = Arrays.asList(button1, button2, button3);
		List midRow = Arrays.asList(button4, button5, button6);
		List botRow = Arrays.asList(button7, button8, button9);
		List topCol = Arrays.asList(button1, button4, button7);
		List midCol = Arrays.asList(button2, button5, button8);
		List botCol = Arrays.asList(button3, button6, button9);
		List cross1 = Arrays.asList(button1, button5, button9);
		List cross2 = Arrays.asList(button7, button5, button3);

		List<List> winningConditions = new ArrayList<List>();
		winningConditions.add(topRow);
		winningConditions.add(midRow);
		winningConditions.add(botRow);
		winningConditions.add(topCol);
		winningConditions.add(midCol);
		winningConditions.add(botCol);
		winningConditions.add(cross1);
		winningConditions.add(cross2);
		
		if(p1.size()+p2.size()>4) {
			for (List l: winningConditions) {
				if (p1.containsAll(l)) {
					p1Score+=1;
					finishAndRestart("P1 Won!");
					userDecider=0;
					break;
				} else if (p2.containsAll(l)) {
					p2Score+=1;
					finishAndRestart("P2 Won!");
					userDecider=0;
					break;
				} else if (p1.size() + p2.size() == 9) {
					tiesTotal+=1;
					finishAndRestart("You Tied");
					userDecider=0;
				}
			}
		}
	}
	
	public static void scoreText(JLabel label, String abc, int a, int b) {
		label.setText(abc);
	    label.setBounds(a, b, 200, 100);
	    label.setFont(new Font("Verdana", Font.PLAIN, 20));
	}
	
	public static void finishAndRestart(String abc) {
		winDeclaration.setText(abc); 
		winDeclaration.setBounds(650,250, 200, 100);
	    winDeclaration.setFont(new Font("Verdana", Font.PLAIN, 20));
	    scoreText(score, "Score:", 665, 10);
	    scoreText(outputScoreP1, "P1: " + p1Score, 670, 40);
	    scoreText(outputScoreP2, "P2: " + p2Score, 670, 70);
	    scoreText(outputScoreTie, "Ties: " + (tiesTotal/8), 655, 100);
		winDeclaration.setVisible(true);
	    button10.setVisible(true);
	    button10.addActionListener(new ActionListener(){
	    
			@Override
			public void actionPerformed(ActionEvent arg0) {
				enableButtons();
				p1.removeAll(p1);
				p2.removeAll(p2);
				
				resetButtons(button1);
				resetButtons(button2);
				resetButtons(button3);
				resetButtons(button4);
				resetButtons(button5);
				resetButtons(button6);
				resetButtons(button7);
				resetButtons(button8);
				resetButtons(button9);
				button10.setVisible(false);
				winDeclaration.setVisible(false);
				
			}
	    	
	    });
		disableButtons();
	}
	
	public static void resetButtons(JButton button) {
		button.setEnabled(true);	
		button.setText("");
		button.setBorderPainted(true);
		button.setFocusPainted(true);
		button.setContentAreaFilled(true);
	}
	
	
	
	public static void main(String[] args) {
			new twoPlayerTicTacToe();
	}

}