import java.util.*;

public class MyStack implements StackADT
{
    // instance variables - replace the example below with your own
    int size;
    Square [] stack;

    /**
     * Constructor for objects of class MyStack
     */
    public MyStack()
    {
        this(10);
    }
    
    public MyStack(int initCap)
    {
        stack = new Square [initCap];
        size = 0;
    }

    public boolean isEmpty()
    {
        return size == 0;
    }
    
    public Square peek()
    {
        if (size == 0)
        {
            throw new EmptyStackException();
        }
        return stack[size-1];
    }
    
    public Square pop()
    {
        if (isEmpty())
        {
            throw new EmptyStackException();
        }
        Square y = stack[size - 1];
        stack[size-1] = null;
        size --;
        return y;
    }
    
    public void push (Square item)
    {
        if(size == stack.length)
        {
            doubleCapacity();
        }
        stack[size] = item;
        size++;
    }
    
    private void doubleCapacity()
    {
        Square[] list2 = new Square[stack.length*2];
        for(int i = 0; i < stack.length; i++)
        {
            list2[i] = stack[i];
        }
        stack = list2;
    }
    
    public void clear()
    {
        Square[] list2 = new Square[stack.length];
        stack = list2;
        size = 0;
    }
    
    public String toString()
    {
        String result =  stack[size-1] + "\t<----- TOP\n";
        for(int i = size-2; i>=0; i--)
        {
            //result+=""+stack[i] + "\n";
            System.out.println(result);
        }
        result+="¯¯¯¯¯¯¯";
        return result;
    }
    
    public int size()
    {
     return size;   
    }
}
