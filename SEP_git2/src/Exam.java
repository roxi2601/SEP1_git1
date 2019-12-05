import java.io.Serializable;

/**
 *  A class containing Exam objects and methods
 * @author Roksana Dziadowicz
 * @version 1.0
 */

public abstract class Exam implements Serializable
{
  private Teacher examiner;
  private MyDate date;
  private Room room;
  private Course course;
  private String kind; // is it midterm, re-exam or re-re-exam???

  public Exam(String kind, Course course, Teacher examiner, MyDate date, Room room)
  {
    this.kind = kind;
    this.room=room;
    this.examiner=examiner;
    this.date=date;
    this.course=course;
  }
  public Course getCourse()
  {
    return course;
  }
  public void setKind(String kind)
  {
    this.kind = kind;
  }
  public String getKind()
  {
    return kind;
  }
  public Room getRoom()
  {
    return room;
  }
  public int getNumberOfStudents()
  {
    return course.getNumberOfStudents();
  }
  public Teacher getExaminer()
  {
    return examiner;
  }
  public MyDate getDate()
  {
    return date;
  }

  public void setCourse(Course course)
  {
    this.course = course;
  }

  public void setNumberOfStudents(int numberOfStudents)
  {
    course.setNumberOfStudents(numberOfStudents);
  }
  public void setExaminer(Teacher examiner)
  {
    this.examiner = examiner;
  }

  public void setDate(MyDate date)
  {
    this.date = date;
  }
  public void reserveRoom(Room room)
  {
    this.room=room;
  }

  public abstract String getType();
  public String toString()
  {
    return course+" "+examiner+" "+date+" "+room;
  }
  public boolean equals(Object obj)
  {
    if(!(obj instanceof Exam))
    {
      return false;
    }
    Exam other=(Exam)obj;
    return course.equals(other.course) && room.equals(other.room) && examiner.equals(other.examiner) && date.equals(other.date);
  }
}
