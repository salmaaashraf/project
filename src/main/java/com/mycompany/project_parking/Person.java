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
public abstract class Person {
    protected int ID;
    protected String name;
    protected String email;
    protected String password;
    protected String phone_number;
    static int no_of_Slots=0;
    static int freeSlots=0;
    static final ArrayList<Slot> slots=new ArrayList<Slot>();
    static  final Map<Integer,Operator> operator=new LinkedHashMap<Integer, Operator>();
    static final Map<String,Integer> shiftReport=new LinkedHashMap<String, Integer>();
    public abstract void  login(int id,String password);
}
