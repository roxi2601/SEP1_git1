import java.io.FileNotFoundException;
import java.io.IOException;

public class ExamScheduleAdapter
{
  private MyFileIO mfio;
  private String fileName;

  public ExamScheduleAdapter(String fileName)
  {
    mfio = new MyFileIO();
    this.fileName = fileName;
  }
  public CourseList getAllCourses()
  {
    CourseList courses = new CourseList();

    try
    {
      courses = (CourseList) mfio.readObjectFromFile(fileName);
    }
    catch (FileNotFoundException e)
    {
      System.out.println("File not found");
    }
    catch (IOException e)
    {
      System.out.println("IO Error reading file");
    }
    catch (ClassNotFoundException e)
    {
      System.out.println("Class Not Found");
    }
    return courses;
  }
  public RoomList getAllRooms()
  {
    RoomList rooms = new RoomList();

    try
    {
      rooms = (RoomList) mfio.readObjectFromFile(fileName);
    }
    catch (FileNotFoundException e)
    {
      System.out.println("File not found");
    }
    catch (IOException e)
    {
      System.out.println("IO Error reading file");
    }
    catch (ClassNotFoundException e)
    {
      System.out.println("Class Not Found");
    }
    return rooms;
  }
  public TeacherList getAllTeachers()
  {
    TeacherList teachers = new TeacherList();

    try
    {
      teachers = (TeacherList) mfio.readObjectFromFile(fileName);
    }
    catch (FileNotFoundException e)
    {
      System.out.println("File not found");
    }
    catch (IOException e)
    {
      System.out.println("IO Error reading file");
    }
    catch (ClassNotFoundException e)
    {
      System.out.println("Class Not Found");
    }
    return teachers;
  }
}
