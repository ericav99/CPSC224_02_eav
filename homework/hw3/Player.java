
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Player extends JPanel{
    
//private JPanel panel;
    public final int boxWidth = 300;
    public final int boxHeight = 200;
    
    public JTextField name;
    private JLabel nameLabel;
    public JLabel winsLabel;
    public JLabel lossesLabel;
    public int wins = 0;
    public int losses = 0;
    
    
    //String playerTitle = "Player 1 (x)";
    
    public Player(String playerTitle, String playerName)
    {
        name = new JTextField(8);
        name.setEditable(true);
        name.setText(playerName);
        setLayout(new GridLayout(4,1));
        setBorder(BorderFactory.createTitledBorder(playerTitle));
        setSize(boxWidth, boxHeight);
        buildPanel();
        setVisible(true);
    }
    
    public void buildPanel()
    {
        nameLabel = new JLabel("Name: ");
        add(nameLabel);
        add(name);
        winsLabel = new JLabel();
        winsLabel.setText("Wins: " + Integer.toString(wins));
        add(winsLabel);
        //add(winsNum);
        lossesLabel = new JLabel();
        lossesLabel.setText("Losses: " + Integer.toString(losses));
        add(lossesLabel);
        //add(lossNum);
    }
}
