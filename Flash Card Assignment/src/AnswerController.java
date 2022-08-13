/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Scanner;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author User
 */
public class AnswerController implements Initializable {

    @FXML
    private Label TextBox;
    @FXML
    private Button NextBtn;
    @FXML
    private Button HomeBtn1;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    void HomeAction(ActionEvent event) throws IOException {
            
        File f = new File("D:/flash.txt");
        Scanner myReader = new Scanner(f);
        myReader.close();
        
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Login.fxml"));
        Parent root = loader.load();
        
        Scene scene = new Scene(root);

        Stage stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.setTitle("Question");
        stage.show();
    }

    
    @FXML
    private void NextAction(ActionEvent event) throws IOException {
        
        FXMLLoader loader = new FXMLLoader(getClass().getResource("ques.fxml"));
        Parent root = loader.load();
        
        NewFXMain read = new NewFXMain();
        String var = read.Read();
            
       try {
            QuesController ques = loader.getController();
            ques.showQues(var);
        } catch (Exception e) {
            System.out.println(e);
        }
        
        Scene scene = new Scene(root);
        Stage stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.setTitle("Question");
        stage.show();
    }
    
    public void showAns(String ans)
    {
        TextBox.setText(ans);
    }
}
