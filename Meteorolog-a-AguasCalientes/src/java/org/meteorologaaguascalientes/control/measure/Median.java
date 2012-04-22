/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.meteorologaaguascalientes.control.measure;

import java.util.Collections;
import java.util.List;
import org.meteorologaaguascalientes.vo.VariableTimeComparator;
import org.meteorologaaguascalientes.vo.VariableVo;

/**
 *
 * @author josebermeo
 */
public class Median implements Measure {

    @Override
    public double calculate(List<VariableVo> data) {
        if (data.isEmpty()) {
            return java.lang.Double.NaN;
        }
        Collections.sort(data, new VariableTimeComparator());
        if (data.size() % 2 == 0) {
            return (data.get(data.size() / 2).getValue() + data.get(data.size() / 2 - 1).getValue()) / 2;
        }
        return data.get((data.size() - 1) / 2).getValue();

    }
}
