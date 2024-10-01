
/**
 * Write a description of class Entry here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Entry <K,V>
{
    // instance variables - replace the example below with your own
    public K Name;
    public V Num;
    public Entry next;
    

    /**
     * Constructor for objects of class Entry
     */
    public Entry(K p, V x)
    {
        Name = p;
        Num = x;
        next = null;
    }
    
    public boolean equals(Entry x)
    {
        return Name == x.Name;
    }
}
