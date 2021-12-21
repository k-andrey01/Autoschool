/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package autoschool;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ResourceBundle;
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
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 *
 * @author russi
 */
public class AdminController implements Initializable{

    @FXML
    private void delete() throws IOException{
        int selectedIndex = courses.getSelectionModel().getSelectedIndex();
        if(selectedIndex >= 0){
            courses.getItems().remove(selectedIndex);
            new Courses().OverWrite(courses.getItems());
        }
        else {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.initOwner(null);
            alert.setTitle("Не выделено");
            alert.setHeaderText("Не выбран курс");
            alert.setContentText("Выберите курс в таблице");
            alert.showAndWait();
        }
    }
    
    @FXML
    private void add() throws IOException{
        Courses cours = new Courses();
        boolean okClicked = showProductEditDialog(cours);
        if(okClicked) {
            courseData.add(cours);
            new Courses().OverWrite(courses.getItems());
        }
    }
    public boolean showProductEditDialog(Courses product){
        try{
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(EditCourseController.class.getResource("EditCourse.fxml"));
            AnchorPane page = (AnchorPane) loader.load();

            Stage dialogStage = new Stage();
            dialogStage.setTitle("Редактирование курса");
            dialogStage.initModality(Modality.WINDOW_MODAL);
            dialogStage.initOwner(null);
            Scene scene = new Scene(page);
            dialogStage.setScene(scene);

            EditCourseController controller = loader.getController();
            controller.setDialogStage(dialogStage);
            controller.setProduct(product);

            dialogStage.showAndWait();

            return controller.isOkClicked();

        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }
    
    
    @FXML
    private void deleteStaff() throws IOException{
        int selectedIndex = staff.getSelectionModel().getSelectedIndex();
        if(selectedIndex >= 0){
            staff.getItems().remove(selectedIndex);
            new StaffOnWork().OverWrite(staff.getItems());
        }
        else {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.initOwner(null);
            alert.setTitle("Не выделено");
            alert.setHeaderText("Не выбран сотрудник");
            alert.setContentText("Выберите сотрудника в таблице");
            alert.showAndWait();
        }
    }
    
    @FXML
    private void addStaff() throws IOException{
        StaffOnWork staf = new StaffOnWork();
        boolean okClicked = showStaffEditDialog(staf);
        if(okClicked) {
            staffData.add(staf);
            new StaffOnWork().OverWrite(staff.getItems());
        }
    }
    @FXML
    private void editStaff() throws IOException{
        StaffOnWork selectedProduct = staff.getSelectionModel().getSelectedItem();
        if(selectedProduct != null) {
            boolean okClicked = showStaffEditDialog(selectedProduct);
            if (okClicked) {
                showDetails1(selectedProduct);
                int selectedIndex = staff.getSelectionModel().getSelectedIndex();
                staffData.set(selectedIndex, selectedProduct);
//                new Products().setProductData(productData);
                new StaffOnWork().OverWrite(staff.getItems());
            }
        }
    }
    public boolean showStaffEditDialog(StaffOnWork product){
        try{
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(EditCourseController.class.getResource("EditPersonal.fxml"));
            AnchorPane page = (AnchorPane) loader.load();

            Stage dialogStage = new Stage();
            dialogStage.setTitle("Изменение сотрудника");
            dialogStage.initModality(Modality.WINDOW_MODAL);
            dialogStage.initOwner(null);
            Scene scene = new Scene(page);
            dialogStage.setScene(scene);

            EditStaffController controller = loader.getController();
            controller.setDialogStage(dialogStage);
            controller.setProduct(product);

            dialogStage.showAndWait();

            return controller.isOkClicked();

        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }
    
    @FXML
    private void deleteClient() throws IOException{
        int selectedIndex = user.getSelectionModel().getSelectedIndex();
        if(selectedIndex >= 0){
            user.getItems().remove(selectedIndex);
            new UserOnStudy().OverWrite(user.getItems());
        }
        else {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.initOwner(null);
            alert.setTitle("Не выделено");
            alert.setHeaderText("Не выбран client");
            alert.setContentText("Выберите client в таблице");
            alert.showAndWait();
        }
    }
    
    @FXML
    private void addClient() throws IOException{
        UserOnStudy staf = new UserOnStudy();
        boolean okClicked = showClientEditDialog(staf);
        if(okClicked) {
            userData.add(staf);
            new UserOnStudy().OverWrite(user.getItems());
        }
    }
    @FXML
    private void editClient() throws IOException{
        UserOnStudy selectedProduct = user.getSelectionModel().getSelectedItem();
        if(selectedProduct != null) {
            boolean okClicked = showClientEditDialog(selectedProduct);
            if (okClicked) {
                showDetails1(selectedProduct);
                int selectedIndex = staff.getSelectionModel().getSelectedIndex();
                userData.set(selectedIndex, selectedProduct);
//                new Products().setProductData(productData);
                new UserOnStudy().OverWrite(user.getItems());
            }
        }
    }
    public boolean showClientEditDialog(UserOnStudy product){
        try{
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(EditCourseController.class.getResource("EditClient.fxml"));
            AnchorPane page = (AnchorPane) loader.load();

            Stage dialogStage = new Stage();
            dialogStage.setTitle("Изменение client");
            dialogStage.initModality(Modality.WINDOW_MODAL);
            dialogStage.initOwner(null);
            Scene scene = new Scene(page);
            dialogStage.setScene(scene);

            EditClientController controller = loader.getController();
            controller.setDialogStage(dialogStage);
            controller.setProduct(product);

            dialogStage.showAndWait();

            return controller.isOkClicked();

        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }
    
    
    @FXML
    private void delShed() throws IOException{
        int selectedIndex = shed.getSelectionModel().getSelectedIndex();
        if(selectedIndex >= 0){
            shed.getItems().remove(selectedIndex);
            new Shedule().OverWrite(shed.getItems());
        }
        else {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.initOwner(null);
            alert.setTitle("Не выделено");
            alert.setHeaderText("Не выбран shedule");
            alert.setContentText("Выберите shedule в таблице");
            alert.showAndWait();
        }
    }
    
    @FXML
    private void addShed() throws IOException{
        Shedule staf = new Shedule();
        boolean okClicked = showShedEditDialog(staf);
        if(okClicked) {
            shedData.add(staf);
            new UserOnStudy().OverWrite(user.getItems());
        }
    }
    @FXML
    private void editShed() throws IOException{
        Shedule selectedProduct = shed.getSelectionModel().getSelectedItem();
        if(selectedProduct != null) {
            boolean okClicked = showShedEditDialog(selectedProduct);
            if (okClicked) {
                showDetails5(selectedProduct);
                int selectedIndex = shed.getSelectionModel().getSelectedIndex();
                shedData.set(selectedIndex, selectedProduct);
//                new Products().setProductData(productData);
                new Shedule().OverWrite(shed.getItems());
            }
        }
    }
    public boolean showShedEditDialog(Shedule product){
        try{
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(EditCourseController.class.getResource("EditShedule.fxml"));
            AnchorPane page = (AnchorPane) loader.load();

            Stage dialogStage = new Stage();
            dialogStage.setTitle("Изменение shedule");
            dialogStage.initModality(Modality.WINDOW_MODAL);
            dialogStage.initOwner(null);
            Scene scene = new Scene(page);
            dialogStage.setScene(scene);

            EditSheduleController controller = loader.getController();
            controller.setDialogStage(dialogStage);
            controller.setProduct(product);

            dialogStage.showAndWait();

            return controller.isOkClicked();

        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }
    
    
    
    @FXML
    private void delTest() throws IOException{
        int selectedIndex = test.getSelectionModel().getSelectedIndex();
        if(selectedIndex >= 0){
            test.getItems().remove(selectedIndex);
            new TestWork().OverWrite(test.getItems());
        }
        else {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.initOwner(null);
            alert.setTitle("Не выделено");
            alert.setHeaderText("Не выбран test");
            alert.setContentText("Выберите test в таблице");
            alert.showAndWait();
        }
    }
    
    @FXML
    private void addTest() throws IOException{
        TestWork staf = new TestWork();
        boolean okClicked = showTestEditDialog(staf);
        if(okClicked) {
            testData.add(staf);
            new TestWork().OverWrite(test.getItems());
        }
    }
    public boolean showTestEditDialog(TestWork product){
        try{
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(EditCourseController.class.getResource("EditTest.fxml"));
            AnchorPane page = (AnchorPane) loader.load();

            Stage dialogStage = new Stage();
            dialogStage.setTitle("Изменение test");
            dialogStage.initModality(Modality.WINDOW_MODAL);
            dialogStage.initOwner(null);
            Scene scene = new Scene(page);
            dialogStage.setScene(scene);

            EditTestController controller = loader.getController();
            controller.setDialogStage(dialogStage);
            controller.setProduct(product);

            dialogStage.showAndWait();

            return controller.isOkClicked();

        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }
    
    
    @FXML
    private void delExam() throws IOException{
        int selectedIndex = exam.getSelectionModel().getSelectedIndex();
        if(selectedIndex >= 0){
            exam.getItems().remove(selectedIndex);
            new TestWork().OverWrite1(exam.getItems());
        }
        else {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.initOwner(null);
            alert.setTitle("Не выделено");
            alert.setHeaderText("Не выбран exam");
            alert.setContentText("Выберите exam в таблице");
            alert.showAndWait();
        }
    }
    
    @FXML
    private void addExam() throws IOException{
        TestWork staf = new TestWork();
        boolean okClicked = showTestEditDialog(staf);
        if(okClicked) {
            examData.add(staf);
            new TestWork().OverWrite1(exam.getItems());
        }
    }
    public boolean showExamEditDialog(TestWork product){
        try{
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(EditCourseController.class.getResource("EditExam.fxml"));
            AnchorPane page = (AnchorPane) loader.load();

            Stage dialogStage = new Stage();
            dialogStage.setTitle("Изменение test");
            dialogStage.initModality(Modality.WINDOW_MODAL);
            dialogStage.initOwner(null);
            Scene scene = new Scene(page);
            dialogStage.setScene(scene);

            EditExamController controller = loader.getController();
            controller.setDialogStage(dialogStage);
            controller.setProduct(product);

            dialogStage.showAndWait();

            return controller.isOkClicked();

        } catch (IOException e) {
            e.printStackTrace();
            return false;
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
    
     private final ObservableList <Courses> courseData = FXCollections.observableArrayList();
    @FXML
    private TableView <Courses> courses;
    @FXML
    private TableColumn <Courses, String> courseName;
    @FXML
    private TableColumn <Courses, String> coursePrice;
    @FXML
    private TableColumn <Courses, String> courseTime;
    @FXML
    private TableColumn <Courses, String> courseRating;
    
    
    private final ObservableList <StaffOnWork> staffData = FXCollections.observableArrayList();
    @FXML
    private TableView <StaffOnWork> staff;

    @FXML
    private TableColumn <StaffOnWork, String> staffFam;
    @FXML
    private TableColumn <StaffOnWork, String> staffName;
    @FXML
    private TableColumn <StaffOnWork, String> staffOtch;
    @FXML
    private TableColumn <StaffOnWork, String> staffCourse;
    
    
    private final ObservableList <UserOnStudy> userData = FXCollections.observableArrayList();
    @FXML
    private TableView <UserOnStudy> user;

    @FXML
    private TableColumn <UserOnStudy, String> userFam;
    @FXML
    private TableColumn <UserOnStudy, String> userName;
    @FXML
    private TableColumn <UserOnStudy, String> userOtch;
    @FXML
    private TableColumn <UserOnStudy, String> userStatus;
    
    
    private final ObservableList <Shedule> shedData = FXCollections.observableArrayList();
    @FXML
    private TableView <Shedule> shed;
    @FXML
    private TableColumn <Shedule, String> shedClient;
    @FXML
    private TableColumn <Shedule, String> shedStaff;
    @FXML
    private TableColumn <Shedule, String> shedDate;
    @FXML
    private TableColumn <Shedule, String> shedStatus;
    
    private final ObservableList <TestWork> testData = FXCollections.observableArrayList();
    @FXML
    private TableView <TestWork> test;
    @FXML
    private TableColumn <TestWork, String> testClient;
    @FXML
    private TableColumn <TestWork, String> testDate;
    @FXML
    private TableColumn <TestWork, String> testMistakes;
    @FXML
    private TableColumn <TestWork, String> testResult;
    
    private final ObservableList <TestWork> examData = FXCollections.observableArrayList();
    @FXML
    private TableView <TestWork> exam;
    @FXML
    private TableColumn <TestWork, String> examClient;
    @FXML
    private TableColumn <TestWork, String> examDate;
    @FXML
    private TableColumn <TestWork, String> examMistakes;
    @FXML
    private TableColumn <TestWork, String> examResult;
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {
            FileInputStream finn = null;
            try {
                FileInputStream fins = null;
                try {
                    try {
                        FileInputStream fin = null;                        
                        try {
                            
                            try {
                                String[] strarray = null;
                                fin = new FileInputStream("C:\\Users\\russi\\Documents\\NetBeansProjects\\Autoschool\\src\\autoschool\\Courses");
                                BufferedReader br = new BufferedReader(new InputStreamReader(fin));
                                while (true) {
                                    try {
                                        strarray = br.readLine().split(" ");
                                    } catch (NullPointerException e) {
                                        break;
                                    } catch (IOException ex) {
                                        Logger.getLogger(StaffController.class.getName()).log(Level.SEVERE, null, ex);
                                    }
                                    courseData.add(new Courses(strarray[0], strarray[1], strarray[2], strarray[3]));
                                }
                                courseName.setCellValueFactory(new PropertyValueFactory<>("Name"));
                                coursePrice.setCellValueFactory(new PropertyValueFactory<>("Price"));
                                courseTime.setCellValueFactory(new PropertyValueFactory<>("Time"));
                                courseRating.setCellValueFactory(new PropertyValueFactory<>("Rating"));
                                courses.setItems(courseData);
                            } catch (FileNotFoundException ex) {
                                Logger.getLogger(AdminController.class.getName()).log(Level.SEVERE, null, ex);
                            } finally {
                                try {
                                    fin.close();
                                } catch (IOException ex) {
                                    Logger.getLogger(AdminController.class.getName()).log(Level.SEVERE, null, ex);
                                }
                            }
                            courses.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
                                showDetails(newValue);
                            });
                            
                            String[] strarray = null;
                            fin = new FileInputStream("C:\\Users\\russi\\Documents\\NetBeansProjects\\Autoschool\\src\\autoschool\\StaffOnWork");
                            BufferedReader br = new BufferedReader(new InputStreamReader(fin));
                            while (true) {
                                try {
                                    strarray = br.readLine().split(" ");
                                } catch (NullPointerException e) {
                                    break;
                                } catch (IOException ex) {
                                    Logger.getLogger(StaffController.class.getName()).log(Level.SEVERE, null, ex);
                                }
                                staffData.add(new StaffOnWork(strarray[0], strarray[1], strarray[2], strarray[3], strarray[4]));
                            }
                            
                            staffFam.setCellValueFactory(new PropertyValueFactory<>("Fam"));
                            staffName.setCellValueFactory(new PropertyValueFactory<>("Name"));
                            staffOtch.setCellValueFactory(new PropertyValueFactory<>("Otch"));
                            staffCourse.setCellValueFactory(new PropertyValueFactory<>("Course"));
                            staff.setItems(staffData);
                        } catch (FileNotFoundException ex) {
                            Logger.getLogger(AdminController.class.getName()).log(Level.SEVERE, null, ex);
                        } finally {
                            try {
                                fin.close();
                            } catch (IOException ex) {
                                Logger.getLogger(AdminController.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        }
                        
                        
                        staff.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue1) -> {
                            showDetails1(newValue1);
                        });
                        
                        
                        String[] strarray = null;
                        fin = new FileInputStream("C:\\Users\\russi\\Documents\\NetBeansProjects\\Autoschool\\src\\autoschool\\UsersOnStudy");
                        BufferedReader br = new BufferedReader(new InputStreamReader(fin));
                        while (true) {
                            try {
                                strarray = br.readLine().split(" ");
                            } catch (NullPointerException e) {
                                break;
                            } catch (IOException ex) {
                                Logger.getLogger(StaffController.class.getName()).log(Level.SEVERE, null, ex);
                            }
                            userData.add(new UserOnStudy(strarray[0], strarray[1], strarray[2], strarray[3], strarray[4]));
                        }
                        
                        userFam.setCellValueFactory(new PropertyValueFactory<>("Fam"));
                        userName.setCellValueFactory(new PropertyValueFactory<>("Name"));
                        userOtch.setCellValueFactory(new PropertyValueFactory<>("Otch"));
                        userStatus.setCellValueFactory(new PropertyValueFactory<>("Status"));
                        user.setItems(userData);
                        
                        fin.close();
                        
                        
                        user.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue2) -> {
                            showDetails1(newValue2);
                        });
                    }       catch (IOException ex) {
                        Logger.getLogger(AdminController.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    String[] strarray = null;
                    fins = new FileInputStream("C:\\Users\\russi\\Documents\\NetBeansProjects\\Autoschool\\src\\autoschool\\SheduleThemes");
                    BufferedReader br = new BufferedReader(new InputStreamReader(fins));
                    while (true) {
                        try {
                            strarray = br.readLine().split(" ");
                        } catch (NullPointerException e) {
                            break;
                        } catch (IOException ex) {
                            Logger.getLogger(AdminController.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        shedData.add(new Shedule(strarray[0], strarray[1], strarray[2], strarray[3], strarray[4], strarray[5]));
                    }
                    shedClient.setCellValueFactory(new PropertyValueFactory<>("Klient"));
                    shedStaff.setCellValueFactory(new PropertyValueFactory<>("Staff"));
                    shedDate.setCellValueFactory(new PropertyValueFactory<>("Date"));
                    shedStatus.setCellValueFactory(new PropertyValueFactory<>("Status"));
                    shed.setItems(shedData);
                    fins.close();
                    shed.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue2) -> {
                        showDetails5(newValue2);
                    });
                }       catch (FileNotFoundException ex) {
                    Logger.getLogger(AdminController.class.getName()).log(Level.SEVERE, null, ex);
                }       catch (IOException ex) {
                    Logger.getLogger(AdminController.class.getName()).log(Level.SEVERE, null, ex);
                } finally {
                    try {
                        fins.close();
                    } catch (IOException ex) {
                        Logger.getLogger(AdminController.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                
                
                String[] strarray = null;
                fins = new FileInputStream("C:\\Users\\russi\\Documents\\NetBeansProjects\\Autoschool\\src\\autoschool\\Tests");
                BufferedReader br = new BufferedReader(new InputStreamReader(fins));
                while (true) {
                    try {
                        strarray = br.readLine().split(" ");
                    } catch (NullPointerException e) {
                        break;
                    } catch (IOException ex) {
                        Logger.getLogger(AdminController.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    testData.add(new TestWork(strarray[0], strarray[1], strarray[2], strarray[3]));
                }
                testClient.setCellValueFactory(new PropertyValueFactory<>("Client"));
                testDate.setCellValueFactory(new PropertyValueFactory<>("Date"));
                testMistakes.setCellValueFactory(new PropertyValueFactory<>("mistakes"));
                testResult.setCellValueFactory(new PropertyValueFactory<>("Result"));
                test.setItems(testData);
                fins.close();
                test.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue2) -> {
                    showDetails16(newValue2);
                });
                
                fins.close();
                
            }       catch (IOException ex) {
                Logger.getLogger(AdminController.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            
            String[] strarray = null;
            finn = new FileInputStream("C:\\Users\\russi\\Documents\\NetBeansProjects\\Autoschool\\src\\autoschool\\Exams");
            BufferedReader br = new BufferedReader(new InputStreamReader(finn));
            while (true) {
                try {
                    strarray = br.readLine().split(" ");
                } catch (NullPointerException e) {
                    break;
                } catch (IOException ex) {
                    Logger.getLogger(AdminController.class.getName()).log(Level.SEVERE, null, ex);
                }
                examData.add(new TestWork(strarray[0], strarray[1], strarray[2], strarray[3]));
            }
            examClient.setCellValueFactory(new PropertyValueFactory<>("Client"));
            examDate.setCellValueFactory(new PropertyValueFactory<>("Date"));
            examMistakes.setCellValueFactory(new PropertyValueFactory<>("Mistakes"));
            examResult.setCellValueFactory(new PropertyValueFactory<>("Result"));
            exam.setItems(examData);
            finn.close();
            exam.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue2) -> {
                showDetails161(newValue2);
            });
            
            finn.close();
            

        }       catch (FileNotFoundException ex) {
            Logger.getLogger(AdminController.class.getName()).log(Level.SEVERE, null, ex);
}       catch (IOException ex) {
            Logger.getLogger(AdminController.class.getName()).log(Level.SEVERE, null, ex);
        }
            

    }
        

    @FXML
    private Label myName;
    @FXML
    private Label myPrice;
    @FXML
    private Label myTime;
    @FXML
    private Label myRating;
private void showDetails(Courses product){
        if(product != null){
            myName.setText(product.getName());
            myPrice.setText(product.getPrice());
            myTime.setText(product.getTime());
            myRating.setText(product.getRating());
        }
        else {
            myName.setText("");
            myPrice.setText("");
            myTime.setText("");
            myRating.setText("");
        }
    }

@FXML
    private Label iClient;
    @FXML
    private Label iStaff;
    @FXML
    private Label iTheme;
    @FXML
    private Label iDate;
     @FXML
    private Label iType;
      @FXML
    private Label iStatus;
private void showDetails5(Shedule product){
        if(product != null){
            iClient.setText(product.getKlient());
            iStaff.setText(product.getStaff());
            iTheme.setText(product.getTheme());
            iDate.setText(product.getDate());
            iType.setText(product.getType());
            iStatus.setText(product.getStatus());
        }
        else {
            iClient.setText("");
            iStaff.setText("");
            iTheme.setText("");
            iDate.setText("");
            iType.setText("");
            iStatus.setText("");
        }
    }

@FXML
    private void edit() throws IOException{
        Courses selectedProduct = courses.getSelectionModel().getSelectedItem();
        if(selectedProduct != null) {
            boolean okClicked = showProductEditDialog(selectedProduct);
            if (okClicked) {
                showDetails(selectedProduct);
                int selectedIndex = courses.getSelectionModel().getSelectedIndex();
                courseData.set(selectedIndex, selectedProduct);
//                new Products().setProductData(productData);
                new Courses().OverWrite(courses.getItems());
            }
        }
        else {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.initOwner(null);
            alert.setTitle("Ничего не выбрано");
            alert.setHeaderText("Нет выбранного продукта");
            alert.setContentText("Выберите продукт в таблице");

            alert.showAndWait();
        }
    }
    
    @FXML
    private Label nowName;
    @FXML
    private Label nowLog;
    @FXML
    private Label nowFam;
    @FXML
    private Label nowOtch;
    @FXML
    private Label nowCourse;
    private void showDetails1(StaffOnWork product){
        if(product != null){
            nowLog.setText(product.getLog());
            nowFam.setText(product.getFam());
            nowName.setText(product.getName());
            nowOtch.setText(product.getOtch());
            nowCourse.setText(product.getCourse());
        }
        else {
            nowLog.setText("");
            nowFam.setText("");
            nowName.setText("");
            nowOtch.setText("");
            nowCourse.setText("");
        }
    }
    
    @FXML
    private Label hisName;
    @FXML
    private Label hisLog;
    @FXML
    private Label hisFam;
    @FXML
    private Label hisOtch;
    @FXML
    private Label hisStatus;
    private void showDetails1(UserOnStudy product){
        if(product != null){
            hisLog.setText(product.getLog());
            hisFam.setText(product.getFam());
            hisName.setText(product.getName());
            hisOtch.setText(product.getOtch());
            hisStatus.setText(product.getStatus());
        }
        else {
            hisLog.setText("");
            hisFam.setText("");
            hisName.setText("");
            hisOtch.setText("");
            hisStatus.setText("");
        }
    }
    
    @FXML
    private Label tClient;
    @FXML
    private Label tDate;
    @FXML
    private Label tMistakes;
    @FXML
    private Label tResult;

    private void showDetails16(TestWork product){
        if(product != null){
            tClient.setText(product.getClient());
            tDate.setText(product.getDate());
            tMistakes.setText(product.getMistakes());
            tResult.setText(product.getResult());
        }
        else {
            tClient.setText("");
            tDate.setText("");
            tMistakes.setText("");
            tResult.setText("");
        }
    }
    
    @FXML
    private Label eClient;
    @FXML
    private Label eDate;
    @FXML
    private Label eMistakes;
    @FXML
    private Label eResult;

    private void showDetails161(TestWork product){
        if(product != null){
            eClient.setText(product.getClient());
            eDate.setText(product.getDate());
            eMistakes.setText(product.getMistakes());
            eResult.setText(product.getResult());
        }
        else {
            eClient.setText("");
            eDate.setText("");
            eMistakes.setText("");
            eResult.setText("");
        }
    }
}
