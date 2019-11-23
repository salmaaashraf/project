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
import java.util.*;

public class Admin extends Person{
     
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
         }
    }
    void viewOperators(){
        for(Map.Entry <Integer, Operator> p:operator.entrySet()){  
            Operator op=new Operator();
            op=p.getValue();          
            System.out.println(p.getKey()+" "+op.name+" "+op.email+" "+op.password+" "+op.phone_number);
        }        
    }
    void DeleteOperator(int id){
       if(operator.containsKey(id)){
           operator.remove(id);
           System.out.println("operator deleted successfully");
       }else{
           System.out.println("Error,operator not found");
       }
    }
    void ViewShiftReports(int id,String name){
        for(Map.Entry m:shiftReport.entrySet()){  
            System.out.println(m.getKey()+" "+m.getValue());  
        }  
    }
    void viewSlots(){
        for(Slot s:slots){
            int id=s.id_slot;
            String row=s.slot_description;
            System.out.println("Slot number:"+ id+" Row Number: "+row);
        }
    }
    public void login(int id,String password){
        if(id==0000 && password=="admin"){
            System.out.println("logged in Successfully");
        }else{
            System.out.println("wrong username or password");
        }
    }   
    void updateEmail(String email,Operator op){
        op.email=email;
    }
    void updatePhone(String phone,Operator op){
        op.phone_number=phone;
    }
    public void InfoOfCustemersAndTickets(){
        /////////////////////////////////////////
    }
}
