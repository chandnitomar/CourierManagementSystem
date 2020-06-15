package employee;
import java.util.*;
import customer.*;

abstract class deliveryperson
{
	abstract String deliverby();
}
class person1 extends deliveryperson
{
		String deliverby()
		{
			String str ="Package will be delivered by Jill";
			return str;
		}
}
class person2 extends deliveryperson
{
	String deliverby()
	{
		String str ="Package will be delivered by Joe";
		return str;
	}
}
class person3 extends deliveryperson
{
		String deliverby()
		{
			String str ="Package will be delivered by Jack";
			return str;
		}
}
public class selectperson 
{
	String person;
	public String allocateperson()
	{
		deliveryperson it[] = new deliveryperson[3];
		
		
		double x = Math.random()*3;
		int y = (int)x;
		
		if (y == 0)
		{
			it[0] = new person1();
			person = it[0].deliverby();
			return person;
		}
			
		else if (y == 1)
			{
				it[1] = new person2();
				person = it[1].deliverby();
				return person;
			}
			
		else if (y == 2)
		{
			it[2] = new person3();
			person = it[2].deliverby();
			return person;
		}
	
		return person;
	}
}
