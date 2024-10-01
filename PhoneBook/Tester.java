
/**
 * Write a description of class Tester here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Tester
{
    // instance variables - replace the example below with your own
    private int x;

    /**
     * Constructor for objects of class Tester
     */
    public Tester()
    {
        // initialise instance variables
        x = 0;
    }

    public static void main(String [] args)
    {
        MyHashTable<Person, Integer> table = new MyHashTable<>();
        table.put(new Person("Siblings"), 60);
        table.put(new Person("Teheran"), 70);
        
        System.out.println(table.remove(new Person("Siblings")));
        System.out.println(table.get(new Person("Siblings")));
        //System.out.println("Teheran".hashCode());
    }
}
