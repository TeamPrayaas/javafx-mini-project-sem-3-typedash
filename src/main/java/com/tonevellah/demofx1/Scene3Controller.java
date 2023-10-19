//signup GUI controller
package com.tonevellah.demofx1;
import com.tonevellah.demofx1.dao.CloseResourcesDao;
import com.tonevellah.demofx1.dao.JdbcConnection;
import com.tonevellah.demofx1.dao.Scene3ControllerDao;
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
import java.sql.*;
import java.io.*;

import static com.tonevellah.demofx1.Scene1Controller.log;
public class Scene3Controller {
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
    private Scene3ControllerDao scene3ControllerDao = new Scene3ControllerDao();

    public void menu(ActionEvent event) throws IOException {
        username=uname.getText();
        password=pass.getText();

        try {
            if (scene3ControllerDao.ifUsersExists(username)) { // If username already exists
                warnin.setText("Name already taken!");
                warnin.setVisible(true);
                System.out.println("user exists");

                uname.setText("");
                pass.setText("");
            } else { // If username doesn't exist.
                scene3ControllerDao.addUser(username,password); // Adding user into the user table.
          log=1;
                root = FXMLLoader.load(getClass().getResource("Scene4.fxml"));
                stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                scene = new Scene(root);
                stage.setScene(scene);
                stage.show();
            }
        } finally { // Closing All Resources (Connections and all)
            try {
                CloseResourcesDao closingResources = new CloseResourcesDao();
                closingResources.closeResources();
//                System.out.println("All resources closed in Scene3Controller.");
            } catch (Exception se){
                System.out.println(se);
                System.out.println("Error while closing connection in SCene 3 controller.");
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