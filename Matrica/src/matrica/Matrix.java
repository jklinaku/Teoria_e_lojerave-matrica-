package matrica;

/**
 *
 * @author Sead Mejzini
 */
public class Matrix {

    private int row;
    private int col;
    private double[][] content;

    public Matrix() {
    }

    public Matrix(double[][] mat) {
        row = mat.length;
        col = mat[0].length;
        content = mat;
    }

    public double[][] getContent() {
        return content;
    }

    public void setContent(double[][] content) {
        this.content = content;
        row = content.length;
        col = content[0].length;
    }

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }

    public double[] getContentRow(int i) {
        return content[i];
    }

    public double[] getContentCol(int j) {
        double[] ans = new double[row];
        for (int i = 0; i < row; i++) {
            ans[i] = content[i][j];
        }
        return ans;
    }

    public Matrix update(Matrix m, int a, boolean isRow) {
        Matrix mat = new Matrix();
        double[][] temp = m.getContent();
        double[][] ans;
        if (isRow) {
            ans = new double[temp.length - 1][temp[0].length];
            for (int i = 0; i < ans.length; i++) {
                ans[i] = (i < a) ? temp[i] : temp[i + 1];
            }
        } else {
            ans = new double[temp.length][temp[0].length - 1];
            for (int i = 0; i < ans.length; i++) {
                for (int j = 0; j < ans[0].length; j++) {
                    ans[i][j] = (j < a) ? temp[i][j] : temp[i][j + 1];
                }
            }
        }
        mat.setContent(ans);
        return mat;
    }

    public void printTest(Matrix m) {
        double[][] temp = m.getContent();
        for (double[] temp1 : temp) {
            for (int j = 0; j < temp[0].length; j++) {
                System.out.print(temp1[j] + "\t\t");
            }
            System.out.println("");
        }
    }

    public void printText(Matrix[] m) {
        for (int i = 0; i < m[0].getRow(); i++) {
            for (int j = 0; j < m[0].getCol(); j++) {
                System.out.print("( " + m[0].getContent()[i][j] + ",  " + m[1].getContent()[i][j] + " )");
            }
            System.out.println();
        }
    }
}
