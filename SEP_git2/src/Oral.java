import java.io.Serializable;

/**
 * A class containing Oral objects and methods
 * @author Roksana Dziadowicz and
 * @version 1.0
 */
public class Oral extends Exam implements Serializable
{
  public Oral(Course course ,Teacher examiner, MyDate date, Room room)
  {
    super(course, examiner, date, room);
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
