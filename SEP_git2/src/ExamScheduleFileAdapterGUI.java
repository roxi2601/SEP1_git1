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
  private ExamTab examsTab;
  private ChangeCourseTab changeCourseTab;
  private ChangeExaminerTab changeExaminerTab;
  private ChangeRoomTab changeRoomTab;
  private ChangeDateTab changeDateTab;
  private AddNewTab addNewTab;

  private MenuBar menuBar;

  private Menu fileMenu;
  private Menu editMenu;
  private Menu aboutMenu;

  private MenuItem exitMenuItem;
  private MenuItem newMenuItem;
  private MenuItem saveMenuItem;
  private MenuItem updateWebsiteMenuItem;
  private MenuItem aboutMenuItem;

  private CheckMenuItem editMenuItem;

  private MyActionListener listener;
  private MyTabListener tabListener;

  public void start(Stage window)
  {
    window.setTitle("Exam Schedule");

    adapter = new ExamScheduleAdapter("exams.bin");

    listener = new MyActionListener();
    tabListener = new MyTabListener();

    tabPane = new TabPane();
    tabPane.getSelectionModel().selectedIndexProperty().addListener(tabListener);//why error :((

    examsTab = new ExamTab();


  }

  private class MyActionListener implements EventHandler<ActionEvent>
  {
    public void handle(ActionEvent e)
    {
      if(e.getSource() ==exitMenuItem)
      {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION,"Do you want to exit the program?",ButtonType.YES,ButtonType.NO);
        alert.setTitle("Exit");
        alert.setHeaderText(null);//header text??

        alert.showAndWait();
        if(alert.getResult()==ButtonType.YES)
        {
          System.exit(0);
        }
      }

    }
  }
  private class MyTabListener implements ChangeListener<Tab>
  {
    public void changed(ObservableValue<? extends Tab> tab,Tab oldTab,Tab newTab)
    {
      if(newTab.equals(examsTab))
      {
      }
    }
  }


}
