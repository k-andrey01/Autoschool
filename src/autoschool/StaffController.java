/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package autoschool;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ResourceBundle;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

/**
 *
 * @author russi
 */
public class StaffController implements Initializable{
    
     Shedule purchases;

    @FXML
    private ComboBox<String> ChooseCourse;
    ObservableList <String> list1= FXCollections.observableArrayList();
    
    @FXML
    private TextField myFam;
    
     @FXML
    private TextField myName;
    
      @FXML
    private TextField myOtch;
      
     @FXML
    private TextField myDate;
     
     @FXML
    private TextField myTel;
     
    @FXML
    private Button myBtn;
    
    private final ObservableList <Courses> courseData = FXCollections.observableArrayList();
    @FXML
    private TableView <Courses> AnalizTab;
    @FXML
    private TableColumn <Courses, String> AnalizName;
    @FXML
    private TableColumn <Courses, String> AnalizPrice;
    @FXML
    private TableColumn <Courses, String> AnalizTime;
    @FXML
    private TableColumn <Courses, String> AnalizRating;
    
    @FXML
    public void giveZayav(javafx.event.ActionEvent actionEvent) throws IOException{
        Scanner in = new Scanner(new File("C:\\Users\\russi\\Documents\\NetBeansProjects\\Autoschool\\src\\autoschool\\nowUser"));
        String realuser=in.next();
        String Course=ChooseCourse.getValue().toString();
        String Fam=myFam.getText();
        String Name=myName.getText();
        String Otch=myOtch.getText();
        String Date=myDate.getText();
        String Tel=myTel.getText();
        FileWriter fw = new FileWriter("C:\\Users\\russi\\Documents\\NetBeansProjects\\Autoschool\\src\\autoschool\\StaffZayavki");
                    PrintWriter pw = new PrintWriter(fw);
                    String lines2 = realuser+" "+Fam+" "+Name+" "+Otch+" "+Course+"\n";
                    Path file2 = Paths.get("C:\\Users\\russi\\Documents\\NetBeansProjects\\Autoschool\\src\\autoschool\\StaffZayavki");
                    try {
                        Files.write(file2, lines2.getBytes(), StandardOpenOption.APPEND);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
    }
    
    @FXML
    private Hyperlink link;
    
    @FXML
    public void goLink(ActionEvent event) throws IOException{
        Stage newstage = new Stage();
                    newstage.setTitle("Главное меню");
                    Parent root = FXMLLoader.load(getClass().getResource("MainMenuOpen.fxml"));
                    Scene scene = new Scene(root);
                    newstage.setScene(scene);
                    newstage.show();
                    Stage stage1 = (Stage) link.getScene().getWindow();
                    stage1.close();
    }
    
    @FXML
    private Button first;
    
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
    private ComboBox<String> status;
    ObservableList <String> list= FXCollections.observableArrayList();
private final ObservableList <Shedule> otlozhData = FXCollections.observableArrayList();
    private final ObservableList <Shedule> klientData = FXCollections.observableArrayList();
    @FXML
    private TableView <Shedule> klients;
    @FXML
    private TableColumn <Shedule, String> klientName;
    @FXML
    private TableColumn <Shedule, String> klientDate;
    
    
    private final ObservableList <Shedule> fullInfa = FXCollections.observableArrayList();
    @FXML
    private TableView <Shedule> fullInfo;
    @FXML
    private TableColumn <Shedule, String> infoTheme;
    @FXML
    private TableColumn <Shedule, String> infoType;
    @FXML
    private TableColumn <Shedule, String> infoStatus;
    
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {
            list1.add("Не_выбрано");
            list1.add("Категория_А");
            list1.add("Категория_В");
            list1.add("Категория_С");
            list1.add("Доп._вождение");
            list1.add("Теория");
            ChooseCourse.setItems(list1);
            ChooseCourse.getSelectionModel().select(0);
            
            courseData.clear();
            Scanner in = null;
            try {
                in = new Scanner(new File("C:\\Users\\russi\\Documents\\NetBeansProjects\\Autoschool\\src\\autoschool\\Courses"));
            } catch (FileNotFoundException ex) {
                Logger.getLogger(StaffController.class.getName()).log(Level.SEVERE, null, ex);
            }
            while (in.hasNext()){
                String Name = in.next();
                String Price = in.next();
                String Time = in.next();
                String Rating = in.next();
                
                courseData.add(new Courses(Name, Price, Time, Rating));
                AnalizName.setCellValueFactory(new PropertyValueFactory<>("Name"));
                AnalizPrice.setCellValueFactory(new PropertyValueFactory<>("Price"));
                AnalizTime.setCellValueFactory(new PropertyValueFactory<>("Time"));
                AnalizRating.setCellValueFactory(new PropertyValueFactory<>("Rating"));
                AnalizTab.setItems(courseData);
            }
            
            Scanner real=new Scanner(new File("C:\\Users\\russi\\Documents\\NetBeansProjects\\Autoschool\\src\\autoschool\\nowUser"));
            String staffer=real.next();
            
            String[] strarray = null;
        try {
            FileInputStream fin = new FileInputStream("C:\\Users\\russi\\Documents\\NetBeansProjects\\Autoschool\\src\\autoschool\\SheduleThemes");
            BufferedReader br = new BufferedReader(new InputStreamReader(fin));
            while (true) {
                try {
                    strarray = br.readLine().split(" ");
                } catch (NullPointerException e) {
                    break;
                } catch (IOException ex) {
                    Logger.getLogger(StaffController.class.getName()).log(Level.SEVERE, null, ex);
                }
                if (staffer.equals(strarray[1])){
                klientData.add(new Shedule(strarray[0], strarray[1], strarray[2], strarray[3], strarray[4], strarray[5]));
                }else{otlozhData.add(new Shedule(strarray[0], strarray[1], strarray[2], strarray[3], strarray[4], strarray[5]));}
            }
            klientName.setCellValueFactory(new PropertyValueFactory<>("Klient"));
            klientDate.setCellValueFactory(new PropertyValueFactory<>("Date"));
            klients.setItems(klientData);
                
                list.add("Ожидается");
                list.add("Отлично");
                list.add("Хорошо");
                list.add("Удовлетворительно");
                list.add("Неудовлетворительно");
                status.setItems(list);
                status.setDisable(true);
            } catch (FileNotFoundException ex) {
            Logger.getLogger(StaffController.class.getName()).log(Level.SEVERE, null, ex);
        }
}       catch (FileNotFoundException ex) {
            Logger.getLogger(StaffController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
         try {
             showDetails(null);
         } catch (IOException ex) {
             Logger.getLogger(StaffController.class.getName()).log(Level.SEVERE, null, ex);
         }

        klients.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            try {
                purchases = showDetails(newValue);
            } catch (IOException ex) {
                Logger.getLogger(StaffController.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
} 
    @FXML
    private Label nowClient;
    
    public Shedule showDetails(Shedule purchases) throws IOException{
        ObservableList<Shedule> productData = new Shedule().getsheduleData();
        if (purchases != null) {
            nowClient.setText(purchases.getKlient());

            fullInfo.getItems().clear();
            String[] strarray;
            try {
                FileInputStream fin = new FileInputStream("C:\\Users\\russi\\Documents\\NetBeansProjects\\Autoschool\\src\\autoschool\\SheduleThemes");
                BufferedReader br = new BufferedReader(new InputStreamReader(fin));

                if(purchases.getStatus().equals("Ожидается")) {
                    status.getSelectionModel().select("Ожидается");
                }
                else if(purchases.getStatus().equals("Отлично")) {
                    status.getSelectionModel().select("Отлично");
                }
                else if(purchases.getStatus().equals("Хорошо")) {
                    status.getSelectionModel().select("Хорошо");
                }
                else if(purchases.getStatus().equals("Удовлетворительно")) {
                    status.getSelectionModel().select("Удовлетворительно");
                }
                else if(purchases.getStatus().equals("Неудовлетворительно")) {
                    status.getSelectionModel().select("Неудовлетворительно");
                }
                else
                    status.getSelectionModel().clearSelection();

                fullInfa.add(new Shedule(purchases.getKlient(), purchases.getStaff(), purchases.getTheme(), purchases.getDate(), purchases.getType(), purchases.getStatus()));
                infoTheme.setCellValueFactory(new PropertyValueFactory<>("Theme"));
                infoType.setCellValueFactory(new PropertyValueFactory<>("Type"));
                infoStatus.setCellValueFactory(new PropertyValueFactory<>("Status"));
                fullInfo.setItems(fullInfa);
                fin.close();
            } catch (FileNotFoundException e) {
                System.out.println("File has not found");
            }
        }
        else{
            nowClient.setText("");
        }
        return purchases;
    }
    
    @FXML
    private TextField myClient;
    @FXML
    private void search() throws FileNotFoundException{
        Scanner real=new Scanner(new File("C:\\Users\\russi\\Documents\\NetBeansProjects\\Autoschool\\src\\autoschool\\nowUser"));
            String staffer=real.next();
        String people = myClient.getText();
        String[] strarray = null;
        klientData.clear();
            FileInputStream fin = new FileInputStream("C:\\Users\\russi\\Documents\\NetBeansProjects\\Autoschool\\src\\autoschool\\SheduleThemes");
            BufferedReader br = new BufferedReader(new InputStreamReader(fin));
            while (true) {
                try {
                    strarray = br.readLine().split(" ");
                } catch (NullPointerException e) {
                    break;
                } catch (IOException ex) {
                    Logger.getLogger(StaffController.class.getName()).log(Level.SEVERE, null, ex);
                }
                if (staffer.equals(strarray[1])&&people.equals(strarray[0])){
                klientData.add(new Shedule(strarray[0], strarray[1], strarray[2], strarray[3], strarray[4], strarray[5]));
                }
            }
            klientName.setCellValueFactory(new PropertyValueFactory<>("Klient"));
            klientDate.setCellValueFactory(new PropertyValueFactory<>("Date"));
            klients.setItems(klientData);
    }
    
    @FXML
    private void save() throws IOException{
        if (status.getSelectionModel().getSelectedItem() != null) {
            if (status.getSelectionModel().getSelectedItem().equals("Ожидается"))
                purchases.setStatus("Ожидается");
            else if (status.getSelectionModel().getSelectedItem().equals("Отлично"))
                purchases.setStatus("Отлично");
            else if (status.getSelectionModel().getSelectedItem().equals("Хорошо"))
                purchases.setStatus("Хорошо");
            else if (status.getSelectionModel().getSelectedItem().equals("Удовлетворительно"))
                purchases.setStatus("Удовлетворительно");
            else if (status.getSelectionModel().getSelectedItem().equals("Неудовлетворительно"))
                purchases.setStatus("Неудовлетворительно");
            new Shedule().OverWrite(klientData, otlozhData);
            status.setDisable(true);
        }
    }
    
    @FXML
    private void comboBoxChangeHL(){
        status.setDisable(false);
    }
    
    
}    
