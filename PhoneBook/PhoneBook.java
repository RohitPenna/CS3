
/**
 * Write a description of class PhoneBook here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class PhoneBook implements IMap
{
    // instance variables - replace the example below with your own
    private Entry[] book;
    private int size;

    /**
     * Constructor for objects of class PhoneBook
     */
    public PhoneBook()
    {
        book = new Entry [983];
        size = 0;
    }

    public PhoneBook(int len)
    {
        book = new Entry [len];
        size = 0;
    }

    public PhoneNumber put(Person person, PhoneNumber phone)
    {
        if (book[person.hashCode() % book.length] == null)
        {
            return null;
        }
        PhoneNumber Return;
        Entry now = new Entry(person, phone);
        Entry place = book[person.hashCode() % book.length];

        Return = place.Num;
        while (place.next != null)
        {
            if (place.equals(now))
            {
                return Return;
            }
            place = place.next;
        }
        place.next = now;
        size++;
        return Return;

    }

    public PhoneNumber get(Person person)
    {
        if (book[person.hashCode() % book.length] == null)
        {
            return null;
        }
        Entry place = book[person.hashCode() % book.length];
        while (place.next != null)
        {
            if (place.Name.equals(person.Name))
            {
                return place.Num;
            }
            place = place.next;
        }
        return place.Num;
    }

    public PhoneNumber remove(Person person)
    {
        if (book[person.hashCode() % book.length] == null)
        {
            return null;
        }
        Entry place = book[person.hashCode() % book.length];
        PhoneNumber x;
        if(place.Name.equals(person.Name) && place.next == null)
        {
            x = new PhoneNumber(place.Num.number);
            place = null;
            return x;
        }
        else
        {
            while (place.next != null)
            {
                if (place.next.Name.equals(person.Name))
                {
                    x = new PhoneNumber(place.next.Num.number);
                    place.next = place.next.next;
                    return x;
                }
            }
            return place.Num;
        }
    }

    public int size()
    {
        return size;
    }
}
