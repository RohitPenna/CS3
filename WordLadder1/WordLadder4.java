import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;

public class WordLadder4
{
    private static Scanner reader;
    private static Scanner sc;
    private static File file2 = new File("dictionary.txt");
    private static Queue<Stack> x;
    private String start;
    private String end;
    private ArrayList <String> y;
    HashSet<String> wordUsed;

    public WordLadder4(String start, String end)
    {
        this.start = start;
        this.end = end;
        try 
        {
            sc = new Scanner(file2);
            y = new ArrayList<>();
            while (sc.hasNextLine())
            {
                String s = sc.nextLine();
                if(s.length() == start.length())
                {
                    y.add(s);
                }
            }
        } 
        catch (FileNotFoundException e) 
        {
            e.printStackTrace();
        }
        x = new LinkedList<Stack>();
        wordUsed = new HashSet<>();
    }

    public int stringCompare(String start, String comp, int k)
    {
        int dif = 0;
        for(int i = 0; i < comp.length(); i++)
        {
            if(!start.substring(i,i+1).equalsIgnoreCase(comp.substring(i,i+1)))
            {
                dif++;
            }
        }
        return dif;
    }

    public int stringCompare(Stack <String> x, String comp, int k)
    {
        int dif = 0;
        String start = x.peek();
        for(int i = 0; i < comp.length(); i++)
        {
            if(!start.substring(i,i+1).equalsIgnoreCase(comp.substring(i,i+1)))
            {
                dif++;
            }
        }
        return dif;
    }

    public String iteration ()
    {
        boolean u = false;
        boolean w = false;
        for(int i = 0; i < y.size(); i ++)
        {
            if(y.get(i).equalsIgnoreCase(start))
            {
                u = true;
            }
            if( y.get(i).equalsIgnoreCase(end))
            {
                w = true;
            }
        }
        Stack <String> initial = new Stack <String>();
        initial.push(start);
        x.offer(initial);
        int run = 0;
        int i = 0;
        if(u && w)
        {
            while(x.size() > 0)
            {
                String comp = y.get(i);
                if(stringCompare(start,comp, i) == 1 && run == 0)
                {
                    Stack <String> o = new Stack <String>();
                    o.push(start);
                    o.push(comp);
                    x.offer(o);
                    wordUsed.add(comp);
                }
                if(run > 0)
                {
                    if(stringCompare(x.peek(),comp, i) == 1 && !wordUsed.contains(comp))
                    {
                        Stack <String> c = deepCopy(x.peek());
                        c.push(comp);
                        wordUsed.add(comp);
                        x.offer(c);
                    }
                    x.offer(x.poll());
                }
                i++;
                if(comp.equalsIgnoreCase(end))
                {
                    int size = 4000;
                    Stack <String> xs = null;
                    for (int z = 0; z < x.size(); z++)
                    {
                        if(isFinished(x.peek()))
                        {
                            if(x.peek().size() < size)
                            {
                                xs = x.peek();
                            }
                        }
                        x.offer(x.poll());
                    }
                    if(xs != null)
                    {
                        //System.out.print(x);
                        return "bridge found >> " + xs;
                    }
                }
                if (i >= y.size())
                {
                    i = 0;
                    run++;
                }
                if(wordUsed.size() == y.size())
                {
                    return "no bridge between " + start + " and " + end;
                }
            }
        }
        return "no bridge between " + start + " and " + end;
    }

    public boolean isFinished(Stack <String> x)
    {
        //System.out.println(x.peek());
        return x.peek().equalsIgnoreCase(end);
    }

    public static Stack<String> deepCopy(Stack<String> k){
        Stack<String> t = (Stack<String>) k.clone();
        Stack<String> c = new Stack<>();
        Stack<String> f = new Stack<>();
        while(!t.isEmpty())
            c.push(t.pop());
        while(!c.isEmpty())
            f.push(c.pop());
        return f;
    }
}
