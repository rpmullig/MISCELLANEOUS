import java.util.Scanner;

class Validator {
  
  public static String getString(Scanner sc){
    String s = "";
    boolean isValid = false;
    while (isValid == false)
    {
      if (sc.hasNext())
      {
        s = sc.next();
        isValid = true;
      }
      else
      {
        System.out.println("Error! Invalid value. Try again.");
      }
      sc.nextLine();  // discard any other data entered on the line
    } 
    return s;
  }
  
      public static int getInt(Scanner sc)
    {
        boolean isValid = false;
        int i = 0;
        while (isValid == false)
        {
            if (sc.hasNextInt())
            {
                i = sc.nextInt();
                isValid = true;
            }
            else
            {
                System.out.println("Error! Invalid integer value. Try again.");
            }
            sc.nextLine();  // discard any other data entered on the line
        }
        return i;
    }

    public static int getInt(Scanner sc, int min, int max)
    {
        int i = 0;
        boolean isValid = false;
        while (isValid == false)
        {
            i = getInt(sc);
            if (i <= min)
                System.out.println(
                    "Error! Number must be greater than " + min);
            else if (i >= max)
                System.out.println(
                    "Error! Number must be less than " + max);
            else
                isValid = true;
        }
        return i;
    }
  
  
}