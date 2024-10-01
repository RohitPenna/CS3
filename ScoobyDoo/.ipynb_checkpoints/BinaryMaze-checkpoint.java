import java.io.File;
import java.io.FileNotFoundException;
import java.sql.Array;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BinaryMaze {

    boolean[][] matrix;
    boolean[][] visited;
    Scanner file;

    public static void main(String[] args) throws FileNotFoundException {
        BinaryMaze test = new BinaryMaze("maze.txt");
    }

    public BinaryMaze(String fileName) throws FileNotFoundException, ArrayIndexOutOfBoundsException {
        File input = new File(fileName);
        file = new Scanner(input);
        int rows = file.nextInt();
        int cols = file.nextInt();
        int cases = file.nextInt();
        file.nextLine();
        matrix = new boolean[rows][cols];
        visited = new boolean[rows][cols];
        constructMaze(rows, cols);

        for (int t = 0; t < cases; t++)
        {
            Queue<Location> path = new LinkedList<>();
            Location first = new Location(file.nextInt(), file.nextInt());
            Location last = new Location(file.nextInt(), file.nextInt());
            path.add(first);
            while (!path.isEmpty())
            {
                Location curr = path.remove();
                if (curr.equals(last))
                {
                    System.out.println(curr.len);
                    last.len = curr.len;
                    break;
                }
                if(visited[curr.x][curr.y]) continue;
                visited[curr.x][curr.y] = true;
                if (isValid(curr.x  + 1, curr.y))
                {
                    if (matrix[curr.x + 1][curr.y])
                    {
                        path.add(new Location(curr.x + 1, curr.y, curr.len + 1));
                    }
                }
                if (isValid(curr.x  - 1, curr.y))
                {
                    if (matrix[curr.x - 1][curr.y])
                    {
                        path.add(new Location(curr.x - 1, curr.y, curr.len + 1));

                    }
                }
                if (isValid(curr.x, curr.y + 1))
                {
                    if (matrix[curr.x][curr.y + 1])
                    {
                        path.add(new Location(curr.x, curr.y + 1, curr.len + 1));
                    }
                }
                if (isValid(curr.x, curr.y - 1))
                {
                    if (matrix[curr.x][curr.y - 1])
                    {
                        path.add(new Location(curr.x, curr.y - 1, curr.len + 1));
                    }
                }
            }
            visited = new boolean[rows][cols];
            if (last.len == 0)
            {
                System.out.println("-1");
            }
        }
    }
    public void constructMaze(int rows, int columns)
    {
        for (int r = 0; r < rows; r++)
        {
            for (int c = 0; c < columns; c++)
            {
                int input = file.nextInt();
                if (input == 1)
                {
                    matrix[r][c] = true;
                }
                else {
                    matrix[r][c] = false;
                }
            }
            file.nextLine();
        }
    }

    public boolean isValid(int r, int c)
    {
        return (r < matrix.length && c < matrix[0].length && r >= 0 && c >= 0);
    }
}
class Location
{
    int x;
    int y;
    int len;

    public Location(int r, int c)
    {
        x = r;
        y = c;
        len = 0;
    }

    public Location(int r, int c, int l)
    {
        x = r;
        y = c;
        len = l;
    }

    @Override
    public boolean equals(Object obj) {
        return x == ((Location) obj).x && y == ((Location) obj).y;
    }
}
