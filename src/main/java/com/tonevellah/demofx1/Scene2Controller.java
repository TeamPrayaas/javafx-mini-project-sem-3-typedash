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
    @FXML
    private TextField uname;
    @FXML
    private PasswordField pass;
    @FXML
    private Label warning;
    public String username;
    public String password;
    private Scene2ControllerDao scene2ControllerDao = new Scene2ControllerDao();
    private FxmlLoader fxmlLoader = new FxmlLoader();

    public void menu(ActionEvent event)  {
        username=uname.getText();
        password=pass.getText();

        try {
            if (scene2ControllerDao.checkUserExist(username,password)) {
                try {
                    log = 1;
                    fxmlLoader.loadinFxml(event,"Scene4.fxml");

                } catch (Exception e){
                    System.out.println(e);
                }
            } else {
                warning.setText("Wrong Name or Password!");
                warning.setVisible(true);
                System.out.println("User not found");
                uname.setText("");
                pass.setText("");
            }
        } finally { // Closing Connections and all resources
            try {
                CloseResourcesDao closingResources = new CloseResourcesDao();
                closingResources.closeResources();
            } catch (Exception e){
                System.out.println(e);
                System.out.println("Error while closing connection in Scene 2 controller.");
            }
        }
    }
    public void goback(ActionEvent event)  {
        try {
            fxmlLoader.loadinFxml(event,"hello-view.fxml");

        } catch (Exception e){
            System.out.println(e);
            System.out.println("Failed to load hello-view.fxml");
        }
    }
}
