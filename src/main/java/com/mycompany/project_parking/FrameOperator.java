/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.project_parking;

/**
 *
 * @author metr
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
public class FrameOperator extends JFrame {
  
         JMenu menu;  
          JMenuItem i1, i2, i3;  
          JLabel label;
          FrameOperator(){  
          setTitle("Operator"); 
          JMenuBar mb=new JMenuBar();  
          menu=new JMenu("Menu");  
          i1=new JMenuItem("View All Slots");  
          i2=new JMenuItem("View Free Slots");  
          i3=new JMenuItem("Log out");
         // label= new JLabel();
         // label.setHorizontalAlignment(JLabel.CENTER);  
         // label.setSize(400,100);  
          menu.add(i1);
          menu.add(i2);
          menu.add(i3);  
          mb.add(menu);  
          setJMenuBar(mb);
          setSize(800,560);  
          setLayout(null);  
         setVisible(true);
       /*  i1.addActionListener(new ActionListener(){  
         public void actionPerformed(ActionEvent e) {  
               label.setVisible(true);
               label.setText("View All Slots."); 
         }  
        }); 
         i2.addActionListener(new ActionListener(){  
         public void actionPerformed(ActionEvent e) {              
               label.setVisible(false); 
         }  
        }); 
         add(label);*/
          setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
          }
      
        
}
