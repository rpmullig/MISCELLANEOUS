import java.io.*;


public class textFileReader{

	
	public static String getFile() {

		String S = ""; 
		String fileN = "C:\\Users\\rpmulligan\\Desktop\\S428_final_projects\\finalProject\\src\\inventory.txt";

        // This will reference one line at a time
        String line = null;

        try {
            // FileReader reads text files in the default encoding.
            FileReader fileReader = 
                new FileReader(fileN);

            // Always wrap FileReader in BufferedReader.
            BufferedReader bufferedReader = 
                new BufferedReader(fileReader);

            String [] soda_names = {"Pepsi", "Diet Pepsi", "Mountain Dew", "Dr.Pepper", "Root Beer", "Water" };
            
            
            
            int x = 0; 
            while((line = bufferedReader.readLine()) != null) {
            	
            	int line_int = Integer.parseInt(line);
            	
                S += soda_names[x] + " has qty " + line + " with revenue " + (10 - line_int) + "\n";
                x++;
            }   

            // Always close files.
            bufferedReader.close();
        	return S;
        }
        

        catch(FileNotFoundException ex) {
            System.out.println(
                "Unable to open file '" + 
                fileN + "'");
            
        }
            catch(IOException ex) {
                System.out.println(
                    "Error reading file '" 
                    + fileN + "'");   
            }
		return S;
         
        
	
	}
	
	
	
	public static void updateFile(int line, int qty){
		
		int[] soda_inventory = fileRead(false);
		soda_inventory [line] = (qty-1);
		
        // The name of the file to open.
        String fileName2 = "C:\\Users\\rpmulligan\\Desktop\\S428_final_projects\\finalProject\\src\\inventory.txt";

        // This will reference one line at a time
        String line2 = null;

        try{
            
            FileWriter fileWriter= new FileWriter(fileName2);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            
            
            for(int z = 0; z <soda_inventory.length; z++){
            	line2 = "" + soda_inventory[z];
            	bufferedWriter.write(line2 +"\n");
            }
         bufferedWriter.close();
	}
    catch(FileNotFoundException ex) {
        System.out.println(
            "Unable to open file '" + 
            fileName2 + "'");
        
    }
        catch(IOException ex) {
            System.out.println(
                "Error reading file '" 
                + fileName2 + "'");   
        }
        
        
        fileRead(true);
	}
	
	
	public static int[] fileRead(boolean p) {

		
		if(p){
		System.out.println("----------------------------");
		}
		int [] soda_inventory = {0,0,0,0,0,0};
        
		
        // The name of the file to open.
        String fileName = "C:\\Users\\rpmulligan\\Desktop\\S428_final_projects\\finalProject\\src\\inventory.txt";

        // This will reference one line at a time
        String line = null;

        try {
            // FileReader reads text files in the default encoding.
            FileReader fileReader = 
                new FileReader(fileName);

            // Always wrap FileReader in BufferedReader.
            BufferedReader bufferedReader = 
                new BufferedReader(fileReader);

            String [] soda_names = {"Pepsi", "Diet Pepsi", "Mountain Dew", "Dr.Pepper", "Root Beer", "Water" };
            
            
            
            int x = 0; 
            while((line = bufferedReader.readLine()) != null) {
            	
            	int line_int = Integer.parseInt(line);
            	if(p){
                System.out.println(soda_names[x] + " has qty " + line + " with revenue " + (10 - line_int) );
            	}
                soda_inventory[x] = line_int;
                x++;
            }   

            // Always close files.
            bufferedReader.close();
            return soda_inventory;
        }
        catch(FileNotFoundException ex) {
            System.out.println(
                "Unable to open file '" + 
                fileName + "'");
            return soda_inventory;
        }
        catch(IOException ex) {
            System.out.println(
                "Error reading file '" 
                + fileName + "'");   
            return soda_inventory;
        }
    }
	
	
}


