/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package matrica;

import java.io.BufferedWriter;
import java.io.FileWriter;

/**
 *
 * @author Sead Mejzini
 */
public class Matrica {

    public static void main(String[] args) {
        Matrix m = new Matrix();
        double[][] input = {{3, 6, 5, 5}, {2, 5, 3, 4}, {1, 3, 2, 1}};
        m.setContent(input);
        Manipulimi_me_matrica mm = new Manipulimi_me_matrica(m);
        Matrix mat = m.update(m, 2, false);
        mat.printTest(mat);
        try {
            FileWriter fw = new FileWriter("Collison.txt");
            try (final BufferedWriter bw = new BufferedWriter(fw)) {
                bw.write("1244");
            }
        } catch (Exception e) {
        }
        System.exit(0);
    }
}
