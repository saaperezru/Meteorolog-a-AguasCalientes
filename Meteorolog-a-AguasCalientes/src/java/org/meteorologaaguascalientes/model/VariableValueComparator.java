/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.meteorologaaguascalientes.model;

import java.util.Comparator;
import org.meteorologaaguascalientes.model.Variable;

/**
 *
 * @author josebermeo
 */
public class VariableValueComparator implements Comparator<Variable> {

    @Override
    public int compare(Variable t, Variable t1) {
        if (t.getValue()<t1.getValue())
            return -1;
        if(t.getValue()==t1.getValue())
            return 0;
        return 1;
    }
    
}
