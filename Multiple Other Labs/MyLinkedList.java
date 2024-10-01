import java.util.*;
import java.io.*;

public class MyLinkedList<T>
{

    ListNode Head;
    ListNode Last;
    int size;

    public MyLinkedList()
    {
        Head = null;
        Last = null;
        size = 0;
    }

    public MyLinkedList(T... val)
    {
        ListNode Temp = Head;
        
        size = 0;
        for (T vals : val)
        {
            Head = new ListNode(vals);
            Last = Head;
            Head.next = null;
            Head = Head.next;
            size ++;
        }
        
        Head = Temp;
    }

    public void add(T newVal)
    {
        if (Head == null)
        {
            Head = new ListNode(newVal);
            Last = Head;
            size ++;
        }
        else
        {
            Last.next = new ListNode(newVal);
            Last = Last.next;
            size ++;
        }

    }

    public boolean contains (T target)
    {
        ListNode temp = Head;

        while (Head != null)
        {
            if(Head.val == target)
            {
                Head = temp;
                return true;
            }
            Head = Head.next;
        }
        Head = temp;
        return false;
    }

    public T get (int index)
    {
        if(index < 0)
        {
            throw new IndexOutOfBoundsException();
        }

        ListNode temp = Head;

        for(int i = 0; i < index; i++)
        {
            Head = Head.next;
        }

        T next = Head.val;
        Head = temp;
        return next;
    }

    public int size()
    {
        return size;
    }

    public boolean isEmpty()
    {
        return Head == null;
    }

    public int recursiveSize()
    {
        ListNode temp = Head;

        if (Head == null)
        {
            return 0;
        }
        Head = Head.next;
        return 1 + recursiveSize();
    }

    public void set (T newVal, int index)
    {
        if(index < 0 || index >= size())
        {
            throw new IndexOutOfBoundsException();
        }

        ListNode temp = Head;

        for(int i = 0; i < index; i++)
        {
            Head = Head.next;
        }

        Head.val = newVal;
        Head = temp;
    }

    public void add (T newVal, int index)
    {
        if(index < 0 || index > size())
        {
            throw new IndexOutOfBoundsException();
        }

        ListNode temp = Head;
        ListNode x = new ListNode (newVal);

        if(index == 0)
        {
            x.next = Head;
            Head = x;
            size++;
        }
        else
        {
            for(int i = 0; i < index - 1; i++)
            {
                Head = Head.next;
            }
            
            x.next = Head.next;
            Head.next = x;
            Head = temp;
            size ++;
        }
    }

    public T remove (int index)
    {
        if(index < 0 || index >= size())
        {
            throw new IndexOutOfBoundsException();
        }

        if(index == 0)
        {
            T x = Head.val;
            Head = Head.next;
            size--;
            return x;
        }

        ListNode temp = Head;

        for(int i = 0; i < index - 1; i++)
        {
            Head = Head.next;
        }

        T newVal = Head.next.val;
        Head.next = Head.next.next;

        Head = temp;
        size --;
        return newVal;

    }

    public int indexOf(T target)
    {
        ListNode temp = Head;
        int index = 0;
        while (Head != null)
        {
            if(Head.val == target)
            {
                Head = temp;
                return index;
            }
            Head = Head.next;
            index ++;
        }
        return -1;
    }

    public String toString()
    {
        if (Head == null)
        {
            return "[]";
        }

        String s = "[" + Head.val;

        ListNode temp = Head;

        //Head = Head.next;

        while (Head.next != null && Head != null)
        {
            Head = Head.next;
            s += ", " + Head.toString();
        }
        s += "]";
        Head = temp;
        return s;
    }
    
    public void clear()
    {
        Head.next = null;
        Head = null;
    }

    private class ListNode
    {
        T val;
        ListNode next;

        public ListNode (T val) 
        {
            this.val = val;
        }

        @Override
        public String toString() 
        {
            return "" + this.val;
        }
    }
}