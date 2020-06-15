package customer;
import java.util.*;
import checker.*;



public class new_customer 
{
   static int iteration = 0;
   String cust_name, receiver_name;
   String from_country, to_country;
   String from_add, to_add;
   String from_postalcode, to_postalcode;
   String from_ph_no, to_ph_no;

    public void set_shipfromdetails()
    {
        int z;
        checkname cn;
        System.out.print("\n*****SHIP FROM DETAILS*****");
        Scanner scan_cust = new Scanner(System.in);
        do
        {
            System.out.print("\n\n\t\tCustomer Name: ");
            this.cust_name = scan_cust.nextLine();
            cn = new checkname(cust_name);
             z =cn.check_name();
        }while(z == 1);
        
       do
       {
		 System.out.print("\n\t\tCountry/Location: ");
         this.from_country = scan_cust.nextLine();
         //System.out.print("\n"+from_country);
         cn = new checkname(from_country);
         z = cn.check_name();
         //System.out.println(""+z);
        }while(z == 1);
        

         System.out.print("\n\t\tPostal Code: ");
         this.from_postalcode = scan_cust.nextLine();
         checknoofdigit ch1 = new checknoofdigit(from_postalcode, 6);
         ch1.testdata();
         System.out.print("\n\t\tFrom Address: ");
         from_add = scan_cust.nextLine();
		 
         
         System.out.print("\n\t\tContact No.: ");
         from_ph_no = scan_cust.nextLine(); 

         checknoofdigit ch = new checknoofdigit(from_ph_no, 10);
         ch.testdata();
         System.out.print("\n\t--------------------------------------------------------------");
    }

    public void set_shiptodetails()
    {
        int z;
        System.out.print("\n\n*****SHIP TO DETAILS*****");
        Scanner s = new Scanner(System.in);
        do
        {
            System.out.print("\n\t\tReceiver's Name: ");
            this.receiver_name = s.nextLine();
            checkname cn = new checkname(receiver_name);
             z =cn.check_name();
        }while(z == 1);
        

        do
        {
    		 System.out.print("\n\t\tCountry/Location: ");
             this.to_country = s.nextLine();
             checkname cn = new checkname(to_country);
             z =cn.check_name();
        }while(z == 1);
        z = 1;
         boolean z1 = false;
         do
         {
            System.out.print("\n\t\tPostal Code: ");
            to_postalcode = s.nextLine();
            checknoofdigit ch1 = new checknoofdigit(to_postalcode, 6);
            ch1.testdata();
            
                System.out.print("\n\t\tTo Address: ");
                to_add = s.nextLine();
                testsameaddress t = new testsameaddress(from_add, to_add, from_postalcode, to_postalcode);
                z1 = t.testaddress();
                if(!z1)
                {
                    System.out.println("\n\t\t**Please Re-enter Receiver's Address' Detail**");
                }
        }while(z1 == false);
		 
         
         System.out.print("\n\t\tContact No.: ");
         to_ph_no = s.nextLine(); 

         checknoofdigit ch = new checknoofdigit(to_ph_no, 10);
         ch.testdata();
         System.out.print("\n\t--------------------------------------------------------------");
         iteration++;

         cust_file cf = new cust_file(cust_name,receiver_name,from_country,to_country,from_add,to_add,from_postalcode,to_postalcode,from_ph_no,
         to_ph_no);
         if(iteration == 0)
         {
            cf.createcustfile();
            cf.writetocustfile();
         }
         if (iteration > 0)
         {
             cf.appendStrToFile("C:\\Users\\Asus\\Desktop\\finaloop\\cust_file.txt");
         }
    }

  public void display()
    {
        System.out.print("\n\t--------------------------------------------------------------");
        System.out.print("\n\n\n\t\t------------S H I P   F R O M   /   T O -----------");
        System.out.print("\n\t--------------------------------------------------------------");
        System.out.print("\n\t\t*-*-*-*-*-*SENDER's DETAILS*-*-*-*-*-*");
        System.out.print("\n\t\t\t\tSender Name : "+cust_name);
        System.out.print("\n\t\t\t\tCountry/Location : "+from_country);
        System.out.print("\n\t\t\t\tPostal Code : "+from_postalcode);
        System.out.print("\n\t\t\t\tAddress : "+from_add);
        System.out.print("\n\t\t\t\tContact No. : "+from_ph_no);
        System.out.print("\n\t--------------------------------------------------------------");
        System.out.print("\n\n\t\t*-*-*-*-*-*RECEIVER's DETAILS*-*-*-*-*-*");
        System.out.print("\n\t\t\t\tReceiver Name : "+receiver_name);
        System.out.print("\n\t\t\t\tCountry/Location : "+to_country);
        System.out.print("\n\t\t\t\tPostal Code : "+to_postalcode);
        System.out.print("\n\t\t\t\tAddress : "+to_add);
        System.out.print("\n\t\t\t\tContact No. : "+to_ph_no);
        System.out.print("\n\t--------------------------------------------------------------");
    }       //set phone nos. private when child class calls the super() display
 


        
    }
