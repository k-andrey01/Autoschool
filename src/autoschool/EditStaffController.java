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
import javafx.scene.Parent;
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
public class EditStaffController {
    private Stage dialogStage;
    private StaffOnWork product;
    private boolean okClicked = false;
    
    @FXML
    private TextField edFam;
    @FXML
    private TextField edName;
    @FXML
    private TextField edOtch;
    @FXML
    private TextField edCourse;
    @FXML
    private TextField edLogin;
    
    public void setProduct(StaffOnWork product){
       this.product = product;
        if(product.getLog() != null && product.getFam() != null && product.getName() != null && product.getOtch() != null && product.getCourse() != null) {
            edFam.setText(product.getFam());
            edName.setText(product.getName());
            edOtch.setText(product.getOtch());
            edCourse.setText(product.getCourse());
            edLogin.setText(product.getLog());
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
        if(edFam.getText() == null || edFam.getText().length() == 0)
            errorMessage += "Familia не доступно\n";
        
        if(edName.getText() == null || edName.getText().length() == 0)
            errorMessage += "Нет доступной name\n";
        
        if(edOtch.getText() == null || edOtch.getText().length() == 0)
            errorMessage += "Нет доступной otchestvo\n";
        
        if(edCourse.getText() == null || edCourse.getText().length() == 0)
            errorMessage += "Нет доступного course\n";
        if(edLogin.getText() == null || edLogin.getText().length() == 0)
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
            product.setFam(edFam.getText());
            product.setName(edName.getText());
            product.setOtch(edOtch.getText());
            product.setCourse(edCourse.getText());
            product.setLogin(edLogin.getText());

//            product.addProduct(product);
//            product.OverWrite();
            okClicked = true;
            dialogStage.close();
        }
    }
    
    @FXML
    private Button myBtn;
    @FXML
    private void watchZayavStaff(ActionEvent event) throws IOException{
        try{
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(EditCourseController.class.getResource("AddStaff.fxml"));
            AnchorPane page = (AnchorPane) loader.load();

            Stage stage1 = new Stage();
            stage1.setTitle("Редактирование курса");
            stage1.initModality(Modality.WINDOW_MODAL);
            stage1.initOwner(null);
            Scene scene = new Scene(page);
            stage1.setScene(scene);

            AddStaffController controller = loader.getController();
            controller.setDialogStage(stage1);
            //controller.setProduct(product);

            stage1.showAndWait();

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
