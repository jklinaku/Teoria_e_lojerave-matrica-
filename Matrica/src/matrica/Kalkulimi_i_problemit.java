package matrica;

/**
 *
 * @author Sead Mejzini && Jon Klinaku
 */
public class Kalkulimi_i_problemit {

    protected int counter;
    private int maxCounter;
    private final Matrix[] m = new Matrix[2];
    private final Manipulimi_me_matrica[] mm = new Manipulimi_me_matrica[2];
    private String[] l1;
    private String[] l2;
    private final Object[] primaryMatrix = new Object[4];

    public Kalkulimi_i_problemit(double[][] a, double[][] b, String[] l1, String[] l2) {
        m[0] = new Matrix(a);
        mm[0] = new Manipulimi_me_matrica(m[0]);
        m[1] = new Matrix(b);
        mm[1] = new Manipulimi_me_matrica(m[1]);
        primaryMatrix[0] = m[0];
        primaryMatrix[1] = m[1];
        primaryMatrix[2] = l1;
        primaryMatrix[3] = l2;
        this.l1 = l1;
        this.l2 = l2;
    }

    public Object[] getPrimaryMatrix() {
        return primaryMatrix;
    }

    public Object[] updateMatrix(boolean b) {
        Object[] ans = new Object[4];
        int mr = m[0].getRow();
        int mc = m[0].getCol();
        if (mr > 0 && mc > 0) {
            if (b) {
                int dr = mm[0].dominant_row(true);
                int[] drs = mm[0].dominated_rows(false);

                if (dr != -1) {
                    for (int i = 0; i < mr; i++) {
                        if (i != dr) {
                            try {
                                m[0] = m[0].update(m[0], i, b);
                                m[0].printTest(m[0]);
                                m[1] = m[1].update(m[1], i, b);
                                m[1].printTest(m[1]);
                            } catch (Exception e) {
                                counter--;
                            }
                            l1 = removeStrategy(l1, i);
                        }
                    }
                    counter++;
                } else if (mm[0].hasDominated(drs)) {
                    for (int i = 0; i < mr; i++) {
                        try{
                        if (drs[i] == 1) {
                            m[0] = m[0].update(m[0], i, b);
                            m[1] = m[1].update(m[1], i, b);
                            l1 = removeStrategy(l1, i);
                        }}
                        catch (Exception e ){
                            counter--;
                        }
                        
                    }
                    counter++;
                }
            } else {
                int dr = mm[0].dominant_col(true);
                int[] drs = mm[0].dominated_cols(false);
                if (dr != -1) {
                    for (int i = 0; i < mc; i++) {
                       try{
                        if (i != dr) {
                            m[0] = m[0].update(m[0], i, b);
                            m[1] = m[1].update(m[1], i, b);
                            l2 = removeStrategy(l2, i);
                        }}
                       catch (Exception e ){counter--;}
                    }
                    counter++;
                } else if (mm[0].hasDominated(drs)) {
                    for (int i = 0; i < mc; i++) {
                        try{
                        if (drs[i] == 1) {
                            m[0] = m[0].update(m[0], i, b);
                            m[1] = m[1].update(m[1], i, b);
                            l2 = removeStrategy(l2, i);
                        }}
                        catch (Exception e ){
                        counter--;}
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
        String[] answer = new String[input.length - 1];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = (i < j) ? input[i] : input[i + 1];
        }
        return answer;
    }

    public String[] getL1() {
        return l1;
    }

    public String[] getL2() {
        return l2;
    }

    public Matrix[] getM() {
        return m;
    }

    public void printS(String[] a) {
        for (String a1 : a) {
            System.out.print(a1 + "  ");
        }
        System.out.println();
    }

    public int getCounter() {
        return counter;
    }

    public void setCounter(int counter) {
        this.counter = counter;
    }
}
