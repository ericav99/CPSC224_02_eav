

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Board extends JPanel {

    public TicTacToe one;
    public JButton squares[];
    int alternate = 0;
    public int p1Win = 0;
    public int p1Loss = 0;
    public int p2Win = 0;
    public int p2Loss = 0;
    int counter = 0;
    ImageIcon Die1 = new ImageIcon("Die1.png");
    ImageIcon Die2 = new ImageIcon("Die2.png");
    public Board() {

        squares = new JButton[9];
        setLayout(new GridLayout(3, 3));
        buildPanel();
        setVisible(true);
    }

    public void buildPanel() {

        for (int i = 0; i < 9; i++) {
            squares[i] = new JButton();
            squares[i].setFont(getFont().deriveFont(Font.BOLD, 24));
            squares[i].setIcon(null);
            //squares[i].setText("");
            squares[i].addActionListener(new buttonListener());
            add(squares[i]);
        }
    }

    public class buttonListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            JButton buttonClicked = (JButton) e.getSource(); //get the particular button that was clicked
            if (alternate % 2 == 0) {
                if (buttonClicked.getIcon() == null) {
                    buttonClicked.setIcon(Die1);
                    alternate++;
                    winCheck(counter);
                }
            } else {
                if (buttonClicked.getIcon() == null) {
                    buttonClicked.setIcon(Die2);
                    alternate++;
                    winCheck(counter);
                }
            }

        }
    }

    public boolean winCheck(int counter) {
        /*
          0 1 2
          3 4 5
          6 7 8
         */
        for (int i = 0; i < 9; i++) {
            if (squares[i].getIcon() != null) {
                counter++;
            }
            if (counter == 9) {
                JOptionPane.showMessageDialog(null, "Tie Game!");
                return false;
            }
        }
        if (squares[0].getIcon() == Die1 && squares[1].getIcon() == Die1 && squares[2].getIcon() == Die1) {
            JOptionPane.showMessageDialog(null, "Player 1 Won! Click New Game to update scores.");
            p1Win += 1;
            p2Loss += 1;
            return true;

            //somehow increase the player 2's wins val and increase player 1's loss val
        } else if (squares[3].getIcon() == Die1 && squares[4].getIcon() == Die1 && squares[5].getIcon() == Die1) {
            JOptionPane.showMessageDialog(null, "Player 1 Won! Click New Game to update scores.");
            p1Win += 1;
            p2Loss += 1;
            return true;
        } else if (squares[6].getIcon() == Die1 && squares[7].getIcon() == Die1 && squares[8].getIcon() == Die1) {
            JOptionPane.showMessageDialog(null, "Player 1 Won! Click New Game to update scores.");
            p1Win += 1;
            p2Loss += 1;
            return true;
        } else if (squares[0].getIcon() == Die1 && squares[3].getIcon() == Die1 && squares[6].getIcon() == Die1) {
            JOptionPane.showMessageDialog(null, "Player 1 Won! Click New Game to update scores.");
            p1Win += 1;
            p2Loss += 1;
            return true;
        } else if (squares[1].getIcon() == Die1 && squares[4].getIcon() == Die1 && squares[7].getIcon() == Die1) {
            JOptionPane.showMessageDialog(null, "Player 1 Won! Click New Game to update scores.");
            p1Win += 1;
            p2Loss += 1;
            return true;
        } else if (squares[2].getIcon() == Die1 && squares[5].getIcon() == Die1 && squares[8].getIcon() == Die1) {
            JOptionPane.showMessageDialog(null, "Player 1 Won! Click New Game to update scores.");
            p1Win += 1;
            p2Loss += 1;
            return true;
        } else if (squares[0].getIcon() == Die1 && squares[4].getIcon() == Die1 && squares[8].getIcon() == Die1) {
            JOptionPane.showMessageDialog(null, "Player 1 Won! Click New Game to update scores.");
            p1Win += 1;
            p2Loss += 1;
            return true;
        } else if (squares[2].getIcon() == Die1 && squares[4].getIcon() == Die1 && squares[6].getIcon() == Die1) {
            JOptionPane.showMessageDialog(null, "Player 1 Won! Click New Game to update scores.");
            p1Win += 1;
            p2Loss += 1;
            return true;
        } else if (squares[0].getIcon() == Die2 && squares[1].getIcon() == Die2 && squares[2].getIcon() == Die2) {
            JOptionPane.showMessageDialog(null, "Player 2 Won! Click New Game to update scores.");
            p2Win += 1;
            p1Loss += 1;
            return true;
            //somehow increase the player 2's wins val and increase player 1's loss val
        } else if (squares[3].getIcon() == Die2 && squares[4].getIcon() == Die2 && squares[5].getIcon() == Die2) {
            JOptionPane.showMessageDialog(null, "Player 2 Won! Click New Game to update scores.");
            p2Win += 1;
            p1Loss += 1;
            return true;
        } else if (squares[6].getIcon() == Die2 && squares[7].getIcon() == Die2 && squares[8].getIcon() == Die2) {
            JOptionPane.showMessageDialog(null, "Player 2 Won! Click New Game to update scores.");
            p2Win += 1;
            p1Loss += 1;
            return true;
        } else if (squares[0].getIcon() == Die2 && squares[3].getIcon() == Die2 && squares[6].getIcon() == Die2) {
            JOptionPane.showMessageDialog(null, "Player 2 Won! Click New Game to update scores.");
            return true;
        } else if (squares[1].getIcon() == Die2 && squares[4].getIcon() == Die2 && squares[7].getIcon() == Die2) {
            JOptionPane.showMessageDialog(null, "Player 2 Won! Click New Game to update scores.");
            p2Win += 1;
            p1Loss += 1;
            return true;
        } else if (squares[2].getIcon() == Die2 && squares[5].getIcon() == Die2 && squares[8].getIcon() == Die2) {
            JOptionPane.showMessageDialog(null, "Player 2 Won! Click New Game to update scores.");
            p2Win += 1;
            p1Loss += 1;
            return true;
        } else if (squares[0].getIcon() == Die2 && squares[4].getIcon() == Die2 && squares[8].getIcon() == Die2) {
            JOptionPane.showMessageDialog(null, "Player 2 Won! Click New Game to update scores.");
            p2Win += 1;
            p1Loss += 1;
            return true;
        } else if (squares[2].getIcon() == Die2 && squares[4].getIcon() == Die2 && squares[6].getIcon() == Die2) {
            JOptionPane.showMessageDialog(null, "Player 2 Won! Click New Game to update scores.");
            p2Win += 1;
            p1Loss += 1;
            return true;
        } else {
            return false;
        }

        //return false;
    }

    public int getP1Win() {
        return p1Win;
    }

    public int getP2Win() {
        return p2Win;
    }

    public int getP1Loss() {
        return p1Loss;
    }

    public int getP2Loss() {
        return p2Loss;
    }
    
    public void clearScores() {
       p1Win = 0;
       p2Win = 0;
       p1Loss = 0;
       p2Loss = 0;
    }

}
