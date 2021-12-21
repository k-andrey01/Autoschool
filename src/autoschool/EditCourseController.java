/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package autoschool;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 *
 * @author russi
 */
public class EditCourseController implements Initializable{
    @FXML
    private TextField newName;
    @FXML
    private TextField newPrice;
    @FXML
    private TextField newTime;
    @FXML
    private TextField newRating;
    
    private Stage dialogStage;
    private Courses product;
    private boolean okClicked = false;
    
    public void setDialogStage(Stage dialogStage){
        this.dialogStage=dialogStage;
    }
    
    public void setProduct(Courses product){
       this.product = product;
        if(product.getName() != null && product.getPrice() != null && product.getTime() != null && product.getRating() != null) {
            newName.setText(product.getName().toString());
            newPrice.setText(product.getPrice());
            newTime.setText(product.getTime());
            newRating.setText(product.getRating());
        }
    }
    
    public boolean isOkClicked(){
        return okClicked;
    }
    
    private boolean isInputValid(){
        String errorMessage = "";
        if(newName.getText() == null || newName.getText().length() == 0)
            errorMessage += "Название не доступно\n";
        
        if(newPrice.getText() == null || newPrice.getText().length() == 0)
            errorMessage += "Нет доступной цены\n";
        
        if(newTime.getText() == null || newTime.getText().length() == 0)
            errorMessage += "Нет доступной продрлжительности\n";
        
        if(newRating.getText() == null || newRating.getText().length() == 0)
            errorMessage += "Нет доступного рейтинга\n";
        
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
            product.setName(newName.getText());
            product.setPrice(newPrice.getText());
            product.setTime(newTime.getText());
            product.setRating(newRating.getText());

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
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        
    }
    
}
