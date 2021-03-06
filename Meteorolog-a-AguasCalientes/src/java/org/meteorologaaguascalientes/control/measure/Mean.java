package org.meteorologaaguascalientes.control.measure;

import java.util.List;
import org.meteorologaaguascalientes.vo.VariableVo;

/**
 *
 * @author josebermeo
 */
public class Mean implements Measure {

    @Override
    public double calculate(List<VariableVo> data) {
        if (data.isEmpty()) {
            return java.lang.Double.NaN;
        }
        double mean = 0;
        for (int i = 0; i < data.size(); i++) {
            mean += data.get(i).getValue();
        }
        return mean / data.size();
    }
}
