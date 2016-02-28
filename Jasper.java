package assignment4;

/**
 * A skier that can walk through the Loipe.
 *
 * @author Hendrik  Werner // s4549775
 * @author Jasper Haasdijk // s4449754
 */
public class Jasper implements Skier {
    private final Punt position;
    private Richting facing;
    private Richting facingBefore;

    /**
     * Constructor method.
     *
     * @param start the position Jasper is starting at (looking north).
     */
    public Jasper (Punt start) {
        this.facing = Richting.N;
        this.facingBefore = Richting.N;
        this.position = start;
    }

    /**
     * Constructor helper that chooses a default starting point.
     *
     */
    public Jasper () {
        this(new Punt());
    }

    /**
     * Make Jasper move in a given direction.
     *
     * @param direction the direction Jasper will move in. One of 's', 'l', 'r'
     * @return The position Jasper is at after moving.
     */
    @Override
    public Punt move (char direction) {
        this.position.stap(facing);
        switch (direction) {
            case 'r': this.turnRight(); break;
            case 'l': this.turnLeft(); break;
            case 's': this.goForward(); break;
        }
        return new Punt(this.position);
    }

    /**
     * Get the Fragment Jasper is standing on.
     *
     * @return the Fragment Jasper is standing on
     */
    @Override
    public Fragment getFragment () {
        switch (this.facingBefore) {
            case N:
                switch (this.facing) {
                    case N: return Fragment.NZ;
                    case O: return Fragment.ZO;
                    // no Z: there are no u turns
                    // case W:
                    default: return Fragment.ZW;
                }
            case O:
                switch (this.facing) {
                    case N: return Fragment.NW;
                    case O: return Fragment.OW;
                    // case Z:
                    default: return Fragment.ZW;
                    // no W: there are no u turns
                }
            case Z:
                switch (this.facing) {
                    // no N: there are no u turns
                    case O: return Fragment.NO;
                    case Z: return Fragment.NZ;
                    // case W:
                    default: return Fragment.NW;
                }
            // case W:
            default:
                switch (this.facing) {
                    case N: return Fragment.NO;
                    // no o: there is no u turn.
                    case Z: return Fragment.ZO;
                    // case W:
                    default: return Fragment.OW;
                }
        }
    }

    /**
     * Update the Richting Jasper is facing in.
     *
     */
    private void turnRight () {
        this.goForward();
        this.facing = this.facing.turnRight();
    }

    /**
     * Update the Richting Jasper is facing in.
     *
     */
    private void turnLeft () {
        this.goForward();
        this.facing = this.facing.turnLeft();
    }

    /**
     * Update the Richting Jasper is facing in.
     *
     */
    private void goForward() {
        this.facingBefore = this.facing;
    }
}
