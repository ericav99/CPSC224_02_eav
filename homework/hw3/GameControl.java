
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
public class GameControl extends JPanel {
    

    
    public final int boxWidth = 400;
    public final int boxHeight = 100;
    private JButton newGameButt; // = new JButton("New Game");
    private JButton resetButt; //  = new JButton("Reset");
    private JButton exitButt; //  = new JButton("Exit");



    public GameControl()
    {
        setSize(boxWidth, boxHeight);
        //setDefaultCloseOperation(JPanel.EXIT_ON_CLOSE);
        buildPanel();
        setVisible(true);
    }

    public void buildPanel()
    {
        newGameButt = new JButton("New Game");
        resetButt  = new JButton("Reset");
        exitButt  = new JButton("Exit");
        add(newGameButt);
        add(resetButt);
        add(exitButt);
        
    }

}
