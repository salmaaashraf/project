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
import java.io.*;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;
public class NewMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
       System.out.println("welcome to our project\n");
        Admin a1 = new Admin();
        Admin a2 = new Admin();
        //a1.AddAdmins(1, "ahmed ashraf", "ahmed200@gmail.com", "ahmoo", "0100152556");
        //a1.AddAdmins(2, "mohammed", "ahmed200@gmail.com", "ahmoo", "0100152556");
       // a2.viewAdmins();
        //a1.AddAdmins(3, "amr", "amr200@gmail.com", "amro", "0100158556");
        //a2.viewAdmins();

        a1.AddSlot("3rd row");
        a2.AddSlot("2nd row");
        a2.AddSlot("1st row");
        //a2.viewSlots();
       // a1.viewSlots();
        a1.AddOperator(8, "ahmed", "ahmed200@gmail.com", "ahmoo", "0100152556");
        //a1.AddOperator(9, "mohammed", "ahmed200@gmail.com", "ahmoo", "0100152556");
        Operator op = new Operator();
       // a1.viewOperators();
        op.login(8, "ahmoo");
         op.viewSlots();
        //op.loggedInOperator();
        /*a2.viewOperators();
        a1.DeleteOperator(0);
         a2.viewOperators();
         a2.UpdateOperator(2);
         a2.viewOperators();
        // Ticket t=new Ticket();*/
         Customer c1=new Customer();
         c1.printTicket("salma","abc123");
         c1.pay(0);
         System.out.println();
         Customer c2=new Customer();
         c2.printTicket("ahmed","abc589");
         System.out.println();
         Customer c3=new Customer();
         c3.printTicket("mohammed","abc589");
         c2.pay(1);
         c3.pay(2);
         a1.ViewShiftReports();
         a2.InfoOfCustemersAndTickets();
         //c3.printt();*/
     
         
    }
    
}
