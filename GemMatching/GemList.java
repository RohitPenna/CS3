public class GemList 
{
    private class ListNode
    {
        public ListNode (Gem gem) 
        {
            this.gem = gem;
        }

        private Gem gem;
        private ListNode next;
    }

    ListNode Head;
    ListNode Last;
    int size;

    public GemList()
    {

    }

    public int size()
    {
        return size;
    }

    public void insertBefore (Gem newGem, int index)
    {
        if(index < 0)
        {
            throw new IndexOutOfBoundsException();
        }

        if(index >= size() && Head == null)
        {
            Head = new ListNode(newGem);
            Last = Head;
        }
        else if (index >= size())
        {
            Last.next = new ListNode(newGem);
            Last = Last.next;
            size ++;
        }
        else if(index == 0)
        {
            ListNode x = new ListNode (newGem);
            x.next = Head;
            Head = x;
            size++;
        }
        else
        {
            ListNode temp = Head;
            ListNode x = new ListNode (newGem);
            for(int i = 0; i < index - 1; i++)
            {
                Head = Head.next;
            }

            x.next = Head.next;
            Head.next = x;
            Head = temp;
            size ++;
        }
        ListNode temp = Head;
        ListNode x = new ListNode (newGem);

    }

    public String toString()
    {
        if (Head == null)
        {
            return "[]";
        }

        String s = "[" + Head.gem;

        ListNode temp = Head;

        while (Head.next != null && Head != null)
        {
            Head = Head.next;
            s += ", " + Head.gem.toString();
        }
        s += "]";
        Head = temp;
        return s;
    }

    public void draw(double y)
    {
        ListNode temp = Head;
        int index = 0;

        while (Head != null)
        {
            Head.gem.draw(GemGame.indexToX(index), y);
            index++;
            Head = Head.next;
            //Head.gem.draw(GemGame.indexToX(index), y);
        }

        Head = temp;
    }

    public int score()
    {
        if(Head == null)
            return 0;
        int score = 0;
        ListNode Temp = Head;
        int multiply = 1;
        int combined = 0;
        if(Head != null)
            combined += Head.gem.getPoints();


        while(Head.next != null)
        {
            if(Head.gem.getType() == Head.next.gem.getType())
            {
                multiply ++;
                combined += Head.next.gem.getPoints();
                Head = Head.next;
            }
            else if(Head.gem.getType() != Head.next.gem.getType())
            {
                combined *= multiply;
                score += combined;
                multiply = 1;
                Head = Head.next;
                combined = Head.gem.getPoints();
            }
        }
        score += (combined * multiply);
        Head = Temp;
        
        return score;
    }

    public static void main(String [] args)
    {
        GemList list = new GemList();
        System.out.println(list);
        System.out.println("size = " + list.size() + ", score = " + list.score());
        list.draw(0.9);     

        list.insertBefore(new Gem(GemType.BLUE, 10), 0);
        System.out.println("\n" + list);
        System.out.println("size = " + list.size() + ", score = " + list.score());
        list.draw(0.8);

        list.insertBefore(new Gem(GemType.BLUE, 20), 99);  //not a mistake, should still work
        System.out.println("\n" + list);
        System.out.println("size = " + list.size() + ", score = " + list.score());
        list.draw(0.7);

        list.insertBefore(new Gem(GemType.ORANGE, 30), 1);
        System.out.println("\n" + list);
        System.out.println("size = " + list.size() + ", score = " + list.score());
        list.draw(0.6);

        list.insertBefore(new Gem(GemType.ORANGE, 10), 2);
        System.out.println("\n" + list);
        System.out.println("size = " + list.size() + ", score = " + list.score());
        list.draw(0.5);

        list.insertBefore(new Gem(GemType.ORANGE, 50), 3);
        System.out.println("\n" + list);
        System.out.println("size = " + list.size() + ", score = " + list.score());
        list.draw(0.4);

        list.insertBefore(new Gem(GemType.GREEN, 50), 2);
        System.out.println("\n" + list);
        System.out.println("size = " + list.size() + ", score = " + list.score());
        list.draw(0.3);     
    }   
}
