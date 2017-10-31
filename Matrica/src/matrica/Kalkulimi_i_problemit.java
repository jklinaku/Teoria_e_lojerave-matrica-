package matrica;

/**
 *
 * @author Sead Mejzini && Jon Klinaku
 */
public class Kalkulimi_i_problemit {

    private int counter;
    private int maxCounter;
    private Matrix[] m = new Matrix[2];
    private Manipulimi_me_matrica[] mm = new Manipulimi_me_matrica[2];
    private String[] l1;
    private String[] l2;

    public Matrix[] getM() {
        return m;
    }

    public Kalkulimi_i_problemit(double[][] a, double[][] b, String[] l1, String[] l2) {
        m[0] = new Matrix(a);
        mm[0] = new Manipulimi_me_matrica(m[0]);
        m[1] = new Matrix(b);
        mm[1] = new Manipulimi_me_matrica(m[1]);
        this.l1 = l1;
        this.l2 = l2;
    }

    public boolean updateCounter(int i) {
        if ((i == -1 && counter == 0) || (i == 1 && counter == maxCounter)) {
            return false;
        }
        counter += i;
        return true;

    }

    public int getCounter() {
        return counter;
    }

    public void setCounter(int counter) {
        maxCounter = counter;
        this.counter = counter;
    }

    public Object[] updateMatrix(boolean b) {
        Object[] ans = new Object[4];
        if (b) {
            int dr = mm[0].dominant_row(true);
            int max = m[0].getRow();
            int[] drs = mm[0].dominated_rows(false);
            if (dr != -1) {
                for (int i = 0; i < max; i++) {
                    if (i != dr) {
                        m[0] = m[0].update(m[0], i, b);
                        m[1] = m[1].update(m[1], i, b);
                        l1 = removeStrategy(l1, i);
                    }
                }
                counter++;
            } else if (mm[0].hasDominated(drs)) {
                for (int i = 0; i < max; i++) {
                    if (drs[i] == 1) {
                        m[0] = m[0].update(m[0], i, b);
                        m[1] = m[1].update(m[1], i, b);
                        l1 = removeStrategy(l1, i);
                    }
                    counter++;
                }
            }
        } else {
            int max = m[0].getCol();
            int dr = mm[0].dominant_col(true);
            int[] drs = mm[0].dominated_cols(false);
            if (dr != -1) {
                for (int i = 0; i < max; i++) {
                    if (i != dr) {
                        m[0] = m[0].update(m[0], i, b);
                        m[1] = m[1].update(m[1], i, b);
                        l2 = removeStrategy(l2, i);
                    }
                }
                counter++;
            } else if (mm[0].hasDominated(drs)) {
                for (int i = 0; i < max; i++) {
                    if (drs[i] == 1) {
                        m[0] = m[0].update(m[0], i, b);
                        m[1] = m[1].update(m[1], i, b);
                        l2 = removeStrategy(l2, i);
                    }
                    counter++;
                }
            }
        }
        ans[0] = m[0];
        ans[1] = m[1];
        ans[2] = l1;
        ans[3] = l2;
        return ans;
    }

    public String[] removeStrategy(String[] input, int j) {
        for (int i = 0; i < input.length - 1; i++) {
            input[i] = (i < j) ? input[i] : input[i + 1];
        }
        return input;
    }

    public String update(String[] a, int i, boolean temp) {
        m[0] = m[0].update(m[0], i, temp);
        m[1] = m[1].update(m[1], i, temp);
        String temp1 = a[i];
        a = removeStrategy(a, i);
        counter++;
        return temp1;
    }
}
