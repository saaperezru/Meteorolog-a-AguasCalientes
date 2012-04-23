package org.meteorologaaguascalientes.businesslogic.service;

import org.meteorologaaguascalientes.control.forecast.Forecast;
import org.meteorologaaguascalientes.control.measure.Measure;
import org.meteorologaaguascalientes.helper.VariablesVoFactory;
import org.meteorologaaguascalientes.vo.PluviosityVo;

/**
 *
 * @author tuareg
 */
public class PluviosityService extends AbstractVariableService<PluviosityVo> {

    public PluviosityService(Measure measure, Forecast forecast) {
        super(measure, forecast);
    }

    @Override
    public String getVariableId() {
        return VariablesVoFactory.PLUVIOSITY;
    }

    @Override
    public void checkVo(PluviosityVo vo) throws IllegalArgumentException {
        if(vo == null){
            throw new IllegalArgumentException("PluviosityVo cannot be null");
        }
        if(vo.getValue()< 0){
            throw new IllegalArgumentException("Pluviosity cannot be less than 0");
        }
    }
}
