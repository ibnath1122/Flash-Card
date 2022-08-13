/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URL;
import java.util.Formatter;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author User
 */
public class SaveCardController implements Initializable {

    @FXML
    private TextField QuesText;
    @FXML
    private TextField AnsText;
    @FXML
    private Button NextBtn;
    @FXML
    private Button DoneBtn;

    String[] data = new String[90];
    static int i,j;
    
    private void saveTextToFile( File file) {
        try {
            PrintWriter writer;
            writer = new PrintWriter(file);
            for(int j=0 ; j<=i ; j++)
            {
                System.out.println(data[j]);
                writer.println(data[j]);
                System.out.println("uuuu");
            }
            writer.close();
        } catch (IOException ex) {
            Logger.getLogger(SaveCardController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void QuesAction(ActionEvent event) {
         
    }

    @FXML
    private void AnsAction(ActionEvent event) {
    }

    @FXML
    private void NextAction(ActionEvent event) throws IOException {
        
        
        /*data[i]=QuesText.getText();
        System.out.println(data[i]);
        i++;
        data[i]=AnsText.getText();
        System.out.println(data[i]);
        i++;
        System.out.println(i);*/
        
        String ques = QuesText.getText();
        String ans = AnsText.getText();
        //System.out.println(ques + ans);
        
        /*try{
            Formatter form = new Formatter ("D:/Proteus 8.0 SP1/Lab4C1/Card/flash.txt");
            form.format("%s %s\r\n", ques ,ans);
            System.out.println("done");
            
            form.close();
            
        } catch (FileNotFoundException e) {
            System.out.println(e);
        }*/
        
        try {
        String content = ques + "\n" + ans;

        java.io.File cards = new java.io.File("D:/flash.txt");
        
        FileWriter fw = new FileWriter(cards.getAbsoluteFile(), true);
        BufferedWriter bw = new BufferedWriter(fw);
        bw.write(content + "\n");
        bw.close();

    } catch (Exception e) {
            System.out.println(e);
    }
        
        FXMLLoader loader = new FXMLLoader(getClass().getResource("SaveCard.fxml"));
        Parent root = loader.load();
        
        Scene scene = new Scene(root);
        Stage stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.setTitle("Input Question");
        stage.show();
    }

    @FXML
    private void DoneAction(ActionEvent event) throws IOException {
       
        /*data[i]=QuesText.getText();
        data[i+1]=AnsText.getText();
        i++;
        
        FileChooser ch = new FileChooser();
       
        File file = ch.showSaveDialog(new Stage());
 
            if (file != null) {
                saveTextToFile( file);
            }*/
        String ques = QuesText.getText();
        String ans = AnsText.getText();
        
        try {
        String content = ques + "\n" + ans;

        java.io.File cards = new java.io.File("D:/flash.txt");
        
        FileWriter fw = new FileWriter(cards.getAbsoluteFile(), true);
        BufferedWriter bw = new BufferedWriter(fw);
        bw.write(content + "\n");
        bw.close();

    } catch (Exception e) {
            System.out.println(e);
    }
        
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Login.fxml"));
        Parent root = loader.load();
        
        Scene scene = new Scene(root);
        Stage stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.setTitle("Input Question");
        stage.show();
    }
    
}
