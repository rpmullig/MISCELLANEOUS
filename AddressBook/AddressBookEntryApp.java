import java.util.Scanner; 

class AddressBookEntryApp {

  public static void main(String[] args){
    
    Scanner sc = new Scanner(System.in); 
    
    System.out.print("Welcome to the Address Book application\n"); 
    
    int input = 0; 
    String s; // a temporary string for printing/inputing values
    AddressBookEntry entry = new AddressBookEntry();
    
    
    while(input != 3){
      
      
      System.out.print("1 - List entries\n2 - Add entry\n3 - Exit\n\n");
      
      System.out.print("Enter menu number:"); 
      
      input = Validator.getInt(sc,0,4); 
      
      switch(input){
        case 1:
          s = AddressBookIO.getEntriesString();
          System.out.println(s);
          s = ""; 
          break;

        case 2:
          System.out.print("Enter Name:\t");
          s = Validator.getString(sc);
          entry.setName(s);
          System.out.println();
          
          System.out.print("Enter email address:\t");
          s = Validator.getString(sc);
          entry.setEmailAddress(s);
          System.out.println();
          
          System.out.print("Enter phone number:\t");
          s = Validator.getString(sc);
          entry.setPhoneNumber(s);
          System.out.println();
          
          AddressBookIO.saveEntry(entry);
          System.out.println();
          break;
          
        case 3:
          System.out.println("Goodbye\n");
          break;
          
        default:
          System.exit(-1);
          break;
      }
    }
    
    
  }
  
  
}