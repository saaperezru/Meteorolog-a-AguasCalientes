/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.meteorologaaguascalientes.control.measure;

import java.util.ArrayList;
import java.util.Collections;
import org.meteorologaaguascalientes.vo.VariableTimeComparator;
import org.meteorologaaguascalientes.vo.VariableVo;

/**
 *
 * @author josebermeo
 */
public class InterquartileRange implements Measure{

    @Override
    public double calculate(ArrayList<VariableVo> data) {
        if(data.size()<4)
            return java.lang.Double.NaN;
        Collections.sort(data,new VariableTimeComparator());
        return data.get(data.size()/4-1).getValue()-data.get(data.size()-data.size()/4).getValue();
    }
    
}
