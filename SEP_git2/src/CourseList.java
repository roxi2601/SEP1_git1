import java.io.Serializable;
import java.util.ArrayList;

/**
 *  A class containing a list of Course objects
 * @author Roksana Dziadowicz
 * @version 1.0
 */
public class CourseList implements Serializable
{
  private ArrayList<Course> courses;

  public CourseList()
  {
    courses=new ArrayList<Course>();
  }
  public ArrayList<Course> getAllCourses()
  {
    return courses;
  }
  public String toString()
  {
    String str="";
    for(int i=0;i<courses.size();i++)
    {
      str+="Course name:"+courses.get(i).getName()+" Teacher:"+courses.get(i).getTeacher()+" Room:"+courses.get(i).getRoom()+""
          + "Exam type:"+courses.get(i).getExamType()+" Number of students:"+courses.get(i).getNumberOfStudents();
    }
    return str;
  }
  public boolean equals(Object obj)
  {
    if(!(obj instanceof CourseList))
    {
      return false;
    }
    CourseList other = (CourseList)obj;
    return other.courses==courses;
  }
}
