import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;

public class WordLadder1
{
    private static File file = new File("input.txt");
    private static File file2 = new File("dictionary.txt");
    public WordLadder1()
    {

    }

    public static void main (String [] args)
    {
        Queue<Stack> x = new LinkedList<Stack>();
        try 
        {
            Scanner reader = new Scanner(file);
            Scanner sc = new Scanner(file2);
            while(reader.hasNextLine())
            {
                String start = reader.next();
                String end = reader.next();
                boolean y = false;
                int run = 0;
                while(!y)
                {
                    int dif = 0;
                    while(sc.hasNextLine())
                    {
                        String comp = sc.nextLine();
                        if(stringCompare(start,comp) == 1 && run == 0)
                        {
                            Stack <String> o = new Stack <String>();
                            o.push(start);
                            o.push(comp);
                            x.offer(o);
                            y = isFinished(o, end);
                        }
                        if(run > 0)
                        {
                            Stack <String> xs = x.poll();
                            System.out.println(xs.peek());
                            if(stringCompare(xs.peek(),comp) == 1 && run > 0)
                            {
                                xs.push(comp);
                                x.offer(xs);
                                y = isFinished(xs, end);
                            }
                        }
                    }
                    run++;
                }
            }
            System.out.print(x);
        } 
        catch (FileNotFoundException e) 
        {
            e.printStackTrace();
        }

    }

    public static int stringCompare(String start, String comp)
    {
        int dif = 0;
        if(comp.length() == start.length())
        {
            for(int i = 0; i < comp.length(); i++)
            {
                if(!start.substring(i,i+1).equalsIgnoreCase(comp.substring(i,i+1)))
                {
                    dif++;
                    //System.out.print(dif);
                }
            }
        }
        return dif;
    }

    public static boolean isFinished(Stack <String> x, String end)
    {
        return x.peek().equals(end);
    }
}
