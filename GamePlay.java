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



public class GamePlay extends JFrame implements ActionListener{

   private static JButton first;
   private static JButton second;   
   private static JLabel label2;
   private static JLabel complete;
   private static JButton quitGame;
   private static String question;
   private static int i;
   public static ArrayList<String>text = new ArrayList<String>();
   public static ArrayList<String>questions = new ArrayList<String>();
   
   public GamePlay(){
      
      getQuestion();
   
      label2 = new JLabel(question);
      label2.setSize(275,180);
      GridBagConstraints q = new GridBagConstraints();
      setLayout(new GridBagLayout());
      q.insets = new Insets(10 , 10 , 1 , 0);
      q.fill = GridBagConstraints.LINE_END;
      q.gridx = 0;
      q.gridy = 0;
      label2.setFont(new Font("Serif" , 1 ,25));
      add(label2 , q);
      
      first = new JButton("1st choice");
      first.addActionListener(this);
      GridBagConstraints fir = new GridBagConstraints();
      fir.insets = new Insets(0 , 5 , 10 , 10);
      fir.fill = GridBagConstraints.LINE_END;
      fir.gridx = 0;
      fir.gridy = 2;
      add(first , fir);
      
      second = new JButton("2nd choice");
      second.addActionListener(this);
      GridBagConstraints sec = new GridBagConstraints();
      sec.insets = new Insets(0 , 5 , 10 , 10);
      sec.fill = GridBagConstraints.LINE_END;
      sec.gridx = 0;
      sec.gridy = 3;
      add(second , sec);
   
   }
   
   public GamePlay(String quit){
      complete = new JLabel("END OF GAME");
      complete.setSize(275,180);
      GridBagConstraints u = new GridBagConstraints();
      setLayout(new GridBagLayout());
      u.insets = new Insets(10 , 10 , 1 , 0);
      u.fill = GridBagConstraints.LINE_END;
      u.gridx = 0;
      u.gridy = 0;
      complete.setFont(new Font("Serif" , 1 , 65));
      add(complete , u);
      
      quitGame = new JButton("QUIT");
      quitGame.addActionListener(this);
      GridBagConstraints finis = new GridBagConstraints();
      finis.insets = new Insets(0 , 5 , 10 , 10);
      finis.fill = GridBagConstraints.LINE_END;
      finis.gridx = 0;
      finis.gridy = 3;
      add(quitGame , finis);
   }

   public static int randNum (int min, int max){

      int rand = (int)((max-min+1) * Math.random() + min);
      return rand;
   }

   public static String getQuestion(){

      try {

        File file = new File ("WouldYouRather.txt");
        Scanner fileScan = new Scanner(file);
        while(fileScan.hasNext()){
         text.add(fileScan.nextLine());
      }

      }

      catch (FileNotFoundException e) {
        System.out.println(e);
      }

      for(int i = 0; i < text.size(); i++){
         questions.add(text.get(i));
      }

      int rand = randNum(0,9);
      question = questions.get(rand);
      
     return question; 
   } 
   
   public static void nextQuestion(){
      GamePlay playy = new GamePlay();
      playy.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      playy.pack();
      playy.setVisible(true);
   }
   
   public static void endOfGame(){
      GamePlay finish = new GamePlay("q");
      finish.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      finish.pack();
      finish.setVisible(true);

   }
   
   @Override
   public void actionPerformed(ActionEvent e){
      JButton sourceEvent = (JButton) e.getSource();
      
      if(sourceEvent == first){
         if(i < 5){
            nextQuestion();
            i++;
            dispose();
         }
         else if(i == 5){
            endOfGame();
            dispose();
         }
      }
      else if(sourceEvent == second){
         if(i < 5){
            nextQuestion();
            i++;
            dispose();
         }
         else if(i == 5){
            endOfGame();
            dispose();
         }
      }
      else if(sourceEvent == quitGame){
         dispose();
      }
      
   }
   
}