import java.io.Serializable;

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
