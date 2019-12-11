import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
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
import javafx.scene.media.MediaException;

import java.util.Date;


public class ExamTab extends Tab
{
  private HBox examsPane;
  private GridPane rightPane;

  private TableView<Exam> examsTable;
  private TableColumn<Exam, Course> courseColumn;
  private TableColumn<Exam, Teacher> examinerColumn;
  private TableColumn<Exam, MyDate> dateColumn;
  private TableColumn<Exam, String> roomNrColumn;
  private TableColumn<Exam, String> typeColumn;

  private Button getButton;
  private Button removeButton;

  private Label courseLabel;
  private Label examinerLabel;
  private Label roomLabel;
  private Label typeLabel;
  private Label examLabel;

  private  ComboBox<Course> courseBox;
  private ComboBox<Teacher> examinerBox;
  private ComboBox<Room> roomBox;
  private RadioButton writtenButton;
  private RadioButton oralButton;
  private ComboBox<Exam> examBox;

  private MyActionListener listener;

  private ExamScheduleAdapter adapter;

  public ExamTab(String title,ExamScheduleAdapter adapter)
  {
   super(title);

   this.adapter = adapter;
   listener = new MyActionListener();

   examsTable=  new TableView<Exam>();
   examsTable.setPrefHeight(250);

    courseColumn = new TableColumn<Exam, Course>("Course");
    courseColumn.setCellValueFactory(new PropertyValueFactory<Exam,Course>("course"));
    courseColumn.setPrefWidth(150);

    examinerColumn = new TableColumn<Exam, Teacher>("Examiner");
    examinerColumn.setCellValueFactory(new PropertyValueFactory<Exam,Teacher>("examiner"));
    examinerColumn.setPrefWidth(170);

    dateColumn = new TableColumn<Exam, MyDate>("Date");
    dateColumn.setCellValueFactory(new PropertyValueFactory<Exam,MyDate>("date"));
    dateColumn.setPrefWidth(170);

    roomNrColumn = new TableColumn<Exam, String>("Room");
    roomNrColumn.setCellValueFactory(new PropertyValueFactory<Exam,String>("room"));
    roomNrColumn.setPrefWidth(100);

    typeColumn = new TableColumn<Exam, String>("Type");
    typeColumn.setCellValueFactory(new PropertyValueFactory<Exam,String>("type"));
    typeColumn.setPrefWidth(100);

    courseColumn.setReorderable(false);
    examinerColumn.setReorderable(false);
    dateColumn.setReorderable(false);
    roomNrColumn.setReorderable(false);
    courseColumn.setReorderable(false);

    examsTable.getColumns().addAll(courseColumn,examinerColumn,dateColumn,roomNrColumn,typeColumn);

    getButton  = new Button("Get schedule");
    getButton.setOnAction(listener);
    removeButton = new Button("Remove");
    removeButton.setOnAction(listener);

    courseLabel = new Label("Course: ");
    examinerLabel = new Label("Examiner: ");
    roomLabel = new Label("Room: ");
    typeLabel = new Label("Type: ");
    examLabel = new Label("Exam: ");

    courseBox = new ComboBox<Course>();
    examinerBox = new ComboBox<Teacher>();
    roomBox = new ComboBox<Room>();
    writtenButton = new RadioButton("Written");
    oralButton = new RadioButton("Oral");
    examBox = new ComboBox<Exam>();

    rightPane = new GridPane();
    rightPane.setPadding(new Insets(10));
    rightPane.setHgap(5);
    rightPane.setVgap(5);
    rightPane.addRow(0,courseLabel,courseBox);
    rightPane.addRow(1,examinerLabel,examinerBox);
    rightPane.addRow(2,roomLabel,roomBox);
    rightPane.addRow(3,typeLabel,writtenButton,oralButton);
    rightPane.addRow(4);
    rightPane.addRow(5,examLabel,examBox);
    rightPane.addRow(6,removeButton);

    examsPane = new HBox(20);
    examsPane.getChildren().addAll(examsTable,rightPane);

    super.setContent(examsPane);

  }
  public void updateExamsTable()
  {
    examsTable.getItems().clear();
    ExamSchedule exams = adapter.getAllExams();
    for(int i = 0;i<exams.size();i++)
    {
      examsTable.getItems().add(exams.get(i));
    }
  }
  public void updateCourseBox()
  {
    int currentIndex=courseBox.getSelectionModel().getSelectedIndex();

    courseBox.getItems().clear();
    CourseList courses = adapter.getAllCourses();
    for(int i =0;i<courses.size();i++)
    {
      coursesBox.getItems().add(courses.get(i));
    }

    if (currentIndex == -1 && examBox.getItems().size() > 0)
    {
      examBox.getSelectionModel().select(0);
    }
    else
    {
      examBox.getSelectionModel().select(currentIndex);
    }

  private class MyActionListener implements EventHandler<ActionEvent>
  {
    public void handle(ActionEvent e)
    {
      if(e.getSource()==getButton)
      {

        if(course
      }
    }
  }
}





