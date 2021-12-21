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
public class TestWork {
    String Client;
    String Date;
    String Mistakes;
    String Result;
    
    public TestWork (String Client, String Date,String Mistakes,String Result){
      this.Client = Client;
      this.Date=Date;
      this.Mistakes=Mistakes;
      this.Result=Result;
    } 

    TestWork() {
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public String getClient() {
        return Client;
    }
    
    public String getDate(){
        return Date;
    }

    public String getMistakes() {
       return Mistakes;
    }

    public String getResult() {
        return Result;
    }
    
    public void setClient(String Client){
        this.Client=Client;
    }
    
    public void setDate(String Date){
        this.Date=Date;
    }
    
    public void setMistakes(String Mistakes){
        this.Mistakes=Mistakes;
    }
    
    public void setResult(String Result){
        this.Result=Result;
    }
    
    void OverWrite(ObservableList<TestWork> items) throws IOException {
        File fout = new File("C:\\Users\\russi\\Documents\\NetBeansProjects\\Autoschool\\src\\autoschool\\Tests");
        FileWriter fr = new FileWriter(fout);
        for(int i = 0;i < items.size();i++) {
            fr.write(items.get(i).getClient() + " ");
            fr.write(items.get(i).getDate() + " ");
            fr.write(items.get(i).getMistakes() + " ");
            fr.write(items.get(i).getResult() + "\n");
        }
        try {
            fr.close();
        } catch (IOException ee) {
            ee.printStackTrace();
        }
    }
    
    void OverWrite1(ObservableList<TestWork> items) throws IOException {
        File fout = new File("C:\\Users\\russi\\Documents\\NetBeansProjects\\Autoschool\\src\\autoschool\\Exams");
        FileWriter fr = new FileWriter(fout);
        for(int i = 0;i < items.size();i++) {
            fr.write(items.get(i).getClient() + " ");
            fr.write(items.get(i).getDate() + " ");
            fr.write(items.get(i).getMistakes() + " ");
            fr.write(items.get(i).getResult() + "\n");
        }
        try {
            fr.close();
        } catch (IOException ee) {
            ee.printStackTrace();
        }
    }
    
}
