

 /* *****************
 * Homework #3
 * Due Date: 2/24/19
 * Names: Eric Av and Tommy Engels
 * A program that simulates Tic Tac Toe in a GUI
 * comment out package tictactoe from above if not running in NetBeans IDE 8.2
 *******************/
import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.lang.*;

public class TicTacToe extends JFrame {

    public final int boxWidth = 400;
    public final int boxHeight = 100;
    public JPanel buttonPanel;

    public PlayerOrg organization;

    public JButton newGameButt;
    public JButton resetButt;
    public JButton exitButt;
    public JLabel PlayerTurn;

    public Board board;

    private final int WINDOW_WIDTH = 500;
    private final int WINDOW_HEIGHT = 500;
    String nameRetrieve;
    String nameRetrieve2;

    public TicTacToe() {
        setTitle("Tic Tac Toe");
        setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        buildPanel();
        buildButtonPanel();
        add(organization, BorderLayout.NORTH);
        add(board, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);

        setVisible(true);
    }

    public void buildButtonPanel() {
        PlayerTurn = new JLabel("Welcome to Tic Tac Toe!");
        buttonPanel = new JPanel();
        PlayerTurn.setBorder(BorderFactory.createEtchedBorder());

        newGameButt = new JButton("New Game");
        resetButt = new JButton("Reset");
        exitButt = new JButton("Exit");

        newGameButt.addActionListener(new buttonListener());
        resetButt.addActionListener(new buttonListener());
        exitButt.addActionListener(new buttonListener());

        buttonPanel.add(newGameButt);
        buttonPanel.add(resetButt);
        buttonPanel.add(exitButt);
        buttonPanel.add(PlayerTurn);

    }

    private void buildPanel() {
        organization = new PlayerOrg();
        //players = new Player();
        board = new Board();
    }

    public void showTurns() {
        if (board.alternate % 2 == 0) {
            PlayerTurn.setText(nameRetrieve + "'s turn.");
        } else if (board.alternate % 2 != 0) {
            PlayerTurn.setText(nameRetrieve2 + "'s turn.");
        }
    }

    public void setScores() {
        int p1Win = board.getP1Win();
        organization.player1.wins += p1Win;
        organization.player1.winsLabel.setText("Wins: " + p1Win);

        int p1Loss = board.getP1Loss();
        organization.player1.losses += p1Loss;
        organization.player1.lossesLabel.setText("Losses: " + p1Loss);

        int p2Win = board.getP2Win();
        organization.player2.wins += p2Win;
        organization.player2.winsLabel.setText("Wins: " + p2Win);

        int p2Loss = board.getP2Loss();
        organization.player2.losses += p2Loss;
        organization.player2.lossesLabel.setText("Losses: " + p2Loss);
    }

    public void clearScores() {
        board.p1Win = 0;
        board.p2Win = 0;
        board.p1Loss = 0;
        board.p2Loss = 0;
    }

    /*private class buttonListe implements ActionListener
    {
        public void ActionPerformed(ActionListener e)
        {
            nameRetrieve = organization.player1.name.getText();
            System.out.println(nameRetrieve);
            nameRetrieve = organization.player2.name.getText();
        }
    }*/
    private class buttonListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            JButton buttonClicked = (JButton) e.getSource();
            showTurns(); // only works if you click reset and then no to continue playing.
            if (buttonClicked == newGameButt) {
                setScores();
                for (int i = 0; i <= 8; i++) {
                    board.squares[i].setIcon(null);
                }

                nameRetrieve = organization.player1.name.getText();
                //System.out.println(nameRetrieve);
                nameRetrieve2 = organization.player2.name.getText();
                PlayerTurn.setText(nameRetrieve + "'s turn."); // player 1 is shown first
                if (nameRetrieve != "") {
                    organization.player1.name.setEditable(false);
                }
                if (nameRetrieve2 != "") {
                    organization.player2.name.setEditable(false);
                }
                if (nameRetrieve.isEmpty() || nameRetrieve == "        ") {
                    JOptionPane.showMessageDialog(null, "Player 1 name is illegal", "Faliure", JOptionPane.ERROR_MESSAGE);
                }
                if (nameRetrieve2.isEmpty() || nameRetrieve == "        ") {
                    JOptionPane.showMessageDialog(null, "Player 2 name is illegal", "Faliure", JOptionPane.ERROR_MESSAGE);
                }
                JOptionPane.showMessageDialog(null, "New Game (In order to show the next player's turn on the panel click 'reset'->'no' after every turn ");
            } else if (buttonClicked == resetButt) {
                int dialogButton = JOptionPane.YES_NO_OPTION;
                int dialogResult = JOptionPane.showConfirmDialog(null, "This will end the game and set the win/loss stats to 0. Are you sure?", "Warning", dialogButton);
                if (dialogResult == 0) {
                    for (int i = 0; i <= 8; i++) {
                        board.squares[i].setIcon(null);
                        board.clearScores();
                        setScores();
                    }
                    organization.player1.name.setEditable(true);
                    organization.player2.name.setEditable(true);
                    organization.player1.name.setText("Player 1");
                    organization.player2.name.setText("Player 2");
                    PlayerTurn.setText("Welcome to Tic Tac Toe!");
                }
            } else if (buttonClicked == exitButt) {
                System.exit(0);
            }
        }
    }

    public static void main(String[] args) {
        // TODO code application logic here
        new TicTacToe();
    }
}
