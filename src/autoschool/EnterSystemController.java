/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package autoschool;

import static com.sun.deploy.config.JREInfo.initialize;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
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
import javafx.scene.control.Hyperlink;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 *
 * @author russi
 */
public class EnterSystemController implements Initializable{
    
    @FXML
    private TextField logins;
    
    @FXML
    private TextField password;
    
    @FXML
    private Button btn;
    
    @FXML
    private Hyperlink reglink;
    
    @FXML
    private ComboBox<String> role;
    ObservableList <String> list= FXCollections.observableArrayList();
    
    @FXML
    public void registrate(javafx.event.ActionEvent actionEvent) throws IOException {
        Stage registerstage = new Stage();
        registerstage.setTitle("Регистрация");
        Parent root = FXMLLoader.load(getClass().getResource("Registration.fxml"));
        Scene scene = new Scene(root);
        registerstage.setScene(scene);
        registerstage.show();
        Stage stage1 = (Stage) reglink.getScene().getWindow();
        stage1.close();
    }  
    
    @FXML
    private void go(ActionEvent event) throws FileNotFoundException, IOException {
        String login=logins.getText();
        String parol=password.getText();
        String Role=role.getValue();
        boolean firsttest=false;
        
        
         
        if(Role.equals("Клиент")){
            Scanner in = new Scanner(new File("C:\\Users\\russi\\Documents\\NetBeansProjects\\Autoschool\\src\\autoschool\\users"));
            User realuser = new User(login, parol);
            boolean testt=false;
            while (in.hasNext()){
                String inLogin = in.next();
                String inParol = in.next();
                FileWriter fw = new FileWriter("C:\\Users\\russi\\Documents\\NetBeansProjects\\Autoschool\\src\\autoschool\\nowUser");
                    PrintWriter pw = new PrintWriter(fw);
                    pw.write("");
                    pw.flush(); 
                    pw.close();
                    String lines2 = realuser.login;
                    Path file2 = Paths.get("C:\\Users\\russi\\Documents\\NetBeansProjects\\Autoschool\\src\\autoschool\\nowUser");
                    try {
                        Files.write(file2, lines2.getBytes(), StandardOpenOption.APPEND);
                    } catch (IOException e) {
                        e.printStackTrace();}
                if (realuser.checker(inLogin, inParol)==true){
                   
                    Stage newstage = new Stage();
                    newstage.setTitle("Главное меню");
                    Parent root = FXMLLoader.load(getClass().getResource("KlientMenu.fxml"));
                    Scene scene = new Scene(root);
                    newstage.setScene(scene);
                    newstage.show();
                    Stage stage1 = (Stage) btn.getScene().getWindow();
                    stage1.close();
                    testt=true;
                     firsttest=true;
                }
                    }    
            if (testt==false){
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Ошибка");
                    alert.setHeaderText("Сообщение об ошибке");
                    alert.setContentText("Проверьте введённые логин, пароль и роль в системе");
                    alert.showAndWait();
            }
        }        
        
        if(Role.equals("Инструктор_Преподаватель")){
            Scanner in = new Scanner(new File("C:\\Users\\russi\\Documents\\NetBeansProjects\\Autoschool\\src\\autoschool\\staff"));
            User realuser = new User(login, parol);
            boolean test = false;
            FileWriter fw = new FileWriter("C:\\Users\\russi\\Documents\\NetBeansProjects\\Autoschool\\src\\autoschool\\nowUser");
                    PrintWriter pw = new PrintWriter(fw);
                    pw.write("");
                    pw.flush(); 
                    pw.close();
                    String lines2 = realuser.login;
                    Path file2 = Paths.get("C:\\Users\\russi\\Documents\\NetBeansProjects\\Autoschool\\src\\autoschool\\nowUser");
                    try {
                        Files.write(file2, lines2.getBytes(), StandardOpenOption.APPEND);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
            while (in.hasNext()){
                String inLogin = in.next();
                String inParol = in.next();
                if (realuser.checker(inLogin, inParol)==true){
                    Stage newstage = new Stage();
                    newstage.setTitle("Главное меню");
                    Parent root = FXMLLoader.load(getClass().getResource("StaffMenu.fxml"));
                    Scene scene = new Scene(root);
                    newstage.setScene(scene);
                    newstage.show();
                    Stage stage1 = (Stage) btn.getScene().getWindow();
                    stage1.close();
                    test=true;
                     firsttest=true;
                }
            }
            if(test==false){
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Ошибка");
                    alert.setHeaderText("Сообщение об ошибке");
                    alert.setContentText("Проверьте введённые логин, пароль и роль в системе");
                    alert.showAndWait();
            }    
        }  
        
        if(Role.equals("Администратор")){
            if(login.equals("admin")&&parol.equals("123")){
                Stage registerstage = new Stage();
                registerstage.setTitle("Главное меню");
                Parent root = FXMLLoader.load(getClass().getResource("AdminMenu.fxml"));
                Scene scene = new Scene(root);
                registerstage.setScene(scene);
                registerstage.show();
                Stage stage1 = (Stage) btn.getScene().getWindow();
                stage1.close();
                firsttest=true;
        }else{
           Alert alert = new Alert(Alert.AlertType.ERROR);
           alert.setTitle("Ошибка");
           alert.setHeaderText("Сообщение об ошибке");
           alert.setContentText("Проверьте введённые логин, пароль и роль в системе");
           alert.showAndWait();
        }}
    }
    
    @FXML
    private void clear(ActionEvent event){
        logins.setText("");
        password.setText("");
    }
    
    @FXML
    private Button btn1;
    @FXML
    private void gowithout(ActionEvent event) throws IOException{
        Stage newstage = new Stage();
                    newstage.setTitle("Главное меню");
                    Parent root = FXMLLoader.load(getClass().getResource("MainMenuOpen.fxml"));
                    Scene scene = new Scene(root);
                    newstage.setScene(scene);
                    newstage.show();
                    Stage stage1 = (Stage) btn1.getScene().getWindow();
                    stage1.close();
    }
    
    @FXML
    public void PressLink(javafx.event.ActionEvent actionEvent) throws IOException {
        Stage registerstage = new Stage();
        registerstage.setTitle("Регистрация");
        Parent root = FXMLLoader.load(getClass().getResource("Registration.fxml"));
        Scene scene = new Scene(root);
        registerstage.setScene(scene);
        registerstage.show();
        Stage stage1 = (Stage) reglink.getScene().getWindow();
        stage1.close();
    }             
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        list.add("Администратор");
        list.add("Клиент");
        list.add("Инструктор_Преподаватель");
        role.setItems(list);
        role.getSelectionModel().select(0);
    } 
    
    
}
