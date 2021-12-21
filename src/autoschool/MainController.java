/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package autoschool;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

/**
 *
 * @author russi
 */
public class MainController {
    @FXML
    private Button first;
    
    @FXML
    private void vhod() throws IOException{
        Stage newstage = new Stage();
                    newstage.setTitle("Главное меню");
                    Parent root = FXMLLoader.load(getClass().getResource("EnterSystem.fxml"));
                    Scene scene = new Scene(root);
                    newstage.setScene(scene);
                    newstage.show();
                    Stage stage1 = (Stage) first.getScene().getWindow();
                    stage1.close();
    }
}
