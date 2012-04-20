/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.meteorologaaguascalientes.businesslogic.service;

import org.meteorologaaguascalientes.da.DataAccessAdapter;
import org.meteorologaaguascalientes.da.JpaDataAccessFactory;
import org.meteorologaaguascalientes.dao.AbstractDaoFactory;
import org.meteorologaaguascalientes.dao.VariableDao;
import org.meteorologaaguascalientes.vo.TemperatureVo;
/**
 *
 * @author tuareg
 */
public class TemperatureService extends AbstractVariableService<TemperatureVo> {

	@Override
	protected VariableDao<?, TemperatureVo> getDao(DataAccessAdapter dataAccess) {
		return AbstractDaoFactory.getDaoFactory(dataAccess).getVariableDao(ServicesFactory.TEMPERATURE);
	}

	public void createRecord(JpaDataAccessFactory da, TemperatureVo temperature) {
		throw new UnsupportedOperationException("Not yet implemented");
	}
	
}
