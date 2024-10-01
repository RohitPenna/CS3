import java.util.HashMap;
import java.util.*;
import java.util.PriorityQueue;
import java.io.PrintWriter;
import java.io.File;
import java.io.FileNotFoundException;

public class HuffmanTree {
    PriorityQueue<Node> baseTree = new PriorityQueue<Node>();
    Node root = new Node(0);
    private HashMap<String, Character> decodeMap;
    private HashMap<Character, String> encodeMap;
    private HashMap<Character, String> dict;

    public HuffmanTree(int[] counts) 
    {
        for (int i = 0; i < counts.length; i++) 
        {
            if (counts[i] > 0) 
            {
                baseTree.offer(new Node((char) i, counts[i]));
            }
        }

        while (!baseTree.isEmpty()) 
        {
            Node x = baseTree.peek();
            baseTree.poll();

            Node y = baseTree.peek();
            baseTree.poll();

            Node temp = new Node(x.frequency + y.frequency);

            temp.left = x;
            temp.right = y;
            root = temp;

            baseTree.offer(temp);
        }
    }

    public HuffmanTree(String codeFile) 
    {
        dict = new HashMap<>();
        try 
        {
            Scanner file = new Scanner(new File( codeFile + ".code"));
            while (file.hasNext()) 
            {
                int val = file.nextInt();
                String key = file.next();
                dict.put((char) val, key);
                root = new Node (0);
                createTree(root, file, file.nextInt(), file.next(), "");
            }
        } 
        catch (FileNotFoundException fnfe) 
        {
            System.out.println("File not found");
        }

    }
    
    private void createTree(Node curr, Scanner in, int ascii, String path, String addr) 
    {
        if(path.equals(addr)) 
        {
            curr.val = (char) ascii;
            return;
        }
        curr.left = new Node(-1);
        createTree(curr.left, in, ascii, path, addr + "0");
        curr.right = new Node(-1);
        createTree(curr.right, in, in.nextInt(), in.next(), addr + "1");
    }

    public void write(String fileName)
    {

        PrintWriter file = null;

        try 
        {
            file = new PrintWriter(new File(fileName));
            createMap("", root);
            for (Map.Entry <Character, String> x : dict.entrySet())
            {
                file.println(x.getKey());
                file.println(x.getValue());
            }
            file.close();
        } 
        catch (FileNotFoundException e) 
        {
            e.printStackTrace();
        }

    }

    private void createMap(String p, Node temp)
    {

        if(temp.Leaf())
        {
            dict.put(temp.val, p);
        }
        else {
            createMap(p + '1', temp.right);
            createMap(p + '0', temp.left);
        }
    }

    public void encode(BitOutputStream out, String file){

        try 
        {
            Scanner in = new Scanner (new File(file));

            while(in.hasNext())
            {
                String temp = in.next();
                for (char c : temp.toCharArray())
                {
                    String code = dict.get(c);
                    for(int i = 0; i < code.length(); i++)
                    {
                        out.writeBit(Integer.parseInt(code.substring(i, i+1)));
                    }
                }
            }
            String EOF = dict.get(256);
            for(int i = 0; i < EOF.length(); i++)
            {
                out.writeBit(Integer.parseInt(EOF.substring(i, i+1)));
            }
            out.close();
        } 
        catch (FileNotFoundException e) 
        {
            e.printStackTrace();
        }

    }

    public void decode(BitInputStream in, String outFile) {
        PrintWriter file = null;

        try {
            file = new PrintWriter(outFile + ".new");
        } catch (FileNotFoundException fnfe) {
            System.out.println("File not found");
        }

        String temp = "";
        
        HashMap<String, Character> newMap = new HashMap<String, Character>();
        for (Map.Entry <Character, String> x : dict.entrySet())
            {
                newMap.put(x.getValue(), x.getKey());
            }
        
        while (true) {
            temp += in.readBit();
            if (newMap.containsKey(temp))
                if (newMap.get(temp) == (char) 256) 
                {
                    in.close();
                    break;
                } else 
                {
                    file.print(dict.get(temp));
                    temp = "";
                }
        }

        file.close();
    }

}
