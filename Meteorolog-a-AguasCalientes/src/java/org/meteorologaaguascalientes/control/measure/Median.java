/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.meteorologaaguascalientes.control.measure;

import java.util.Arrays;

/**
 *
 * @author josebermeo
 */
public class Median implements Measure{

    @Override
    public double calculate(double[] data) {
        if(data.length == 0)
            return -1;
        Arrays.sort(data);
        if(data.length%2 == 0)
            return (data[data.length/2]+data[data.length/2-1])/2;
        return data[(data.length-1)/2];
    }
   
}
