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
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;
public abstract class Person {
    protected int id;
    protected String name;
    protected String email;
    protected String password;
    protected String phone_number;
    static int no_of_Slots=0;
    static int freeSlots=0;
    static final ArrayList<Slot> slots=new ArrayList<Slot>();
    static  final Map<Integer,Operator> operator=new LinkedHashMap<Integer, Operator>();
    static final Map<String,Integer> shiftReport=new LinkedHashMap<String, Integer>();
    static final Map<Integer,Admin> admin=new LinkedHashMap<Integer, Admin>();
    public abstract void  login(int id,String password);
    public void Logout(){
        System.out.println("logged out Successfully");
   }
    void viewSlots(){
       /* for(Slot s:slots){
            
            System.out.println("Slot number:"+ s.id_slot+" Row Number: "+s.slot_description+"Empty: "+s.check);
        }*/
         try{
           File file  =new File("Slots.txt");
           BufferedWriter bw = new BufferedWriter(new FileWriter(file));
        
        for(Slot s:slots){
            int id=s.id_slot;
            String row=s.slot_description;
           bw.write("~"+String.valueOf(s.id_slot)+"~"+s.slot_description +"~"+String.valueOf(s.check));
           bw.newLine();
        }
        bw.flush();
        bw.close();
    }catch(IOException ex){
        System.out.println("Error opening file");
        
    }
        Scanner input ;
        try{
            input=new Scanner(new BufferedReader(new FileReader ("Slots.txt")));
            input.useDelimiter("~");
            while(input.hasNextLine()){
                int id =input.nextInt();
                String row =input.next();
                String check =input.next();
                System.out.println("Slot number: "+ id+" Row Number: "+row+" occupation: "+check);
            }
        input.close();
        }catch(IOException e){
            System.out.println("Erorr to opening file");
            
        }
    }
}
