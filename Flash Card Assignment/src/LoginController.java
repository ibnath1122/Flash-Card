/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author User
 */
public class LoginController implements Initializable {

    @FXML
    private Button ExitBtn;
    @FXML
    private Button PlayBtn;
    @FXML
    private Button CreateBt;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    private void saveTextToFile(String content, File file) {
        try {
            PrintWriter writer;
            writer = new PrintWriter(file);
            writer.println(content);
            writer.close();
        } catch (IOException ex) {
            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void ExitAction(ActionEvent event) {
        
        File myObj = new File("D:/flash.txt"); 
        
        if (myObj.delete()) { 
            System.out.println("Deleted the file: ");
        } else {
        System.out.println("Failed to delete the file.");
        } 
        
        Platform.exit();
        System.exit(0);
        
        
    }

    @FXML
    private void PlayAction(ActionEvent event) throws FileNotFoundException, IOException {
        
        /*File file = new File("D:/Proteus 8.0 SP1/Lab4C1/Card/flash.txt");
        Scanner scan =new Scanner(file);
        
        String var = scan.nextLine();
        
        while(scan.hasNextLine())
        {
            System.out.println(scan.nextLine());
        }*/
        FXMLLoader loader = new FXMLLoader(getClass().getResource("ques.fxml"));
        Parent root = loader.load();
        
        NewFXMain read = new NewFXMain();
        String var = read.Read();
        
        QuesController ques = loader.getController();
        ques.showQues(var);
        
        
        Scene scene = new Scene(root);
        Stage stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.setTitle("Question");
        stage.show();
    }

    @FXML
    private void CreateAction(ActionEvent event) throws IOException {
        
        //FileChooser ch = new FileChooser();
        /*ch.getExtensionFilters().addAll(new ExtensionFilter("TXT File","*txt"));
        /*File file = ch.showOpenDialog(new Stage());
        System.out.println(file);
        
        File filep = ch.showSaveDialog(new Stage());
        if(filep != null)
        {
           
        }
        
        System.out.println(filep);*/
        
        /*File file = ch.showSaveDialog(new Stage());
 
            if (file != null) {
                saveTextToFile(null, file);
            }*/
        
        File dir = new File("Card");
        dir.mkdir();
        String path = dir.getAbsolutePath();
        
        File cards = new File(path);
        
        try
        {
            cards.createNewFile();
            System.out.println("ok");
            
        }catch(Exception e)
        {
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
    
}
