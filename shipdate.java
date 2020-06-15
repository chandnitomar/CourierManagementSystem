package checker;
import java.util.*;
public class shipdate
{
	int dd,mm,yyyy;
	int d,m,y;
 public void setshipdate() throws InputMismatchException
{
	
	int flag = 0;
	int iteration = 0;

	do
	{
			Scanner o=new Scanner(System.in);
			do
			{
				if(iteration>0)
				{
					System.out.print("\n\t\t!!Invalid Date!!");
					System.out.print("\n\n\t\tPlease Re-enter");
				}
				
					System.out.print("\n\t\tEnter date :");
					this.dd=o.nextInt();
					checknoofdigit c = new checknoofdigit(dd, 2);
					c.testintdata();
					iteration++;
				
				
			}while(dd<=0 || dd>31);
			iteration = 0;
			do
			{
				if(iteration>0)
				{
					System.out.print("\n\t\t!!Invalid Month!!");
					System.out.print("\n\n\t\tPlease Re-enter");
				}
				System.out.print("\n\t\tEnter Month : ");
				this.mm=o.nextInt();
				checknoofdigit c = new checknoofdigit(mm, 2);
				c.testintdata();
				iteration++;
			}while(mm<=0 || mm>12);
			iteration = 0;
		do
		{
			if(iteration>0)
			{
				//System.out.print("\n!!Year Cant Be Less than Current year, 2019!!");
				System.out.print("\n\n\t\t!!Enter a Date within 1 year!!");
			}
				System.out.print("\n\t\tEnter year : ");
				this.yyyy=o.nextInt();
				checknoofdigit c = new checknoofdigit(yyyy, 4);
				c.testintdata();
				iteration++;
		}while(yyyy<2019 || yyyy>2022);
			
		if((dd<=0||mm<=0||yyyy<=0)||(dd>31||mm>12))
		{
			System.out.print("\n\t\t!!Invalid Date!!");
			flag = 1;
		}

		else
		{
			if(mm==1||mm==3||mm==5||mm==7||mm==8||mm==10||mm==12)
					{
						if(dd>31)
						{
							System.out.print("\n\t\t**Please Enter date <=31**");
							flag = 1;
						}
						else
						{
							System.out.print("\n\n\t\tShipment Date : "+dd+"/"+mm+"/"+yyyy);
						}
					}
			if(mm==4||mm==6||mm==9||mm==11)
					{
						if(dd>30)
						{
							System.out.print("\n\t\t**Please Enter Date <=30**");
							flag = 1;
						}
						else
						{
							System.out.print("\n\n\t\tShipment Date : "+dd+"/"+mm+"/"+yyyy);
						}
					}
			if(mm==2)
					{
						if(yyyy%4==0)
						{
							if(dd>29)
							{
								System.out.print("\n\t\t**Date can't be greater than 29**");
								flag = 1;
							}
						else
							System.out.print("\n\n\t\tShipment Date : "+dd+"/"+mm+"/"+yyyy);
						}
						else if (yyyy%4!=0)
						{
							if(dd>28)
							{
								System.out.print("\n\t\tDate can't be Greater than 28");
								flag = 1;
							}
						else
							System.out.println("\n\n\t\tShipment Date : "+dd+"/"+mm+"/"+yyyy);
						}
					}					
		}
}while (flag == 1);
}

public void displayshipdate()
{
	
	this.d = dd;
	this.m = mm;
	this.y = yyyy;
	System.out.println("\n\n\t\t Shipment Date : "+d+"/"+m+"/"+y);
}
}
				
				
	



