/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.meteorologaaguascalientes.control.measure;

import java.util.ArrayList;
import org.meteorologaaguascalientes.model.Variable;

/**
 *
 * @author josebermeo
 */
public interface Measure {
    
    public double calculate(ArrayList<Variable> data);
}
