package matrica;

/**
 *
 * @author Sead Mejzini && Jon Klinaku
 */
public class Counter {

    private final int max;
    private int count;

    public Counter(int max) {
        this.count = 0;
        this.max = max;
    }

    public boolean add() {
        if (count < max - 1) {
            count++;
            return true;
        }
        return false;
    }

    public boolean sub() {
        if (count > 0) {
            count--;
            return true;
        }
        return false;
    }

    public int getCount() {
        return count;
    }
}
