/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.meteorologaaguascalientes.businesslogic.service;

import org.meteorologaaguascalientes.helper.VariablesVoFactory;
import org.meteorologaaguascalientes.vo.PluviosityVo;

/**
 *
 * @author tuareg
 */
public class PluviosityService extends AbstractVariableService<PluviosityVo> {

	@Override
	public String getVariableId() {
		return VariablesVoFactory.PLUVIOSITY;
	}

}
