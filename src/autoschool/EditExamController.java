/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package autoschool;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 *
 * @author russi
 */
public class EditExamController {
    private Stage dialogStage;
    private TestWork product;
    private boolean okClicked = false;
    
    @FXML
    private TextField eClient;
    @FXML
    private TextField eDate;
    @FXML
    private TextField eMistakes;
    @FXML
    private TextField eResult;

    
    public void setProduct(TestWork product){
       this.product = product;
        if(product.getClient() != null && product.getDate() != null && product.getMistakes() != null && product.getResult() != null) {
            eClient.setText(product.getClient());
            eDate.setText(product.getDate());
            eMistakes.setText(product.getMistakes());
            eResult.setText(product.getResult());
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
        if(eClient.getText() == null || eClient.getText().length() == 0)
            errorMessage += "Client не доступно\n";
        
        if(eDate.getText() == null || eDate.getText().length() == 0)
            errorMessage += "Нет доступной Date\n";
        
        if(eMistakes.getText() == null || eMistakes.getText().length() == 0)
            errorMessage += "Нет доступной Mistakes\n";
        
        if(eResult.getText() == null || eResult.getText().length() == 0)
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
            product.setClient(eClient.getText());
            product.setDate(eDate.getText());
            product.setMistakes(eMistakes.getText());
            product.setResult(eResult.getText());

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
