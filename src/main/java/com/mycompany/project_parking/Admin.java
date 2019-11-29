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

import java.io.IOException;
import java.util.*;
import java.io.*;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;


public class Admin extends Person implements IoperatorCustomer{
     
    static int idOfSlot=0;
     
     Admin(){
        
     }
    void AddSlot(String slot_description){ 
       Slot s=new Slot(slot_description);
       s.id_slot= idOfSlot;
       slots.add(s);
       idOfSlot++;
       no_of_Slots++;
       freeSlots++;
    }
    void AddOperator(int iD,String name,String email,String password,String phone_number){
       Operator op= new Operator();
       op.id=iD;
       op.name=name;
       op.password=password;
       op.email=email;
       op.phone_number=phone_number;
       operator.put(iD,op);
    }
    void UpdateOperator(int id){
        
         if(operator.containsKey(id)){
             System.out.println("which element do you want to update?");
             System.out.println("1-Email\n2-Phone number\nEnter number of choice please ");
             try{
             Scanner input=new Scanner(System.in);
             int n=input.nextInt();
             if(n==1){
                 System.out.println("Please enter new email");
                 String eml=input.next();
                 updateEmail(eml,operator.get(id));
             }else if(n==2){
                 System.out.println("Please enter new phone number");
                 String phone=input.next();
                 updatePhone(phone,operator.get(id));
             }
             }catch(InputMismatchException e){
                 System.out.println("Error,you must enter a number");
             }
         }else{
             System.out.println("Wrong id");
         }
    }
    
        void viewOperators() {
        BufferedWriter br;
        try {
                  br = new BufferedWriter(new FileWriter ("Operators.txt"));
                  for(Map.Entry <Integer, Operator> p:operator.entrySet()){  
                      Operator op= new Operator();
                      op=p.getValue(); 
                     
                      br.write("~"+p.getKey()+"~"+op.name+"~"+op.email+"~"+op.password+"~"+op.phone_number);
                    
                      br.newLine();
                  }
                  br.flush();
                  br.close();
                } catch (IOException ex) {
                    System.out.println("Error opening file");
                }
        Scanner input;
        try{
          input= new Scanner(new BufferedReader(new FileReader ("Operators.txt")));                
          input.useDelimiter("~");
          
         Operator op= new Operator();          
          while(input.hasNextLine()){              
         
              op.id=input.nextInt();  
              op.name=input.next();
              op.email=input.next();
              op.password=input.next();         
              op.phone_number=input.next();
              System.out.println("Operator ID: "+op.id+"\nOperator name:"+op.name+"\nEmail:"+op.email+"\nPassword: "+op.password+"\nPjone number:"+op.phone_number);
             
          }
          input.close();
        }catch(IOException ex){
            System.out.println("Error opening file");
        }
       /* for(Map.Entry <Integer, Admin> p:admin.entrySet()){  
            Admin ad= new Admin();
            ad=p.getValue();          
            System.out.println(p.getKey()+" "+ad.name+" "+ad.email+" "+ad.password+" "+ad.phone_number);
        }   */     
        
    
        }
        
        
               
    void DeleteOperator(int id){
       if(operator.containsKey(id)){
           operator.remove(id);
           System.out.println("operator deleted successfully");
       }else{
           System.out.println("Sorry,operator not found");
       }
    }
    void ViewShiftReports(){
        /*for(Map.Entry m:shiftReport.entrySet()){  
            System.out.println(m.getKey()+" "+m.getValue());  
        }  */
         try { 
               File file =new File ("ShiftReport.txt");
                BufferedWriter bw = new BufferedWriter (new FileWriter(file));
                   
            for(Map.Entry m:shiftReport.entrySet()){  
                bw.write("~"+m.getKey()+"~");
                bw.write(String.valueOf(m.getValue()));
                bw.flush();
                bw.close();
            }
         }catch(IOException ex){
                System.out.println("Error opening File");
            }
         Scanner input ;
         try{
             input = new Scanner(new BufferedReader( new FileReader("ShiftReport.txt")));
              input.useDelimiter("~");
             while(input.hasNextLine()){
             String date=input.next();
             int profit =input.nextInt();
             System.out.println("Date:"+date +" Profit ="+profit);
         }
         input.close();
         }catch(IOException ex){
            System.out.println("Error opening file");
        }
    }
    
    public void login(int id,String password){ 
         if (admin.containsKey(id)){
           Admin ad = admin.get(id);
            if(password.equals(ad.password)){
                System.out.println ("logged in Successfully");
                 BufferedWriter br;
               try {
                  br = new BufferedWriter(new FileWriter ("LoginAdmin.txt"));
                  br.write(String.valueOf(id));
                  br.newLine();
                  br.write(password);
                  br.flush();
                  br.close();
                } catch (IOException ex) {
                    System.out.println("Error opening file");
                }
            }else{
                System.out.println("Wrong password");
            }
        }
        else {
            System.out.println("Wrong Username");
        }
    
    }   
    void updateEmail(String email,Operator op){
        op.email=email;
    }
    void updatePhone(String phone,Operator op){
        op.phone_number=phone;
    }
    public void InfoOfCustemersAndTickets(){
        Iterator<Entry<Integer, Ticket>> iter1 = tInfo.entrySet().iterator();
        Iterator<Entry<Integer, Customer>> iter2 = cuInfo.entrySet().iterator();
        Ticket t;
        Customer c;
        BufferedWriter br;
        try {
            br = new BufferedWriter(new FileWriter ("InfoOfCustemersAndTickets.txt"));
        while(iter1.hasNext() || iter2.hasNext()) {
            Entry<Integer, Ticket> e1 = iter1.next();
            Entry<Integer, Customer> e2 = iter2.next();
            t=e1.getValue();
            c=e2.getValue(); 
            br.write("~"+e1.getKey() +"~"+t.getidSlot()+"~"+t.getarrivalTime() +"~"+t.getdepartureTime() + "~"+t.getdate()+"~"+t.getOperatorname()+"~"+c.name+"~"+c.plateNumber);
            br.newLine();
                     
        }
         br.flush();
         br.close();
        }catch(IOException ex){
            System.out.println("Error opening file");
        }
        Scanner input;
        try{
          input= new Scanner(new BufferedReader(new FileReader ("InfoOfCustemersAndTickets.txt")));                
          input.useDelimiter("~");
          int slotid,tid;
          String arr,dep,dat,nme,plateno,opname;
          while(input.hasNextLine()){  
              tid=input.nextInt();
              slotid =input.nextInt();
              arr=input.next();
              dep=input.next();
              dat=input.next();
              opname=input.next();
              nme=input.next();
              plateno=input.next();
              System.out.println("Ticket ID: " +tid+"\nSlot ID: "+slotid+"\nArrival time: "+arr +"\nDepartureTime: "+dep+ "\nDate: "+dat+"\nOperator name: "+opname+"\nCustomer name: "+nme+"\nPlate number: "+plateno+"\n");               
          }
          input.close();
        }catch(IOException ex){
            System.out.println("Error opening file");
        }
        
    }
    void AddAdmins(int iD,String name,String email,String password,String phone_number){
        Admin ad= new Admin();
       ad.id=iD;
       ad.name=name;
       ad.password=password;
       ad.email=email;
       ad.phone_number=phone_number;
       admin.put(iD,ad);
    } 
    void viewAdmins(){ 
        BufferedWriter br;
        try {
                  br = new BufferedWriter(new FileWriter ("Admins.txt"));
                  for(Map.Entry <Integer, Admin> p:admin.entrySet()){  
                      Admin ad= new Admin();
                      ad=p.getValue(); 
                     
                      br.write("~"+p.getKey()+"~"+ad.name+"~"+ad.email+"~"+ad.password+"~"+ad.phone_number);
                    
                      br.newLine();
                  }
                  br.flush();
                  br.close();
                } catch (IOException ex) {
                    System.out.println("Error opening file");
                }
        Scanner input;
        try{
          input= new Scanner(new BufferedReader(new FileReader ("Admins.txt")));                
          input.useDelimiter("~");
          Admin a=new Admin();       
          while(input.hasNextLine()){  
              a.id=input.nextInt();
              a.name=input.next();
              a.email=input.next();
              a.password=input.next();
              a.phone_number=input.next();
              System.out.println("Admin id: "+a.id+"\nAdmin name: "+a.name+"\nEmail: "+a.email+"\nPassword: "+a.password+"Phone number: "+a.phone_number);
             
          }
          input.close();
        }catch(IOException ex){
            System.out.println("Error opening file");
        }
       /* for(Map.Entry <Integer, Admin> p:admin.entrySet()){  
            Admin ad= new Admin();
            ad=p.getValue();          
            System.out.println(p.getKey()+" "+ad.name+" "+ad.email+" "+ad.password+" "+ad.phone_number);
        }   */     
        
    }
}
