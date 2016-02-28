package assignment4;

/**
 * Implements the TekenLoipe interface using Ascii art.
 *
 * @author Hendrik Werner // s4549775
 * @author Jasper Haasdijk // s4449754
 */
public class AsciiArt implements TekenLoipe {
    private final Loipe loipe;
    private Punt skierPosition;

    /**
     * Constructor method
     *
     * @param l the Loipe this should draw
     */
    public AsciiArt (Loipe l) {
        this.loipe = l;
    }

    /**
     * Get an Ascii representation of a Fragment.
     *
     * @param f the fragment to get the Ascii representation for
     * @return the Ascii representation of f
     */
    public static char fragmentToChar (Fragment f) {
        switch (f) {
            case NZ: return '|';
            case OW: return '-';
            case NO: return '`';
            case NW: return '´';
            case ZO: return '´';
            case ZW: return '`';
            default: return '+'; // case KR
        }
    }

    /**
     * Print an Ascii representation of this.loipe to the console.
     *
     */
    @Override
    public void teken () {
        StringBuilder sb = new StringBuilder();
        Punt p;
        for (int y = 0; y < this.loipe.getHeight(); y++) {
            for (int x = 0; x < this.loipe.getWidth(); x++) {
                p = new Punt(x, y);
                if (p.equals(this.skierPosition)) {
                    sb.append('*');
                } else if (this.loipe.getFragment(p) != null) {
                    sb.append(fragmentToChar(this.loipe.getFragment(p)));
                } else {
                    sb.append(' ');
                }
                sb.append(' ');
            }
            sb.append('\n');
        }
        System.out.println(sb);
    }

    /**
     * Set the position of the Skier.
     *
     * @param p
     */
    @Override
    public void setPosition (Punt p) {
        this.skierPosition = p;
    }
}
