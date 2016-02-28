package assignment4;

/**
 * An interface for a skier that can walk through the Loipe.
 *
 * @author Hendrik  Werner // s4549775
 * @author Jasper Haasdijk // s4449754
 */
public interface Skier {
    public Punt move (char direction);
    public Fragment getFragment ();
}
