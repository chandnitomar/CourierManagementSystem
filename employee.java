package employee;
import checker.*;
import customer.*;
import employee.emp_file;
import employee.selectperson;

import java.util.*;

class InvalidPasswordLength extends Exception
{
    public InvalidPasswordLength(String s)
    {
        super(s);
    }
}
public class employee 
{

    String emp_id;
    String emp_name = new String();
    String emp_pass ;
    String fname;
    String str; //to append delivery person

    Scanner scan_emp = new Scanner(System.in);

    public void setdetails()
    {
        int z;
        do
        {
            System.out.print("\n\t\tEmployee Name: ");
            emp_name = scan_emp.nextLine();
            checkname cn = new checkname(emp_name);
             z =cn.check_name();
        }while(z == 1);
        z = 0;

        System.out.print("\n\t\tEmployee ID: ");
        emp_id = scan_emp.nextLine();
        scan_emp.nextLine();
       
        password();
        emp_file ef = new emp_file(emp_name,emp_id,emp_pass);
        ef.createempfile();
        ef.writetoempfile();

    }

    public void password()
    {
            int iteration = 0;
            System.out.print("\n\t\tPassword: ");
           this.emp_pass  = scan_emp.nextLine();
            
            
            char pass_array[] = emp_pass.toCharArray();
            int flag = 0;
        outer1:do
        {
            if(iteration>0)
            {
                System.out.print("\n\t\tPassword: ");
                emp_pass = scan_emp.nextLine();
                pass_array = emp_pass.toCharArray();
            }
           
                if (pass_array.length < 8)
                {
                    flag = 1;
                }
				
				
            
            if(flag == 1)
            {
                    try
                    {
                        throw new InvalidPasswordLength("Minimum 8 characters");
                    }
                    catch(InvalidPasswordLength i1)
                    {
                        System.out.print("\n"+i1.getMessage());
                    }
           }

           if(flag==0)
           {
               System.out.println("\n\t\tPassword set Successfully");
               break outer1;
           }
            
            iteration++;
            
        }while(pass_array.length<8);
        }

    public boolean login()
    {
        boolean exists,z2;
        int z;
        do
        {
            System.out.print("\n\t\tEmployee name: ");
            this.emp_name = scan_emp.nextLine();
            checkname cn = new checkname(emp_name);
             z =cn.check_name();
        }while(z == 1);
        z = 0;

         
        System.out.print("\n\t\tPassword: ");
        this.emp_pass = scan_emp.nextLine();
        emp_file ef = new emp_file(emp_name,emp_pass);
        
       exists = ef.emplogin();
       if (exists == true)
       {
            selectperson sp =new selectperson();
            str = sp.allocateperson();
            //System.out.print("\nWhy I wasn't executed:");
            //open cust file in append mode
            cust_file cf = new cust_file();
            cf.appendStrToFile("C:\\Users\\Asus\\Desktop\\finaloop\\cust_file.txt", str);
            z2 = true;

       }

       else 
            z2 = false;

       return z2;
    }
    
}
