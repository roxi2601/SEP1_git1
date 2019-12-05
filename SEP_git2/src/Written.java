import java.io.Serializable;

/**
 * A class containing Written objects and methods
 * @author Roksana Dziadowicz and
 * @version 1.0
 */
public class Written extends Exam implements Serializable
{
  public Written(Room room, Teacher examiner, MyDate date, Course course)
  {
    super(course, examiner, room, date);
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
