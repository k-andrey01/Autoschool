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
public class EditClientController {
    private Stage dialogStage;
    private UserOnStudy product;
    private boolean okClicked = false;
    
    @FXML
    private TextField qFam;
    @FXML
    private TextField qName;
    @FXML
    private TextField qOtch;
    @FXML
    private TextField qStatus;
    @FXML
    private TextField qLogin;
    
    public void setProduct(UserOnStudy product){
       this.product = product;
        if(product.getLog() != null && product.getFam() != null && product.getName() != null && product.getOtch() != null && product.getStatus() != null) {
            qFam.setText(product.getFam());
            qName.setText(product.getName());
            qOtch.setText(product.getOtch());
            qStatus.setText(product.getStatus());
            qLogin.setText(product.getLog());
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
        if(qFam.getText() == null || qFam.getText().length() == 0)
            errorMessage += "Familia не доступно\n";
        
        if(qName.getText() == null || qName.getText().length() == 0)
            errorMessage += "Нет доступной name\n";
        
        if(qOtch.getText() == null || qOtch.getText().length() == 0)
            errorMessage += "Нет доступной otchestvo\n";
        
        if(qStatus.getText() == null || qStatus.getText().length() == 0)
            errorMessage += "Нет доступного course\n";
        if(qLogin.getText() == null || qLogin.getText().length() == 0)
            errorMessage += "Нет доступного login\n";
        
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
            product.setFam(qFam.getText());
            product.setName(qName.getText());
            product.setOtch(qOtch.getText());
            product.setStatus(qStatus.getText());
            product.setLogin(qLogin.getText());

//            product.addProduct(product);
//            product.OverWrite();
            okClicked = true;
            dialogStage.close();
        }
    }
    
    @FXML
    private Button myBtn;
    @FXML
    private void showZayav(ActionEvent event) throws IOException{
        try{
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(EditCourseController.class.getResource("AddClient.fxml"));
            AnchorPane page = (AnchorPane) loader.load();

            Stage stage2 = new Stage();
            stage2.setTitle("Редактирование client");
            stage2.initModality(Modality.WINDOW_MODAL);
            stage2.initOwner(null);
            Scene scene = new Scene(page);
            stage2.setScene(scene);

            AddClientController controller = loader.getController();
            controller.setDialogStage(stage2);
            //controller.setProduct(product);

            stage2.showAndWait();

           // return controller.isOkClicked();

        } catch (IOException e) {
            e.printStackTrace();
           
        }

    }

    @FXML
    private void handleCancel(){
        dialogStage.close();
    }
}
