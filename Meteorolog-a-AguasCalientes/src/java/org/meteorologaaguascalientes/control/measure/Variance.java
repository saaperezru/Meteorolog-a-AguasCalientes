/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.meteorologaaguascalientes.control.measure;

/**
 *
 * @author josebermeo
 */
public class Variance implements Measure{

    @Override
    public double calculate(double[] data) {
        if(data.length == 0)
            return -1;
        
        double mean = (new Mean()).calculate(data);
        double varaince = 0;
        for(int i = 0; i<data.length; i++)
            varaince += (data[i]-mean)*(data[i]-mean);
        return varaince/data.length;
    }
    
}
