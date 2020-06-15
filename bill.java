package checker;
import java.util.*;
public class bill
{
    public static double NetEarned=0;
    double amt;
    double weight;
    int pickupchoice;
    public bill()
    {

    }

    public bill(double w, int choice1)
    {
        this.weight = w;
        this.pickupchoice = choice1;
    }

    public void totalbill()
    {
        if(pickupchoice == 1)
        {
            if(weight<=5)
            {
                amt = 200 + 125;
            }
            else if (weight>5)
            {
                amt = 200 + (125 + (weight-5)*5*2);
            }
            NetEarned+=amt;
        }

        else if(pickupchoice ==2)
        {
            if(weight<=5)
            {
                amt = 200;
            }
            else if(weight >5)
            {
                amt = 200 + (weight-5)*5;
            }
            NetEarned+=amt;
        }
        
    }

        public void displaybill()
        {
            System.out.print("\n\t\t---------------------------------------------------");

            System.out.print("\n\t\t\tTotal Bill : "+amt);
            System.out.print("\n\t\t---------------------------------------------------");

            

        }
    
}