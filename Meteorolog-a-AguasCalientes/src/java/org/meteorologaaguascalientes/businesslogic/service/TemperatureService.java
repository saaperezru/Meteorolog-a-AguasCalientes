package org.meteorologaaguascalientes.businesslogic.service;

import org.meteorologaaguascalientes.control.forecast.Forecast;
import org.meteorologaaguascalientes.control.measure.Measure;
import org.meteorologaaguascalientes.helper.VariablesVoFactory;
import org.meteorologaaguascalientes.vo.TemperatureVo;

/**
 *
 * @author tuareg
 */
public class TemperatureService extends AbstractVariableService<TemperatureVo> {

    public TemperatureService(Measure measure, Forecast forecast) {
        super(measure, forecast);
    }

    @Override
    public String getVariableId() {
        return VariablesVoFactory.TEMPERATURE;
    }

    @Override
    public void checkVo(TemperatureVo vo) throws IllegalArgumentException {
        if(vo == null){
            throw new IllegalArgumentException("TemperatureVo cannot be null");
        }
        if(vo.getValue()< -273.15){
            throw new IllegalArgumentException("Temperature cannot be less than -273.15 C");
        }
    }
}
