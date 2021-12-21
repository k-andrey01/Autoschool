/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package autoschool;

import java.io.BufferedReader;
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
import javafx.scene.control.Alert;
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
public class KlientController implements Initializable{
    Shedule purchases;

    @FXML
    private ComboBox ChooseCourse;
        ObservableList <String> list= FXCollections.observableArrayList();
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
    private ComboBox oplata;
        ObservableList <String> list1= FXCollections.observableArrayList();
    @FXML
    private TextField cardNumber;
    @FXML
    private TextField cardSrok;
    @FXML
    private TextField cardCVC;
    @FXML
    private Button give;
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
        String Opl=oplata.getValue().toString();
        String CardNum=cardNumber.getText();
        String CardSrok=cardSrok.getText();
        String CardCVC=cardCVC.getText();
        String skip = "Лично";
        if (Opl.equals("Личное посещение")){
                    FileWriter fw = new FileWriter("C:\\Users\\russi\\Documents\\NetBeansProjects\\Autoschool\\src\\autoschool\\KlientZayavki");
                    PrintWriter pw = new PrintWriter(fw);
                    String lines2 = realuser+" "+Fam+" "+Name+" "+Otch+" "+Course+"_Не_оплачено"+"\n";
                    Path file2 = Paths.get("C:\\Users\\russi\\Documents\\NetBeansProjects\\Autoschool\\src\\autoschool\\KlientZayavki");
                    try {
                        Files.write(file2, lines2.getBytes(), StandardOpenOption.APPEND);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
        }if (Opl.equals("Online")){
            if (CardNum.length()==16&&CardSrok.length()==5&&CardCVC.length()==3){
            FileWriter fw = new FileWriter("C:\\Users\\russi\\Documents\\NetBeansProjects\\Autoschool\\src\\autoschool\\KlientZayavki");
                    PrintWriter pw = new PrintWriter(fw);
                    String lines2 = realuser+" "+Fam+" "+Name+" "+Otch+" "+Course+"_Оплачено"+"\n";
                    Path file2 = Paths.get("C:\\Users\\russi\\Documents\\NetBeansProjects\\Autoschool\\src\\autoschool\\KlientZayavki");
                    try {
                        Files.write(file2, lines2.getBytes(), StandardOpenOption.APPEND);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
            }else{
                 Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Ошибка");
                    alert.setHeaderText("Сообщение об ошибке");
                    alert.setContentText("Проверьте платежные данные");
                    alert.showAndWait();
            }        
        }            
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
    
    private final ObservableList <Shedule> sheduleData = FXCollections.observableArrayList();
    @FXML
    private TableView <Shedule> shedule;
    @FXML
    private TableColumn <Shedule, String> sheduleTheme;
    @FXML
    private TableColumn <Shedule, String> sheduleDate;
    @FXML
    private TableColumn <Shedule, String> sheduleType;
    @FXML
    private TableColumn <Shedule, String> sheduleStatus;
    
    private final ObservableList <Test> testData = FXCollections.observableArrayList();
    @FXML
    private TableView <Test> test;
    @FXML
    private TableColumn <Test, String> testDate;
    @FXML
    private TableColumn <Test, String> testMistakes;
    @FXML
    private TableColumn <Test, String> testResult;
    
    private final ObservableList <Test> examData = FXCollections.observableArrayList();
    @FXML
    private TableView <Test> exam;
    @FXML
    private TableColumn <Test, String> examDate;
    @FXML
    private TableColumn <Test, String> examMistakes;
    @FXML
    private TableColumn <Test, String> examResult;
    
    @Override
    public void initialize(URL location, ResourceBundle resources){
            try {
                try {
                    try {
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
                        
                        list.add("Не_выбрано");
                        list.add("Категория_А");
                        list.add("Категория_В");
                        list.add("Категория_С");
                        list.add("Доп._вождение");
                        list.add("Теория");
                        ChooseCourse.setItems(list);
                        ChooseCourse.getSelectionModel().select(0);
                        
                        list1.add("Личное посещение");
                        list1.add("Online");
                        oplata.setItems(list1);
                        oplata.getSelectionModel().select(0);
                        
                        Scanner real=new Scanner(new File("C:\\Users\\russi\\Documents\\NetBeansProjects\\Autoschool\\src\\autoschool\\nowUser"));
                        String staffer=real.next();
                        
                        String[] strarray = null;
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
                            if (staffer.equals(strarray[0])||strarray[0].equals("ВСЕ")){
                                sheduleData.add(new Shedule(strarray[0], strarray[1], strarray[2], strarray[3], strarray[4], strarray[5]));
                            }
                        }
                        sheduleTheme.setCellValueFactory(new PropertyValueFactory<>("Theme"));
                        sheduleDate.setCellValueFactory(new PropertyValueFactory<>("Date"));
                        sheduleType.setCellValueFactory(new PropertyValueFactory<>("Type"));
                        sheduleStatus.setCellValueFactory(new PropertyValueFactory<>("Status"));
                        shedule.setItems(sheduleData);
                    } catch (FileNotFoundException ex) {
                        Logger.getLogger(KlientController.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    shedule.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
                        showDetails(newValue);
                    });
                    
                    Scanner real=new Scanner(new File("C:\\Users\\russi\\Documents\\NetBeansProjects\\Autoschool\\src\\autoschool\\nowUser"));
                    String staffer=real.next();
                    String[] strarray = null;
                    FileInputStream fin = new FileInputStream("C:\\Users\\russi\\Documents\\NetBeansProjects\\Autoschool\\src\\autoschool\\Tests");
                    BufferedReader br = new BufferedReader(new InputStreamReader(fin));
                    while (true) {
                        try {
                            strarray = br.readLine().split(" ");
                        } catch (NullPointerException e) {
                            break;
                        } catch (IOException ex) {
                            Logger.getLogger(StaffController.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        if (staffer.equals(strarray[0])){
                            testData.add(new Test(strarray[0], strarray[1], strarray[2], strarray[3]));
                        }
                    }
                    testDate.setCellValueFactory(new PropertyValueFactory<>("Date"));
                    testMistakes.setCellValueFactory(new PropertyValueFactory<>("Mistakes"));
                    testResult.setCellValueFactory(new PropertyValueFactory<>("Result"));
                    test.setItems(testData);
                    
                } catch (FileNotFoundException ex) {
                    Logger.getLogger(KlientController.class.getName()).log(Level.SEVERE, null, ex);
                }
                
                Scanner real=new Scanner(new File("C:\\Users\\russi\\Documents\\NetBeansProjects\\Autoschool\\src\\autoschool\\nowUser"));
                String staffer=real.next();
                String[] strarray = null;
                FileInputStream fin = new FileInputStream("C:\\Users\\russi\\Documents\\NetBeansProjects\\Autoschool\\src\\autoschool\\Exams");
                BufferedReader br = new BufferedReader(new InputStreamReader(fin));
                while (true) {
                    try {
                        strarray = br.readLine().split(" ");
                    } catch (NullPointerException e) {
                        break;
                    } catch (IOException ex) {
                        Logger.getLogger(StaffController.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    if (staffer.equals(strarray[0])){
                        examData.add(new Test(strarray[0], strarray[1], strarray[2], strarray[3]));
                    }
                }
                examDate.setCellValueFactory(new PropertyValueFactory<>("Date"));
                examMistakes.setCellValueFactory(new PropertyValueFactory<>("Mistakes"));
                examResult.setCellValueFactory(new PropertyValueFactory<>("Result"));
                exam.setItems(examData);
                
            } catch (FileNotFoundException ex) {
            Logger.getLogger(KlientController.class.getName()).log(Level.SEVERE, null, ex);
        }
    
}
    
    @FXML
    private Label mySheduleTheme;
    @FXML
    private Label mySheduleDate;
    @FXML
    private Label mySheduleType;
    @FXML
    private Label mySheduleStatus;
private void showDetails(Shedule product){
        if(product != null){
            mySheduleTheme.setText(product.getTheme());
            mySheduleDate.setText(product.getDate());
            mySheduleType.setText(product.getType());
            mySheduleStatus.setText(product.getStatus());
        }
        else {
            mySheduleTheme.setText("");
            mySheduleDate.setText("");
            mySheduleType.setText("");
            mySheduleStatus.setText("");
        }
    }
}
