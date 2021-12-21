/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package autoschool;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

/**
 *
 * @author russi
 */
public class AddClientController implements Initializable{
    private Stage stage2;

    
    private final ObservableList <UserOnStudy> zayData = FXCollections.observableArrayList();
    @FXML
    private TableView <UserOnStudy> zay;

    @FXML
    private TableColumn <UserOnStudy, String> zayFam;
    @FXML
    private TableColumn <UserOnStudy, String> zayName;
    @FXML
    private TableColumn <UserOnStudy, String> zayOtch;
    @FXML
    private TableColumn <UserOnStudy, String> zayStatus;
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        FileInputStream fin = null; 
                try {
                    String[] strarray = null;
                    fin = new FileInputStream("C:\\Users\\russi\\Documents\\NetBeansProjects\\Autoschool\\src\\autoschool\\KlientZayavki");
                    BufferedReader br = new BufferedReader(new InputStreamReader(fin));
                    while (true) {
                        try {
                            strarray = br.readLine().split(" ");
                        } catch (NullPointerException e) {
                            break;
                        } catch (IOException ex) {
                            Logger.getLogger(StaffController.class.getName()).log(Level.SEVERE, null, ex);
                        }    
                        zayData.add(new UserOnStudy(strarray[0], strarray[1], strarray[2], strarray[3], strarray[4]));
                    }
                    zayFam.setCellValueFactory(new PropertyValueFactory<>("Fam"));
                    zayName.setCellValueFactory(new PropertyValueFactory<>("Name"));
                    zayOtch.setCellValueFactory(new PropertyValueFactory<>("Otch"));
                    zayStatus.setCellValueFactory(new PropertyValueFactory<>("Status"));
                    zay.setItems(zayData);
                } catch (FileNotFoundException ex) {
                    Logger.getLogger(AddClientController.class.getName()).log(Level.SEVERE, null, ex);
                } finally {
                    try {
                        fin.close();
                    } catch (IOException ex) {
                        Logger.getLogger(AddClientController.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                zay.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue3) -> {
                    showDetails(newValue3);
                });
    }
    
    @FXML
    private void handleOk() throws IOException{
        FileWriter fw = new FileWriter("C:\\Users\\russi\\Documents\\NetBeansProjects\\Autoschool\\src\\autoschool\\UsersOnStudy", true);
        String realuser = etaLogin.getText();
        String Fam = etaFam.getText();
        String Name = etaName.getText();
        String Otch = etaOtch.getText();
        String Course = etaStatus.getText();
                   // PrintWriter pw = new PrintWriter(fw);
                    String lines2 = realuser+" "+Fam+" "+Name+" "+Otch+" "+Course+"\n";
                    BufferedWriter bw = new BufferedWriter(fw);
                    bw.write(lines2);
                    bw.close();
    }
    
    @FXML
    private void delete() throws IOException{
        int selectedIndex = zay.getSelectionModel().getSelectedIndex();
        if(selectedIndex >= 0){
            zay.getItems().remove(selectedIndex);
            new UserOnStudy().OverWrite1(zay.getItems());
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
    
    public void setDialogStage(Stage stage1){
        this.stage2=stage1;
    }
    @FXML
    private void handleCancel(){
        stage2.close();
    }
    
    @FXML
    private TextField etaFam;
    @FXML
    private TextField etaName;
    @FXML
    private TextField etaOtch;
    @FXML
    private TextField etaLogin;
    @FXML
    private TextField etaStatus;
private void showDetails(UserOnStudy product){
        if(product != null){
            etaLogin.setText(product.getLog());
            etaFam.setText(product.getFam());
            etaName.setText(product.getName());
            etaOtch.setText(product.getOtch());
            etaStatus.setText(product.getStatus());
        }
        else {
            etaLogin.setText("");
            etaFam.setText("");
            etaName.setText("");
            etaOtch.setText("");
            etaStatus.setText("");
        }
    }
}
