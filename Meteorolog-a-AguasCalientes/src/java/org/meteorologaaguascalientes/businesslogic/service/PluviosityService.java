/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.meteorologaaguascalientes.businesslogic.service;

import org.meteorologaaguascalientes.da.DataAccessAdapter;
import org.meteorologaaguascalientes.dao.AbstractDaoFactory;
import org.meteorologaaguascalientes.dao.VariableDao;
import org.meteorologaaguascalientes.vo.PluviosityVo;

/**
 *
 * @author tuareg
 */
public class PluviosityService extends AbstractVariableService<PluviosityVo>{

	@Override
	protected VariableDao<?, PluviosityVo> getDao(DataAccessAdapter dataAccess) {
		return AbstractDaoFactory.getDaoFactory(dataAccess).getVariableDao(ServicesFactory.PLUVIOSITY);
	}

	
}
