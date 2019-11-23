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

public class Operator extends Person implements IoperatorCustomer{
    protected int id;
    protected String name;
    protected String email;
    protected String password;
    protected String phone_number;
  
   public Slot retrnSlot(){
       for(Slot s:slots){
           if(s.check==false){
               s.check=true;
               return s;
           }
       }
       return null;
   } 
   public void Logout(){
       ///////////////////////////////////////
       
        System.out.println("logged in Successfully");
   }
   public String calcTimedep(){
        Date date= new Date();
         SimpleDateFormat d=new SimpleDateFormat("hh:mm:ss",Locale.US);
         return d.format(date);
    }
    public void login(int id,String password){
        ////////////////////////////////////////////////////////////
    }
    public Operator loggedInOperator(){
        Operator op;
        op=operator.get(id); /////////////read id from file of logged in operator
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
        if(shiftReport.containsKey(t.getdate())){
           int m= shiftReport.get(t.getdate());
           money+=m;
           shiftReport.replace(t.getdate(),money);
        }else{
        shiftReport.put(t.getdate(),money);
        }
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
}


