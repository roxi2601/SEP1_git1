import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

/**
 * A GUI tab containing components for changing a exam's examiner.
 * @author Roksana Dziadowicz
 * @version 1.0
 */
public class ChangeExaminerTab extends Tab
{
  private HBox changeExaminerPane; //all

  private HBox addAndRemoveButtons;

  private VBox coursePane; // left
  private VBox examinerPane; //right

  private ComboBox<Exam> examBox;
  private ComboBox<Teacher> examinerBox;

  private GridPane changeExaminerInputPane; //right
  private GridPane courseDataPane; //left

  private Button addButton;
  private Button removeButton;

  private TextField courseField;
  private TextField examinerField;
  private TextField roomField;
  private TextField dateField;
  private TextField nameField;
  private TextField availabilityField;
  private TextField contactField;

  private Label courseLabel;
  private Label examinerLabel;
  private Label roomLabel;
  private Label dateLabel;
  private Label nameLabel;
  private Label availabilityLabel;
  private Label contactLabel;

  private MyActionListener listener;

  private ExamScheduleAdapter adapter;

  /**
   * Constructor initializing the GUI components
   * @param title The title of the tab
   * @param adapter ExamScheduleAdapter object used for retrieving and storing room information
   */
  public ChangeExaminerTab(String title, ExamScheduleAdapter adapter)
  {
    super("Change examiner");
    this.adapter = adapter;

    listener = new MyActionListener();

    changeExaminerPane = new HBox(20);

    //course data-start
    coursePane = new VBox(20);
    coursePane.setPrefWidth(200);

    examBox = new ComboBox<Exam>();
    examBox.setOnAction(listener);

    roomLabel = new Label("Room:");
    courseLabel = new Label("Course");
    examinerLabel = new Label("Examiner:");
    dateLabel = new Label("Date");

    roomField = new TextField();
    roomField.setEditable(false);
    courseField = new TextField();
    courseField.setEditable(false);
    examinerField = new TextField();
    examinerField.setEditable(false);
    dateField = new TextField();
    dateField.setEditable(false);

    courseDataPane = new GridPane();
    courseDataPane.setHgap(5);
    courseDataPane.setVgap(5);
    courseDataPane.addRow(0, examinerLabel, examinerField);
    courseDataPane.addRow(1, courseLabel, courseField);
    courseDataPane.addRow(2, roomLabel, roomField);
    courseDataPane.addRow(3, dateLabel, dateField);

    coursePane.getChildren().add(examBox);
    coursePane.getChildren().add(courseDataPane);
    //course data-end

    //examiner data- start
    examinerPane = new VBox(20);
    examinerPane.setPrefWidth(200);

    examinerBox = new ComboBox<Teacher>();
    examinerBox.setOnAction(listener);

    nameLabel = new Label("Name:");
    availabilityLabel = new Label("Availability:");
    contactLabel = new Label("Contact:");

    nameField = new TextField();
    nameField.setEditable(false); //i'm not sure
    availabilityField = new TextField();
    availabilityField.setEditable(true);
    contactField = new TextField();
    contactField.setEditable(true);

    changeExaminerInputPane = new GridPane();
    changeExaminerInputPane.setVgap(5);
    changeExaminerInputPane.setHgap(5);
    changeExaminerInputPane.addRow(0, nameLabel, nameField);
    changeExaminerInputPane.addRow(1, availabilityLabel, availabilityField);
    changeExaminerInputPane.addRow(2, contactLabel, contactField);

    addButton = new Button("Add");
    addButton.setOnAction(listener);

    removeButton = new Button("Remove");
    removeButton.setOnAction(listener);

    examinerPane.getChildren().add(examinerBox);
    examinerPane.getChildren().add(changeExaminerInputPane);

    addAndRemoveButtons = new HBox(20);
    addAndRemoveButtons.getChildren().add(addButton);
    addAndRemoveButtons.getChildren().add(removeButton);

    examinerPane.getChildren().add(examinerBox);
    examinerPane.getChildren().add(changeExaminerInputPane);
    examinerPane.getChildren().add(addAndRemoveButtons); //examiner data-end

    changeExaminerPane.getChildren().add(coursePane);
    changeExaminerPane.getChildren().add(examinerPane);

    super.setContent(changeExaminerPane);
  }
  /**
   * Enables or disables editing of examinerField, courseField, roomField, dateField, availabilityField and contactField.
   * @param bool if true then the fields will be editable, if false then they will not
   */
  public void changeEditableState (boolean bool)
  {
    examinerField.setEditable(bool);
    contactField.setEditable(bool);
    roomField.setEditable(bool);
    dateField.setEditable(bool);
    availabilityField.setEditable(bool);
    contactField.setEditable(bool);
  }
  /**
   * Updates the examBox ComboBox with information from the exam file
   */
  public void updateExamBox()
  {
    int currentIndex = examBox.getSelectionModel().getSelectedIndex();

    examBox.getItems().clear();

    ExamSchedule exams = adapter.getAllExams();
    for (int i = 0; i < exams.size(); i++)
    {
      examBox.getItems().add(exams.get(i));
    }

    if (currentIndex == -1 && examBox.getItems().size() > 0)
    {
      examBox.getSelectionModel().select(0);
    }
    else
    {
      examBox.getSelectionModel().select(currentIndex);
    }
  }
  /**
   * Updates the examinerBox ComboBox with information from the examiner file
   */
  public void updateExaminerBox()
  {
    int currentIndex = examinerBox.getSelectionModel().getSelectedIndex();

    examinerBox.getItems().clear();

    TeacherList examiners = adapter.getAllExaminers(); //we have to do getAllExaminers() in ExamScheduleAdapter
    for (int i = 0; i < examiners.size(); i++)
    {
      examBox.getItems().add(examiners.get(i));
    }

    if (currentIndex == -1 && examBox.getItems().size() > 0)
    {
      examBox.getSelectionModel().select(0);
    }
    else
    {
      examBox.getSelectionModel().select(currentIndex);
    }
  }
  /*
   * Inner action listener class
   * @author Roksana Dziadowicz
   * @version 1.0
   */
  private class MyActionListener implements EventHandler<ActionEvent>
  {
    public void handle(ActionEvent e)
    {
      if(e.getSource() == addButton)
      {
        String name = nameField.getText();
        String availability = availabilityField.getText(); //???????
        String contact = contactField.getText();
        if(availability.equals(" "))
        {
          availability = "?";
        }
        else if(contact.equals(" "))
        {
          contact = "?";
        }
        adapter.addExaminer(name, availability, contact); //we have to do addExaminer() method in ExamScheduleAdapter
        updateExaminerBox();
        availabilityField.setText("");
        contactField.setText("");
      }
      else if(e.getSource() == removeButton)
        {
          String name = nameField.getText();
          String availability = availabilityField.getText(); //???????
          String contact = contactField.getText();
          if(availability.equals(" "))
          {
            availability = "?";
          }
          else if(contact.equals(" "))
          {
            contact = "?";
          }
          adapter.removeExaminer(name, availability, contact); //we have to do removeExaminer() method in ExamScheduleAdapter
          updateExaminerBox();
          availabilityField.setText("");
          contactField.setText("");
        }
      else if (e.getSource() == examBox)
      {
        Exam temp = examBox.getSelectionModel().getSelectedItem();
        if(temp != null)
        {
          roomField.setText(temp.getRoom());
          courseField.setText(temp.getCourse());
          examinerField.setText(temp.getExaminer());
          dateField.setText(temp.getDate());
        }
      }
      else if(e.getSource() == examinerBox)
      {
        Teacher temp = examinerBox.getSelectionModel().getSelectedItem();
        if(temp !=null)
        {
          nameField.setText(temp.getName());
          availabilityField.setText(temp.getAvailability());
          contactField.setText(temp.getContact());
        }
        else if(temp.equals("New"))
        {
          availabilityField.setText("");
          contactField.setText("");
          nameField.setText(temp.getName());
        }
      }
    }
  }

}
