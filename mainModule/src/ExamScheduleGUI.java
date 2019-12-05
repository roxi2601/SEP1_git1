import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class ExamScheduleGUI extends Application
{
  @Override public void start(Stage window) throws Exception
  {
    window.setTitle("Scene builder test");
    FXMLLoader loader = new FXMLLoader();
    loader.setLocation(getClass().getResource("sample.fxml"));


    Scene scene = new Scene(loader.load());
    scene.setFill(Color.TRANSPARENT);
    window.setScene(scene);
    window.initStyle(StageStyle.TRANSPARENT);
    window.show();
  }
}
