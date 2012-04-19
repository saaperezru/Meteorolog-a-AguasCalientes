/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.meteorologaaguascalientes.businesslogic.service;

import org.meteorologaaguascalientes.vo.PluviosityVo;

/**
 *
 * @author tuareg
 */
public class PluviosityService extends AbstractVariableService<PluviosityVo>{

	@Override
	public boolean createRecord(PluviosityVo record) {
		boolean add = data.add(record);
		if (lastRecord == null || (lastRecord.getTime().compareTo(record.getTime()))<=0){
			lastRecord = record;
		}
		return true;
	}

	
	
}
