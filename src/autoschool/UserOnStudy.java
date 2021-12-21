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
public class UserOnStudy {

String Login;
    String Fam;
    String Name;
    String Otch;
    String Status;
    
    
    public UserOnStudy (String Login, String Fam,String Name,String Otch,String Status){
      this.Fam = Fam;
      this.Name=Name;
      this.Otch=Otch;
      this.Status=Status;
      this.Login=Login;
    } 

    UserOnStudy() {
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public String getFam() {
        return Fam;
    }
    
    public String getLog(){
        return Login;
    }

    public String getName() {
       return Name;
    }

    public String getOtch() {
        return Otch;
    }

    public String getStatus() {
        return Status;
    }
    
    public void setLogin(String Login){
        this.Login=Login;
    }
    
    public void setName(String Name){
        this.Name=Name;
    }
    
    public void setFam(String Fam){
        this.Fam=Fam;
    }
    
    public void setOtch(String Otch){
        this.Otch=Otch;
    }
    
    public void setStatus(String Status){
        this.Status=Status;
    }
    
    void OverWrite(ObservableList<UserOnStudy> items) throws IOException {
        File fout = new File("C:\\Users\\russi\\Documents\\NetBeansProjects\\Autoschool\\src\\autoschool\\UsersOnStudy");
        FileWriter fr = new FileWriter(fout);
        for(int i = 0;i < items.size();i++) {
            fr.write(items.get(i).getLog() + " ");
            fr.write(items.get(i).getFam() + " ");
            fr.write(items.get(i).getName() + " ");
            fr.write(items.get(i).getOtch() + " ");
            fr.write(items.get(i).getStatus() + "\n");
        }
        try {
            fr.close();
        } catch (IOException ee) {
            ee.printStackTrace();
        }
    }
    
    void OverWrite1(ObservableList<UserOnStudy> items) throws IOException {
        File fout = new File("C:\\Users\\russi\\Documents\\NetBeansProjects\\Autoschool\\src\\autoschool\\KlientZayavki");
        FileWriter fr = new FileWriter(fout);
        for(int i = 0;i < items.size();i++) {
            fr.write(items.get(i).getLog() + " ");
            fr.write(items.get(i).getFam() + " ");
            fr.write(items.get(i).getName() + " ");
            fr.write(items.get(i).getOtch() + " ");
            fr.write(items.get(i).getStatus() + "\n");
        }
        try {
            fr.close();
        } catch (IOException ee) {
            ee.printStackTrace();
        }
    }
}

