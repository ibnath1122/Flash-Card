/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
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
import static sun.net.util.IPAddressUtil.scan;

/**
 * FXML Controller class
 *
 * @author User
 */
public class QuesController implements Initializable {

    @FXML
    private Label TextBox;
    @FXML
    private Button AnsBtn;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void AnsAction(ActionEvent event) throws IOException {
        
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Answer.fxml"));
        Parent root = loader.load();
        
        NewFXMain read = new NewFXMain();
        String var = read.Read();
        
        
        AnswerController ques = loader.getController();
        ques.showAns(var);
        
        
        Scene scene = new Scene(root);
        Stage stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.setTitle("Question");
        stage.show();
    }
    
    public void showQues(String Ques)
    {
        TextBox.setText(Ques);
    }
}
