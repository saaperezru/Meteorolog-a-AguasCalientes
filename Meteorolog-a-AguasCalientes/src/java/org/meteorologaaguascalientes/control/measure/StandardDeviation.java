/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.meteorologaaguascalientes.control.measure;

import java.util.ArrayList;
import org.meteorologaaguascalientes.model.vo.Variable;

/**
 *
 * @author josebermeo
 */
public class StandardDeviation implements Measure{

    @Override
    public double calculate(ArrayList<Variable> data) {
        if(data.isEmpty())
            return java.lang.Double.NaN;
        double variance = (new Variance()).calculate(data);
        return Math.sqrt(variance);
    }
    
}
