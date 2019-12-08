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
public class ExamTab extends Tab
{
  private HBox examsPane;

  private TableView<Exam> examsTable;
  private TableView.TableViewSelectionModel<Exam> defaultSelectionModel;
  private TableColumn<Exam, String> courseColumn;
  private TableColumn<Exam, String> examinerColumn;
  private TableColumn<Exam, MyDate> dateColumn;
  private TableColumn<Exam, String> roomNrColumn;
  private TableColumn<Exam,String > kindColumn;
  private TableColumn<Exam, String> typeColumn;

  private Button getButton;
}
