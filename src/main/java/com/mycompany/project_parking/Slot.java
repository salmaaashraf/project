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
public class Slot {
    protected int id_slot;
    protected String slot_description;
    protected boolean check;
    Slot(){
        this.id_slot=0;
        this.slot_description=null;
        this.check=false;
    }
    Slot(String slot_des){
       this.slot_description=slot_des;
       this.check=false;
    }
 
}
