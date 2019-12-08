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

  /**
   * No-argument constructor initializing the CourseList.
   */
  public CourseList()
  {
    courses=new ArrayList<Course>();
  }

  /**
   * Gets all the courses.
   * @return all the courses
   */
  public ArrayList<Course> getAllCourses()
  {
    return courses;
  }

  /**
   * Gets a String representation of the CourseList.
   * @return a String containing information about all Course objects in the list-each Course object ollowed by a new line character
   */
  public String toString()
  {
    String returnStr = "";

    for(int i = 0; i<courses.size(); i++)
    {
      Course temp = courses.get(i);

      returnStr += temp +"\n";
    }
    return returnStr;
  }
}
