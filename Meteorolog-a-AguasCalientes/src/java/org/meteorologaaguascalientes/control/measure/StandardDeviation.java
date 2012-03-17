/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.meteorologaaguascalientes.control.measure;

/**
 *
 * @author josebermeo
 */
public class StandardDeviation implements Measure{

    @Override
    public double calculate(double[] data) {
        if(data.length == 0)
            return -1;
        double variance = (new Variance()).calculate(data);
        return Math.sqrt(variance);
    }
    
}
