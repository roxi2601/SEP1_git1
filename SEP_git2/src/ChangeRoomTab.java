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
 * A GUI tab containing components for changing a exam's room.
 * @author Roksana Dziadowicz
 * @version 1.0
 */
public class ChangeRoomTab extends Tab
{
  private HBox changeRoomPane; //all

  private HBox addAndRemoveButtons;

  private VBox coursePane; // left
  private VBox roomPane; //right

  private ComboBox<Exam> examBox;
  private ComboBox<Room> roomBox;

  private GridPane changeRoomInputPane; //right
  private GridPane courseDataPane; //left

  private Button addButton;
  private Button removeButton;

  private TextField courseField;
  private TextField examinerField;
  private TextField roomField;
  private TextField dateField;
  private TextField projectorField;
  private TextField seatsField;
  private TextField roomNumberField;

  private Label courseLabel;
  private Label examinerLabel;
  private Label roomLabel;
  private Label dateLabel;
  private Label projectorLabel;
  private Label seatsLabel;
  private Label roomNumberLabel;

  private MyActionListener listener;

  private ExamScheduleAdapter adapter;

  /**
   * Constructor initializing the GUI components
   * @param title The title of the tab
   * @param adapter ExamScheduleAdapter object used for retrieving and storing room information
   */
  public ChangeRoomTab(String title, ExamScheduleAdapter adapter)
  {
    super(title);

    this.adapter = adapter;

    listener = new MyActionListener();

    changeRoomPane = new HBox(20);

    //exam data-start
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
      courseDataPane.addRow(0, roomLabel, roomField);
      courseDataPane.addRow(1, courseLabel, courseField);
      courseDataPane.addRow(2, examinerLabel, examinerField);
      courseDataPane.addRow(3, dateLabel, dateField);

       coursePane.getChildren().add(examBox);
       coursePane.getChildren().add(courseDataPane);
         //exam data-end

    //room data- start
    roomPane = new VBox(20);
    roomPane.setPrefWidth(200);

    roomBox = new ComboBox<Room>();
    roomBox.setOnAction(listener);

    projectorLabel = new Label("Projector:");
    seatsLabel = new Label("Number of seats:");
    roomNumberLabel = new Label("Room number:");

    projectorField = new TextField();
    projectorField.setEditable(true);
    seatsField = new TextField();
    seatsField.setEditable(true);
    roomNumberField = new TextField();
    roomNumberField.setEditable(false);

    changeRoomInputPane = new GridPane();
    changeRoomInputPane.setVgap(5);
    changeRoomInputPane.setHgap(5);
    changeRoomInputPane.addRow(0, projectorLabel, projectorField);
    changeRoomInputPane.addRow(1, seatsLabel, seatsField);
    changeRoomInputPane.addRow(2, roomNumberLabel, roomNumberField);

    addButton = new Button("Add");
    addButton.setOnAction(listener);

    removeButton = new Button("Remove");
    removeButton.setOnAction(listener);

    roomPane.getChildren().add(roomBox);
    roomPane.getChildren().add(changeRoomInputPane);

    addAndRemoveButtons = new HBox(20);
    addAndRemoveButtons.getChildren().add(addButton);
    addAndRemoveButtons.getChildren().add(removeButton);

    roomPane.getChildren().add(roomBox);
    roomPane.getChildren().add(changeRoomInputPane);
    roomPane.getChildren().add(addAndRemoveButtons); //room data-end

    changeRoomPane.getChildren().add(coursePane);
    changeRoomPane.getChildren().add(roomPane);

    super.setContent(changeRoomPane);

  }
    /**
     * Enables or disables editing of roomField, courseField, examinerField, dateField and roomNumberField.
     * @param bool if true then the fields will be editable, if false then they will not
     */
    public void changeEditableState (boolean bool)
    {
      roomField.setEditable(bool);
      courseField.setEditable(bool);
      examinerField.setEditable(bool);
      dateField.setEditable(bool);
      roomNumberField.setEditable(bool);
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
   * Updates the roomBox ComboBox with information from the room file
   */
  public void updateRoomBox()
  {
    int currentIndex = roomBox.getSelectionModel().getSelectedIndex();

    roomBox.getItems().clear();

    RoomList rooms = adapter.getAllRooms(); //we have to do getAllRooms() method in ExamScheduleAdapter
    for (int i = 0; i < rooms.size(); i++)
    {
      roomBox.getItems().add(rooms.get(i)); //:(((
    }

    if (currentIndex == -1 && roomBox.getItems().size() > 0)
    {
      roomBox.getSelectionModel().select(0);
    }
    else
    {
      roomBox.getSelectionModel().select(currentIndex);
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
        String projector = projectorField.getText();
        String seats = seatsField.getText(); //is it possible to do it as int?
        String roomNumber = roomNumberField.getText();

        if (projector.equals(" "))
        {
          projector = "?";
        }
        else if (seats.equals(" "))
        {
          seats = "?";
        }
        adapter.addRoom(projector, seats, roomNumber); //we have to do addRoom() method in ExamScheduleAdapter
        updateRoomBox();
        projectorField.setText("");
        seatsField.setText("");
      }
        else if(e.getSource() == removeButton)
      {
        String projector = projectorField.getText();
        String seats = seatsField.getText(); //is it possible to do it as int?
        String roomNumber = roomNumberField.getText();

        if (projector.equals(" "))
        {
          projector = "?";
        }
        if (seats.equals(" "))
        {
          seats = "?";
        }
        adapter.removeRoom(projector, seats, roomNumber); //we have to do removeRoom() method in ExamScheduleAdapter
        updateRoomBox();
        projectorField.setText("");
        seatsField.setText("");
      }
        else if (e.getSource() == examBox)
      {
        Exam temp = examBox.getSelectionModel().getSelectedItem();
        if(temp != null)
        {
          roomField.setText(String.valueOf(temp.getRoom()));
          courseField.setText(String.valueOf(temp.getCourse()));
          examinerField.setText(String.valueOf(temp.getExaminer()));
          dateField.setText(String.valueOf(temp.getDate()));
        }
      }
      else if (e.getSource() == roomBox)
      {
        Room temp = roomBox.getSelectionModel().getSelectedItem();
        if(temp != null)
        {
          projectorField.setText(String.valueOf(temp.isProjector()));
          seatsField.setText(String.valueOf(temp.getSeatsCapacity()));
          roomNumberField.setText(temp.getNumber());

        }
        else if(temp.equals("New"))
        {
          projectorField.setText("");
          seatsField.setText("");
          roomNumberField.setText(temp.getNumber());
        }
      }
    }
  }
}
