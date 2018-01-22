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

public class GamePlay extends JFrame{

   private static JLabel label;
   private static String question;
   public static ArrayList<String>text = new ArrayList<String>();
   public static ArrayList<String>questions = new ArrayList<String>();

   public static void main(String[] args){
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
      guiThingy();
      //label.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      label.setSize(275,180);
      label.setVisible(true);
      //System.out.println(question); // for testing
   }

   public static void guiThingy (){
      label = new JLabel(question);
      GridBagConstraints q = new GridBagConstraints();
      label.setLayout(new GridBagLayout());
      q.insets = new Insets(10 , 10 , 1 , 0);
      q.fill = GridBagConstraints.LINE_END;
      q.gridx = 0;
      q.gridy = 0;
      label.setFont(new Font("Serif" , 1 ,60));
      //add(label);
   }

   public static int randNum (int min, int max){
      int rand = (int)((max-min+1) * Math.random() + min);
      return rand;
   }
}
