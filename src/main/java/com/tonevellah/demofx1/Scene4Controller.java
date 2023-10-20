//after signing or logging in
package com.tonevellah.demofx1;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import java.io.IOException;
import static com.tonevellah.demofx1.Scene1Controller.*;
public class Scene4Controller {
    @FXML
    Text advc;
    @FXML
    Text uname;
    private FxmlLoader fxmlLoader = new FxmlLoader();
//    public void tips(String str){
//        advc.setText(str);
//    }
    public void playGame(ActionEvent e) { // On Action of WPM rush
        try {
            fxmlLoader.loadinFxml(e, "Scene5.fxml");
        } catch (Exception error){
            System.out.println(error);
        }
    }
    public void exit(ActionEvent e){
        try {
            fxmlLoader.loadinFxml(e,"hello-view.fxml");
        }catch (Exception er){
            System.out.println(er);
        }
    }
}
