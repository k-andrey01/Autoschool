/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package autoschool;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 *
 * @author russi
 */
public class EditSheduleController {
    private Stage dialogStage;
    private Shedule product;
    private boolean okClicked = false;
    
    @FXML
    private TextField sClient;
    @FXML
    private TextField sStaff;
    @FXML
    private TextField sTheme;
    @FXML
    private TextField sDate;
    @FXML
    private TextField sType;
    @FXML
    private TextField sStatus;
    
    public void setProduct(Shedule product){
       this.product = product;
        if(product.getKlient() != null && product.getStaff() != null && product.getTheme() != null && product.getDate() != null && product.getType() != null && product.getStatus() != null) {
            sClient.setText(product.getKlient());
            sStaff.setText(product.getStaff());
            sTheme.setText(product.getTheme());
            sDate.setText(product.getDate());
            sType.setText(product.getType());
            sStatus.setText(product.getStatus());
        }
    }
    
    public void setDialogStage(Stage dialogStage){
        this.dialogStage=dialogStage;
    }
    
    public boolean isOkClicked(){
        return okClicked;
    }
    
    private boolean isInputValid(){
        String errorMessage = "";
        if(sClient.getText() == null || sClient.getText().length() == 0)
            errorMessage += "Client не доступно\n";
        
        if(sStaff.getText() == null || sStaff.getText().length() == 0)
            errorMessage += "Нет доступной Staff\n";
        
        if(sTheme.getText() == null || sTheme.getText().length() == 0)
            errorMessage += "Нет доступной Theme\n";
        
        if(sDate.getText() == null || sDate.getText().length() == 0)
            errorMessage += "Нет доступного Date\n";
        if(sType.getText() == null || sType.getText().length() == 0)
            errorMessage += "Нет доступного Type\n";
        if(sStatus.getText() == null || sStatus.getText().length() == 0)
            errorMessage += "Нет доступного Status\n";
        
//        try {
//            Integer.parseInt(productIdField.getText());
//            Double.parseDouble(productSumField.getText());
//            Integer.parseInt(productCountField.getText());
//        }catch (NumberFormatException e){
//            errorMessage += "Введите число!";
//        }

        if(errorMessage.length() == 0)
            return true;
        else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.initOwner(dialogStage);
            alert.setTitle("Некорректные поля");
            alert.setHeaderText("Внесите корректную информацию");
            alert.setContentText(errorMessage);
            alert.showAndWait();
            return false;
        }
    }
    
    @FXML
    private void handleOk(){
        if(isInputValid()){
            product.setKlient(sClient.getText());
            product.setStaff(sStaff.getText());
            product.setTheme(sTheme.getText());
            product.setDate(sDate.getText());
            product.setType(sType.getText());
            product.setStatus(sStatus.getText());

//            product.addProduct(product);
//            product.OverWrite();
            okClicked = true;
            dialogStage.close();
        }
    }
    
    
    @FXML
    private void handleCancel(){
        dialogStage.close();
    }
}
