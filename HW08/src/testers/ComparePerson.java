package testers;
import java.util.Comparator;
public class ComparePerson implements Comparator<Person>
{
	public int compare(Person left, Person right)
	{
		Date leftDate = left.getBirthDate();
		Date rightDate = right.getBirthDate();
		
		if(leftDate.getYear() == rightDate.getYear())
		{
			if(leftDate.getMonth() == rightDate.getMonth())
			{
				//This returns positive if left day is earlier and negative if right day is earlier
				return rightDate.getDay() -leftDate.getDay() ;
			}
			else
			{
				//This returns positive if left month is earlier and negative if right month is earlier
				return rightDate.getMonth() - leftDate.getMonth();
			}
		}
		else
		{
			return rightDate.getYear() - leftDate.getYear();
		}
	}

}
