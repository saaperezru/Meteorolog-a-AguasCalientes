/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.meteorologaaguascalientes.businesslogic.service;

import org.meteorologaaguascalientes.helper.VariablesVoFactory;
import org.meteorologaaguascalientes.vo.TemperatureVo;
/**
 *
 * @author tuareg
 */
public class TemperatureService extends AbstractVariableService<TemperatureVo> {

	@Override
	public String getVariableId() {
		return VariablesVoFactory.TEMPERATURE;
	}

	
}
