package matrica;

/**
 *
 * @author Sead Mejzini && Jon Klinaku
 */
public class Kalkulimi_i_problemit {

    protected int counter;
    private Matrix[] m = new Matrix[2];
    private Manipulimi_me_matrica[] mm = new Manipulimi_me_matrica[2];
    private String[] l1;
    private String[] l2;
    private final Object[] primaryMatrix = new Object[4];

    private boolean state = false;

    public Kalkulimi_i_problemit(double[][] a, double[][] b, String[] l1, String[] l2) {
        m[0] = new Matrix(a);
        m[1] = new Matrix(b);
        mm[0] = new Manipulimi_me_matrica(m[0]);
        mm[1] = new Manipulimi_me_matrica(m[1]);
        primaryMatrix[0] = m[0];
        primaryMatrix[1] = m[1];
        primaryMatrix[2] = l1;
        primaryMatrix[3] = l2;
        this.l1 = l1;
        this.l2 = l2;
    }

    public Object[] updateMatrix(boolean b) {
        Object[] ans = new Object[4];

        if (b) {
            int dr = mm[0].dominant_row(b);
            int[] domrs = mm[0].dominated_rows(b);
            if (dr != -1) {
                System.out.println("A1");
                this.isDominatorUpdate(dr, b);
            } else if (mm[0].hasDominated(domrs)) {
                System.out.println("A2");
                this.isDominatedOrHasLowestChances(domrs, b);
            } else {
                System.out.println("A3");
                int[] sameSum = mm[0].smallestSum(b);
                this.isDominatedOrHasLowestChances(sameSum, b);
            }
        } else {
            int dr = mm[1].dominant_col(true);
            int[] domrs = mm[1].dominated_cols(b);
            if (dr != -1) {
                System.out.println("B1");
                this.isDominatorUpdate(dr, b);
            } else if (mm[1].hasDominated(domrs)) {
                System.out.println("B2");
                this.isDominatedOrHasLowestChances(domrs, b);
            } else {
                System.out.println("B3");
                int[] sameSum = mm[1].smallestSum(b);
                this.isDominatedOrHasLowestChances(sameSum, b);
            }
        }
        ans[0] = m[0];
        ans[1] = m[1];
        ans[2] = l1;
        ans[3] = l2;
        return ans;
    }

    public String[] removeStrategy(String[] input, int j) {
        String[] answer = new String[input.length - 1];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = (i < j) ? input[i] : input[i + 1];
        }
        return answer;
    }

    public void isDominatorUpdate(int dominatorArray, boolean isRow) {

        int temp = (isRow) ? m[0].getRow() : m[0].getCol();
        for (int i = 0; i < temp; i++) {
            if (i < dominatorArray) {
                m[0] = m[0].update(m[0], 0, isRow);
                m[1] = m[1].update(m[1], 0, isRow);
                this.removeStrategy(i, isRow);
            } else if (i > dominatorArray) {
                m[0] = m[0].update(m[0], i - dominatorArray, isRow);
                m[1] = m[1].update(m[1], i - dominatorArray, isRow);
                this.removeStrategy(i, isRow);
            }
        }
        this.setState();
    }

    public void isDominatedOrHasLowestChances(int[] dominatedArrays, boolean isRow) {
        int removed = 0;
        int temp = (isRow) ? m[0].getRow() : m[0].getCol();
        for (int i = 0; i < temp; i++) {
            if (dominatedArrays[i] == 1) {
                m[0] = m[0].update(m[0], i - removed, isRow);
                m[1] = m[1].update(m[1], i - removed, isRow);
                this.removeStrategy(i - removed, isRow);
                removed++;
            }
        }
        this.setState();
    }

    public void removeStrategy(int i, boolean isRow) {
        if (isRow) {
            l1 = removeStrategy(l1, i);
        } else {
            l2 = removeStrategy(l2, i);
        }
    }

    public void setState() {
        state = (m[0].getRow() == 1 && m[0].getCol() == 1);
        mm[0].setM(m[0]);
        mm[1].setM(m[1]);
        counter++;
    }

    public Object[] getPrimaryMatrix() {
        return primaryMatrix;
    }

    public int getCounter() {
        return counter;
    }

    public boolean getState() {
        return state;
    }
}
