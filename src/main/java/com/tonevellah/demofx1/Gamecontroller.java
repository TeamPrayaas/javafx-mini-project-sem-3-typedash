package com.tonevellah.demofx1;

import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;

import java.io.File;
import java.time.Instant;
import java.util.Scanner;

import static com.tonevellah.demofx1.Scene1Controller.car;
import static com.tonevellah.demofx1.Scene1Controller.lvl;

public class Gamecontroller {
    @FXML
    public Text seconds; // Displaying Seconds
    @FXML
    private ImageView imgview; // will set imgview to car image

    public void startGame(KeyEvent ke){ // On entering value in the TextField
        System.out.println(car);
        System.out.println("Work in progres");
    }
    public void resultview(MouseEvent e){
        System.out.println("Work in progres");
    }
}
