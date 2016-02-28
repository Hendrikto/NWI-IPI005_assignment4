package assignment4;

/**
 * An interface to get information about a Loipe.
 *
 * @author Hendrik Werner // s4549775
 * @author Jasper Haasdijk // s4449754
 */
public interface InfoLoipe {
    public int getWidth ();
    public int getHeight ();
    public Fragment getFragment (Punt p);

    public Punt start ();
    public Punt stap ();
}
