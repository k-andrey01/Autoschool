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
public class User {
    String login;
    String parol;
    
    public boolean checker(String inLogin, String inParol){
        if (login.equals(inLogin) && parol.equals(inParol)){
            return true;
        }
        else{
            return false;
        }    
    }
    
    public User (String hisLog,String hisPar){
      this.login = hisLog;
      this.parol=hisPar;
    }  
}
