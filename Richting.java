package assignment4;

/**
 * This is an enumeration of directions.
 *
 * @author Hendrik Werner // s4549775
 * @author Jasper Haasdijk // s4449754
 */
public enum Richting {
    N(0, -1), O(1, 0), Z(0, 1), W(-1, 0);

    public final int dx;
    public final int dy;

    /**
     * Constructor method.
     *
     * @param dx delta in the x direction
     * @param dy delta in the y direction
     */
    private Richting (int dx, int dy) {
        this.dx = dx;
        this.dy = dy;
    }

    /**
     * Get a new Richting by turning left.
     *
     * @return a new Richting based on what the current position is.
     */
    public Richting turnLeft () {
        switch (this) {
            case N: return Richting.W;
            case O: return Richting.N;
            case Z: return Richting.O;
            default: return Richting.Z; // this == W
        }
    }

    /**
     * Get a new Richting by turning right.
     *
     * @return a new Richting based on what the current position is.
     */
    public Richting turnRight () {
        switch (this) {
            case N: return Richting.O;
            case O: return Richting.Z;
            case Z: return Richting.W;
            default: return Richting.N; // this == W
        }
    }
}
