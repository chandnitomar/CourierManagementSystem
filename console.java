package console;
import customer.*;
import java.util.*;
import employee.*;
import checker.*;
class console
{
    public static void main(String args[]) throws Exception
            {
                Scanner s = new Scanner(System.in);
                int ch, ch2;
                
                do
                {
                System.out.print("\n\t\tAre you a");
                System.out.print("\n\t\t1.Customer\n\t\t2.Employee\n\t\t3.EXIT\t: ");
                ch = s.nextInt();

                new_customer nc = new new_customer();
                cust_file cf = new cust_file();

                    switch(ch)
                    {
                        case 1:
                            
                            packageinfo pi = new packageinfo();
                            
                            nc.set_shipfromdetails();
                            nc.set_shiptodetails();
                            pi.set_packageinfo();
                            nc.display();
                            pi.displaypackageinfo();
                            
                            // cfile.readcustfile();
                            break;

                        case 2:
                            System.out.print("\n\n\t\t1.Register\n\t\t2.Login : ");
                            ch2 = s.nextInt();
                            employee emp = new employee();
                            bill b = new bill();
                            switch(ch2)
                            {   
                                case 1:
                                emp.setdetails();
                                break;
                                
                                case 2 :
                               boolean z =  emp.login();
                                if(z == true)
                                {
                                    // String amtearned = Double.toString(bill.NetEarned);
                                    // String str = "Net Earned : "+amtearned;
                                    // cf.appendStrToFile("C:\\Users\\Asus\\Desktop\\finaloop\\cust_file.txt",str);
                                    cf.readcustfile();
                                }
                                else if (z == false)
                                {
                                    System.out.print("\n\t\t **Invalid Login Details**");
                                }
                                break;


                            
                                    
                            }
                            
                            
                    }
                    
                }while(ch!=3);
                
            }
        

        
    
}