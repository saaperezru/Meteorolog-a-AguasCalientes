/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.meteorologaaguascalientes.control.measure;

/**
 *
 * @author josebermeo
 */
public class Mean implements Measure{

    @Override
    public double calculate(double [] data) {
        if(data.length == 0)
            return -1;
        
        double mean = 0;
        for(int i = 0; i<data.length; i++)
            mean += data[i];
        return mean/data.length;
    }
    
}
