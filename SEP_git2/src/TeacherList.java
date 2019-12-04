import java.io.Serializable;
import java.util.ArrayList;

public class TeacherList implements Serializable
{
  private ArrayList<Teacher> teachers;
  public TeacherList()
  {
    teachers=new ArrayList<Teacher>();
  }
  public ArrayList<Teacher> getAllTeachers()
  {
    return teachers;
  }
  public String toString()
  {
    String str="";
    for(int i=0;i<teachers.size();i++)
    {
      str+="Teacher's name:"+teachers.get(i).getName()+" Contact:"+teachers.get(i).getContact()+"Availability:"+teachers.get(i).getAvailability();
    }
    return str;
  }
}
