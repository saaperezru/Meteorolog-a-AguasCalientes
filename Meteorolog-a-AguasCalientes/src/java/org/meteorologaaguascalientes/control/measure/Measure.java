/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.meteorologaaguascalientes.control.measure;

import java.util.List;
import org.meteorologaaguascalientes.vo.VariableVo;

/**
 *
 * @author josebermeo
 */
public interface Measure {

    public double calculate(List<VariableVo> data);
}
