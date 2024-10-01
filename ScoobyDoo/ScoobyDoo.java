import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
/**
 * Write a description of class ScoobyDoo here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class ScoobyDoo
{
    // instance variables - replace the example below with your own
    private HashMap <String, String > graph = new HashMap <String, String > ();
    private boolean check = false;

    /**
     * Constructor for objects of class ScoobyDoo
     */
    public ScoobyDoo(String Filename)
    {
        File file = new File(Filename);

        try 
        {

            Scanner sc = new Scanner(file);

            int x = sc.nextInt();
            sc.nextLine();

            for (int i = 0; i < x; i++)
            {
                String s = sc.nextLine();
                create(s);
                s = sc.nextLine();
                //System.out.println(s);
                check(s);
                reset();
            }

        } 
        catch (FileNotFoundException e) 
        {
            e.printStackTrace();
        }
    }

    public void create(String line)
    {
        //System.out.println(line);
        String [] arr = line.split(" ");
        for (int i = 0; i < arr.length; i++)
        {

            String y2 = arr[i].substring(1,2);
            String x2 = arr[i].substring(0,1);
            
            //System.out.println(graph);

            if(graph.containsKey(x2))
            {
                String s = graph.get(x2);
                s += y2;
                graph.put(x2, s);
            }
            else
            {
                graph.put(x2, y2);
            }
            if (graph.containsKey(y2))
            {
                String s = graph.get(y2);
                //System.out.println(s);
                s += x2;
                graph.put(y2, s);
            }
            else
            {
                graph.put(y2, x2);
            }
        }
    }

    public void check(String path)
    {
        //System.out.println(path);
        String start = path.substring(0,1);
        String end = path.substring(1,2);
        HashSet <String> passed = new HashSet<String>();

        checkHelp(start, end, passed);
        if (check == false)
        {
            System.out.println("no");
        }

    }

    public void checkHelp (String start, String end, HashSet x)
    {
        String edges = graph.get(start);
        x.add(start);

        if (edges == null)
        {
            return;
        }
        if (edges.contains(end))
        {
            System.out.println("yes");
            check = true;
        }
        else
        {
            for (int i = 0; i < edges.length(); i++)
            {
                if (!x.contains(edges.substring(i, i + 1)))
                    checkHelp(edges.substring(i, i + 1), end, x);
            }
        }
    }

    public void reset()
    {
        graph =  new HashMap <String, String > ();
        check = false;
    }

    private class Vertex
    {
        String vertex;

        public Vertex(String x)
        {
            vertex = x;
        }
        
        public boolean equals(Vertex x)
        {
            return x.vertex.equals(this.vertex);
        }
    }

    public static void main (String [] args)
    {
        ScoobyDoo x = new ScoobyDoo("scooby.txt");
    }

    // private class Edges
    // {
    // Vertex v1;
    // Vertex v2;

    // public Edges(Vertex x, Vertex y)
    // {
    // v1 = x;
    // v2 = y;
    // }

    // public boolean contains (Vertex x)
    // {
    // return x.equals(v1) || x.equals(v2);
    // }

    // }

}
