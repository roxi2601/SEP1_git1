import java.io.Serializable;
import java.util.ArrayList;

/**
 *  A class containing ExamSchedule objects and methods
 * @author Roksana Dziadowicz
 * @version 1.0
 */
public class ExamSchedule implements Serializable
{
  private ArrayList<Exam> exams;

  public ExamSchedule()
  {
    exams = new ArrayList<Exam>();
  }

  public ArrayList<Exam> getAllExams()
  {
    return exams;
  }

  public Exam getExam(int index)
  {
    return exams.get(index);
  }
  public int size()
  {
    return exams.size();
  }
  public ArrayList<Exam> getAllExams(String courseName)
  {
    ArrayList<Exam> exams2 = new ArrayList<>();
    for (int i = 0; i < exams.size(); i++)
    {
      if (!(exams.get(i).getCourse().getName().equals(courseName)))
      {
        exams2.add(exams.get(i));
      }
    }
    return exams2;
  }
  public ArrayList<Exam> getAllOralExams()
  {
    ArrayList<Exam> exams2 = new ArrayList<>();
    for (int i = 0; i < exams.size(); i++)
    {
      if (!(exams.get(i).getType().equals("Oral")))
      {
        exams2.add(exams.get(i));
      }
    }
    return exams2;
  }
  public ArrayList<Exam> getAllWrittenExams()
  {
    ArrayList<Exam> exams2 = new ArrayList<>();
    for (int i = 0; i < exams.size(); i++)
    {
      if (!(exams.get(i).getType().equals("Written")))
      {
        exams2.add(exams.get(i));
      }
    }
    return exams2;
  }
  public void editExam(Exam exam)
  {
    //should it be in GUI adapter???
  }
  public void addExam(Exam exam)
  {
    exams.add(exam);
  }
  public void removeExam(Exam exam)
  {
    exams.remove(exam);
  }
  public String toString()
  {
    String str="";
    for(int i=0;i<exams.size();i++)
    {
      str+= exams.get(i).getCourse()+","+exams.get(i).getType()+","+exams.get(i).getExaminer()+","
          +exams.get(i).getRoom()+","+exams.get(i).getDate()+"\n";
    }
    return str;
  }
}
