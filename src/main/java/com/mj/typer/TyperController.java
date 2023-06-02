package com.mj.typer;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.text.Text;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.Scanner;

public class TyperController implements Initializable {


    @FXML
    private Label timeLabel;
    @FXML
    private Label displayUsername;
    @FXML
    private Text total;
    @FXML
    private Text wpm;
    @FXML
    private Text invalid;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        File newFile = new File("username.txt");
        if (newFile.length() != 0) {
            Scanner reader = null;
            try {
                reader = new Scanner(newFile);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            String data = reader.nextLine();
            displayUsername.setText("Welcome, " + data);
        }
        Date date = new Date();
        Locale locale = new Locale("en");
        DateFormat formatter = new SimpleDateFormat("EEEE", locale);
        String strDay = formatter.format(date);
        timeLabel.setText("Today is " + strDay);

        int[] data = FileHandling.sumUpNumbers("com.pl.typer/data");



    }

    public void playGame (ActionEvent ae) throws IOException {
        Main main = new Main();

        File newFile = new File("username.txt");
        if(newFile.length() == 0) {
            try {
                main.changeScene("popup.fxml");
            }  catch (IOException e) {
                    e.printStackTrace();
                }
            } else {
            main.changeScene("game.fxml");
            }
        }
}


