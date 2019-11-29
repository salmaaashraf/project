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
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;

public class Customer implements IoperatorCustomer{
    protected String name;
    protected String plateNumber;
    Customer(){
        this.name=null;
        this.plateNumber=null;
    }
    Customer(String name,String platno){
        this.name=name;
        this.plateNumber=platno;
    }
    public void printTicket(String name,String plateno){
        Ticket t=new Ticket();
        Operator optr=new Operator();
        Customer c1 =new Customer(name,plateno);
        Slot s =optr.retrnSlot();
        if(s==null){
            System.out.println("Sorry,all slots are full");
            return ;
        }
        t.setDate();
        t.setarrivaltime(calcTime());
        t.setidSlot(s.id_slot);
        optr=optr.loggedInOperator();
        t.setOperatorname(optr.name);
        cuInfo.put(t.getid(),c1);
        tInfo.put(t.getid(),t);
      
        System.out.println("Ticket ID: " +t.getid() +"\nSlot ID: "+s.id_slot+"\nSlot Row: "+s.slot_description +"\nPlate Number: "+c1.plateNumber + "\nTransaction Time: "+t.getarrivalTime()+"\nOperator name: "+t.getOperatorname()+"\nDate: "+t.getdate());
    }
    public void pay(int ticketId){
      if(tInfo.containsKey(ticketId)){
        Ticket t;
        Operator optr=new Operator();
        t=tInfo.get(ticketId);
        t.setdeparturetime(calcTime());
        int money=optr.calculateMoney(ticketId);
        optr.freeSlot(t.getidSlot());
        System.out.println("You should pay: "+money+" LE");
      }else{
          System.out.println("Wrong Ticket ID");
      }
    }
    public String calcTime(){
        Date date= new Date();
         SimpleDateFormat d=new SimpleDateFormat("hh:mm:ss",Locale.US);
         return d.format(date);
    }
    /*public void printt(){
       for(Map.Entry <Integer,Ticket> p:tInfo.entrySet()){  
            Ticket t=new Ticket();
            t=p.getValue();          
            System.out.println(p.getKey()+" "+t.getid()+" "+t.getarrivalTime()+" "+t.getdepartureTime()+" "+t.getdate());
            
        }
        
    }*/
}

