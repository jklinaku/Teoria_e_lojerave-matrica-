package matrica;

public class Test {

	public static void main(String[] args) {
		double[][] mat= {{3,0,3},
						{1,-2,0},
						{2,-1,2}};
		Matrix a= new Matrix(mat);
		Manipulimi_me_matrica b=new Manipulimi_me_matrica(a);
		//System.out.println(new Manipulimi_me_matrica(a).sequence_check(mat[0], mat[1]));
		//System.out.println(b.dominant_row());
		System.out.println();
		b.dominated_col();
		//System.out.println(b.dominant_col());
		//System.out.println(a.getRow());
	}

}
