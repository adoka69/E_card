package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
class Emperor {
    public void Power() {
        System.out.println("Slave>Emperor>Citizen");
    }}
class Citizen extends Emperor {
    public void Power() {
        System.out.println("Emperor>Citizen>Slave");
    }}
class Slave extends Emperor{
    public void Power() {
        System.out.println("Citizen>Slave>Emperor");
    }}

public class Main extends Application {
    public static void main(String[] args) {
        launch(args);
    }


    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        String title = "a";
        try {
            File myObj = new File("C:\\Users\\Адока\\untitled2\\src\\sample\\info.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                primaryStage.setTitle(data);
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

        primaryStage.setScene(new Scene(root, 900, 600));
        primaryStage.setResizable(false);
        primaryStage.show();
        Emperor myEmperor = new Emperor();
        Emperor myCitizen = new Citizen();
        Emperor mySalve = new Slave();

        myEmperor.Power();
        myCitizen.Power();
        mySalve.Power();

    }
}
