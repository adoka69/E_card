package sample;

import java.io.IOException;
import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import java.io.FileWriter;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

import static sample.Controller.arr;

public class Controller1 {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private AnchorPane stat;

    @FXML
    private Text round;

    @FXML
    private TextField playerfield;

    @FXML
    private Text player;

    @FXML
    private Text comptext;

    @FXML
    private Button butt;

    @FXML
    private Text playertext;

    @FXML
    private Label statusbar;

    @FXML
    private Button nextround;
    @FXML
    private Button Citizen;
    @FXML
    private Text Victory;
    int draw = 0;
    int win = 0;
    int lose = 0;
    @FXML
    private Text wld;
    @FXML
    private Button Again;
    String[] rounds = {"1","2","3","4","5","6","7","8","9","10","11","12"};
    int r_check=0;



    @FXML
    void initialize() {

        String name = String.valueOf(arr).replaceAll("\\p{P}","");
        if(!name.isEmpty()){
            player.setText(name);
        }
        Again.setDisable(true);


        

        String slave="Slave";
        String citizen="Citizen";
        String imperior="Emperor";
        String status1 = "draw";
        String status2 = "win";
        String status3 = "lose";
        String roundtext = "Round ";
        int min = 50;
        int max = 100;
        int n = 13;
        int b = 0;
        round.setText("Round 1");



        ArrayList<Integer> arrli = new ArrayList<Integer>(n);
        for (int i = 2; i <= n; i++)
            arrli.add(i);





        Citizen.setOnAction(event -> {
            playertext.setText(citizen);
        });

        statusbar.setText("");
        AtomicInteger a = new AtomicInteger();
        nextround.setDisable(true);

        butt.setOnAction(event -> {
            int random_int = (int)(Math.random() * (max - min + 1) + min);
            String text1 = playerfield.getText();
            if(text1.equals(slave)||text1.equals(citizen)||text1.equals(imperior)){
                nextround.setDisable(false);
                butt.setDisable(true);
                if(random_int<66){
                    comptext.setText(imperior);}
                else if(random_int>83){
                    comptext.setText(slave);}
                else{
                    comptext.setText(citizen);
                };
                String text2 = comptext.getText();

                playertext.setText(playerfield.getText());
                if(text1.equals(text2)){
                    statusbar.setText(status1);
                    draw ++;
                }
                else if(text1.equals(slave)&&text2.equals(imperior)){
                    statusbar.setText(status2);
                    win++;
                }
                else if(text1.equals(imperior)&&text2.equals(slave)){
                    statusbar.setText(status3);
                    lose++;
                }
                else if(text1.equals(citizen)&&text2.equals(imperior)){
                    statusbar.setText(status3);
                    lose++;
                }
                else if(text2.equals(citizen)&&text1.equals(imperior)){
                    statusbar.setText(status2);
                    win++;
                }
                else if(text1.equals(citizen)&&text2.equals(slave)){
                    statusbar.setText(status2);
                    win++;
                }
                else if(text2.equals(citizen)&&text1.equals(slave)){
                    statusbar.setText(status3);
                    lose++;
                }
                String roundf =round.getText();
                if(roundf.equals("Round 12")){
                    if(win>lose){
                        Victory.setText("Victory");}
                    else if(win<lose){
                        Victory.setText("Defeat");}
                    else{
                        Victory.setText("Draw");}
                    wld.setText("W: "+win+"  L: "+lose+"  D: "+draw);
                    butt.setDisable(true);
                    nextround.setDisable(true);
                    roundf = "";
                    Again.setDisable(false);
                }
                r_check++;
            }
        });
        nextround.setOnAction(event -> {
            playerfield.setText("");
            playertext.setText("");
            comptext.setText("wait...");
            String arr = roundtext+rounds[r_check];
            round.setText(arr);
            a.set(a.get() + 1);
            nextround.setDisable(true);
            butt.setDisable(false);
        });
        Again.setOnAction(event -> {
            try {
                FileWriter myWriter = new FileWriter("result.txt");
                myWriter.write(String.valueOf("Win:"+win+" Lose:"+lose+" Draw:"+draw));
                myWriter.close();
                System.out.println("Successfully wrote to the file.");
            } catch (IOException e) {
                System.out.println("An error occurred.");
                e.printStackTrace();
            }



            playerfield.setText("");
            playertext.setText("");
            comptext.setText("wait...");
            nextround.setDisable(true);
            butt.setDisable(false);
            Victory.setText("");
            wld.setText("");

            r_check=0;
            round.setText("Round 1");
            win=0;
            lose=0;
            draw=0;

        });

    }
}
