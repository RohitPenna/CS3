import java.util.ArrayList;
import java.util.List;

public abstract class MazeSolver <T>{

    private Maze maze;

    private boolean solved = false;
    private boolean solvable = true;

    MazeSolver(Maze maze)
    {
        this.maze = maze;
        makeEmpty();
        add(maze.getStart());

    }

    abstract void makeEmpty();

    abstract boolean isEmpty();

    abstract void  add(Square s);

    abstract void remove();

    abstract Square next();

    boolean isSolved()
    {
       return solved ;
    }

    void step() {
        if(isEmpty())
        {
            solvable = false;
        }
        else
        {
            Square next = next();
            if(!isEmpty() && next.getType() != Square.EXIT)
            {

                List<Square> temp = maze.getNeighbors(next);
                next.setStatus(Square.EXPLORED);
                remove();
                for(int i = 0; i < temp.size(); i++)
                {
                    if(temp.get(i).getType() != Square.WALL && temp.get(i).getStatus() != Square.EXPLORED)
                    {
                        temp.get(i).setStatus(Square.WORKING);
                        add(temp.get(i));
                    }
                }

            }
            if(next.getType() == Square.EXIT)
            {
                solved = true;
            }
        }

    }
    String getPath()
    {
        if(solved)
        {
            return "Maze is Solved";
        }
        if(solvable)
        {
         return "Maze is not yet solved";   
        }
        return "Maze not solvable";

    }
    void solve()
    {
        while(!isSolved())
        {
            step();
        }
    }


}