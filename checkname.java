package checker;
import customer.*;
import java.util.*;

class InvalidNameException extends Exception
{
    public InvalidNameException(String s)
    {
        super(s);
    }
}

public class checkname
{
    String name;
    
    public checkname(String testname)
    {
        name = testname;
    }

    public int check_name()
    {
        char namearray[] = name.toCharArray();
        int flag = 0;


        outer:for (int i=0 ; i<namearray.length ;i++)
        {
            if(!(('A'<=namearray[i]) && ('Z'>=namearray[i])) && !(('a'<=namearray[i]) && ('z'>=namearray[i])))
              {
                flag = 1;
                break outer;
              }
        }

        if(flag == 1)
        {
            try
            {
                throw new InvalidNameException("**Invalid Characters For This Field**");
            }
            catch(InvalidNameException i)
            {
                System.out.print("\n\t\t"+i.getMessage());
            }
        }

            return flag;
        }

 }
