import java.util.*;
import java.io.*; 

public class Maze
{
    private Square [] [] squares;

    private Square start,exit;

    public Maze()
    {

    }

    public boolean loadMaze(String filename)
    {
        Scanner reader;
        try{
            File x = new File(filename);
            reader = new Scanner(x);
        }
        catch(FileNotFoundException e){
            e.printStackTrace();
            return false;
        }
        squares = new Square [reader.nextInt()][reader.nextInt()];
        for (int r = 0; r < squares.length; r++)
        {
            for (int c = 0; c < squares[r].length; c++)
            {
                int y = reader.nextInt();
                squares[r][c] = new Square(r, c, y);
                if (y == 2)
                {
                    start = squares[r][c];
                }
                else if (y == 3)
                {
                    exit = squares[r][c];
                }
            }
        }
        reader.close();
        return true;
    }

    public List<Square> getNeighbors(Square s)
    {   
        int r = s.getRow();
        int c = s.getCol();
        ArrayList<Square> neighbor = new ArrayList<>();
        if (r > 0)
        {
            neighbor.add(squares[r - 1][c]);
        }
        if (c < squares[s.getRow()].length - 1)
        {
            neighbor.add(squares[r][c + 1]);
        }
        if (r < squares.length - 1)
        {
            neighbor.add(squares[r + 1][c]);
        }
        if (c > 0)
        {
            neighbor.add(squares[r][c - 1]);
        }
        return neighbor;
    }

    public Square getStart()
    {
        return start;
    }

    public Square getExit()
    {
        return exit;
    }

    public void reset()
    {
        for (int r = 0; r < squares.length; r++)
        {
            for (int c = 0; c < squares[0].length; c++)
            {
                squares[r][c].reset();
            }
        }
    }

    public String toString()
    {
        String s = "";
        for (int i = 0; i < squares.length; i++)
        {
            for (int c = 0; c < squares[0].length; c++)
            {
                s += squares[i][c].toString() + " ";
            }
            s += "\n";
        }
        return s;
    }
}
