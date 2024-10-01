import java.util.*;

public class QueueProbs
{
    // instance variables - replace the example below with your own

    public QueueProbs()
    {

    }

    public Queue <Integer> evenFirst(Queue <Integer> nums)

    {
        Queue <Integer> x = new LinkedList();
        int y = nums.size();
        for(int i = 0; i < y; i++)
        {
            int z = nums.poll();
            if(z % 2 == 0)
            {
                x.offer(z);
                continue;
            }
            nums.offer(z);
        }
        y = nums.size();
        for(int i = 0; i < y; i++)
        {
            x.offer(nums.poll());
        }
        return x;
    }

    public boolean numPalindrome(Queue<Integer> nums)
    {
        Queue <Integer> x = new LinkedList();
        Stack <Integer> x2 = new Stack();
        int y = nums.size();
        for(int i = 0; i < y; i++)
        {
            int z = nums.poll();
            x.offer(z);
            x2.push(z);
        }
        for(int i = 0; i < y; i++)
        {
            if(x.poll() != x2.pop())
            {
                return false;
            }
        }
        return true;
    }

    public Stack<Integer> Sieve(int n)
    {
        Queue <Integer> x = new LinkedList();
        for(int i = 2; i <= n; i ++)
        {
            x.offer(i);
        }
        Stack <Integer> primes = new Stack();
        while(x.size() > 0)
        {
            Queue <Integer> x2 = new LinkedList();
            int p = x.poll();
            primes.push(p);
            int z = x.size();
            for(int i = 0; i < z; i++)
            {
                int l = x.poll();
                if (l % p != 0)
                {
                    x2.offer(l);
                }
            }
            x = x2;
        }
        return primes;
    } 
}
