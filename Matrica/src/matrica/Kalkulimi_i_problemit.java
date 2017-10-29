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
public class Kalkulimi_i_problemit {

    private int counter;
    private int maxCounter;
    private double[][] a;
    private double[][] b;
    private String[] l1;
    private String[] l2;

    //private 
    public Kalkulimi_i_problemit(double[][] a, double[][] b, String[] l1, String[] l2) {
        this.a = a;
        this.b = b;
        this.l1 = l1;
        this.l2 = l2;
    }

    public boolean updateCounter(int i) {
        if ((i == -1 && counter == 0) || (i == 1 && counter == maxCounter)) {
            return false;
        }
        counter += i;
        return true;

    }

    public int getCounter() {
        return counter;
    }

    public void setCounter(int counter) {
        maxCounter = counter;
        this.counter = counter;
    }
}
