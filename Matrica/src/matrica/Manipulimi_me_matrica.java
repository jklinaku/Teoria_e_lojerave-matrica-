package matrica;

/**
 *
 * @author Sead Mejzini && Jon Klinaku
 */
public class Manipulimi_me_matrica {

    private final Matrix m;

    public Manipulimi_me_matrica(Matrix m) {
        this.m = m;
    }

    public Matrix getM() {
        return m;
    }

    public int dominant_row(boolean isRegorously) {
        for (int i = 0; i < m.getRow(); i++) {
            if (this.dominator_check(i, true, isRegorously)) {
                return i;
            }
        }
        return -1;
    }

    public int dominant_col(boolean isRegorously) {
        for (int i = 0; i < m.getCol(); i++) {
            if (this.dominator_check(i, false, isRegorously)) {
                return i;
            }
        }
        return -1;
    }

    public boolean dominator_check(int i, boolean row, boolean isRegorously) {
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
                    ans = ans && sequence_check_greater(m.getContentRow(i), m.getContentRow(k), isRegorously);
                } else {
                    ans = ans && sequence_check_greater(m.getContentCol(i), m.getContentCol(k), isRegorously);
                }
            }
        }
        return ans;
    }

    public boolean sequence_check_greater(double[] a, double[] b, boolean isRegorously) {
        boolean ans = true;
        for (int i = 0; i < a.length; i++) {
            if (isRegorously) {
                ans = ans && (a[i] > b[i]);
            } else {
                ans = ans && (a[i] >= b[i]);
            }
        }
        return ans;
    }

    public boolean sequence_check_lesser(double[] a, double[] b, boolean isRegorously) {
        boolean ans = true;
        for (int i = 0; i < a.length; i++) {
            if (isRegorously) {
                ans = ans && (a[i] < b[i]);
            } else {
                ans = ans && (a[i] <= b[i]);
            }
        }
        return ans;
    }

    public boolean[] dominated_check(int i, boolean row, boolean isRegorously) {

        int nr;
        if (row) {
            nr = m.getRow();
        } else {
            nr = m.getCol();
        }
        boolean[] ans = new boolean[nr];

        for (int k = 0; k < nr; k++) {
            if (row) {
                ans[k] = sequence_check_lesser(m.getContentRow(i), m.getContentRow(k), isRegorously);
            } else {
                ans[k] = sequence_check_lesser(m.getContentCol(i), m.getContentCol(k), isRegorously);
            }
        }
        return ans;
    }

    public int[][] dominated_row() {
        int[][] ans = new int[m.getRow()][m.getRow()];
        for (int i = 0; i < ans.length; i++) {
            boolean[] a = this.dominated_check(i, true, true);
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
            boolean[] a = this.dominated_check(i, false,true);
            for (int k = 0; k < ans.length; k++) {
                ans[i][k] = a[k] ? 1 : 0;
                System.out.print(ans[i][k]);
            }
            System.out.println();
        }
        return ans;
    }

    public int[] dominated_rows(boolean isRegorously) {
        int[] ans = new int[m.getRow()];
        for (int i = 0; i < ans.length; i++) {
            boolean[] a = this.dominated_check(i, true, isRegorously);
            boolean found = false;
            for (int k = 0; k < ans.length && !found; k++) {
                if (k != i) {
                    found = found || a[k];
                    ans[i] = found ? 1 : 0;
                }
            }
        }
        return ans;
    }

    public int[] dominated_cols(boolean isRegorously) {
        int[] ans = new int[m.getCol()];
        for (int i = 0; i < ans.length; i++) {
            boolean[] a = this.dominated_check(i, false, isRegorously);
            boolean found = false;
            for (int k = 0; k < ans.length; k++) {
                if (k != i) {
                    found = found || a[k];
                    ans[i] = found ? 1 : 0;
                }
            }
        }
        return ans;
    }

    public boolean hasDominated(int[] a) {
        boolean ans = false;
        for (int i = 0; i < a.length; i++) {
            ans = ans || (a[i] == 1);
        }
        return ans;
    }
}
//    public boolean isDominated(int j, boolean isRow) {
//        boolean ans = true;
//        if (isRow) {
//            boolean[] temp = dominated_check(j, isRow);
//            for (int i = 0; i < m.getRow(); i++) {
//                if (i != j) {
//                    ans = ans && temp[i];
//                }
//            }
//        } else {
//            ans = false;
//            boolean[] temp = dominated_check(j, false);
//            for (int i = 0; i < m.getCol(); i++) {
//                if (i != j) {
//                    ans = ans || temp[i];
//                }
//            }
//        }
//        return ans;
//    }
