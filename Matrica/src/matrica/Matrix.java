package matrica;

/**
 *
 * @author Sead Mejzini
 */
public class Matrix {

    private int row = 1;
    private int col = 1;
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
                for (int j = 0; j < ans.length; j++) {
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
}
