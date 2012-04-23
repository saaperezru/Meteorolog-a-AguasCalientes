package org.meteorologaaguascalientes.control.measure;

import java.util.List;
import org.meteorologaaguascalientes.vo.VariableVo;

/**
 *
 * @author josebermeo
 */
public class Variance implements Measure {

    @Override
    public double calculate(List<VariableVo> data) {
        if (data.isEmpty()) {
            return java.lang.Double.NaN;
        }
        double mean = (new Mean()).calculate(data);
        double varaince = 0;
        for (int i = 0; i < data.size(); i++) {
            varaince += (data.get(i).getValue() - mean) * (data.get(i).getValue() - mean);
        }
        return varaince / data.size();
    }
}
