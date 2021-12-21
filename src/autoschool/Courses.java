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
public class Courses {
    String Name;
    String Price;
    String Time;
    String Rating;
    
    public Courses (String Name,String Price,String Time,String Rating){
      this.Name = Name;
      this.Price=Price;
      this.Time=Time;
      this.Rating=Rating;
    }  

    public Courses() {
    }
    
    public String getName(){
        return Name;
    }
    
    public void setName(String Name){
        this.Name=Name;
    }
    
     public String getPrice(){
        return Price;
    }
    
    public void setPrice(String Price){
        this.Price=Price;
    }
    
     public String getTime(){
        return Time;
    }
    
    public void setTime(String Time){
        this.Time=Time;
    }
    
     public String getRating(){
        return Rating;
    }
    
    public void setRating(String Rating){
        this.Rating=Rating;
    }

    void OverWrite(ObservableList<Courses> items) throws IOException {
        File fout = new File("C:\\Users\\russi\\Documents\\NetBeansProjects\\Autoschool\\src\\autoschool\\Courses");
        FileWriter fr = new FileWriter(fout);
        for(int i = 0;i < items.size();i++) {
            fr.write(items.get(i).getName() + " ");
            fr.write(items.get(i).getPrice() + " ");
            fr.write(items.get(i).getTime() + " ");
            fr.write(items.get(i).getRating() + "\n");
        }
        try {
            fr.close();
        } catch (IOException ee) {
            ee.printStackTrace();
        }
    }
}
