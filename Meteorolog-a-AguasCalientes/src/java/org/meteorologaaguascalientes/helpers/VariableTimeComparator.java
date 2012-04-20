/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.meteorologaaguascalientes.helpers;

import java.util.Comparator;
import org.meteorologaaguascalientes.model.vo.Variable;

/**
 *
 * @author josebermeo
 */
public class VariableTimeComparator implements Comparator<Variable> {

    @Override
    public int compare(Variable t, Variable t1) {
        if(t == null || t1 == null)
            throw new NullPointerException("The variables cannot be null");
        return t.getSample().getTime().compareTo(t1.getSample().getTime());
    }
    
}
