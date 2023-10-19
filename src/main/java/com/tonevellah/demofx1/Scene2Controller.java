//login logic
package com.tonevellah.demofx1;

import com.tonevellah.demofx1.dao.CloseResourcesDao;
import com.tonevellah.demofx1.dao.JdbcConnection;
import com.tonevellah.demofx1.dao.Scene2ControllerDao;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.*;

import static com.tonevellah.demofx1.Scene1Controller.log;

public class Scene2Controller {
    private Stage stage;
    private Scene scene;
    private Parent root;
    @FXML
    private TextField uname;
    @FXML
    private PasswordField pass;
    @FXML
    private Label warnin;
    public String username;
    public String password;
    private Scene2ControllerDao scene2ControllerDao = new Scene2ControllerDao();

    public void menu(ActionEvent event) throws IOException {
        username=uname.getText();
        password=pass.getText();

        try {
            if (scene2ControllerDao.checkUserExist(username,password)) {
                try {
                    log = 1;
                    root = FXMLLoader.load(getClass().getResource("Scene4.fxml"));
                    stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                    scene = new Scene(root);
                    stage.setScene(scene);
                    stage.show();
                } catch (Exception e){
                    System.out.println(e);
                }
            } else {
                warnin.setText("Username not found!");
                warnin.setVisible(true);
                System.out.println("User not found");
                uname.setText("");
                pass.setText("");
            }
        } finally { // Closing Connections and all resources
            try {
                CloseResourcesDao closingResources = new CloseResourcesDao();
                closingResources.closeResources();
                System.out.println("All resources closed.");
            } catch (Exception e){
                System.out.println(e);
                System.out.println("Error while closing connection in Scene 2 controller.");
            }
        }
    }
    public void goback(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("hello-view.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
