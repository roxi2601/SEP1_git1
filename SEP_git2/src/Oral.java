import java.io.Serializable;

/**
 * A class containing Oral objects and methods
 * @author Roksana Dziadowicz and
 * @version 1.0
 */
public class Oral extends Exam implements Serializable
{
  public Oral(String kind,Course course ,Teacher examiner, MyDate date, Room room)
  {
    super(kind,course, examiner, date, room);
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
