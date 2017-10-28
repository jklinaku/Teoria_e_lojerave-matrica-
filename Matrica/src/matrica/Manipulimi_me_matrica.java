package matrica;

/**
 *
 * @author Sead Mejzini
 */
public class Manipulimi_me_matrica {

    private final Matrix m;

    public Manipulimi_me_matrica(Matrix m) {
        this.m = m;
    }

    public Matrix getM() {
        return m;
    }

    public int dominant_row() {
        for (int i = 0; i < m.getRow(); i++) {
            if (this.dominator_check(i, true)) {
                return i;
            }
        }
        return -1;
    }

    public int dominant_col() {
        for (int i = 0; i < m.getCol(); i++) {
            if (this.dominator_check(i, false)) {
                return i;
            }
        }
        return -1;
    }

    public boolean dominator_check(int i, boolean row) {
        boolean ans = true;
        int nr;
        if (row) {
            nr = m.getRow();
        } else {
            nr = m.getCol();
        }
        for (int k = 0; k < nr; k++) {
            if (k != i) {
                if (row) {
                    ans = ans && sequence_check_greater(m.getContentRow(i), m.getContentRow(k));
                } else {
                    ans = ans && sequence_check_greater(m.getContentCol(i), m.getContentCol(k));
                }
            }
        }
        return ans;
    }

    public boolean sequence_check_greater(double[] a, double[] b) {
        boolean ans = true;
        for (int i = 0; i < a.length; i++) {
            ans = ans && (a[i] > b[i]);
        }
        return ans;
    }

    public boolean sequence_check_lesser(double[] a, double[] b) {
        boolean ans = true;
        for (int i = 0; i < a.length; i++) {
            ans = ans && (a[i] < b[i]);
        }
        return ans;
    }

    public boolean[] dominated_check(int i, boolean row) {

        int nr;
        if (row) {
            nr = m.getRow();
        } else {
            nr = m.getCol();
        }
        boolean[] ans = new boolean[nr];

        for (int k = 0; k < nr; k++) {
            if (row) {
                ans[k] = sequence_check_lesser(m.getContentRow(i), m.getContentRow(k));
            } else {
                ans[k] = sequence_check_lesser(m.getContentCol(i), m.getContentCol(k));
            }
        }
        return ans;
    }

    public int[][] dominated_row() {
        int[][] ans = new int[m.getRow()][m.getRow()];
        for (int i = 0; i < ans.length; i++) {
            boolean[] a = this.dominated_check(i, true);
            for (int k = 0; k < ans.length; k++) {
                ans[i][k] = a[k] ? 1 : 0;
                System.out.print(ans[i][k]);
            }
            System.out.println();
        }
        return ans;

    }

    public int[][] dominated_col() {
        int[][] ans = new int[m.getCol()][m.getCol()];
        for (int i = 0; i < ans.length; i++) {
            boolean[] a = this.dominated_check(i, false);
            for (int k = 0; k < ans.length; k++) {
                ans[i][k] = a[k] ? 1 : 0;
                System.out.print(ans[i][k]);
            }
            System.out.println();
        }
        return ans;
    }
}
