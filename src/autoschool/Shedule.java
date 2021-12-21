/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package autoschool;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import javafx.collections.ObservableList;

/**
 *
 * @author russi
 */
public class Shedule {
    String Klient;
    String Staff;
    String Date;
    String Theme;
    String Status;
    String Type;
    
    static ObservableList<Shedule> sheduleData;
    public void setsheduleData(ObservableList<Shedule> sheduleData){
        this.sheduleData = sheduleData;
    }
    public ObservableList<Shedule> getsheduleData(){
        return sheduleData;
    }
    
    public Shedule(){
        
    }
    
    public Shedule (String Klient,String Staff,String Theme,String Date,String Type,String Status){
      this.Klient = Klient;
      this.Staff=Staff;
      this.Date=Date;
      this.Theme=Theme;
      this.Type=Type;
      this.Status=Status;
    }  
   
    public Shedule (String Theme,String Type,String Status){
      this.Theme = Theme;
      this.Type=Type;
      this.Status=Status;
    } 
    
    public Shedule (String Klient,String Date){
      this.Klient = Klient;
      this.Date=Date;
    }
    
    public String getKlient(){
        return Klient;
    }
    
    public void setKlient(String Klient){
        this.Klient=Klient;
    }
    
     public String getStaff(){
        return Staff;
    }
    
    public void setStaff(String Staff){
        this.Staff=Staff;
    }
    
     public String getDate(){
        return Date;
    }
    
    public void setDate(String Date){
        this.Date=Date;
    }
    
     public String getTheme(){
        return Theme;
    }
    
    public void setTheme(String Theme){
        this.Theme=Theme;
    }
    
    public String getStatus(){
        return Status;
    }
    
    public void setStatus(String Status){
        this.Status=Status;
    }
    
    public String getType(){
        return Type;
    }
    
    public void setType(String Type){
        this.Type=Type;
    }
    
    public void OverWrite(ObservableList<Shedule> modifiedList, ObservableList<Shedule> newList) throws IOException{
        File fout = new File("C:\\Users\\russi\\Documents\\NetBeansProjects\\Autoschool\\src\\autoschool\\SheduleThemes");
        FileWriter fr = new FileWriter(fout);
        try {
            for(int i = 0;i < modifiedList.size();i++) {
                fr.write(modifiedList.get(i).getKlient() + " ");
                fr.write(modifiedList.get(i).getStaff() + " ");
                fr.write(modifiedList.get(i).getTheme() + " ");
                fr.write(modifiedList.get(i).getDate() + " ");
                fr.write(modifiedList.get(i).getType() + " ");
                fr.write(modifiedList.get(i).getStatus()+"\n");
            }
            for (int i =0; i<newList.size();i++){
                fr.write(newList.get(i).getKlient() + " ");
                fr.write(newList.get(i).getStaff() + " ");
                fr.write(newList.get(i).getTheme() + " ");
                fr.write(newList.get(i).getDate() + " ");
                fr.write(newList.get(i).getType() + " ");
                fr.write(newList.get(i).getStatus()+"\n");
            }
        } catch (IOException ee) {
            ee.printStackTrace();
        }finally{
            try {
                fr.close();
            } catch (IOException ee) {
                ee.printStackTrace();
            }
        }
    }
    
    public void OverWrite(ObservableList<Shedule> modifiedList) throws IOException{
        File fout = new File("C:\\Users\\russi\\Documents\\NetBeansProjects\\Autoschool\\src\\autoschool\\SheduleThemes");
        FileWriter fr = new FileWriter(fout);
        try {
            for(int i = 0;i < modifiedList.size();i++) {
                fr.write(modifiedList.get(i).getKlient() + " ");
                fr.write(modifiedList.get(i).getStaff() + " ");
                fr.write(modifiedList.get(i).getTheme() + " ");
                fr.write(modifiedList.get(i).getDate() + " ");
                fr.write(modifiedList.get(i).getType() + " ");
                fr.write(modifiedList.get(i).getStatus()+"\n");
            }
            } catch (IOException ee) {
            ee.printStackTrace();
        }finally{
            try {
                fr.close();
            } catch (IOException ee) {
                ee.printStackTrace();
            }
        }
    }
}
