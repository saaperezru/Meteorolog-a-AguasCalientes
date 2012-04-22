/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.meteorologaaguascalientes.vo;

import java.util.Comparator;

/**
 *
 * @author josebermeo
 */
public class VariableTimeComparator implements Comparator<VariableVo> {

    @Override
    public int compare(VariableVo t, VariableVo t1) {
        return t.getTime().compareTo(t1.getTime());
    }
    
}
