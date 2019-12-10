import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import javax.swing.*;

/**
 * A GUI tab containing components for changing a exam's room.
 * @author Roksana Dziadowicz
 * @version 1.0
 */
public class ChangeRoomTab extends Tab
{
  private HBox changeRoomPane; //all

  private HBox addAndRemoveButtons;

  private VBox examPane; // left
  private VBox roomPane; //right
  private VBox projectorPane;

  private ComboBox<Exam> examBox;
  private ComboBox<Room> roomBox;

  private GridPane changeRoomInputPane; //right
  private GridPane examDataPane; //left

  private Button addButton;
  private Button removeButton;

  private TextField courseField;
  private TextField examinerField;
  private TextField roomField;
  private TextField dateField;
  private TextField seatsField;
  private TextField roomNumberField;

  private CheckBox projectorYes;
  private CheckBox projectorNo;

  private Label courseLabel;
  private Label examinerLabel;
  private Label roomLabel;
  private Label dateLabel;
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
       examPane = new VBox(20);
       examPane.setPrefWidth(200);

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

      examDataPane = new GridPane();
      examDataPane.setHgap(5);
      examDataPane.setVgap(5);
      examDataPane.addRow(0, roomLabel, roomField);
      examDataPane.addRow(1, courseLabel, courseField);
      examDataPane.addRow(2, examinerLabel, examinerField);
      examDataPane.addRow(3, dateLabel, dateField);

       examPane.getChildren().add(examBox);
       examPane.getChildren().add(examDataPane);
         //exam data-end

    //room data- start
    roomPane = new VBox(20);
    roomPane.setPrefWidth(200);

    roomBox = new ComboBox<Room>();
    roomBox.setOnAction(listener);

    projectorYes = new CheckBox("Yes");
    projectorNo = new CheckBox("No");

    projectorPane.getChildren().add(projectorYes);
    projectorPane.getChildren().add(projectorNo);

    seatsLabel = new Label("Number of seats:");
    roomNumberLabel = new Label("Room number:");


    seatsField = new TextField();
    seatsField.setEditable(true);
    roomNumberField = new TextField();
    roomNumberField.setEditable(false);

    changeRoomInputPane = new GridPane();
    changeRoomInputPane.setVgap(5);
    changeRoomInputPane.setHgap(5);
    changeRoomInputPane.addRow(0, seatsLabel, seatsField);
    changeRoomInputPane.addRow(1, roomNumberLabel, roomNumberField);

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

    changeRoomPane.getChildren().add(examPane);
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
        boolean projector = Boolean.parseBoolean(projectorField.getText());
        int seats = Integer.parseInt(seatsField.getText());
        String roomNumber = roomNumberField.getText();

        Room room=new Room(roomNumber,projector,seats);
        adapter.changeRoom(examBox.getSelectionModel().getSelectedItem().getCourse(), examBox.getSelectionModel().getSelectedItem().getDate(), room);
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
          removeButton.isDisable(); //????????????????????????????????????????
        }

      }
    }
  }
}
