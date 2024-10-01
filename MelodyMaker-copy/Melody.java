import java.util.*;
public class Melody
{
   
    private Queue<Note> notes = new LinkedList();

    /**
     * Constructor for objects of class Melody
     */
    public Melody(Queue <Note> song)
    {
        int y = song.size();
        for(int i = 0; i<y; i++)
        {
            notes.offer(song.poll());
        }
    }
public Queue<Note> cloneNotes()
    {
         Queue<Note> temp = new LinkedList();
         Queue<Note> temp1 = new LinkedList();
        while(!notes.isEmpty())
        {
            temp.offer(notes.peek());
            temp1.offer(notes.poll());
        }
        while(!temp.isEmpty())
        {
            notes.offer(temp.poll());
        }
        return temp1;
    }
    public double getTotalDuration()
    {
        Queue <Note> x = cloneNotes();
        int y = x.size();
        double total = 0;
        for(int i = 0; i < y; i++)
        {
            total += x.poll().getDuration();
        }
        System.out.print(this.notes);
        return total;
    }
    
    public String toString()
    {
        Queue <Note> x = cloneNotes();
        int y = x.size();
        String total = "";
        for(int i = 0; i < y; i++)
        {
            total += x.poll().toString() + " ";
        }
        return total;
    }
    
    public void changeTempo(double Tempo)
    {
        Queue <Note> x = cloneNotes();
        int y = x.size();
        for(int i = 0; i < y; i++)
        {
            Note hi = x.poll();
            hi.setDuration(hi.getDuration() * Tempo);
            x.offer(hi);
        }
    }
    
    public void reverse()
    {
        Stack <Note> h = new Stack();
        int y = notes.size();
        for(int i = 0; i < y; i++)
        {
            h.push(notes.poll());
        }
        for(int i = 0; i < y; i++)
        {
            notes.offer(h.pop());
        }
    }
    
    public void append(Melody other)
    {
        int y = other.notes.size();
        for(int i = 0; i < y; i++)
        {
            notes.offer(other.notes.poll());
        }
    }
    
    public void play()
    {
        Queue <Note> x = cloneNotes();
        int y = x.size();
        for(int i = 0; i < y; i++)
        {
            x.poll().play();
        }
    }
    
    public Queue<Note> getNotes()
    {
        return notes;
    }
}
