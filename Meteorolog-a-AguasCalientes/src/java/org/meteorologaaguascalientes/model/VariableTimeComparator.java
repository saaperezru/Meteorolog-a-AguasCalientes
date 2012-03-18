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
public class VariableTimeComparator implements Comparator<Variable> {

    @Override
    public int compare(Variable t, Variable t1) {
        return t.getTime().compareTo(t1.getTime());
    }
    
}
