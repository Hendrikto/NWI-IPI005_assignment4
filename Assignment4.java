package assignment4;

import java.util.Scanner;

/**
 * Contains the main method.
 *
 * @author Hendrik Werner // s4549775
 * @author Jasper Haasdijk // s4449754
 */
public class Assignment4 {
    /**
     * Entry point.
     *
     * @param args the command line arguments
     */
    public static void main (String[] args) {
        Loipe l = new Loipe("srrsslssllrsrrrslssslsllsslrrsss");
        TekenLoipe lp = new LoipePlaatje(l);
        TekenLoipe ascii = new AsciiArt(l);
        Punt p = new Punt();

        // Setup
        LoipePresenter h = new Hendrik(l, new Scanner(System.in));
        h.addView(ascii);
        h.addView(lp);
        /* I don't know why exactly but when calling setPosition before teken on
        the LoipePlaatje class the program crashes. Because this class was
        provided by Pieter Koopman I did not want to mess with it. Just calling
        teken here fixes the problem.
        This is not necessary for the AsciiArt class. */
        lp.teken();

        // Present
        h.present();
    }
}
