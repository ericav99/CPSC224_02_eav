
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
public class BoardOrg extends JPanel{
    private Board board;
    private GameControl gc;
    final private int width = 500;
    final private int height = 500;

    
    public BoardOrg()
    {
        setPreferredSize(new Dimension (width, height));
        board = new Board();
        gc = new GameControl();
        add(board,BorderLayout.CENTER);
        add(gc, BorderLayout.SOUTH);
        setVisible(true);
        //add(player1,BorderLayout.WEST);
        //add(player2, BorderLayout.EAST);
    }
    
}
