import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;

public class BoggleSolver
{
    Scanner dict;
    File dile;
    static HashSet<String> dict1 = new HashSet<>();
    private static boolean [][] visited;
    public static HashSet <String> foundWords = new HashSet <> ();

    static BoggleBoard board;

    // Initializes the data structure using the given array of strings as the dictionary.
    // (You can assume each word in the dictionary contains only the uppercase letters A - Z.)
    public BoggleSolver(String dictionaryName)
    {
        dile = new File (dictionaryName);
        try
        {
            dict = new Scanner(dile);
            while (dict.hasNextLine())
            {
                dict1.add(dict.nextLine());
            }
        }
        catch (FileNotFoundException e)
        {
            e.printStackTrace();
        }
    }

    public static Iterable<String> getAllValidWords(BoggleBoard board)
    {
        visited = new boolean [board.rows()][board.cols()];
        for (int i = 0; i < board.rows(); i++)
        {
            for (int z = 0; z < board.cols(); z++)
            {
                visited [i][z] = false;
            }
        }
        for (int i = 0; i < board.rows(); i++)
        {
            for (int z = 0; z < board.cols(); z++)
            {
                getAllValidWordsHelper(board, i, z, "");
            }
        }
        return foundWords;
    }

    // Returns the set of all valid words in the given Boggle board, as an Iterable object

    public static Iterable<String> getAllValidWordsHelper(BoggleBoard board, int row, int col, String prefix)
    {
        if (row < 0 || row >= board.rows() || col < 0 || col >= board.cols())
        {
            return null;
        }
        
        if (visited[row][col] == false)
        {
            visited[row][col] = true;
            if(board.getLetter (row, col) == ('q'))
            {
                prefix += "qu";
            }
            else
            {
                prefix += board.getLetter (row, col);
            }
        }
        else
        {
            return null;
        }
        
        getAllValidWordsHelper (board, row + 1, col, prefix);
        getAllValidWordsHelper (board, row - 1, col, prefix);
        getAllValidWordsHelper (board, row -1, col - 1, prefix);
        getAllValidWordsHelper (board, row -1, col + 1, prefix);
        getAllValidWordsHelper (board, row +1, col + 1, prefix);
        getAllValidWordsHelper (board, row +1, col - 1, prefix);
        getAllValidWordsHelper (board, row, col + 1, prefix);
        getAllValidWordsHelper (board, row, col - 1, prefix);
        
        if (prefix.length() >= 3)
        {
            if (dict1.contains(prefix))
            {
                foundWords.add(prefix);
            }
        }
        
        visited[row][col] = false;
        
        //System.out.println(foundWords);
        
        
        return foundWords;
    }

    // Returns the score of the given word if it is in the dictionary, zero otherwise.
    // (You can assume the word contains only the uppercase letters A - Z.)
    public int scoreOf(String word)
    {
        if (!dict1.contains(word))
        {
            return 0;
        }
        int x = word.length();
        if (x <= 2)
            return 0;
        if (x <= 4)
            return 1;
        if (x == 5)
            return 2;
        if (x == 6)
            return 3;
        if (x == 7)
            return 5;
        if (x >= 8)
            return 11;

        return 0;
    }

    public static void main(String[] args) {
        System.out.println("WORKING");

        final String PATH   = "./data/";
        BoggleBoard  board  = new BoggleBoard("board-q.txt");
        BoggleSolver solver = new BoggleSolver("dictionary.txt");
        getAllValidWords(board);
    }

}
