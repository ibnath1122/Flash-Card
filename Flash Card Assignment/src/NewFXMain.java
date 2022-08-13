/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 *
 * @author Medul
 */
public class NewFXMain extends Application {

    public static int glo=0;
    
    @Override
    public void start(Stage primaryStage) throws IOException {
//        
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Login.fxml"));
        Parent root = loader.load();
        
        Scene scene = new Scene(root);

        primaryStage.setTitle("Flash Card");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    
     public String Read() throws FileNotFoundException, IOException
            {
                File file = new File("D:/flash.txt");
                Scanner scan =new Scanner(file);
        
                //String var = scan.nextLine();
                 String var = null ;
                 int s= size();
                 
                 System.out.println(s);
                
                for (int i=0 ; i<=s ; i++)
                {
                    if(i<=glo)
                    {
                        
                        if(i==glo)
                        {
                            var = scan.nextLine();
                            glo++;
                            System.out.println(glo);
                            scan.close();
                            break;
                        }
                        scan.nextLine();
                    }
                }
                
                return var;
            }

     
     public int size () throws FileNotFoundException, IOException{
         
         InputStream is = new BufferedInputStream(new FileInputStream("D:/flash.txt"));
    try {
        byte[] c = new byte[1024];

        int readChars = is.read(c);
        if (readChars == -1) {
            // bail out if nothing to read
            return 0;
        }

        // make it easy for the optimizer to tune this loop
        int count = 0;
        while (readChars == 1024) {
            for (int i=0; i<1024;) {
                if (c[i++] == '\n') {
                    ++count;
                }
            }
            readChars = is.read(c);
        }

        // count remaining characters
        while (readChars != -1) {
            System.out.println(readChars);
            for (int i=0; i<readChars; ++i) {
                if (c[i] == '\n') {
                    ++count;
                }
            }
            readChars = is.read(c);
        }

        return count == 0 ? 1 : count;
    } finally {
        is.close();
    }
     }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}
