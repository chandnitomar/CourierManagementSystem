package customer;
import java.util.*;
import checker.*;

public class packageinfo
{
    public int packageunits;
     int select;
    public double unitweight;
    int pickupchoice;
    shipdate sd = new shipdate();
   public void set_packageinfo()
       {
        Scanner s = new Scanner(System.in);
        System.out.print("\n\n*-*-*-*-*-*PACKAGE DETAILS*-*-*-*-*-*");
        int flag = 0;
        do
        {
            flag = 0;
            System.out.print("\n\t\tNo. of Packages : ");
            try
            {
               this.packageunits = s.nextInt();
            }
            catch (InputMismatchException i)
            {
                System.out.print("\n\t\t!!!Please Enter an Integer!!!");
                flag++;
            }
        }while(flag!=0);
        System.out.print("\n\t\tType:-");
        System.out.print("\n\t\t1.Documents(<1kg)\n\t\t2. Product/Commodity(<5kg)\n\t\t3.Heavy/Bulky(>5kg)");
        this.select = s.nextInt();
        System.out.print("\n\t\tTotal Weight in kgs : ");
        this.unitweight = s.nextDouble();
        do
        {
            System.out.println("\n\t\tWould you like your package to be:-");
            System.out.print("\n\t\t\t1. Picked-up by us");
            System.out.print("\n\t\t\t\t Charges may apply as follows:");
            System.out.print("\n\t\t\t\t(a) Rs 125/- if weight is below 5kgs");
            System.out.print("\n\t\t\t\t(b) Rs 125/- + Rs 5/- per kg if weight is >5kg");
            System.out.print("\n\t\t\t2.Dropped of by you\t: ");
            this.pickupchoice = s.nextInt();
        }while(!(pickupchoice==1)&& !(pickupchoice==2));
        
        
        
        System.out.print("\n\t\tShipment Date : ");
        
        sd.setshipdate();

    }

    public void displaypackageinfo()
    {
        System.out.print("\n\t\t*-*-*-*-*-*PACKAGE DETAILS*-*-*-*-*-*-*");
        if(select == 1)
        System.out.print("\n\t\t\t Category : Documents");
        if(select == 2)
        System.out.print("\n\t\t\t Category : Product/Commodity");
        if(select == 3)
        System.out.print("\n\t\t\t Category : Heavy/Bulky");
        System.out.print("\n\t\t\t Delivery Choice : ");
        if (pickupchoice == 1)
        {
            System.out.print("To be picked up by us");
            if(unitweight <=5 )
            System.out.print("\n\t\t\t\t Pickup Charges :  125 INR  ");
            if(unitweight >5)
            System.out.print("\n\t\t\t\t Pickup Charges : 125 + 5*("+(unitweight-5)+") = "+(125 + (unitweight-5)*5)+" INR");
            
        }
        if(pickupchoice == 2)
            System.out.print("Dropped of by you");
        sd.displayshipdate();
        bill b = new bill(unitweight,pickupchoice);
        cust_file cf = new cust_file();

        System.out.print("\n\t--------------------------------------------------------------");
        b.totalbill();
        b.displaybill();
        String amtearned = Double.toString(bill.NetEarned);
        String str = "Net Earned : "+amtearned;
        cf.appendStrToFile("C:\\Users\\Asus\\Desktop\\finaloop\\cust_file.txt",str);

    }
}