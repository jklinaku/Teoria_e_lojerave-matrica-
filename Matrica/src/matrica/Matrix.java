package matrica;

public class Matrix {
	private int row;
	private int col;
	private double[][] content;
	public Matrix(int row, int col) {
		this.row=row;
		this.col=col;
	}
	public Matrix(double[][] mat) {
		row=mat.length;
		col=mat[0].length;
		content=mat;	
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
		double[] ans= new double[row];
		for(int i=0;i<row;i++) {
			ans[i]=content[i][j];
		}
		return ans;
		
	}

}
