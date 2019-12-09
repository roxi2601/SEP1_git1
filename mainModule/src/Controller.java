import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Side;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable
{
  @FXML private MenuItem exit;
  @FXML private AnchorPane selection;
  @FXML private AnchorPane root;
  @FXML private TextField myText;
  @FXML private TabPane tabpane;
  private StackPane stackPane;
  private Group group;
  private Tab tab1;
  private Tab tab2;

  private double x = 0;
  private double y = 0;
  private Stage stage;



  @Override public void initialize(URL url, ResourceBundle resourceBundle)
  {
    makeDraggable();
    Platform.runLater( () -> root.requestFocus() ); // Disable automatic focus of textfield



  }

  public void closeWindow(MouseEvent event){
    System.exit(0);
  }

  public void minimizeWindow(MouseEvent event) {
    stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
    stage.setIconified(true);
  }

  public void clickButton(ActionEvent event){
    System.out.println("focused");
  }

  public void keyEnter(KeyEvent event){
    String input = myText.getText();
    String newText = input.replaceAll("[^0-9]", "");
    myText.setText(newText);
    myText.positionCaret(newText.length());
  }

  public void makeDraggable(){
    StackPane headerArea  = (StackPane) tabpane.lookup(".tab-header-area");
    selection.setOnMousePressed((event) -> {
      x = event.getSceneX();
      y = event.getSceneY();
    });

    selection.setOnMouseDragged((event) -> {
      stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
      stage.setX(event.getScreenX() - x);
      stage.setY(event.getScreenY() - y);
    });
  }
}
