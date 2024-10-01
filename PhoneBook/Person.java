
/**
 * Write a description of class Person here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Person
{
    // instance variables - replace the example below with your own
    public String Name;

    /**
     * Constructor for objects of class Person
     */
    public Person(String x)
    {
        Name = x;
    }

    @Override
    public int hashCode()
    {
        return Name.hashCode();
    }
    
    public boolean equals(String Name)
    {
        return this.Name.equals(Name);
    }
}
