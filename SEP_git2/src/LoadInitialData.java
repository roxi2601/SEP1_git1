import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * A class loading initial data
 * @author Julia Tankiewicz
 * @version 1.0
 */
public class LoadInitialData
{
  public static void main(String[] args)
  {
    ExamSchedule exams = new ExamSchedule();


    MyTextFileIO mtfio = new MyTextFileIO();
    String[] examsArray = null;
    try
    {
      examsArray = mtfio.readArrayFromFile("SEP_git2/exams.txt");

      for (int i = 0; i < examsArray.length; i++)
      {
        String temp = examsArray[i];
        String[] tempArr = temp.split(" ");
        /*if(tempArr[0] instanceof Course)
        {
          Course course = (Course)tempArr[0];
        }
        Teacher examiner = tempArr[1];
        MyDate date = tempArr[2];
        Room room = tempArr[3];*/
        int nrOfStudents =Integer.parseInt(tempArr[4]);
        /*in exam project we have difrent types of data: other objects, ints itd..
        so I don't know how to convert Strings from txt file to diferent
        java objects to use them later, if you have idea please do it
        and contact me - julia :)
         */
        //exams.addExam(new Exam());
      }
    }
       catch (FileNotFoundException e)
      {
        System.out.println("File was not found, or could not be opened");
      }

      MyFileIO mfio = new MyFileIO();

      try
      {
        mfio.writeToFile("SEP_git2/exams.bin", exams);
      }
      catch (FileNotFoundException e)
      {
        System.out.println("Error opening file ");
      }
      catch (IOException e)
      {
        System.out.println("IO Error writing to file ");
      }

      System.out.println("Done");
    }

}


