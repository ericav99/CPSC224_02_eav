
import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author eric.av
 */
public class PlayerOrg extends JPanel{
    public Player player1;
    public Player player2;
    
    public PlayerOrg()
    {
        player1 = new Player("Player 1 (Die1)", "Player 1");
        player2 = new Player("Player 2 (Die2)", "Player 2");
        add(player1);
        add(player2);
        setVisible(true);
        //add(player1,BorderLayout.WEST);
        //add(player2, BorderLayout.EAST);
    }
    
}
