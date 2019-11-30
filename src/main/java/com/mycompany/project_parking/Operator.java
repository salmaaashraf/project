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
import java.util.LinkedHashMap;
import java.util.Map;
import java.io.*;


public class Operator extends Person implements IoperatorCustomer{
   
  
   public Slot retrnSlot(){
       for(Slot s:slots){
           if(s.check==false){
               s.check=true;
               freeSlots--;
               return s;
           }
       }
       return null;
   } 
   
   public String calcTimedep(){
        Date date= new Date();
         SimpleDateFormat d=new SimpleDateFormat("hh:mm:ss",Locale.US);
         return d.format(date);
    }
   
    public void login(int id,String password){
        
        if (operator.containsKey(id)){
           Operator p = operator.get(id);
            if(password.equals(p.password)){
                System.out.println ("logged in Successfully");
                 BufferedWriter br;
               try {
                  br = new BufferedWriter(new FileWriter ("LoginOperator.txt"));
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
    public Operator loggedInOperator(){
        Operator op;
        Scanner input;
        String s1,iidd = null;
        int cnt=0;
        try {
          input= new Scanner(new BufferedReader(new FileReader ("LoginOperator.txt")));
          while(input.hasNextLine()){  
              if(cnt==0){
                  iidd=input.nextLine();
              }
              s1=input.nextLine();
              cnt++;
          }
        }catch(IOException ex){
            System.out.println("Error opening file");
        }
        
        op=operator.get(Integer.parseInt(iidd)); 
        return op;
    }
    
    
    public int calculateMoney(int id){
        Ticket t;
        t = tInfo.get(id);
        String temp=t.getarrivalTime();
        String arrival=temp.substring(0,2);
        temp=t.getdepartureTime();
        String departure=temp.substring(0,2);
        String departurem = temp.substring(3, 5);
        String departures = temp.substring(6);
        int h1 = Integer.valueOf(arrival);
        int h2 =Integer.valueOf(departure);
        int min=Integer.valueOf(departurem);
        int sec=Integer.valueOf(departures);
        if(min>0 || sec>0){
            h2++;
        }  
        int TotalHours = h2-h1;
        int money=TotalHours*10;
        int x;
        if(shiftReport.containsKey(t.getdate())){
           int m= shiftReport.get(t.getdate());
           x=money+m;
           shiftReport.replace(t.getdate(),x);
        }else{
        shiftReport.put(t.getdate(),money);
        }
        freeSlots++;
        return money;
   }
    
    public void freeSlot(int n){
        for(Slot s:slots){
           if(s.id_slot==n){
               s.check=false;
               break;
           }
       }
    }
    
    @Override
    public void viewSlots(){
       super.viewSlots();
       System.out.println("Number of free slots: "+freeSlots);
    }
    @Override
    public void Logout(){
        super.Logout();
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
    }
}


