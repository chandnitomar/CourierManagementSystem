package checker;
import java.util.*;

class SameAddressException extends Exception
{
    public SameAddressException(String s)
    {
        super(s);
    }
}

public class testsameaddress
{
    String from_add = new String();
    String to_add = new String();
    String from_postalcode, to_postalcode;
   public testsameaddress(String add1 , String add2, String postalcode1, String postalcode2)
    {
        this.from_add = add1;
        this.to_add = add2;
        this.from_postalcode = postalcode1;
        this.to_postalcode = postalcode2;
    }

    public boolean testaddress()
    {
        if (from_add.equalsIgnoreCase(to_add) && (from_postalcode.equals(to_postalcode)))
        {
            try
            {
                throw new SameAddressException("Both Addresses Can't be Same");
            }
            catch(SameAddressException e)
            {
                System.out.print("\n"+e.getMessage());
            }
            return false;
        }
        else
            return true;
    }
}