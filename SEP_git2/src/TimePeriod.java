import java.io.Serializable;
import java.util.ArrayList;

/**
 * A class containing TimePeriod objects and methods
 * @author Roksana Dziadowicz
 * @version 1.0
 */
public class TimePeriod implements Serializable
{
  private int startHour;
  private int startMinute;
  private int endHour;
  private int endMinute;

  public TimePeriod(int startHour, int startMinute, int endHour, int endMinute)
  {
    this.startHour=startHour;
    this.startMinute=startMinute;
    this.endHour=endHour;
    this.endMinute=endMinute;
  }
  public int getStartHour()
  {
    return startHour;
  }
  public int getStartMinute()
  {
    return startMinute;
  }
  public int getEndHour()
  {
    return endHour;
  }
  public int getEndMinute()
  {
    return endMinute;
  }
  public void setStartHour(int startHour)
  {
    this.startHour = startHour;
  }
  public void setStartMinute(int startMinute) { this.startMinute = startMinute; }
  public void setEndHour(int endHour)
  {
    this.endHour = endHour;
  }
  public void setEndMinute(int endMinute)
  {
    this.endMinute = endMinute;
  }

  public TimePeriod copy()
  {
    return new TimePeriod(startHour,startMinute,endHour,endMinute);
  }
  public String toString()
  {
    return startHour+":"+startMinute+"-"+endHour+":"+endMinute;
  }
  public boolean equals(Object obj)
  {
    if(!(obj instanceof TimePeriod))
    {
      return false;
    }
    TimePeriod other=(TimePeriod)obj;
    return startHour==other.startHour && startMinute==other.startMinute && endHour==other.endHour && endMinute==other.endMinute;
  }

}
