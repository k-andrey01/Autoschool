/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package autoschool;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Scanner;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 *
 * @author russi
 */
public class RegistrationController implements Initializable{
    @FXML
    private TextField mylogin;
    
    @FXML
    private TextField mypassword;
    
    @FXML
    private Button reg;
    
    @FXML
    private Button first;
    
    @FXML
    private Label lbl1;
    
    @FXML
    private ComboBox<String> myrole;
    ObservableList <String> list= FXCollections.observableArrayList();
    
    @FXML
    private void vhod(ActionEvent event) throws IOException{
        Stage stage = new Stage();
            Parent root = FXMLLoader.load(getClass().getResource("EnterSystem.fxml"));
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
            Stage stage1 = (Stage) first.getScene().getWindow();
            stage1.close();
    }
    
    @FXML
    public void registrate(ActionEvent event) throws IOException{
        String EnterLogin = mylogin.getText();
        String EnterPassword = mypassword.getText();
        
        if(myrole.getValue().equals("Клиент")){
            FileWriter writer = null;
            writer = new FileWriter("C:\\Users\\russi\\Documents\\NetBeansProjects\\Autoschool\\src\\autoschool\\users", true);
            BufferedWriter wr = null;
            wr = new BufferedWriter(writer);
            if (checks(EnterLogin)==true){
                wr.write(EnterLogin+"\n");
                wr.write(EnterPassword+"\n");  
                lbl1.setText("Вы успешно зарегистрировались");
                wr.close();
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
           alert.setTitle("Успешно");
           alert.setHeaderText("");
           alert.setContentText("Вы успешно зарегистрировались");
           alert.showAndWait();
            }else{
                Alert alert = new Alert(Alert.AlertType.ERROR);
           alert.setTitle("Ошибка");
           alert.setHeaderText("Сообщение об ошибке");
           alert.setContentText("Логин занят");
           alert.showAndWait();
            }
            writer.close();
        
            Stage stage = new Stage();
            Parent root = FXMLLoader.load(getClass().getResource("EnterSystem.fxml"));
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
            Stage stage1 = (Stage) reg.getScene().getWindow();
            stage1.close();
        }    
        if(myrole.getValue().equals("Инструктор_Преподаватель")){
            FileWriter writer = null;
            writer = new FileWriter("C:\\Users\\russi\\Documents\\NetBeansProjects\\Autoschool\\src\\autoschool\\staff", true);
            BufferedWriter wr = null;
            wr = new BufferedWriter(writer);
            if (checks2(EnterLogin)==true){
                wr.write(EnterLogin+"\n");
                wr.write(EnterPassword+"\n");  
                lbl1.setText("Вы успешно зарегистрировались");
                wr.close();
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
           alert.setTitle("Успешно");
           alert.setHeaderText("");
           alert.setContentText("Вы успешно зарегистрировались");
           alert.showAndWait();
            }else{
                Alert alert = new Alert(Alert.AlertType.ERROR);
           alert.setTitle("Ошибка");
           alert.setHeaderText("Сообщение об ошибке");
           alert.setContentText("Логин занят");
           alert.showAndWait();
            }
            writer.close();
        
            Stage stage = new Stage();
            Parent root = FXMLLoader.load(getClass().getResource("EnterSystem.fxml"));
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
            Stage stage1 = (Stage) reg.getScene().getWindow();
            stage1.close();
        }  
    }
    
    public boolean checks(String log) throws FileNotFoundException{
        Scanner inp = new Scanner(new File("C:\\Users\\russi\\Documents\\NetBeansProjects\\Autoschool\\src\\autoschool\\users"));
        int cnt=0;
        String log1;
        String pas1;
        boolean ch;
        ch = true;
        while (inp.hasNext()){
            log1=inp.next();
            pas1=inp.next();
            if (log1.equals(log)){
                cnt=1;
                ch = false;
            }
        }
        return ch;
    }
    
    public boolean checks2(String log) throws FileNotFoundException{
        Scanner inp = new Scanner(new File("C:\\Users\\russi\\Documents\\NetBeansProjects\\Autoschool\\src\\autoschool\\staff"));
        int cnt=0;
        String log1;
        String pas1;
        boolean ch;
        ch = true;
        while (inp.hasNext()){
            log1=inp.next();
            pas1=inp.next();
            if (log1.equals(log)){
                cnt=1;
                ch = false;
            }
        }
        return ch;
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        list.add("Клиент");
        list.add("Инструктор_Преподаватель");
        myrole.setItems(list);
    }  
}
