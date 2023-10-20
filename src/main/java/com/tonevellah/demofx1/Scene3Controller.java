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
    @FXML
    private TextField uname;
    @FXML
    private PasswordField pass;
    @FXML
    private Label warning;
    public String username;
    public String password;
    private Scene3ControllerDao scene3ControllerDao = new Scene3ControllerDao();
    private FxmlLoader fxmlLoader = new FxmlLoader();

    public void menu(ActionEvent event) throws IOException {
        username=uname.getText();
        password=pass.getText();
        if(username.equals("")){
            warning.setText("Enter a Username");
            warning.setVisible(true);
        }
        else if(password.equals("")){
            warning.setText("Enter a Password");
            warning.setVisible(true);
        }
    else {
        try {
            if (scene3ControllerDao.ifUsersExists(username)) { // If username already exists
                warning.setText("Name already taken!");
                warning.setVisible(true);
                System.out.println("user exists");

                uname.setText("");
                pass.setText("");
            } else { // If username doesn't exist.
                scene3ControllerDao.addUser(username,password); // Adding user into the user table.
                log=1;
                fxmlLoader.loadinFxml(event,"Scene4.fxml");

            }
        } catch (Exception e){
            System.out.println(e);
        }finally { // Closing All Resources (Connections and all)
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
    }
    public void goback(ActionEvent event) {
        try {
            fxmlLoader.loadinFxml(event, "hello-view.fxml");
        }catch (Exception e){
            System.out.println(e);
        }
    }
}