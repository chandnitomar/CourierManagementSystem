package employee;
import checker.*;
import java.io.*;

public class emp_file
{
    String emp_name;
    String emp_id;
    String emp_pswd;
    String fname;
    String makefname;

    public emp_file(String empname, String pswd)
    {
        this.emp_name = empname;
        this.emp_pswd = pswd;
        this.makefname = empname.concat(pswd);
        this.fname = "C:\\Users\\Asus\\Desktop\\finaloop\\"+makefname+".txt";
    }

    public emp_file(String empname,String empid, String pswd)
    {
        this.emp_name = empname;
        this.emp_id = empid;
        this.emp_pswd = pswd;
        this.makefname = empname.concat(pswd);
        this.fname = "C:\\Users\\Asus\\Desktop\\finaloop\\"+makefname+".txt";
    }

    public void readempfile(String filename)
    {
        System.out.print("\n Im void readempfile");
       
        try
        {
            BufferedReader in = new BufferedReader(new FileReader(filename));
            
            try
            {
                String line = in.readLine();
                
                while(line != null)
                {
                    System.out.println(line);
                    line = in.readLine();
                }
            }
            catch(IOException i)
           {
               System.out.println("\nError reading a file");
           } 
           try
           {
            in.close();
           }
           catch(IOException i)
           {
               System.out.print("\nError Closing the file");
           }
        }
        catch (FileNotFoundException f)
        {
            System.out.println("\nFile not found");
        }
    }

    public boolean emplogin()
    {
        File emp_file = new File(fname);
        if(emp_file.exists())
        {
            System.out.print("\n**Login Succesful**");
            return true;
        }
        else
        {
            return false;
        }

    }

    public void createempfile()
    {
        File emp_file = new File(fname);
        try
        {
            if(emp_file.createNewFile())
            {
                 System.out.print("\n File created: "+emp_file.getName());
            }
        }
        catch(IOException e)
        {
            System.out.print("\nError creating a file");
            e.printStackTrace();
        }
    }

    public  void writetoempfile()
    {
       
		FileWriter empfilewriter = null;
		BufferedWriter writer = null;
        try
        {

            empfilewriter = new FileWriter(fname);
            writer = new BufferedWriter(empfilewriter);
           
            writer.write("\nEmployee Name :"+emp_name);
            writer.newLine();
            writer.write("\nPassword: "+emp_pswd);
            writer.newLine();
            writer.write("\nEmployee ID: "+emp_id);
            writer.newLine();
            System.out.print("\n***Registered Successfully**");

        }
        catch (Exception e) 
        {
            e.printStackTrace();
        
        }

        finally
         {
			// close BufferedWriter
            if (writer != null)
             {
                try 
                {
					writer.close();
                } catch (IOException e) 
                {
					e.printStackTrace();
				}
			}
			// close FileWriter
            if (empfilewriter != null) 
            {
                try 
                {
					empfilewriter.close();
                } 
                catch (IOException e) 
                {
					e.printStackTrace();
				}
			}
		}
    }
}
    
   