import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.geometry.Insets;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.image.*;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
//import java.util.ArrayList;
//import java.util.Locale;
/**
 * A class containing ExamScheduleFileAdapterGUI objects and methods
 * @author Julia Tankiewicz
 * @version 1.0
 */
public class ExamScheduleFileAdapterGUI //extends Application
{
  private ExamScheduleAdapter adapter;

  private VBox mainPane;

  private TabPane tabPane;
  private Tab ExamsTab;
  private Tab changeCourseTab;
  private Tab changeExaminerTab;
  private Tab changeRoomTab;
  private Tab changeDateTab;
  private Tab addNewTab;

  private TableView examTable;
}
