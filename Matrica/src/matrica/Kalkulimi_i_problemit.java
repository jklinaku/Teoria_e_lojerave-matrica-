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

    //private 
    public Kalkulimi_i_problemit(double[][] a,double[][] b) {

    }

    public boolean updateCounter(int i) {
        if (!(i == -1 && counter == 0) && !(i == 1 && counter == maxCounter)) {
            counter += i;
            return true;
        }
        return false;
    }

    public int getCounter() {
        return counter;
    }
    
    public void setCounter(int counter) {
        maxCounter = counter;
        this.counter = counter;
    }
}
