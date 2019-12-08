import java.io.Serializable;

/**
 * A class containing Written objects and methods
 * @author Roksana Dziadowicz
 * @version 1.0
 */
public class Written extends Exam implements Serializable
{
  /**
   * Four-argument constructor.
   * @param kind kind of the exam
   * @param course the exam's course
   * @param examiner the exam's examiner
   * @param date the exam's date
   * @param room the exam's room
   */
  public Written(String kind,Course course,Teacher examiner, MyDate date, Room room)
  {
    super(kind,course, examiner, date, room);
  }
  /**
   * Gets type of the exam.
   * @return "Written"
   */
  public String getType()
  {
    return "Written";
  }

  /**
   * Returns a string representation of the written (exam).
   * @return a string representation of the written (exam) in the format: " course examiner Written date room"
   */
  public String toString()
  {
    return super.toString();
  }
}
