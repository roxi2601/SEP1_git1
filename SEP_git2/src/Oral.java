import java.io.Serializable;

/**
 * A class containing Oral objects and methods
 * @author Roksana Dziadowicz and
 * @version 1.0
 */
public class Oral extends Exam implements Serializable
{
  public Oral(Room room, Teacher examiner, MyDate date, Course course)
  {
    super(course, examiner, room, date);
  }
  public void planBreak() //????????/
  {

  }
  public void reserveRoom() //??????????
  {

  }
  public String getType()
  {
    return "Oral";
  }

  public String toString()
  {
    return super.toString();
  }
}
