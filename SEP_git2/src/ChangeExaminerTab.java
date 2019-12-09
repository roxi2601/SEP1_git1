import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
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
  private VBox changeExaminerPane; //all

  private HBox changeExaminerTopPane; //top

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
}
