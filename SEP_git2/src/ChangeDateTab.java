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
 * A GUI tab containing components for changing a exam's date.
 * @author Roksana Dziadowicz
 * @version 1.0
 */
public class ChangeDateTab
{
  private HBox changeDatePane; //all

  private HBox addAndRemoveButtons;

  private VBox coursePane; // left
  private VBox datePane; //right

  private ComboBox<Exam> examBox;
  private ComboBox<Room> dateBox;

  private GridPane changeDateInputPane; //right
  private GridPane courseDataPane; //left

  private Button addButton;
  private Button removeButton;

  private TextField courseField;
  private TextField examinerField;
  private TextField roomField;
  private TextField dateField;
  private TextField dayField;
  private TextField monthField;
  private TextField yearField;

  private Label courseLabel;
  private Label examinerLabel;
  private Label roomLabel;
  private Label dateLabel;
  private Label dayLabel;
  private Label monthLabel;
  private Label yearLabel;

  private MyActionListener listener;

  private ExamScheduleAdapter adapter;

  /**
   * Constructor initializing the GUI components
   * @param title The title of the tab
   * @param adapter ExamScheduleAdapter object used for retrieving and storing date information
   */
}
