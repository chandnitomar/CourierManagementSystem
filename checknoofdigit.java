package checker;
import java.util.*;

class InvalidLengthException extends Exception
{
    public InvalidLengthException(String str)
    {
        super(str);
    }
}

class InvalidDataTypeException extends Exception
{
    public InvalidDataTypeException(String str)
    {
        super(str);
    }
}

public class checknoofdigit
{
    int intdata;
    String stringdata = new String();
    int x;//no. of digits required
    public checknoofdigit(String testdata, int n)
    {
        stringdata = testdata;
        this.x = n;
    }

    public checknoofdigit(int testdata, int n)
    {
        this.intdata = testdata;
        this.x = n;
    }

   public void testdata()
    {
        Scanner s = new Scanner(System.in);
        char digits[] = stringdata.toCharArray();
         int flag = 0; 
         int iteration = 0;
        outer1: do
         {      if(iteration>0)
            {
                System.out.print("\n\nPlease Re-enter: ");
                String data2 = s.nextLine();
                digits = data2.toCharArray();
                flag = 0; 
            }    
            
             int counter = 0;
             outer: for(int i=0; i<digits.length;i++)
             {
                 if('0'>digits[i] || digits[i]>'9' )
                    {
                         flag = 1;
                         break outer;
                    }
             }
             

                 if(flag==1)
                 {
                     try
                     {
                         throw new InvalidDataTypeException("Invalid Input for this Field");
                     }
                     catch(InvalidDataTypeException i3)
                     {
                         System.out.print("\n"+i3.getMessage());
                         System.out.print("\n**Please enter integers**");
                     }
                }
                 if (flag == 0)
                 {
                    if(digits.length != x)
                    {
                        try
                        {
                            throw new InvalidLengthException("Invalid Length"); 
                        }
                        catch(InvalidLengthException i2)
                        {
                            System.out.print("\n"+i2.getMessage());
                            System.out.print("\n**Please enter "+x+" digit no.**");
                        }
                    }
                    else
                        break outer1;
                 }
                 
             iteration++;
         }while(digits.length != x || flag == 1);
}

    public void testintdata()
{
        Scanner s = new Scanner(System.in);
        stringdata = Integer.toString(intdata);
        char digits[] = stringdata.toCharArray();
         int flag = 0; 
        
                    if(digits.length > x)
                    {
                        try
                        {
                            throw new InvalidLengthException("Invalid Length"); 
                        }
                        catch(InvalidLengthException i2)
                        {
                            System.out.print("\n"+i2.getMessage());
                            System.out.print("\n**Please enter "+x+" digit no.**");
                        }
                    }
               
}

}