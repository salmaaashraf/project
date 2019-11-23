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

import java.text.SimpleDateFormat;
import java.util.*;
public class NewMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        System.out.println("welcome to our project\n");
        Admin a1 = new Admin();
        Admin a2 = new Admin();
        a1.AddSlot("3rd row");
        a2.AddSlot("2nd row");
        a2.AddSlot("1st row");
        a2.viewSlots();
        a1.viewSlots();
        a1.AddOperator(0, "ahmed", "ahmed200@gmail.com", "ahmoo", "0100152556");
        a1.AddOperator(2, "mohammed", "ahmed200@gmail.com", "ahmoo", "0100152556");
        a2.viewOperators();
        a1.DeleteOperator(0);
         a2.viewOperators();
        // a2.UpdateOperator(2);
         a2.viewOperators();
        // Ticket t=new Ticket();
         Customer c1=new Customer();
         c1.printTicket("salma","abc123");
         c1.pay(0);
         System.out.println();
         Customer c2=new Customer();
         c2.printTicket("ahmed","abc589");
         System.out.println();
         Customer c3=new Customer();
         c3.printTicket("ahmed","abc589");
         Ticket t=new Ticket();
         c3.printt();
        
         
    }
    
}
