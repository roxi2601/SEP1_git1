import java.io.Serializable;

/**
 * A class containing Written objects and methods
 * @author Roksana Dziadowicz and
 * @version 1.0
 */
public class Written extends Exam implements Serializable
{
  public Written(String kind,Course course,Teacher examiner, MyDate date, Room room)
  {
    super(kind,course, examiner, date, room);
  }
  public String getType()
  {
    return "Written";
  }

  public String toString()
  {
    return super.toString();
  }
}
