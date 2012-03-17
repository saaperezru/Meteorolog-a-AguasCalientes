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
public class InterquartileRange implements Measure{

    @Override
    public double calculate(double[] data) {
        if(data.length < 4)
            return -1;
        Arrays.sort(data);
        return data[data.length/4-1]-data[data.length-data.length/4];
        
    }
    
}
