import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.NumberFormat;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import java.awt.Color;
import java.awt.Font;
import java.io.*;
import java.util.*;

public class WelcomeScreen extends JFrame implements ActionListener{

   private static JLabel label;
   private static JButton playButton;
   private static JButton quitButton;
   
   public WelcomeScreen(){
   
      label = new JLabel("Welcome to Would You Rather");
      GridBagConstraints g = new GridBagConstraints();
      setLayout(new GridBagLayout());
      g.insets = new Insets(10 , 10 , 1 , 0);
      g.fill = GridBagConstraints.LINE_END;
      g.gridx = 0;
      g.gridy = 0;
      label.setFont(new Font("Serif" , 1 ,60));
      add(label , g);
      
      playButton = new JButton("PLAY AT YOUR OWN RISK");
      playButton.addActionListener(this);
      GridBagConstraints k = new GridBagConstraints();
      k.insets = new Insets(0 , 5 , 10 , 10);
      k.fill = GridBagConstraints.HORIZONTAL;
      k.gridx = 0;
      k.gridy = 2;
      add(playButton , k);
      
      quitButton = new JButton("QUIT");
      quitButton.addActionListener(this);
      GridBagConstraints p = new GridBagConstraints();
      p.insets = new Insets(0 , 5 , 10 , 10);
      p.fill = GridBagConstraints.HORIZONTAL;
      p.gridx = 0;
      p.gridy = 3;
      add(quitButton , p);
   }
   
   @Override
   public void actionPerformed(ActionEvent e){
      JButton sourceEvent = (JButton) e.getSource();
      if(sourceEvent == quitButton){
         dispose();
      }
      else if(sourceEvent == playButton){
         
         GamePlay playGame = new GamePlay();
         playGame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         playGame.pack();
         playGame.setVisible(true);

      }
   }
      
   public static void main(String[] args){
   
      WelcomeScreen playScreen = new WelcomeScreen();
      
      JLabel intro = new JLabel("Choose an option to either play or leave the game.");
      intro.setFont(new Font("Serif" , 0 , 25));
      GridBagConstraints size = new GridBagConstraints();
      size.insets = new Insets(10 , 10 , 1 , 0);
      size.fill = GridBagConstraints.HORIZONTAL;
      size.gridx = 0;
      size.gridy = 1;
      playScreen.add(intro , size);
      
      playScreen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      playScreen.pack();
      playScreen.setVisible(true);
      
      playScreen.getContentPane().setBackground(Color.yellow);
      quitButton.setBackground(Color.gray);
      playButton.setBackground(Color.gray);
      
      
   }

}
