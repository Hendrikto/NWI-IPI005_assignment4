package assignment4;

/**
 * Implements the InfoLoipe interface.
 *
 * @author Hendrik  Werner // s4549775
 * @author Jasper Haasdijk // s4449754
 */
public class Loipe implements InfoLoipe {
    private final Fragment[][] fragments;
    private final Punt start;
    private final Punt[] points;
    private final int width;
    private final int height;
    private final int length;
    private int position;

    /**
     * Constructor method.
     *
     * @param path A string consisting of 's', 'l' and 'r' that describes the
     * path a skier must take to finish the Loipe.
     */
    public Loipe (String path) {
        this.position = 0;
        this.length = path.length();
        this.start = this.calculateStart(path);
        this.points = this.calculatePoints(path);
        this.width = this.calculateWidth();
        this.height = this.calculateHeight();
        this.fragments = this.calculateFragments(path);
    }

    /**
     * Get the width of this Loipe.
     *
     * @return the width of this Loipe
     */
    @Override
    public int getWidth () {
        return this.width;
    }

    /**
     * Get the height of this Loipe.
     *
     * @return the height of this Loipe
     */
    @Override
    public int getHeight () {
        return this.height;
    }

    /**
     * Get the Fragment at Punt p.
     *
     * @param p the point for which to get the Fragment
     * @return the Fragment at Punt p
     */
    @Override
    public Fragment getFragment (Punt p) {
        return this.fragments[p.getX()][p.getY()];
    }

    /**
     * Get the starting point of this Loipe.
     *
     * @return the starting point of this Loipe
     */
    @Override
    public Punt start () {
        return this.start;
    }

    /**
     * Make a step.
     *
     * @return the Punt where we are after taking a step
     */
    @Override
    public Punt stap () {
        this.position = ++this.position % this.length;
        return this.points[this.position];
    }

    /**
     * Calculate where to start the path so it does not overflow the container.
     *
     * @param path a String consisting of 'l', 'r', and 's' that describes the
     * Loipe.
     * @return the Punt at which to start so taking the path does not lead you
     * outside of the container.
     */
    private Punt calculateStart (String path) {
        Skier s = new Jasper();
        Punt p;
        int minX = 0;
        int minY = 0;
        for (char c: path.toCharArray()) {
            p = s.move(c);
            if (p.getX() < minX) {
                minX = p.getX();
            }
            if (p.getY() < minY) {
                minY = p.getY();
            }
        }
        return new Punt(-minX, -minY);
    }

    /**
     * Get a chronological list of points which the Skier visits when following
     * the Loipe.
     *
     * @param path the path that descibes the Loipe
     * @return a chronological list of points which the Skier visits when
     * following the Loipe.
     */
    private Punt[] calculatePoints (String path) {
        Skier s = new Jasper(new Punt(this.start));
        Punt[] pa = new Punt[path.length()];
        for (int i = 0; i < path.length(); i++) {
            pa[i] = s.move(path.charAt(i));
        }
        return pa;
    }

    /**
     * Calculate the width of the Loipe.
     *
     * @return the width of the Loipe (x-axis)
     */
    private int calculateWidth () {
        int maxX = this.start.getX();
        for (Punt p: this.points) {
            if (p.getX() > maxX) {
                maxX = p.getX();
            }
        }
        return maxX + 1; // because it starts at 0
    }

    /**
     * Calculate the height of the Loipe.
     *
     * @return the height of the Loipe (y-axis)
     */
    private int calculateHeight () {
        int maxY = this.start.getY();
        for (Punt p: this.points) {
            if (p.getY() > maxY) {
                maxY = p.getY();
            }
        }
        return maxY + 1; // because it starts at 0
    }

    /**
     * Get a two dimensional array containing the Fragments which the Loipe
     * consists of. If the Loipe does not visit a Punt then there will be a null
     * at this position in the array.
     *
     * @param path the path that describes the Loipe
     * @return a two dimensional array containing the Fragment the Loipe
     * consists of
     */
    private Fragment[][] calculateFragments (String path) {
        Fragment[][] fa = new Fragment[this.width][this.height];
        Skier s = new Jasper(this.start);
        Punt p;
        for (char c: path.toCharArray()) {
            p = s.move(c);
            if (fa[p.getX()][p.getY()] == null) {
                fa[p.getX()][p.getY()] = s.getFragment();
            } else {
                fa[p.getX()][p.getY()] = Fragment.KR;
            }
        }
        return fa;
    }
}
