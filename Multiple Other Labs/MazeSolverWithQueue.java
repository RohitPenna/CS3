
/**
 * Write a description of class MazeSolverQueue here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class MazeSolverWithQueue extends MazeSolver
{
    private MyQueue y;

    public MazeSolverWithQueue(Maze maze)
    {
        super(maze);
    }

    public void makeEmpty()
    {
        y = new MyQueue <Square> ();
    }

    public boolean isEmpty()
    {
        return y.isEmpty();
    }

    public void  add(Square s)
    {
        y.offer(s);
    }

    public void remove()
    {
        y.poll();
    }

    public Square next()
    {
        return (Square) y.peek();
    }
}
