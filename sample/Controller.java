package sample;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class Controller {

    @FXML
    private ResourceBundle resources;


    @FXML
    private URL location;

    @FXML
    private TextField namefield;

    @FXML
    private Button PlayButton;
    @FXML
    private Button info;
    public static ArrayList<String> arr=new ArrayList<String >();



    @FXML
    void initialize() {
        
        PlayButton.setOnAction(event -> {
            String n = namefield.getText();
            arr.add(n);


            PlayButton.getScene().getWindow().hide();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/sample/sample1.fxml"));
            try {
                loader.load();
            } catch (IOException e) {
                e.printStackTrace();
            }
            Parent root =loader.getRoot();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            String title = "E_card";
            stage.setTitle(title);
            stage.setResizable(false);
            stage.showAndWait();
        });


    }
}
