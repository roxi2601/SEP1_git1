import java.io.Serializable;
import java.util.ArrayList;

public class MyDate implements Serializable
{
  private int day;
  private int month;
  private int year;
  private ArrayList<TimePeriod> hours;

  public MyDate(int day, int month, int year)
  {
    hours = new ArrayList<TimePeriod>();
    this.day=day;
    this.month=month;
    this.year=year;
  }
  public void setHours(TimePeriod hour)
  {
    hours.add(hour);
  }
  public void setDay(int day)
  {
    this.day = day;
  }

  public void setMonth(int month)
  {
    this.month = month;
  }

  public void setYear(int year)
  {
    this.year = year;
  }

  public int getDay()
  {
    return day;
  }

  public int getMonth()
  {
    return month;
  }

  public int getYear()
  {
    return year;
  }

  public ArrayList<TimePeriod> getHours()
  {
    return hours;
  }
  public MyDate copy()
  {
    return new MyDate(day,month,year);
  }
  public String toString()
  {
    String str="";
    for(int i = 0;i<hours.size();i++)
    {
      str+=hours.get(i)+" ";
    }
    return day+"/"+month+"/"+year+" "+str;
  }
  public boolean equals(Object obj)
  {
    if(!(obj instanceof MyDate))
    {
      return false;
    }
    MyDate other=(MyDate)obj;
    return day==other.day && month==other.month && year==other.year;
  }
}
