
import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.Font;
import java.awt.event.*;


public class Board extends JPanel
{
    
    private JPanel boardPanel;
    public JButton squares[];
    public int alternate = 0;
    //private JButton [][] field;

    public Board()
    {
        squares = new JButton[9];
        
        setLayout(new GridLayout(3,3));//100,100));//, 100, 100));
        buildPanel();
  
        setVisible(true);
    }
    
    public void buildPanel()
    {
        for(int i = 0; i < 9; i++)
        {
            //Font font1 = new Font("SansSerif", Font.BOLD, 24);
            //setFont(new Font("SansSerif", Font.BOLD, 24));
            squares[i] = new JButton();
            //setFont(font1);
            //squares[i].setText("");
            squares[i].setFont(getFont().deriveFont(Font.BOLD,24));
            squares[i].setText("");
            squares[i].addActionListener(new ButtonListener());
            add(squares[i]);
        }
    }
    private class ButtonListener implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            JButton squareClicked = (JButton)e.getSource();
            
            if(alternate%2 == 0) //
            {
                squareClicked.setText("X");
                winCheck();
            }
            else
            {
                squareClicked.setText("O");
                winCheck();
            }
            
            alternate++;
        }
    }
    
    
    public boolean winCheck()
    {
        /*
          0 1 2
          3 4 5
          6 7 8
         */
        if(squares[0].getText() == "X" && squares[1].getText() == "X" && squares[2].getText() == "X")
        {
            JOptionPane.showMessageDialog(null,"Player 1 Won!");
            return true;
            //somehow increase the player 2's wins val and increase player 1's loss val
        }
        else if( squares[3].getText() == "X" && squares[4].getText() == "X" && squares[5].getText() == "X")
        {
            JOptionPane.showMessageDialog(null,"Player 1 Won!");
            return true;
        }
        else if(squares[6].getText() == "X" && squares[7].getText() == "X" && squares[8].getText() == "X")
        {
            JOptionPane.showMessageDialog(null,"Player 1 Won!");
            return true;
        }
        else if(squares[0].getText() == "X" && squares[3].getText() == "X" && squares[6].getText() == "X")
        {
            JOptionPane.showMessageDialog(null,"Player 1 Won!");
            return true;
        }
        else if(squares[1].getText() == "X" && squares[4].getText() == "X" && squares[7].getText() == "X")
        {
            JOptionPane.showMessageDialog(null,"Player 1 Won!");
            return true;
        }
        
        else if(squares[2].getText() == "X" && squares[5].getText() == "X" && squares[8].getText() == "X")
        {
            JOptionPane.showMessageDialog(null,"Player 1 Won!");
            return true;
        }
        else if(squares[0].getText() == "X" && squares[4].getText() == "X" && squares[8].getText() == "X")
        {
            JOptionPane.showMessageDialog(null,"Player 1 Won!");
            return true;
        }
        else if(squares[2].getText() == "X" && squares[4].getText() == "X" && squares[6].getText() == "X")
        {
            JOptionPane.showMessageDialog(null,"Player 1 Won!");
            return true;
        }
        else if(squares[0].getText() == "O" && squares[1].getText() == "O" && squares[2].getText() == "O")
        {
            JOptionPane.showMessageDialog(null,"Player 2 Won!");
            return true;
            //somehow increase the player 2's wins val and increase player 1's loss val
        }
        else if( squares[3].getText() == "O" && squares[4].getText() == "O" && squares[5].getText() == "O")
        {
            JOptionPane.showMessageDialog(null,"Player 2 Won!");
            return true;
        }
        else if(squares[6].getText() == "O" && squares[7].getText() == "O" && squares[8].getText() == "O")
        {
            JOptionPane.showMessageDialog(null,"Player 2 Won!");
            return true;
        }
        else if(squares[0].getText() == "O" && squares[3].getText() == "O" && squares[6].getText() == "O")
        {
            JOptionPane.showMessageDialog(null,"Player 2 Won!");
            return true;
        }
        else if(squares[1].getText() == "O" && squares[4].getText() == "O" && squares[7].getText() == "O")
        {
            JOptionPane.showMessageDialog(null,"Player 2 Won!");
            return true;
        }
        
        else if(squares[2].getText() == "O" && squares[5].getText() == "O" && squares[8].getText() == "O")
        {
            JOptionPane.showMessageDialog(null,"Player 2 Won!");
            return true;
        }
        else if(squares[0].getText() == "O" && squares[4].getText() == "O" && squares[8].getText() == "0")
        {
            JOptionPane.showMessageDialog(null,"Player 2 Won!");
            return true;
        }
        else if(squares[2].getText() == "O" && squares[4].getText() == "O" && squares[6].getText() == "O")
        {
            JOptionPane.showMessageDialog(null,"Player 2 Won!");
            return true;
        }
        else
        {
            return false;
        }
        
        //return false;
        
        
    }
    
    
    
    
     
}
