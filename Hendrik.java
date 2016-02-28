package assignment4;

import java.util.LinkedList;
import java.util.Scanner;

/**
 * Implements the LoipePresenter interface. Presents a Loipe interactively to a
 * user.
 *
 * @author Hendrik Werner // s4549775
 * @author Jasper Haasdijk // s4449754
 */
public class Hendrik implements LoipePresenter {
    private final LinkedList<TekenLoipe> views;
    private final Loipe loipe;
    private final Scanner scanner;

    /**
     * Constructor method.
     *
     * @param l the Loipe which to present
     * @param sc the scanner to use for user input
     */
    public Hendrik (Loipe l, Scanner sc) {
        this.loipe = l;
        this.scanner = sc;
        this.views = new LinkedList<>();
    }

    /**
     * Greet the user and explain how to use the presenter.
     *
     */
    private static void greet () {
        System.out.println("Hello, I am Hendrik, the interactive Loipe presenter.");
        System.out.println("Press enter to advance to the next state.");
    }

    /**
     * Add a view implementing the TekenLoipe interface.
     *
     * @param view the view to add
     */
    @Override
    public void addView (TekenLoipe view) {
        this.views.add(view);
    }

    @Override
    public void present () {
        greet();
        updateViews(this.loipe.start());
        draw();
        while (true) {
            this.scanner.nextLine();
            updateViews(this.loipe.stap());
            draw();
        }
    }

    private void updateViews (Punt p) {
        for (TekenLoipe v: this.views) {
            v.setPosition(p);
        }
    }

    private void draw () {
        for (TekenLoipe v: this.views) {
            v.teken();
        }
    }
}
