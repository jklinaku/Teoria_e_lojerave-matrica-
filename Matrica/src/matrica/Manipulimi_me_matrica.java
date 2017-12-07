package matrica;

/**
 *
 * @author Sead Mejzini && Jon Klinaku
 */
public class Manipulimi_me_matrica {

    private Matrix m;

    public Manipulimi_me_matrica(Matrix m) {
        this.m = m;
    }

    public void setM(Matrix m) {
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

    private boolean dominator_check(int i, boolean row, boolean isRegorously) {
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

    private boolean sequence_check_greater(double[] a, double[] b, boolean isRegorously) {
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

    private boolean sequence_check_lesser(double[] a, double[] b, boolean isRegorously) {
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

    private boolean[] dominated_check(int i, boolean row, boolean isRegorously) {

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
        boolean temp = false;
        for (int i = 0; i < ans.length; i++) {
            temp = temp || ans[i] == 0;
        }
        ans[0] = temp ? ans[0] : 0;
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
        boolean temp = false;
        for (int i = 0; i < ans.length; i++) {
            temp = temp || ans[i] == 0;
        }
        ans[0] = temp ? ans[0] : 0;
        return ans;
    }

    public boolean hasDominated(int[] a) {
        boolean ans = false;
        for (int i = 0; i < a.length; i++) {
            ans = ans || (a[i] == 1);
        }
        return ans;
    }

    public int[] smallestSum(boolean isRow) {
        double tempS;
        double[] sum;
        int[] ans;
        if (isRow) {
            ans = new int[m.getRow()];
            sum = new double[m.getRow()];
            for (int i = 0; i < m.getRow(); i++) {
                sum[i] = rowSum(m.getContentRow(i));
            }
            tempS = findMin(sum, sum.length);
            boolean allSame = true;
            for (int i = 0; i < sum.length; i++) {
                ans[i] = tempS == sum[i] ? 1 : 0;
                allSame = allSame && ans[i] == 1;
            }
            if (allSame) {
                ans[0] = 0;
            }
        } else {
            ans = new int[m.getCol()];
            sum = new double[m.getCol()];
            for (int i = 0; i < m.getCol(); i++) {
                sum[i] = rowSum(m.getContentCol(i));
            }
            tempS = findMin(sum, sum.length);
            boolean allSame = true;
            for (int i = 0; i < sum.length; i++) {
                ans[i] = tempS == sum[i] ? 1 : 0;
                allSame = allSame && ans[i] == 1;
            }
            if (allSame) {
                ans[0] = 0;
            }
        }
        return ans;
    }

    private double findMin(double[] data, int size) {
        double temp;
        if (size == 1) {
            return data[0];
        } else {
            temp = findMin(data, size - 1);
            if (temp <= data[size - 1]) {
                return temp;
            } else {
                return data[size - 1];
            }
        }
    }

    private double rowSum(double[] input) {
        double ans = 0.0;
        for (int i = 0; i < input.length; i++) {
            ans += input[i];
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
            boolean[] a = this.dominated_check(i, false, true);
            for (int k = 0; k < ans.length; k++) {
                ans[i][k] = a[k] ? 1 : 0;
                System.out.print(ans[i][k]);
            }
            System.out.println();
        }
        return ans;
    }
}
