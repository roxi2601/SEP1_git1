import java.io.Serializable;

/**
 * A class containing Written objects and methods
 * @author Roksana Dziadowicz and
 * @version 1.0
 */
public class Written extends Exam implements Serializable
{
  public Written(Course course,Teacher examiner, MyDate date, Room room)
  {
    super(course, examiner, date, room);
  }
  public void reserveRoom() //??????????????/
  {

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
