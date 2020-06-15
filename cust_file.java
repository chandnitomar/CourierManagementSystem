package customer;
import java.io.*;



public class cust_file 
{
    static int entryno = 0;
    String cust_name, receiver_name;
    String from_country, to_country;
    String from_add, to_add;
    String from_postalcode, to_postalcode;
    String from_ph_no, to_ph_no;

    public cust_file()
    {
        
    }
 
    public cust_file(String sname, String rname, String scountry, String rcountry, String sadd, String radd, String scode, String rcode, 
    String scontact, String rcontact )
    {
        this.cust_name = sname;
        this.receiver_name = rname;
        this.from_country = scountry;
        this.to_country = rcountry;
        this.from_add = sadd;
        this.to_add = radd;
        this.from_postalcode = scode;
        this.to_postalcode = rcode;
        this.from_ph_no = scontact;
        this.to_ph_no = rcontact;
    }
    
    public void createcustfile()
    {
        File cust_file = new File("C:\\Users\\Asus\\Desktop\\finaloop\\cust_file.txt");
        try
        {
            if(cust_file.createNewFile())
            {
                 System.out.print("\n File created: "+cust_file.getName());
            }
        }
        catch(IOException e)
        {
            System.out.print("\nError creating a file");
            e.printStackTrace();
        }
    }
   public void readcustfile()
    {
        //System.out.print("\n Im void readcustfile");
       
        try
        {
            BufferedReader in = new BufferedReader(new FileReader("C:\\Users\\Asus\\Desktop\\finaloop\\cust_file.txt"));
            
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
               System.out.println("\nError writing a file");
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

  public  void writetocustfile()
    {
       
		FileWriter custfilewriter = null;
		BufferedWriter writer = null;
        try
        {

            custfilewriter = new FileWriter("C:\\Users\\Asus\\Desktop\\finaloop\\cust_file.txt");
            writer = new BufferedWriter(custfilewriter);
            System.out.println("\n"+cust_name);
            writer.newLine();
            writer.write("Entry No : "+(++entryno)+"\n");
            writer.newLine();
            writer.write("Sender name : "+cust_name+"\n");
            writer.newLine();
            writer.write("Country/Location : "+from_country+"\n");
            writer.newLine();
            writer.write("Pickup Location : "+from_add+"\n");
            writer.newLine();
            writer.write("Pincode : "+from_postalcode+"\n");
            writer.newLine();
            writer.write("Contact no.: "+from_ph_no+"\n");
            writer.newLine();
            writer.write("\n--------------------------------------");
            writer.newLine();
            writer.write("Receiver name : "+receiver_name+"\n");
            writer.newLine();
            writer.write("Country/Location : "+to_country+"\n");
            writer.newLine();
            writer.write("Destination : "+to_add+"\n");
            writer.newLine();
            writer.write("Pincode : "+to_postalcode+"\n");
            writer.newLine();
            writer.write("Contact no.: "+to_ph_no+"\n");
            writer.newLine();
            writer.write("\n--------------------------------------");
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
            if (custfilewriter != null) 
            {
                try 
                {
					custfilewriter.close();
                } 
                catch (IOException e) 
                {
					e.printStackTrace();
				}
			}
		}
    }
    
    public static void appendStrToFile(String fileName, String str) 
{ 
    File cust_file = new File("C:\\Users\\Asus\\Desktop\\finaloop\\cust_file.txt");
    try 
{ 
    // Open given file in append mode. 
    BufferedWriter out = new BufferedWriter(new FileWriter(cust_file, true)); 
    out.newLine();
    out.write(str); 
    out.newLine();
    out.close(); 
}    
    catch (IOException e) 
    { 
        System.out.println("exception occoured" + e); 
    } 
} 

public void appendStrToFile(String filename)
{
    File cust_file = new File(filename);
    try 
{ 
    // Open given file in append mode. 
    BufferedWriter writer = new BufferedWriter(new FileWriter(cust_file, true)); 
   // writer.write(str); 
    writer.newLine();
    writer.write("Entry No : "+(++entryno)+"\n");
    writer.newLine();
    writer.write("Sender name : "+cust_name+"\n");
    writer.newLine();
    writer.write("Country/Location : "+from_country+"\n");
    writer.newLine();
    writer.write("Pickup Location : "+from_add+"\n");
    writer.newLine();
    writer.write("Pincode : "+from_postalcode+"\n");
    writer.newLine();
    writer.write("Contact no.: "+from_ph_no+"\n");
    writer.newLine();
    writer.write("\n--------------------------------------");
    writer.newLine();
    writer.write("Receiver name : "+receiver_name+"\n");
    writer.newLine();
    writer.write("Country/Location : "+to_country+"\n");
    writer.newLine();
    writer.write("Destination : "+to_add+"\n");
    writer.newLine();
    writer.write("Pincode : "+to_postalcode+"\n");
    writer.newLine();
    writer.write("Contact no.: "+to_ph_no+"\n");
    writer.newLine();
    writer.write("\n--------------------------------------");
    writer.close(); 
}    
catch (Exception e) 
{
    e.printStackTrace();

}
    // catch (IOException e) 
    // { 
    //     System.out.println("exception occoured" + e); 
    // } 
}

}

/*class writecustfile extends cust_file 
{
    void writetocustfile()
    {
       
		FileWriter custfilewriter = null;
		BufferedWriter writer = null;
        try
        {

            custfilewriter = new FileWriter("C:\\Users\\Asus\\Desktop\\cust_file.txt");
            writer = new BufferedWriter(custfilewriter);
            writer.write(cust_name);;
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
            if (custfilewriter != null) 
            {
                try 
                {
					custfilewriter.close();
                } 
                catch (IOException e) 
                {
					e.printStackTrace();
				}
			}
		}

	}

}*/
