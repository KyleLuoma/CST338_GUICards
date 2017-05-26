package com.northvine.engineering;

import javax.swing.*;
import java.awt.*;

/**
 *  This class is the main class for Phase1 of the assignment
 *  All this class does is loads up the card images and displays them
 *  as JLabels 
 *
 * @Author Gene Evans, Kyle Luoma, Trammel May, Trent Dehart
 * @Date May 24th, 2017
 * @Version 1.0.0
 */
public class Main
{
   // This private constant points to the directory where all the card images are stored
   private static final String IMAGES_FOLDER = String.format("%s%s", System.getProperty("user.dir"), "/src/images/");
   private static final int NUM_CARD_IMAGES = 57; // 52 basic cards & 4 jokers & back of card image
   private static Icon[] icon = new ImageIcon[NUM_CARD_IMAGES];
   private static final String[] CARD_SUITES =
      {
         "D", "H", "S", "C"
      };

   private static final String[] CARD_VALUES =
      {
         "A", "2", "3", "4", "5", "6", "7", "8", "9", "T", "J", "Q", "K", "X"
      };

   private static void loadCardIcons()
   {
      int i = 0; // array pointer
      final String filetype = ".gif";
      for(String suite : CARD_SUITES)
      {
         for(String value : CARD_VALUES)
         {
            icon[i++] = new ImageIcon(IMAGES_FOLDER + value + suite + filetype);
         }
      }
      icon[i] = new ImageIcon(IMAGES_FOLDER + "BK" + filetype); //sets card back image
   }



   // a simple main to throw all the JLabels out there for the world to see
   public static void main(String[] args)
   {
      int k;

      // prepare the image icon array
      loadCardIcons();

      // establish main frame in which program will run
      final JFrame frmMyWindow = new JFrame("Card Room");
      frmMyWindow.setSize(1150, 650);
      frmMyWindow.setLocationRelativeTo(null);
      frmMyWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

      // set up layout which will control placement of buttons, etc.
      final FlowLayout layout = new FlowLayout(FlowLayout.CENTER, 5, 20);
      frmMyWindow.setLayout(layout);

      // prepare the image label array
      final JLabel[] labels = new JLabel[NUM_CARD_IMAGES];
      for (k = 0; k < NUM_CARD_IMAGES; k++)
      {
         labels[k] = new JLabel(icon[k]);
      }
      // place your 3 controls into frame
      for (k = 0; k < NUM_CARD_IMAGES; k++)
      {
         frmMyWindow.add(labels[k]);
      }
      // show everything to the user
      frmMyWindow.setVisible(true);
   }
}