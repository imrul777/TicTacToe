import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
class Gaming {
    public static void main(String[] args) {
        
     TicTacToe ttt = new TicTacToe();
    }
}


class TicTacToe implements ActionListener{

	Random random = new Random();
	JFrame frame = new JFrame();
	JPanel title_panel = new JPanel();
	JPanel button_panel = new JPanel();
	JPanel winButton=new JPanel();
	JLabel textfield = new JLabel();
	JButton[] buttons = new JButton[9];
	boolean player1_turn;
    JButton resetButton = new JButton("Reset");
	
JLabel xWinsLabel;
JLabel oWinsLabel;
JLabel drawLabel;
int xWinCount = 0;
int oWinCount = 0;
int drawcount=0;	
void new_game(){
		button_panel.setLayout(new GridLayout(3,3));
		button_panel.setBackground(Color.DARK_GRAY);

		
		
		for(int i=0;i<9;i++) {
			buttons[i] = new JButton();
			button_panel.add(buttons[i]);
			buttons[i].setFont(new Font("MV Boli",Font.BOLD,140));
			buttons[i].setFocusable(false);
			buttons[i].addActionListener(this);
		}
	}

	public TicTacToe() {
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(800, 800);
		frame.getContentPane().setBackground(Color.CYAN);
		frame.setLayout(new BorderLayout());
		frame.setVisible(true);
	
		textfield.setBackground(new Color(25, 125, 175));
		textfield.setForeground(Color.GREEN);
		textfield.setFont(new Font("Ink Free", Font.ITALIC, 75));
		textfield.setHorizontalAlignment(JLabel.CENTER);
		textfield.setText("Tic-Tac-Toe");
		textfield.setOpaque(true);
	
		title_panel.setLayout(new BorderLayout());
		title_panel.setBounds(0, 0, 800, 100);
	    new_game();
		
        JButton resetButton = new JButton();
		resetButton.setFont(new Font("Ink Free", Font.BOLD, 36)); 
		resetButton.setText("Reset");
		
		//ADD COLOR TO RESET BUTTON
		resetButton.setPreferredSize(new Dimension(300, 85)); // set preferred size


resetButton.setBackground(new Color(25, 125, 175)); 
resetButton.setForeground(new Color(20, 150, 40)); 
resetButton.setOpaque(true); 


		resetButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				reset();
			}
		});

		title_panel.add(resetButton, BorderLayout.WEST);
		title_panel.add(textfield, BorderLayout.CENTER);
		title_panel.setBackground(Color.RED);
		title_panel.setForeground(Color.RED);
		
		frame.add(title_panel, BorderLayout.NORTH);
		frame.add(button_panel);
     //

xWinsLabel = new JLabel("X Wins: 0");
oWinsLabel = new JLabel("O Wins: 0");
drawLabel=new JLabel("Draw: 0");

JPanel winCountPanel = new JPanel();
winCountPanel.setLayout(new GridLayout(3, 1));

winCountPanel.add(xWinsLabel);
xWinsLabel.setForeground(Color.BLACK); // set the text color to red
xWinsLabel.setBackground(new Color(200, 25, 80)); // set the background color to yellow
xWinsLabel.setOpaque(true); 

winCountPanel.add(drawLabel);
drawLabel.setForeground(Color.black); // set the text color to red
drawLabel.setBackground(new Color(65, 150, 75)); // set the background color to yellow
drawLabel.setOpaque(true); 


winCountPanel.add(oWinsLabel);
oWinsLabel.setForeground(Color.black); // set the text color to red
oWinsLabel.setBackground(new Color(31,57,150)); // set the background color to yellow
oWinsLabel.setOpaque(true); 

frame.add(winCountPanel, BorderLayout.EAST);

	
		firstTurn();
		
	}
	

	@Override
	public void actionPerformed(ActionEvent e) {
		
		for(int i=0;i<9;i++) {
			if(e.getSource()==buttons[i]) {
				if(player1_turn) {
					if(buttons[i].getText()=="") {
						buttons[i].setForeground(new Color(255,0,0));
						buttons[i].setText("X");
						player1_turn=false;
						textfield.setText("O turn");
						check();
					}
				}
				else {
					if(buttons[i].getText()=="") {
						buttons[i].setForeground(new Color(0,0,255));
						buttons[i].setText("O");
						player1_turn=true;

						textfield.setText("X turn");
						check();
						
					}
				}
			}			
		}
		
	}
	
	public void firstTurn() {
		
		try {
			Thread.sleep(200);
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
		
		if(random.nextInt(2)==0) {
			player1_turn=true;
			textfield.setText("X turn");
		}
		else {
			player1_turn=false;
			textfield.setText("O turn");
		}
		
	}
	
	public void check() {
		//check X win conditions
		if(
				(buttons[0].getText()=="X") &&
				(buttons[1].getText()=="X") &&
				(buttons[2].getText()=="X")
				) {
			xWins();
		}
		if(
				(buttons[3].getText()=="X") &&
				(buttons[4].getText()=="X") &&
				(buttons[5].getText()=="X")
				) {
			xWins();
		}
		if(
				(buttons[6].getText()=="X") &&
				(buttons[7].getText()=="X") &&
				(buttons[8].getText()=="X")
				) {
			xWins();
		}
		if(
				(buttons[0].getText()=="X") &&
				(buttons[3].getText()=="X") &&
				(buttons[6].getText()=="X")
				) {
			xWins();
		}
		if(
				(buttons[1].getText()=="X") &&
				(buttons[4].getText()=="X") &&
				(buttons[7].getText()=="X")
				) {
			xWins();
		}
		if(
				(buttons[2].getText()=="X") &&
				(buttons[5].getText()=="X") &&
				(buttons[8].getText()=="X")
				) {
			xWins();
		}
		if(
				(buttons[0].getText()=="X") &&
				(buttons[4].getText()=="X") &&
				(buttons[8].getText()=="X")
				) {
			xWins();
		}
		if(
				(buttons[2].getText()=="X") &&
				(buttons[4].getText()=="X") &&
				(buttons[6].getText()=="X")
				) {
			xWins();
		}
		//check O win conditions
		if(
				(buttons[0].getText()=="O") &&
				(buttons[1].getText()=="O") &&
				(buttons[2].getText()=="O")
				) {
			oWins();
		}
		if(
				(buttons[3].getText()=="O") &&
				(buttons[4].getText()=="O") &&
				(buttons[5].getText()=="O")
				) {
			oWins();
		}
		if(
				(buttons[6].getText()=="O") &&
				(buttons[7].getText()=="O") &&
				(buttons[8].getText()=="O")
				) {
			oWins();
		}
		if(
				(buttons[0].getText()=="O") &&
				(buttons[3].getText()=="O") &&
				(buttons[6].getText()=="O")
				) {
			oWins();
		}
		if(
				(buttons[1].getText()=="O") &&
				(buttons[4].getText()=="O") &&
				(buttons[7].getText()=="O")
				) {
			oWins();
		}
		if(
				(buttons[2].getText()=="O") &&
				(buttons[5].getText()=="O") &&
				(buttons[8].getText()=="O")
				) {
			oWins();
		}
		if(
				(buttons[0].getText()=="O") &&
				(buttons[4].getText()=="O") &&
				(buttons[8].getText()=="O")
				) {
			oWins();
		}
		if(
				(buttons[2].getText()=="O") &&
				(buttons[4].getText()=="O") &&
				(buttons[6].getText()=="O")
				) {
			oWins();
		}
		//check draw
		if(     (buttons[0].getText()!="") &&
				(buttons[1].getText()!="") &&
				(buttons[2].getText()!="") &&
				(buttons[3].getText()!="") &&
				(buttons[4].getText()!="") &&
				(buttons[5].getText()!="") &&
				(buttons[6].getText()!="") &&
				(buttons[7].getText()!="") &&
				(buttons[8].getText()!="") 
				
				) {
					
					draw();
					
					}
					
					
					
		
	}
public void draw(){
	for(int i=0;i<9;i++) {
		buttons[i].setEnabled(false);
	}
	textfield.setText("Draw");
	drawcount++;
	drawLabel.setText("Draw: " + drawcount);
}

	
	
	public void xWins() {
		
	
		for(int i=0;i<9;i++) {
			buttons[i].setEnabled(false);
		}
	
		textfield.setText("X wins");
	    xWinCount++;
		xWinsLabel.setText("X Wins: " + xWinCount);
		
	}
	
	

	public void oWins() {
		
		
		for(int i=0;i<9;i++) {
			buttons[i].setEnabled(false);
		}
		textfield.setText("O wins");

		oWinCount++;
		oWinsLabel.setText("O Wins: " + oWinCount);
		
	}





public void reset() {

	
    for (int i = 0; i < 9; i++) {
        buttons[i].setText("");
    }
    
    textfield.setText("Tic-Tac-Toe");
	firstTurn();
	//reset background
	for(int i=0;i<9;i++) {
		buttons[i].setBackground(Color.LIGHT_GRAY);
	}
	//reset buttons
	for(int i=0;i<9;i++) {
		buttons[i].setEnabled(true);

}

}
}




