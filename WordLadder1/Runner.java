import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;

public class Runner
{
    // instance variables - replace the example below with your own
    private int x;
    private static File file = new File("input.txt");
    
    public Runner()
    {
        // initialise instance variables
        x = 0;
    }

    public static void main (String [] Args)
    {
        try 
        {
            Scanner reader = new Scanner(file);
            while(reader.hasNextLine())
            {
                String start = reader.next();
                String end = reader.next();
                WordLadder4 x = new WordLadder4(start, end);
                System.out.println(x.iteration());
            }
        } 
        catch (FileNotFoundException e) 
        {
            e.printStackTrace();
        }
    }
}
