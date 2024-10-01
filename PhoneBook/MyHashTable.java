import java.util.*;
/**
 * Write a description of class MyHashTable here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class MyHashTable <K,V> implements IMap <K,V>
{
    // instance variables - replace the example below with your own
    private Entry[] book;
    private int size;

    /**
     * Constructor for objects of class MyHashTable
     */
    public MyHashTable()
    {
        book = new Entry [983];
        size = 0;
    }

    public MyHashTable(int len)
    {
        book = new Entry [len];
        size = 0;
    }

    public V put(K person, V phone)
    {
        int hash = Math.abs(person.hashCode());
        if (book[hash % 983] == null)
        {
            book[hash % 983] = new Entry<>(person,phone);;
            size++;
            return null;
        }
        Entry <K,V> now = new Entry<>(person, phone);
        Entry <K,V> place = book[hash % book.length];
        V Return = (V) place.Num;
        while (place.next != null)
        {
            if (place.equals(now))
            {
                place.Num = now.Num;
                return Return;
            }
            place = place.next;
        }
        
        place.next = now;
        size++;
        return Return;

    }

    public V get(K person)
    {
        int hash = Math.abs(person.hashCode());
        if (book[hash % book.length] == null)
        {
            return null;
        }
        Entry place = book[hash % book.length];
        if(place.next == null)
        {
            return (V) place.Num;
        }

        while (place.next != null)
        {
            if (place.Name.equals((K)person))
            {
                return (V) place.Num;
            }
            place = place.next;
        }
        return (V) place.Num;
    }

    public V remove(K person)
    {
        int hash = Math.abs(person.hashCode());
        if (book[hash % book.length] == null)
        {
            return null;
        }
        Entry place = book[hash % book.length];
        V x;
        if(place.Name.equals((K)person))
        {
            x = (V) place.Num;
            book[hash % book.length] = place.next;
            size --;
            return x;
        }
        else
        {
            while (place.next != null)
            {
                if (place.next.Name.equals((K)person))
                {
                    x = (V) place.Num;
                    place.next = place.next.next;
                    size--;
                    return x;
                }
                place = place.next;
            }
            return (V) place.Num;
        }
    }

    public int size()
    {
        return size;
    }
}
