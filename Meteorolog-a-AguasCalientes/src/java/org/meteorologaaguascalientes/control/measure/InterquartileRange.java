/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.meteorologaaguascalientes.control.measure;

import java.util.ArrayList;
import java.util.Collections;
import org.meteorologaaguascalientes.model.VariableTimeComparator;
import org.meteorologaaguascalientes.model.Variable;

/**
 *
 * @author josebermeo
 */
public class InterquartileRange implements Measure{

    @Override
    public double calculate(ArrayList<Variable> data) {
        if(data.size()<4)
            return java.lang.Double.NaN;
        Collections.sort(data,new VariableTimeComparator());
        return data.get(data.size()/4-1).getValue()-data.get(data.size()-data.size()/4).getValue();
    }
    
}
