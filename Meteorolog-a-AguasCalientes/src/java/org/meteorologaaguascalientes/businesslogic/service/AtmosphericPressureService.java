/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.meteorologaaguascalientes.businesslogic.service;

import org.meteorologaaguascalientes.da.DataAccessAdapter;
import org.meteorologaaguascalientes.dao.AbstractDaoFactory;
import org.meteorologaaguascalientes.dao.VariableDao;
import org.meteorologaaguascalientes.vo.AtmosphericPressureVo;

/**
 *
 * @author tuareg
 */
public class AtmosphericPressureService extends AbstractVariableService<AtmosphericPressureVo> {

	@Override
	protected VariableDao<?, AtmosphericPressureVo> getDao(DataAccessAdapter dataAccess) {
		return AbstractDaoFactory.getDaoFactory(dataAccess).getVariableDao(ServicesFactory.ATMOSPHERIC_PRESSURE);
	}

}
