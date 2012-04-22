/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
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
}
