package org.meteorologaaguascalientes.vo;

import java.util.Comparator;

/**
 *
 * @author josebermeo
 */
public class VariableValueComparator implements Comparator<VariableVo> {

    @Override
    public int compare(VariableVo t, VariableVo t1) {
        if (t.getValue() < t1.getValue()) {
            return -1;
        }
        if (t.getValue() == t1.getValue()) {
            return 0;
        }
        return 1;
    }
}
