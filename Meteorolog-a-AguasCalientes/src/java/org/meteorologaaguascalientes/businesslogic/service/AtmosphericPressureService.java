package org.meteorologaaguascalientes.businesslogic.service;

import org.meteorologaaguascalientes.control.forecast.Forecast;
import org.meteorologaaguascalientes.control.measure.Measure;
import org.meteorologaaguascalientes.helper.VariablesVoFactory;
import org.meteorologaaguascalientes.vo.AtmosphericPressureVo;

/**
 *
 * @author tuareg
 */
public class AtmosphericPressureService extends AbstractVariableService<AtmosphericPressureVo> {

    public AtmosphericPressureService(Measure measure, Forecast forecast) {
        super(measure, forecast);
    }

    @Override
    public String getVariableId() {
        return VariablesVoFactory.ATMOSPHERIC_PRESSURE;
    }

    @Override
    public void checkVo(AtmosphericPressureVo vo) throws IllegalArgumentException {
        if(vo == null){
            throw new IllegalArgumentException("AtmosphericPressureVo cannot be null");
        }
    }
}
