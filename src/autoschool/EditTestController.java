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
public class EditTestController {
    private Stage dialogStage;
    private TestWork product;
    private boolean okClicked = false;
    
    @FXML
    private TextField tClient;
    @FXML
    private TextField tDate;
    @FXML
    private TextField tMistakes;
    @FXML
    private TextField tResult;

    
    public void setProduct(TestWork product){
       this.product = product;
        if(product.getClient() != null && product.getDate() != null && product.getMistakes() != null && product.getResult() != null) {
            tClient.setText(product.getClient());
            tDate.setText(product.getDate());
            tMistakes.setText(product.getMistakes());
            tResult.setText(product.getResult());
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
        if(tClient.getText() == null || tClient.getText().length() == 0)
            errorMessage += "Client не доступно\n";
        
        if(tDate.getText() == null || tDate.getText().length() == 0)
            errorMessage += "Нет доступной Date\n";
        
        if(tMistakes.getText() == null || tMistakes.getText().length() == 0)
            errorMessage += "Нет доступной Mistakes\n";
        
        if(tResult.getText() == null || tResult.getText().length() == 0)
            errorMessage += "Нет доступного Result\n";
        
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
            product.setClient(tClient.getText());
            product.setDate(tDate.getText());
            product.setMistakes(tMistakes.getText());
            product.setResult(tResult.getText());

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
