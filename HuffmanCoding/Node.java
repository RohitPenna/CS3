public class Node implements Comparable<Node> {
    public char val;
    public int frequency;
    public Node left;
    public Node right;

    @Override
    public int compareTo(Node t)
    {
        return this.frequency - t.frequency;
    }
    
    public Node(char value, int freq){

        this.val = value;
        this.frequency= freq;

    }
    
    public Node(int freq){

        this.val = '-';
        this.frequency= freq;

    }
    
    public boolean Leaf()
    {
        return left == null && right == null;
    }

    @Override
    public String toString(){
    
      return "" + val + "-" + frequency;    

    }


}
