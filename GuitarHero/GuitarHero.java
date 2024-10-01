/*****************************************************************************
 *  Compilation:  javac GuitarHeroLite.java
 *  Execution:    java  GuitarHeroLite
 *  Dependencies: StdAudio.java StdDraw.java GuitarString.java
 *
 *  Plays two guitar strings (concert A and concert C) when the user
 *  types the lowercase letters 'a' and 'c', respectively in the 
 *  standard drawing window.
 *
 ****************************************************************************/

public class GuitarHero{ 

    public static void main(String[] args) 
    {
        String keyboard = "q2we4r5ty7u8i9op-[=zxdcfvgbnjmk,.;/' ";
        double concert = 0;
        GuitarString [] x = new GuitarString[keyboard.length()];
        for(int i = 0; i < keyboard.length(); i++)
        {
            concert = 440 * Math.pow(1.05956, (i - 24));
            //System.out.println(concert);
            x[i] = new GuitarString(concert);
        }
        // the main input loop
        while (true) {

            // check if the user has typed a key, and, if so, process it
            if (StdDraw.hasNextKeyTyped()) {
 
                // the user types this character
                char key = StdDraw.nextKeyTyped();
                int y = keyboard.indexOf(key);

                // pluck the corresponding string
                if (y >= 0)
                    x[y].pluck();
            }

            // compute the superposition of the samples
            double sample = 0;
            for(int i = 0; i < x.length; i++)
            {
                sample += x[i].sample();
            }

            // send the result to standard audio
            StdAudio.play(sample);

            // advance the simulation of each guitar string by one step
            for(int i = 0; i < x.length; i++)
            {
                x[i].tic();
            }
        }
    }

}