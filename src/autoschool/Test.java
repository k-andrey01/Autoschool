/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package autoschool;

/**
 *
 * @author russi
 */
public class Test {
    String Klient;
    String Date;
    String Mistakes;
    String Result;
    
    public Test(String Klient, String Date, String Mistakes, String Result){
        this.Klient=Klient;
        this.Date=Date;
        this.Mistakes=Mistakes;
        this.Result=Result;
    }
    
    public String getKlient(){
        return Klient;
    }
    
    public void setKlient(String Klient){
        this.Klient=Klient;
    }
    public String getDate(){
        return Date;
    }
    
    public void setDate(String Date){
        this.Date=Date;
    }
    public String getMistakes(){
        return Mistakes;
    }
    
    public void setMistakes(String Mistakes){
        this.Mistakes=Mistakes;
    }
    public String getResult(){
        return Result;
    }
    
    public void setResult(String Result){
        this.Result=Result;
    }
}
