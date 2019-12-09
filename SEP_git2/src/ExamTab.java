import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
/**
 * A GUI tab containing components for displaying a list of exams.
 * @author Julia Tankiewicz
 * @version 1.0
 */

import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.*;

import java.util.Date;


public class ExamTab extends Tab
{
  private HBox examsPane;
  private VBox rightPane;

  private TableView<Exam> examsTable;
  private TableView.TableViewSelectionModel<Exam> defaultSelectionModel;
  private TableColumn<Exam, String> courseColumn;
  private TableColumn<Exam, String> examinerColumn;
  private TableColumn<Exam, String> dateColumn;
  private TableColumn<Exam, String> roomNrColumn;
  private TableColumn<Exam, String> typeColumn;

  private Button getButton;
  private Button removeButton;

  private Label courseLabel;
  private Label examinerLabel;
  private Label roomLabel;
  private Label typeLabel;
  private Label examLabel;

  private TextField courseField;
  private TextField examinerField;
  private TextField roomField;
  private TextField typeField;

  private ComboBox<Exam> examBox;

  private MyActionListener listener;

  private ExamScheduleAdapter adapter;

  public ExamTab(String title,ExamScheduleAdapter adapter)
  {
   super(title);

   this.adapter = adapter;
   listener = new MyActionListener();

   examsTable=  new TableView<Exam>();
   defaultSelectionModel = examsTable.getSelectionModel();// i dont understand what it's for,can sb explain me? -julia
   examsTable.setPrefHeight(250);

    courseColumn = new TableColumn<Exam, String>("Course");
    courseColumn.setCellValueFactory(new PropertyValueFactory<Exam,String>("country")); //this too
    courseColumn.setPrefWidth(150);

    examinerColumn = new TableColumn<Exam, String>("Examiner");
    examinerColumn.setCellValueFactory(new PropertyValueFactory<Exam,String>("examiner"));
    examinerColumn.setPrefWidth(170);

    dateColumn = new TableColumn<Exam, String>("Date");
    dateColumn.setCellValueFactory(new PropertyValueFactory<Exam,String>("date"));
    dateColumn.setPrefWidth(170);

    roomNrColumn = new TableColumn<Exam, String>("Room");
    roomNrColumn.setCellValueFactory(new PropertyValueFactory<Exam,String>("room"));
    roomNrColumn.setPrefWidth(100);

    typeColumn = new TableColumn<Exam, String>("Type");
    typeColumn.setCellValueFactory(new PropertyValueFactory<Exam,String>("type"));
    typeColumn.setPrefWidth(100);



  }
  private class MyActionListener implements EventHandler<ActionEvent>
  {
    public void handle(ActionEvent e)
    {
      if(e.getSource()==getButton)
      {

      }
    }
  }
}
