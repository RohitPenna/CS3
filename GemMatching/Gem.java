import java.awt.Font;
import java.util.*;

enum GemType {
    GREEN, BLUE, ORANGE; //define the different types of Gems, comma delimited

    public static GemType randomizer()
    {
        int x = new Random().nextInt(GemType.values().length);
        return GemType.values()[x];
    }
}

public class Gem 
{
    private int points;
    private GemType color;
    private int [] p = {0,5,10,15,20,25,30,35,40,45,50};

    public Gem()
    {
        color = GemType.randomizer();
        points = p[new Random().nextInt(11)];
    }

    public Gem (GemType type, int points)
    {
        color = type;
        this.points = points;
    }

    public GemType getType()
    {
        return color;
    }

    public int getPoints()
    {
        return points;
    }

    public String toString()
    {
        return "" + getType() + " worth " + points + " points";
    }

    public void draw (double x, double y)
    {
        if (getType().equals(GemType.BLUE))
        {
            StdDraw.picture(x,y, "gem_blue.png");
            String x2 = Integer.toString(getPoints());
            StdDraw.text(x,y, x2);
            StdDraw.setPenColor(java.awt.Color.white);
        }
        if (getType().equals(GemType.ORANGE))
        {
            StdDraw.picture(x,y, "gem_orange.png");
            String x2 = Integer.toString(getPoints());
            StdDraw.text(x,y, x2);
            StdDraw.setPenColor(java.awt.Color.white);
        }
        if (getType().equals(GemType.GREEN))
        {
            StdDraw.picture(x,y, "gem_green.png");
            StdDraw.setPenColor(java.awt.Color.white);
            String x2 = Integer.toString(getPoints());
            StdDraw.text(x,y, x2);
        }
    }

    /** Tester main method */
    public static void main(String [] args)
    {
        final int maxGems = 16;

        // Create a gem of each type
        Gem green  = new Gem(GemType.GREEN, 10);
        Gem blue   = new Gem(GemType.BLUE, 20);
        Gem orange = new Gem(GemType.ORANGE, 30);
        System.out.println(green  + ", " + green.getType()  + ", " + green.getPoints());        
        System.out.println(blue   + ", " + blue.getType()   + ", " + blue.getPoints());
        System.out.println(orange + ", " + orange.getType() + ", " + orange.getPoints());
        green.draw(0.3, 0.7);
        blue.draw(0.5, 0.7);
        orange.draw(0.7, 0.7);      
        // A row of random gems
        for (int i = 0; i < maxGems; i++)
        {
            Gem g = new Gem();
            g.draw(1.0 / maxGems * (i + 0.5), 0.5);
        }
    }
}
