/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.meteorologaaguascalientes.businesslogic.service;

import org.meteorologaaguascalientes.helper.VariablesVoFactory;
import org.meteorologaaguascalientes.vo.AtmosphericPressureVo;

/**
 *
 * @author tuareg
 */
public class AtmosphericPressureService extends AbstractVariableService<AtmosphericPressureVo> {

	@Override
	public String getVariableId() {
		return VariablesVoFactory.ATMOSPHERIC_PRESSURE;
	}


}
