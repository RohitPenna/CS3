
/**
 * Write a description of class MyQueue here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class MyQueue <T> implements QueueADT<T>
{

    MyLinkedList<T> queue;
    private int size;
    
    public MyQueue()
    {
        queue = new MyLinkedList <T> ();
        size = 0;
    }
    
    public MyQueue(T... nums)
    {
        size = 0;
        for (T num : nums)
        {
            queue.add(num);
            size++;
        }
    }

    public void offer(T item)
    {
        queue.add(item);
        size ++;
    }

    /**
     * Remove the front item from the queue
     * @return the front item in the queue
     */
    public T poll()
    {
        size --;
        return queue.remove(0);
    }
    
    /**
     * Return the front item in the queue without removing it
     * @return the front item in the queue
     */
    public T peek()
    {
        return queue.get(0);
    }

    /**
     * Find how many items are in the queue
     * @return the number of items in the queue
     */
    public int size()
    {
        return queue.size();
    }

    /**
     * Determine if the queue is empty
     * @return true if the size is 0, false otherwise
     */
    public boolean isEmpty()
    {
        return queue.isEmpty();
    }

    /**
     * Clear out the data structure
     */
    public void clear()
    {
        queue.clear();
    }
}
