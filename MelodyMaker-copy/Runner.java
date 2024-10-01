import java.util.*;
import java.util.LinkedList;

public class Runner
{
    public static void main(String[] args)
    {
        //1
        QueueProbs Queue = new QueueProbs();
        Integer[] arr = {3,5,4,17,6,83,1,84,16,37};
        List <Integer> list = Arrays.asList(arr);
        Queue <Integer> x = new LinkedList<>(list);
        System.out.println(Queue.evenFirst(x));
        
        //2
        Integer [] arr2 = {3,8,17,9,17,8,3};
        list = Arrays.asList(arr2);
        x = new LinkedList<>(list);
        System.out.println(Queue.numPalindrome(x));
        
        //3
        System.out.println(Queue.Sieve(20));
    }
    
}
