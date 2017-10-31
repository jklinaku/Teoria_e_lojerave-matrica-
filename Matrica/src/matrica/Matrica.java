package matrica;

/**
 *
 * @author Sead Mejzini && Jon Klinaku
 */
public class Matrica {

    public static void main(String[] args) {
        Matrix[] m = new Matrix[2];
        double[][] i1 = {
            {3, 6, 5, 5},
            {2, 5, 3, 4},
            {0, 1, 0, 0},
            {1, 3, 4, 1}};
        double[][] i2 = {
            {2, 3, 5, 4},
            {1, 1, 2, 1},
            {1, 3, 4, 1},
            {0, 0, 1, 0}};

        double[][] testM = {
            {1, 2, 2},
            {0, 1, 4},
            {2, 3, 3}
        };
        double[][] testM2 = {
            {1, 0, 2},
            {3, 5, 4},
            {4, 6, 0}
        };

        double[][] t1 = {
            {2, 4, 1},
            {3, 1, 4}
        };

        double[][] t2 = {
            {1, 5, 10},
            {5, 4, 1}
        };
        i1 = t1;
        i2 = t2;
        String[] a = {"a", "d", "f", "g"};
        String[] b = {"a1", "d1", "f1", "g1"};

        Matrix t = new Matrix(testM);
        //t = t.update(t, 0, false);
        //t.printTest(t);
        Manipulimi_me_matrica test = new Manipulimi_me_matrica(t);
//        int[] mc = test.dominated_cols(false);
//        for (int i = 0; i < mc.length; i++) {
//            System.out.println(mc[i]);
//        }

//        int[] temp = test.dominated_rows();
//        for (int i = 0; i < temp.length; i++) {
//            System.out.print(temp[i]);
//        }
//        t = t.update(t, 2, false);
//        t.printTest(t);
        // System.exit(0);
        Kalkulimi_i_problemit kp = new Kalkulimi_i_problemit(i1, i2, a, b);
        kp.updateMatrix(true);

        kp.updateMatrix(false);

        kp.updateMatrix(true);
        m = kp.getM();
        m[0].printTest(m[0]);
        System.out.println();
        m[1].printTest(m[1]);

        //MyFrame m = new MyFrame();
    }
}
