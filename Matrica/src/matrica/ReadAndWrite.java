/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package matrica;

/**
 *
 * @author Sead Mejzini
 */
public class ReadAndWrite {

    private final String[][] input;
    private int[][] p1;
    private int[][] p2;

    public ReadAndWrite(String[][] input) {
        this.input = input;
        fill();
    }

    public int[][] getP1() {
        return p1;
    }

    public int[][] getP2() {
        return p2;
    }

    private void fill() {
        for (int i = 0; i < input.length; i++) {
            for (int j = 0; j < input[1].length; j++) {
                int[] temp = read(input[i][j]);
                p1[i][j] = temp[0];
                p2[i][j] = temp[1];
            }
        }
    }

    private int[] read(String input) {
        int[] ans = new int[2];
        input = input.trim();
        boolean found = false;
        int i = 0;
        while (i < input.length() && !found) {
            try {
                int a = Integer.parseInt("" + input.charAt(i));
            } catch (Exception e) {
                ans[0] = Integer.parseInt(input.substring(0, i));
                input = input.substring(i, input.length());
                found = true;
            }
            i++;
        }
        String a1 = "";
        for (int j = 0; j < input.length(); j++) {
            try {
                int a = Integer.parseInt("" + input.charAt(j));
                a1 += a;
            } catch (Exception e) {
            }
        }
        ans[1] = Integer.parseInt(a1);
        return ans;
    }

    public String[][] write(double[][] p1, double[][] p2) {
        String[][] ans = new String[p1.length][p1[0].length];
        for (int i = 0; i < ans.length; i++) {
            for (int j = 0; j < ans[0].length; j++) {
                ans[i][j] = p1[i][j] + " ," + p2[i][j];

            }
        }
        return ans;
    }
}
